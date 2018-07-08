package com.daniel.user.asartaline.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.delegate.FoodItemDelegate;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodViewHolder extends BaseViewHolders<WarDeeVO> {
    @BindView(R.id.food_imgView)
    ImageView imageView;
    @BindView(R.id.food_name)
    MMTextView foodName;
    @BindView(R.id.food_price)
    MMTextView foodPrice;
    @BindView(R.id.food_taste)
    MMTextView foodTaste;
    private FoodItemDelegate foodItemDelegate;

    WarDeeVO warDeeVO;

    public FoodViewHolder(View itemView, FoodItemDelegate foodItemDelegate) {
        super(itemView);
        this.foodItemDelegate = foodItemDelegate;
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void setData(WarDeeVO data) {
        warDeeVO = data;
        Glide.with(imageView)
                .load(data.getImages().get(0))
                .into(imageView);
        foodName.setText(data.getWarTeeName());
        foodPrice.setText(data.getMinPrice() + " - " + data.getMaxPrice());
        foodTaste.setText(data.getGeneralTaste().get(0).getTaste());
    }

    @Override
    public void onClick(View v) {
        foodItemDelegate.onTapFoodItem(warDeeVO.getWarDeeId());
    }
}
