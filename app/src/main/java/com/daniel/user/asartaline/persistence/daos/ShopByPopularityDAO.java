package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.GetWarDee.ShopByPopularityVO;

import java.util.List;

@Dao
public interface ShopByPopularityDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShops(ShopByPopularityVO... shopByPopularityVOS);

    @Query("SELECT * FROM shop_by_popularity WHERE warDeeId = :warDeeId")
    ShopByPopularityVO getShopsById(String warDeeId);

    @Query("SELECT * FROM shop_by_popularity WHERE warDeeId = :warDeeId")
    LiveData<List<ShopByPopularityVO>> getShopsLDbyId(String warDeeId);
}
