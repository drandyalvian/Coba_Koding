package com.example.cobakoding.Api;

import com.example.cobakoding.DTO.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginApi {

    @POST("user")
    Call<List<UserDTO>> doLogin (
            @Field("username") String username,
            @Field("pass") String pass

    );

    @GET("user")
    Call<UserDTO> add();

    @GET("user")
    Call<List<UserDTO>> doLogin2 ();
}
