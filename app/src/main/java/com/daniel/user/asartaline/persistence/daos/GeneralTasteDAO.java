package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.GetWarDee.GeneralTasteVO;

import java.util.List;

@Dao
public interface GeneralTasteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertGeneralTaste(GeneralTasteVO... generalTasteVOS);

    @Query("SELECT * FROM general_taste")
    List<GeneralTasteVO> getAllTastes();

    @Query("SELECT * FROM general_taste WHERE tasteId = :tasteId")
    GeneralTasteVO getTasteById(String tasteId);

    @Query("SELECT * FROM general_taste WHERE tasteId = :tasteId")
    LiveData<List<GeneralTasteVO>> getTasteLDById(String tasteId);
}
