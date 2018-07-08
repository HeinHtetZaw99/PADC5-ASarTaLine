package com.daniel.user.asartaline.data.VOs.GetWarDee;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "suited_for")
public class SuitedForVO {

    @PrimaryKey
    @NonNull
    @SerializedName("suitedForId")
    private String suitedForId;

    @SerializedName("suitedFor")
    private String suitedFor;

    @SerializedName("suitedForDesc")
    private String suitedForDesc;

    public String getSuitedForId() {
        return suitedForId;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }
}
