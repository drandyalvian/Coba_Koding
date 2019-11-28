package com.example.cobakoding;

import com.example.cobakoding.DTO.UserDTO;

import java.util.List;

public interface LoginView {

    void showLoading();

    void hideLoading();

    void onLoginSuccess(int xid);

    void onLoginFailure();

//    void onLoopSuccess(List<UserDTO> results);

}
