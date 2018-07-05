package com.daniel.user.asartaline.data.VOs;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "war_dee")
public class WarDeeVO {
    @PrimaryKey
    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String warTeeName;


    @SerializedName("images")
    private String[] images;

    @Ignore
    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTaste;

    @Ignore
    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFor;

    @SerializedName("priceRangeMin")
    private String minPrice;

    @SerializedName("priceRangeMax")
    private String maxPrice;

    @Ignore
    @SerializedName("matchWarDeeList")
    private List<MatchWarTeeVO> matchWarTees;

    @Ignore
    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistance;

    @Ignore
    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularity;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getWarTeeName() {
        return warTeeName;
    }

    public void setWarTeeName(String warTeeName) {
        this.warTeeName = warTeeName;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public List<GeneralTasteVO> getGeneralTaste() {
        return generalTaste;
    }

    public void setGeneralTaste(List<GeneralTasteVO> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<SuitedForVO> getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(List<SuitedForVO> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<MatchWarTeeVO> getMatchWarTees() {
        return matchWarTees;
    }

    public void setMatchWarTees(List<MatchWarTeeVO> matchWarTees) {
        this.matchWarTees = matchWarTees;
    }

    public List<ShopByDistanceVO> getShopByDistance() {
        return shopByDistance;
    }

    public void setShopByDistance(List<ShopByDistanceVO> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByPopularityVO> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setShopByPopularity(List<ShopByPopularityVO> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }
}
