package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.WarDeeVO;

import java.util.List;

@Dao
public interface WarDeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertWarDee(WarDeeVO... warDeeVOS);

    @Query("SELECT * FROM war_dee")
    List<WarDeeVO> getAllWarDee();

    @Query("SELECT * FROM war_dee WHERE warDeeId = :warDeeId")
    WarDeeVO getWarDeeById(String warDeeId);

    @Query("SELECT * FROM war_dee WHERE warDeeId = :warDeeId")
    LiveData<List<WarDeeVO>> getWarDeeLDById(String warDeeId);
}
