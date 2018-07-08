package com.daniel.user.asartaline.persistence.daos.base;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(T data);

    @Update
    void update(T data);

    @Delete
    void delete(T data);

    @Insert
    long[] insertAll(List<T> data);
}
