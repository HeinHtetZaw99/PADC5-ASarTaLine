package com.daniel.user.asartaline.network.response;

import com.daniel.user.asartaline.data.VOs.WarDeeVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarDeeResponse {
    private int code;
    private String message;
    private int apiVersion;
    @SerializedName("astlWarDee")
    private List<WarDeeVO> warDeeVO;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<WarDeeVO> getWarDeeVO() {
        return warDeeVO;
    }

    public void setWarDeeVO(List<WarDeeVO> warDeeVO) {
        this.warDeeVO = warDeeVO;
    }
}
