package com.example.coco.coconfctag.retrofit;

/**
 * Created by cocoadmin on 5/3/2017.
 */
import com.example.coco.coconfctag.loginmodule.User;
import com.example.coco.coconfctag.loginmodule.UserItem;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("Users/{user_id}/")
    Call<User> getUser(@Path(value = "user_id", encoded = true) int userId);
}