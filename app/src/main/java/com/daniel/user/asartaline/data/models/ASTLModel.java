package com.daniel.user.asartaline.data.models;

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
    private List<ShopVO> shopVOS;
    private List<WarDeeVO> warDeeVOS;


    protected ASTLModel(Context context) {
        super(context);
        shopVOS = new ArrayList<>();
        warDeeVOS = new ArrayList<>();
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
                .flatMap(new Function<MealShopResponse, ObservableSource<WarDeeResponse>>() {
                    @Override
                    public ObservableSource<WarDeeResponse> apply(MealShopResponse mealShopResponse) {
                        if (mealShopResponse != null && mealShopResponse.getShops().size() > 0 && mealShopResponse.getCode() == 200) {
                            shopVOS.addAll(mealShopResponse.getShops());
                            saveMealShopsInDB(shopVOS);

                        } else {
                            errorLD.setValue("Error in Loading WarDee List");

                            Log.d(ASarTaLineApp.LOG_TAG, " Reached in start loading  error");
                        }

                        return theApi.loadWarDees(ACCESS_TOKEN);
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WarDeeResponse warDeeResponse) {
                        if (warDeeResponse.getWarDeeVO() != null && warDeeResponse.getWarDeeVO().size() > 0) {
                            warDeeVOS.addAll(warDeeResponse.getWarDeeVO());
                            saveWarTeeInDB(warDeeVOS);
                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
                        }
                        if (warDeeVOS.size() > 0) {
                            warTeedLD.setValue(warDeeVOS);

                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : warDee");
                        }
                        if (shopVOS.size() > 0) {
                            mealShopLD.setValue(shopVOS);
                            Log.d(ASarTaLineApp.LOG_TAG, "Save in LD : shops");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void saveWarTeeInDB(List<WarDeeVO> warDeeVOS) {

        for (WarDeeVO warDeeVO : warDeeVOS) {
            if (warDeeVO.getGeneralTaste() != null) {
                for (GeneralTasteVO generalTasteVO : warDeeVO.getGeneralTaste()) {
                    warDeeDB.GeneralTasteDAO().insertGeneralTaste(generalTasteVO);
                }
            }
            if (warDeeVO.getMatchWarTees() != null) {
                for (MatchWarTeeVO matchWarTeeVO : warDeeVO.getMatchWarTees()) {
                    warDeeDB.MatchWarDeeDAO().insertMatchWarDee(matchWarTeeVO);
                }
            }
            if (warDeeVO.getShopByDistance() != null) {
                for (ShopByDistanceVO shopByDistanceVO : warDeeVO.getShopByDistance()) {
                    if (shopByDistanceVO.getMealShop() != null) {
                        for (MealShopVO mealShopVO : shopByDistanceVO.getMealShop()) {
                            warDeeDB.MealShopDAO().insertMealShops(mealShopVO);
                        }
                    }
                    warDeeDB.ShopByDistanceDAO().insertShops(shopByDistanceVO);
                }
            }
            if (warDeeVO.getShopByPopularity() != null) {
                for (ShopByPopularityVO shopByPopularityVO : warDeeVO.getShopByPopularity()) {
                    if (shopByPopularityVO.getMealShop() != null) {
                        for (MealShopVO mealShopVO : shopByPopularityVO.getMealShop()) {
                            warDeeDB.MealShopDAO().insertMealShops(mealShopVO);
                        }
                    }
                    warDeeDB.ShopByPopularityDAO().insertShops(shopByPopularityVO);
                }
            }
            if (warDeeVO.getSuitedFor() != null) {
                for (SuitedForVO suitedForVO : warDeeVO.getSuitedFor()) {
                    warDeeDB.SuitedForDAO().insertSuitedFor(suitedForVO);
                }
            }
            warDeeDB.WarDeeDAO().insertWarDee(warDeeVO);
        }
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

}
