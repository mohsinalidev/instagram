package com.ali.corp.instagram.data;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by ali on 9/9/2014.
 */
public interface RetrofitApi {

    @GET("/v1/tags/{hashTag}/media/recent")
    public void getdata(@Path("hashTag") String hashTag, @Query("access_token") String token, Callback<Model> result);

    @GET("/v1/tags/{hashTag}/media/recent")
    public void getdata(@Path("hashTag") String hashTag, @Query("access_token") String token, @Query("max_tag_id") String max_tag_id, Callback<Model> result);

}
