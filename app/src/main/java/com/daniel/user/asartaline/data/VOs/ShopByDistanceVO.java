package com.daniel.user.asartaline.data.VOs;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "shop_by_distance", indices = {@Index(value = "warDeeId")},
        foreignKeys = {@ForeignKey(entity = WarDeeVO.class, parentColumns = "warDeeId", childColumns = "warDeeId")})
public class ShopByDistanceVO {
    @PrimaryKey
    @SerializedName("shopByDistanceId")
    private String shopId;

    @Ignore
    @SerializedName("mealShop")
    private List<MealShopVO> mealShop;

    private String warDeeId;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public List<MealShopVO> getMealShop() {
        return mealShop;
    }

    public void setMealShop(List<MealShopVO> mealShop) {
        this.mealShop = mealShop;
    }
}
