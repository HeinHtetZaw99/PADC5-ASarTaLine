package com.daniel.user.asartaline.persistence.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.daniel.user.asartaline.data.VOs.MatchWarTeeVO;

import java.util.List;

@Dao
public interface MatchWarDeeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertMatchWarDee(MatchWarTeeVO... matchWarTeeLists);

    @Query("SELECT * FROM match_war_tee WHERE warDeeId = :warDeeId")
    MatchWarTeeVO getMatchWarDeeById(String warDeeId);

    @Query("SELECT * FROM match_war_tee WHERE warDeeId = :warDeeId")
    LiveData<List<MatchWarTeeVO>> getMatchWarDeeLDById(String warDeeId);
}
