package com.example.cobakoding.View.Dashbord;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobakoding.Adapter.DashbordAdapter;
import com.example.cobakoding.Api.DashbordApi;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.Network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashbordPresenter {

    DashbordApi dashbordApi;
    DashbordView view;


//    private ArrayList<UserDTO> userList;
    private DashbordAdapter dashbordAdapter;

//    private ArrayList<UserDTO> userList;
    List<UserDTO> userList = new ArrayList<>();

    public DashbordPresenter(DashbordView view) {
        this.view = view;
    }




    public void doFindUser(int xid){

        dashbordApi = ApiClient.getClient().create(DashbordApi.class);

        Call<UserDTO> call = dashbordApi.findUser(xid);

        call.enqueue((new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

                UserDTO userResponse = response.body();

                String xusername = userResponse.getNama();
                String xemail = userResponse.getEmail();
                String xtext = userResponse.getText();

                view.onFindUser(xusername, xemail, xtext);

            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        }));

    }

    public void doFindListUser(DashbordAdapter dashbordAdapter, RecyclerView recyclerView){
        dashbordApi = ApiClient.getClient().create(DashbordApi.class);

        Call<List<UserDTO>> call = dashbordApi.listFindUser();

        call.enqueue((new Callback<List<UserDTO>>() {
            @Override
            public void onResponse(Call<List<UserDTO>> call, Response<List<UserDTO>> response) {
                if(response.isSuccessful()){

                    userList = response.body();

                    recyclerView.setAdapter(dashbordAdapter);
                    dashbordAdapter.setUsers(userList);

                }

            }

            @Override
            public void onFailure(Call<List<UserDTO>> call, Throwable t) {

            }
        }));
    }















//    public void doListUser(){
//
//        dashbordApi = ApiClient.getClient().create(DashbordApi.class);
//
//        Call<List<UserDTO>> call = dashbordApi.listUser();
//        call.enqueue((new Callback<List<UserDTO>>() {
//            @Override
//            public void onResponse(Call<List<UserDTO>> call, Response<List<UserDTO>> response) {
//                view.onLoadUserSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<UserDTO>> call, Throwable t) {
//
//            }
//        }));
//        Call<UserDTO> call = dashbordApi.listUser();
//
//        call.enqueue((new Callback<UserDTO>() {
//            @Override
//            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
//
//
////                if (response.isSuccessful()) {
////                    userList= response.body().getUser;
////                    eAdapter = new NoteAdapter(userList);
////                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
////                    recyclerView.setLayoutManager(eLayoutManager);
////                    recyclerView.setItemAnimator(new DefaultItemAnimator());
////                    recyclerView.setAdapter(eAdapter);
////                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserDTO> call, Throwable t) {
//
//
//            }
//        }));

//    }


}
