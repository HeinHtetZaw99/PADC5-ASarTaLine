package com.daniel.user.asartaline.viewholders;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.components.UIUtils;
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


    @SuppressLint("CheckResult")
    @Override
    public void setData(WarDeeVO data) {
        warDeeVO = data;

        RequestOptions options = new RequestOptions();
        options.centerCrop();
        Glide.with(imageView)
                .asBitmap()
                .apply(options)
                .load(data.getImages().get(0))
                .into(UIUtils.getRoundedImageTarget(itemView.getContext(), imageView, 20.0f));
        foodName.setText(data.getWarTeeName());
        foodPrice.setText(data.getMinPrice() + " - " + data.getMaxPrice());
        foodTaste.setText(data.getGeneralTaste().get(0).getTaste());
    }

    @Override
    public void onClick(View v) {
        foodItemDelegate.onTapFoodItem(warDeeVO.getWarDeeId());
    }
}
