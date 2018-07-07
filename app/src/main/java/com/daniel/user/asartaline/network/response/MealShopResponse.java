package com.daniel.user.asartaline.network.response;

import com.daniel.user.asartaline.data.VOs.GetShopList.ShopVO;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealShopResponse {
    private int code;
    private String message;
    private String apiVersion;
    @SerializedName("astlMealShop")
    private List<ShopVO> shops;

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

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<ShopVO> getShops() {
        return shops;
    }

    public void setShops(List<ShopVO> shops) {
        this.shops = shops;
    }
}
