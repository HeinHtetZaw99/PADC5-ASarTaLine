package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.GetWarDee.SuitedForVO;

import java.util.List;

@Dao
public interface SuitedForDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertSuitedFor(SuitedForVO... suitedForVOS);

    @Query("SELECT * FROM suited_for")
    List<SuitedForVO> getAllSuitedItems();

    @Query("SELECT * FROM suited_for WHERE warDeeId = :id")
    List<SuitedForVO> getSuitedItemsById(String id);

    @Query("SELECT * FROM suited_for WHERE suitedForId = :id")
    LiveData<List<SuitedForVO>> getSuitedItemsLDById(String id);
}
