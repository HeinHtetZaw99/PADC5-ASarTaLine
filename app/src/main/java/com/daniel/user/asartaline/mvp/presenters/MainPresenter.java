package com.daniel.user.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.daniel.user.asartaline.data.VOs.GetShopList.ShopVO;
import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.data.models.ASTLModel;
import com.daniel.user.asartaline.delegate.FoodItemDelegate;
import com.daniel.user.asartaline.mvp.views.MainView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements FoodItemDelegate {

    private MutableLiveData<List<WarDeeVO>> mWarDeeLD;
    private MutableLiveData<List<ShopVO>> mShopLD;
    private MutableLiveData<String> mErrorLD;
    private boolean isOnline;

    @Override
    public void onTapFoodItem(String id) {
        mView.launchFoodDetailsScreen(id);
    }

    @Override
    public void initPresenter(MainView mView) {
        super.initPresenter(mView);
        mWarDeeLD = new MutableLiveData<>();
        mShopLD = new MutableLiveData<>();
        mErrorLD = new MutableLiveData<>();
        //ASTLModel.getInstance().startLoadingWarDeeList(mWarDeeLD, mShopLD, mErrorLD);
        loadData();
    }


    public void onRefreshScreen() {
        loadData();
    }

    private void loadData() {
        ASTLModel.getInstance().startLoadingWarDeeList(mWarDeeLD, mShopLD, mErrorLD);
    }

    public LiveData<List<WarDeeVO>> getWarDeeLD() {
        return mWarDeeLD;
    }


}
