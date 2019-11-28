package com.example.cobakoding.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.R;
import com.example.cobakoding.View.Dashbord.DashbordAct;

import java.util.ArrayList;
import java.util.List;

public class DashbordAdapter extends RecyclerView.Adapter<DashbordAdapter.MyViewHolder>{


    Context context;
    List<UserDTO> usersList;

    public DashbordAdapter(Context c, List<UserDTO> p){

        this.context = c;
        this.usersList = p;
    }

    public void setUsers(List<UserDTO> users) {
        this.usersList = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserDTO userDTO = usersList.get(position);
        holder.xemail.setText(userDTO.getEmail());
        holder.xnama.setText(userDTO.getNama());

    }

    @Override
    public int getItemCount() {

        if(usersList != null){
            return usersList.size();
        }
        return 0;
//        return usersList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView xnama;
        public TextView xemail;

        public MyViewHolder(@NonNull View view) {
            super(view);

            xnama = view.findViewById(R.id.xnama);
            xemail = view.findViewById(R.id.xemail);

        }
    }
}
