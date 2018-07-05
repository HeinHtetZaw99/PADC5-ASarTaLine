package com.daniel.user.asartaline.network;

import com.daniel.user.asartaline.network.response.WarDeeResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WarDeeAPI {
    @FormUrlEncoded
    @POST("v1/GetWarDee.php")
    Observable<WarDeeResponse> loadWarDees(
            @Field("access_token") String accessToken);
}
