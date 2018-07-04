package com.daniel.user.asartaline.viewholders;

import android.view.View;

import com.daniel.user.asartaline.delegate.FoodItemDelegate;

public class FoodViewHolder extends BaseViewHolders {

    private FoodItemDelegate foodItemDelegate;

    public FoodViewHolder(View itemView, FoodItemDelegate foodItemDelegate) {
        super(itemView);
        this.foodItemDelegate = foodItemDelegate;
    }

    @Override
    public void onClick(View v) {
        foodItemDelegate.onTapFoodItem();
    }
}
