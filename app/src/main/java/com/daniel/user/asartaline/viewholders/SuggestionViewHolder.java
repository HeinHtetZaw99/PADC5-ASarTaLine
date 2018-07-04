package com.daniel.user.asartaline.viewholders;

import android.view.View;

import com.daniel.user.asartaline.delegate.FoodItemDelegate;

public class SuggestionViewHolder extends BaseViewHolders {
    private FoodItemDelegate foodItemDelegate;

    public SuggestionViewHolder(View itemView, FoodItemDelegate foodItemDelegate) {
        super(itemView);
        this.foodItemDelegate = foodItemDelegate;
    }

    @Override
    public void onClick(View v) {

    }
}
