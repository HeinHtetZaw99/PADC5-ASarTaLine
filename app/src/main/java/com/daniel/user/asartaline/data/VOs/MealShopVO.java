package com.daniel.user.asartaline.data.VOs;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "meal_shop"
        , indices = {@Index(value = "warDeeId")},
        foreignKeys = {@ForeignKey(entity = WarDeeVO.class, parentColumns = "warDeeId", childColumns = "warDeeId")})
public class MealShopVO {
    @PrimaryKey
    @SerializedName("mealShopId")
    private String mealShopId;

    private String warDeeId;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getMealShopId() {
        return mealShopId;
    }

    public void setMealShopId(String mealShopId) {
        this.mealShopId = mealShopId;
    }
}
