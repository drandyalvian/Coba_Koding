package com.example.cobakoding.View.EditData;

import android.app.Activity;

import com.example.cobakoding.Api.EditDataApi;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.Network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class EditDataPresenter {

    EditDataView view;
    EditDataApi editDataApi;
    EditDataAct editDataAct;

    public EditDataPresenter(EditDataView view) {
        this.view = view;
    }

    public void doFindUser(int id){

        editDataApi = ApiClient.getClient().create(EditDataApi.class);

        Call<UserDTO> call = editDataApi.findUser(id);

        call.enqueue((new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

                UserDTO reseponseUser = response.body();
                String xnama = reseponseUser.getNama();
                String xemail = reseponseUser.getEmail();
                String xtext = reseponseUser.getText();
                int xid = reseponseUser.getId();

                view.onFindUser(xnama, xemail, xtext, xid);
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        }));
    }

    public void doUpdateUser(int id, UserDTO xuser){

        editDataApi = ApiClient.getClient().create(EditDataApi.class);

        Call<UserDTO> call = editDataApi.updateUser(id, xuser);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
                if(response.isSuccessful()){

                    view.onUpdateSuceess();

                }
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });

    }

    public void doAddUser(UserDTO xuser){

        editDataApi = ApiClient.getClient().create(EditDataApi.class);

        Call<UserDTO> call = editDataApi.addUser(xuser);
        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

                view.onAddSuccess();

            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });

    }

    public void doDeleteUser(int xid){

        editDataApi = ApiClient.getClient().create(EditDataApi.class);

        Call<UserDTO> call = editDataApi.deleteUser(xid);

        call.enqueue(new Callback<UserDTO>() {
            @Override
            public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {

                view.onDeleteSuccess();
            }

            @Override
            public void onFailure(Call<UserDTO> call, Throwable t) {

            }
        });

    }


}
