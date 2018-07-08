package com.daniel.user.asartaline.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.daniel.user.asartaline.ASarTaLineApp;
import com.daniel.user.asartaline.data.VOs.GetShopList.ReviewsVO;
import com.daniel.user.asartaline.data.VOs.GetShopList.ShopVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.GeneralTasteVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.MatchWarTeeVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.MealShopVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.ShopByDistanceVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.ShopByPopularityVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.SuitedForVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.network.response.MealShopResponse;
import com.daniel.user.asartaline.network.response.WarDeeResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ASTLModel extends BaseModel {
    private static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static ASTLModel objInstance;
    private ArrayList<ShopVO> shopVOS;



    protected ASTLModel(Context context) {
        super(context);
        shopVOS = new ArrayList<>();

    }

    public static void initASTLModel(Context context) {
        objInstance = new ASTLModel(context);

    }

    public static ASTLModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("Model is being called before it was initialized ");
        }
        return objInstance;
    }


    public void startLoadingWarDeeList(final MutableLiveData<List<WarDeeVO>> warTeedLD, final MutableLiveData<List<ShopVO>> mealShopLD, final MutableLiveData<String> errorLD) {

        Log.d(ASarTaLineApp.LOG_TAG, " Reached in start loading ");
        theApi.loadShops(ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .flatMap((Function<MealShopResponse, ObservableSource<WarDeeResponse>>) mealShopResponse -> {

                    if (mealShopResponse != null && mealShopResponse.getShops().size() > 0) {
                        saveMealShopsInDB(mealShopResponse.getShops());
                        shopVOS.addAll(mealShopResponse.getShops());

                    } else {
                        errorLD.setValue("Error in Loading WarDee List");

                        Log.d(ASarTaLineApp.LOG_TAG, " Reached in start loading  error");
                    }

                    return theApi.loadWarDees(ACCESS_TOKEN);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WarDeeResponse warDeeResponse) {
                        if (warDeeResponse.getWarDeeVO() != null && warDeeResponse.getWarDeeVO().size() > 0) {
                            saveWarTeeInDB(warDeeResponse.getWarDeeVO());
                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
                        }
                        if (warDeeResponse.getWarDeeVO().size() > 0) {
                            warTeedLD.setValue(warDeeResponse.getWarDeeVO());
                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
                        }
                        if (shopVOS.size() > 0) {
                            mealShopLD.setValue(shopVOS);
                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : shops");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                        Log.e("Error", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(ASarTaLineApp.LOG_TAG, " Reached in onComplete");
                    }
                });


    }

//         if (warDeeVOList!= null && warDeeVOList.size() > 0) {
//
//        saveWarTeeInDB(warDeeVOList);
//        Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
//    }
//                        if (warDeeVOList.size() > 0) {
//        warTeedLD.setValue(warDeeVOList);
//        Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
//    }
//                        if (shopVOS.size() > 0) {
//        mealShopLD.setValue(shopVOS);
//        Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : shops");
//    }

    private void saveWarTeeInDB(List<WarDeeVO> warDeeVOSList) {

        List<GeneralTasteVO> generalTasteVOS = new ArrayList<>();
        List<ShopByDistanceVO> shopByDistanceVOS = new ArrayList<>();
        List<ShopByPopularityVO> shopByPopularityVOS = new ArrayList<>();
        List<MatchWarTeeVO> matchWarTeeVOS = new ArrayList<>();
        List<MealShopVO> mealShopVOS = new ArrayList<>();
        List<SuitedForVO> suitedForVOS = new ArrayList<>();
        List<WarDeeVO> warDeeVOS = new ArrayList<>();

        for (WarDeeVO food : warDeeVOSList) {
            for (GeneralTasteVO generalTaste : food.getGeneralTaste()) {
                generalTaste.setTasteId(food.getWarDeeId());
                generalTasteVOS.add(generalTaste);
            }
            for (SuitedForVO suitedFor : food.getSuitedFor()) {
                suitedFor.setSuitedFor(food.getWarDeeId());
                suitedForVOS.add(suitedFor);
            }
            for (MatchWarTeeVO matchWarDee : food.getMatchWarTees()) {
                matchWarDee.setMatchWarDeeId(food.getWarDeeId());
                matchWarTeeVOS.add(matchWarDee);
            }
            for (ShopByDistanceVO shopByDistance : food.getShopByDistance()) {
                mealShopVOS.addAll(shopByDistance.getMealShop());

//                shopByDistance.setWarDeeId(food.getWarDeeId());
                shopByDistanceVOS.add(shopByDistance);
            }
            for (ShopByPopularityVO shopByPopularity : food.getShopByPopularity()) {
                mealShopVOS.addAll(shopByPopularity.getMealShop());

//                shopByPopularity.setWarDeeId(food.getWarDeeId());
                shopByPopularityVOS.add(shopByPopularity);
            }
            warDeeVOS.add(food);
        }

        long[] insertedGeneratedTaste = warDeeDB.GeneralTasteDAO().insertGeneralTaste(generalTasteVOS.toArray(new GeneralTasteVO[0]));
        Log.d("WarDee DB", "insertedGeneratedTaste : " + insertedGeneratedTaste);

        long[] insertedSuitedFor = warDeeDB.SuitedForDAO().insertSuitedFor(suitedForVOS.toArray(new SuitedForVO[0]));
        Log.d("WarDee DB", "insertedSuitedFor : " + insertedSuitedFor);

        long[] insertedMatchWarDee = warDeeDB.MatchWarDeeDAO().insertMatchWarDee(matchWarTeeVOS.toArray(new MatchWarTeeVO[0]));
        Log.d("WarDee DB", "insertedMatchWarDee : " + insertedMatchWarDee);

        long[] insertedShopByDistance = warDeeDB.ShopByDistanceDAO().insertShops(shopByDistanceVOS.toArray(new ShopByDistanceVO[0]));
        Log.d("WarDee DB", "insertedShopByDistance : " + insertedShopByDistance);

        long[] insertedShopByPopularity = warDeeDB.ShopByPopularityDAO().insertShops(shopByPopularityVOS.toArray(new ShopByPopularityVO[0]));
        Log.d("WarDee DB", "insertedShopByPopularity : " + insertedShopByPopularity);

        long[] insertedMealShop = warDeeDB.MealShopDAO().insertMealShops(mealShopVOS.toArray(new MealShopVO[0]));
        Log.d("WarDee DB", "insertedMealShop : " + insertedMealShop);

        long[] insertedFoods = warDeeDB.WarDeeDAO().insertWarDee(warDeeVOS.get(0));
        Log.d("WarDee DB", "insertedFoods : " + insertedFoods);
        Log.d(ASarTaLineApp.LOG_TAG, "SAVED WARDEE LIST ");
    }


    public void saveMealShopsInDB(List<ShopVO> shopVOList) {
        for (ShopVO shopVO : shopVOList) {
            if (shopVO.getReviews() != null) {
                for (ReviewsVO reviewsVO : shopVO.getReviews()) {
                    warDeeDB.ReviewsDAO().insertAllReviews(reviewsVO);
                }
            }
            warDeeDB.ShopDAO().insertShops(shopVO);
        }
        Log.d(ASarTaLineApp.LOG_TAG, "SAVED SHOP LIST ");

    }


    public LiveData<WarDeeVO> getWarDeeByIdLD(final String foodId) {
        final MutableLiveData<WarDeeVO> warDeeLD = new MutableLiveData<>();
        warDeeDB.WarDeeDAO().getWarDeeLDById(foodId).observeForever(warDeeVO -> {
            if (warDeeVO != null) {
//                    for (ShopByDistanceVO shopByDistance : warDeeVO.getShopByDistance()) {
//                        shopByDistance.setMealShop(warDeeDB.MealShopDAO().getMealShopById(shopByDistance.getShopId()));
//                    }
//                    for (ShopByPopularityVO shopByPopularity : warDeeVO.getShopByPopularity()) {
//                        shopByPopularity.setMealShop(warDeeDB.MealShopDAO().getMealShopById(shopByPopularity.getShopId()));
//                    }
                warDeeLD.setValue(warDeeVO);
            }
        });
        return warDeeLD;
    }

    public WarDeeVO getWarDeeById(final String foodId) {
        WarDeeVO warDeeVO = warDeeDB.WarDeeDAO().getWarDeeById(foodId);
        return warDeeVO;
    }

}
