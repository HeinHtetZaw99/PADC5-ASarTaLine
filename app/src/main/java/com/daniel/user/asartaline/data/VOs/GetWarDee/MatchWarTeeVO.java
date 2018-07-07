package com.daniel.user.asartaline.data.VOs.GetWarDee;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "match_war_tee")
public class MatchWarTeeVO {

    @PrimaryKey
    @NonNull
    @SerializedName("warDeeId")
    private String matchWarDeeId;


    @NonNull
    public String getMatchWarDeeId() {
        return matchWarDeeId;
    }

    public void setMatchWarDeeId(@NonNull String matchWarDeeId) {
        this.matchWarDeeId = matchWarDeeId;
    }

}
