package com.daniel.user.asartaline.data.VOs.GetWarDee;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "shop_by_popularity")
public class ShopByPopularityVO {
    @NonNull
    @PrimaryKey
    @SerializedName("shopByPopularityId")
    private String shopId;

    @Ignore
    @SerializedName("mealShop")
    private MealShopVO mealShop;


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public MealShopVO getMealShop() {
        return mealShop;
    }

    public void setMealShop(MealShopVO mealShop) {
        this.mealShop = mealShop;
    }
}
