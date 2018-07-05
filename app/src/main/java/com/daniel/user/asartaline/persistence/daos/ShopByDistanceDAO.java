package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.ShopByDistanceVO;

import java.util.List;

@Dao
public interface ShopByDistanceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertShops(ShopByDistanceVO... shopByDistanceVOS);

    @Query("SELECT * FROM shop_by_distance")
    List<ShopByDistanceVO> getAllShops();

    @Query("SELECT * FROM shop_by_distance WHERE warDeeId = :warDeeId")
    ShopByDistanceVO getShopsById(String warDeeId);

    @Query("SELECT * FROM shop_by_distance WHERE warDeeId = :warDeeId")
    LiveData<List<ShopByDistanceVO>> getShopsLDById(String warDeeId);
}
