package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.GetWarDee.MealShopVO;

import java.util.List;

@Dao
public interface MealShopDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMealShops(MealShopVO... mealShopVOS);

    @Query("SELECT * FROM meal_shop")
    List<MealShopVO> getMealShop();

    @Query("SELECT * FROM meal_shop WHERE mealShopId = :shopId")
    MealShopVO getMealShopById(String shopId);

    @Query("SELECT * FROM meal_shop WHERE mealShopId = :shopId")
    LiveData<List<MealShopVO>> getMealShopLDById(String shopId);
}
