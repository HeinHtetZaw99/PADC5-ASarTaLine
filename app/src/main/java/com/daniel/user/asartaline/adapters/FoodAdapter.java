package com.daniel.user.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.delegate.FoodItemDelegate;
import com.daniel.user.asartaline.viewholders.FoodViewHolder;

public class FoodAdapter extends BaseRecyclerAdapter<FoodViewHolder> {
    private FoodItemDelegate foodItemDelegate;

    public FoodAdapter(Context context, FoodItemDelegate foodItemDelegate) {
        super(context);
        this.foodItemDelegate = foodItemDelegate;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view, foodItemDelegate);
    }
}

