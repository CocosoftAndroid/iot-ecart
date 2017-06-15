package com.example.coco.coconfctag.network;

/**
 * Created by cocoadmin on 5/3/2017.
 */
import com.example.coco.coconfctag.loginmodule.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("Users/{user_id}/")
    Call<User> getUser(@Path(value = "user_id", encoded = true) int userId);

  /*  @POST("Users/")
    Call<User> doSignUp(@Path(value = "user_id", encoded = true) int userId);*/

    @POST("Users/")
    Call<User> createUser(@Body User user);

    @GET("Users/")
    Call<ArrayList<User>> getAllUsers();
}