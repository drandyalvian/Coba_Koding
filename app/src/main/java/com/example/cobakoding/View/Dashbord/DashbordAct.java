package com.example.cobakoding.View.Dashbord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobakoding.Adapter.DashbordAdapter;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.R;
import com.example.cobakoding.View.EditData.EditDataAct;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashbordAct extends AppCompatActivity implements DashbordView {

    @BindView(R.id.btnEdit)
    Button btnEdit;
    @BindView(R.id.xnama)
    TextView xnama;
    @BindView(R.id.xemail)
    TextView xemail;
    @BindView(R.id.xtext)
    TextView xtext;

    DashbordPresenter dashbordPresenter;
    @BindView(R.id.recycler_view)

    RecyclerView recyclerView;
    List<UserDTO> userDTOList;
    DashbordAdapter dashbordAdapter;


//    int xid = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        ButterKnife.bind(this);



        Intent mIntent = getIntent();
        final int xid = mIntent.getIntExtra("id", 0);
        btnEdit.setText(String.valueOf(xid));

        dashbordPresenter = new DashbordPresenter(this);

        dashbordPresenter.doFindUser(xid);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        userDTOList = new ArrayList<>();
        recyclerView.setLayoutManager(layoutManager);
        dashbordAdapter = new DashbordAdapter(getApplicationContext(),userDTOList);

        dashbordPresenter.doFindListUser(dashbordAdapter, recyclerView);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(DashbordAct.this, EditDataAct.class);
                go.putExtra("id", xid);
                startActivity(go);

            }
        });

    }

    @Override
    public void onFindUser(String nama, String email, String text) {

        xnama.setText(nama);
        xemail.setText(email);
        xtext.setText("Text : " + text);

    }

    @Override
    public void onLoadUserSuccess(List<UserDTO> results) {


    }


}
