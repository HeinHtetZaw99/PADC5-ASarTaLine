package com.daniel.user.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.delegate.FoodItemDelegate;
import com.daniel.user.asartaline.viewholders.SuggestionViewHolder;

public class SuggestionAdapter extends BaseRecyclerAdapter<SuggestionViewHolder> {
    private FoodItemDelegate foodItemDelegate;

    public SuggestionAdapter(Context context, FoodItemDelegate foodItemDelegate) {
        super(context);
        this.foodItemDelegate = foodItemDelegate;
    }

    @NonNull
    @Override
    public SuggestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflator.inflate(R.layout.item_food, parent, false);
        return new SuggestionViewHolder(view, foodItemDelegate);
    }
}
