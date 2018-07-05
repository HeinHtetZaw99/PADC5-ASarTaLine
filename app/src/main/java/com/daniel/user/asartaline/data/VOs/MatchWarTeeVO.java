package com.daniel.user.asartaline.data.VOs;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "match_war_tee", indices = {@Index(value = "warDeeId")},
        foreignKeys = {@ForeignKey(entity = WarDeeVO.class, parentColumns = "warDeeId", childColumns = "warDeeId")})
public class MatchWarTeeVO {
    @PrimaryKey
    @SerializedName("warDeeId")
    private List<String> matchWarDeeId;

    private String warDeeId;

    public List<String> getMatchWarDeeId() {
        return matchWarDeeId;
    }

    public void setMatchWarDeeId(List<String> matchWarDeeId) {
        this.matchWarDeeId = matchWarDeeId;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }
}
