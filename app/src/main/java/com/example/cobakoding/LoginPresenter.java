package com.example.cobakoding;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.example.cobakoding.Api.LoginApi;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.Network.ApiClient;
import com.example.cobakoding.Session.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoginPresenter {

    private LoginView view;
    SessionManager sessionManager;

    LoginApi loginApi;
    Context context;

    public LoginPresenter(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public LoginPresenter (LoginView view) {

        this.view = view;
    }

//    void doFindLogin(final String xid){
//
//    }

    void doLogin (final String username, final String password) {

        view.showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loginApi = ApiClient.getClient().create(LoginApi.class);

                Call<List<UserDTO>> call = loginApi.doLogin2();

                call.enqueue((new Callback<List<UserDTO>>() {
                    @Override
                    public void onResponse(Call<List<UserDTO>> call, Response<List<UserDTO>> response) {

//                        view.onLoopSuccess(response.body());

                        List<UserDTO> loginResponse = response.body();
                        for (UserDTO userDTO : loginResponse) {

                            if (username.equals(userDTO.getNama()) && password.equals(userDTO.getPass())){

                                int keyId = userDTO.getId();
//                                String xusernmae = userDTO.getNama();
//                                SessionManager.getInstance(context).setEmail(xusernmae);
                                view.onLoginSuccess(keyId);

                            }else {
                                view.onLoginFailure();

                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<List<UserDTO>> call, Throwable t) {


                    }
                }));

                view.hideLoading();
            }
        }, 3000);


    }
}
