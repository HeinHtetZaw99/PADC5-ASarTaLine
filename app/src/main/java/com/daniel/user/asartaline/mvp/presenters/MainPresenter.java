package com.daniel.user.asartaline.mvp.presenters;

import com.daniel.user.asartaline.delegate.FoodItemDelegate;
import com.daniel.user.asartaline.mvp.views.MainView;

public class MainPresenter extends BasePresenter<MainView> implements FoodItemDelegate {
    @Override
    public void onTapFoodItem() {
        mView.launchFoodDetailsScreen();
    }
}
