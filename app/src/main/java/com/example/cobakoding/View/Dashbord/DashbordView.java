package com.example.cobakoding.View.Dashbord;

import com.example.cobakoding.DTO.UserDTO;

import java.util.List;

public interface DashbordView {

    public void onFindUser(String nama, String email, String text);

    public void onLoadUserSuccess(List<UserDTO> results);



}
