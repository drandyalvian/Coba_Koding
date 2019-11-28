package com.example.cobakoding.Api;

import com.example.cobakoding.DTO.UserDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EditDataApi {

    @GET("user/{id}")
    Call<UserDTO> findUser(@Path("id") int id);

//    @PUT("user")
//    Call<UserDTO> updateUser(@Field("id") int id,
//                             @Field("nama") String nama,
//                             @Field("email") String email,
//                             @Field("text") String text);

    @PUT("user/{id}")
    Call<UserDTO> updateUser(@Path("id") int id, @Body UserDTO Body);

    @POST("user")
    Call<UserDTO> addUser(@Body UserDTO body);

    @DELETE("user/{id}")
    Call<UserDTO> deleteUser(@Path("id") int id);


}