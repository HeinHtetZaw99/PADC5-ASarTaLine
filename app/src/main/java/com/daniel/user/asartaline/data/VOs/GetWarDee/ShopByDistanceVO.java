package com.daniel.user.asartaline.data.VOs.GetWarDee;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "shop_by_distance")
public class ShopByDistanceVO {

    @PrimaryKey
    @NonNull
    @SerializedName("shopByDistanceId")
    private String shopId;

    public String distanceInFeet;
    @Ignore
    @SerializedName("mealShop")
    private MealShopVO mealShop;

    public String getDistanceInFeet() {
        return distanceInFeet;
    }

    public void setDistanceInFeet(String distanceInFeet) {
        this.distanceInFeet = distanceInFeet;
    }

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
