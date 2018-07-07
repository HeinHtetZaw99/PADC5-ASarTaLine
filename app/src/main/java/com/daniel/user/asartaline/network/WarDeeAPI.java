package com.daniel.user.asartaline.network;

import com.daniel.user.asartaline.network.response.MealShopResponse;
import com.daniel.user.asartaline.network.response.WarDeeResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WarDeeAPI {
    @FormUrlEncoded
    @POST("GetWarDee.php")
    Observable<WarDeeResponse> loadWarDees(
            @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("GetMealShop.php")
    Observable<MealShopResponse> loadShops(
            @Field("access_token") String accessToken);
}
