package com.example.cobakoding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cobakoding.Api.LoginApi;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.Dialog.LoadingDialog;
import com.example.cobakoding.Session.SessionManager;
import com.example.cobakoding.View.Dashbord.DashbordAct;
import com.example.cobakoding.View.Dashbord.DashbordPresenter;

import java.security.Key;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginAct extends AppCompatActivity implements LoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btnlogin)
    Button btnlogin;

    LoginApi loginApi;

    private LoginPresenter loginPresenter;

    private LoadingDialog loadingDialog;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Nama = "nameKey";
    public static final String Password = "passKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        loginPresenter = new LoginPresenter(this);
        loadingDialog = new LoadingDialog(this);

        username.setText("admin");
        password.setText("123");

//        if(SessionManager.getInstance(this).getEmail() != null){
//            username.setText(SessionManager.getInstance(this).getEmail());
//        }

    }

    @OnClick(R.id.btnlogin)
    public void btnlogin(View view){

        loginPresenter.doLogin(username.getText().toString(), password.getText().toString());

    }

    @Override
    public void showLoading() {
        loadingDialog.showDialog();
    }

    @Override
    public void hideLoading() {
        loadingDialog.hideDialog();

    }

    @Override
    public void onLoginSuccess(int keyId) {

//        if(keyId != 0){
//            SessionManager.getInstance(this).setEmail(username);
//
//        }

        Intent go = new Intent(LoginAct.this, DashbordAct.class);
        go.putExtra("id", keyId);
        startActivity(go);

    }

    @Override
    public void onLoginFailure() {

//        Toast.makeText(LoginAct.this, "Login Gagal",
//                Toast.LENGTH_SHORT).show();

    }

}
