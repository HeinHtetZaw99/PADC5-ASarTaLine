package com.daniel.user.asartaline.data.VOs.GetShopList;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.daniel.user.asartaline.persistence.typeconvertors.WarDeeImagesTypeConvertor;

import java.util.List;


@Entity(tableName = "shops")
@TypeConverters(WarDeeImagesTypeConvertor.class)
public class ShopVO {

    @PrimaryKey
    @NonNull
    private String shopId;

    private String name;
    private String address;
    private String lat;
    private String lng;
    private String township;
    private String popularity;
    private List<String> shopImages;

    @Ignore
    private List<ReviewsVO> reviews;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public void setShopImages(List<String> shopImages) {
        this.shopImages = shopImages;
    }

    public List<ReviewsVO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewsVO> reviews) {
        this.reviews = reviews;
    }


}
