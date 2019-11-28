package com.example.cobakoding.Api;

import com.example.cobakoding.DTO.UserDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DashbordApi {

    @GET("user/{id}")
    Call<UserDTO> findUser(@Path("id") int id);

    @GET("user")
    Call<List<UserDTO>> listFindUser();

}