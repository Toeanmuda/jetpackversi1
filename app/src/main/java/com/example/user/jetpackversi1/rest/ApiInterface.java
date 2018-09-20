package com.example.user.jetpackversi1.rest;


import com.example.user.jetpackversi1.data.model.UserModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

      @Headers("Content-Type: application/json")
    @POST("api/user/login/driver")
    Call<ResponseBody> postLogin(@Body UserModel userModel);

    @Headers("Content-Type: application/json")
    @POST("api/user/login/driver")
    Call<UserModel> postLogin2(@Body UserModel userModel);


}
