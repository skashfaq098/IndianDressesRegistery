package com.example.indiandressesstocks.rest;

import com.example.indiandressesstocks.model.ItemsObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("1dUu0Ggb09eCV5kuaUS6iIHb_jSX19O0qA7CtkMqMJwo/values/Sheet1?key=AIzaSyAZ4ReIxkuA4jtDQzulRSnwwPpATtO4F_A")
    Call<ItemsObject> getItem();

//    @POST("/api/users")
//    Call<User> createUser(@Body User user);
//
//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}