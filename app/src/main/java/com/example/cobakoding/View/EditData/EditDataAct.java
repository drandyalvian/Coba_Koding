package com.example.cobakoding.View.EditData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cobakoding.Api.EditDataApi;
import com.example.cobakoding.DTO.UserDTO;
import com.example.cobakoding.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditDataAct extends AppCompatActivity implements EditDataView {

    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.xnama)
    EditText xnama;
    @BindView(R.id.xemail)
    EditText xemail;
    @BindView(R.id.xtext)
    EditText xtext;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnDelet)
    Button btnDelet;
    @BindView(R.id.xid)
    EditText xid;

    EditDataPresenter editDataPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        ButterKnife.bind(this);

        editDataPresenter = new EditDataPresenter(this);

        Intent mIntent = getIntent();
        final int idx = mIntent.getIntExtra("id", 0);

        editDataPresenter.doFindUser(idx);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDTO xdata = new UserDTO(xnama.getText().toString(),
                        xemail.getText().toString(), xtext.getText().toString());

                if (xid != null || xid.equals(idx) ){

                    editDataPresenter.doUpdateUser(idx, xdata);

                }else {

                    editDataPresenter.doAddUser(xdata);

                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDTO xdata = new UserDTO(xnama.getText().toString(),
                        xemail.getText().toString(), xtext.getText().toString());

                editDataPresenter.doAddUser(xdata);

            }
        });


        btnDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editDataPresenter.doDeleteUser(Integer.parseInt(xid.getText().toString()));
            }
        });

    }

    @Override
    public void onFindUser(String nama, String email, String text, int id) {

        xnama.setText(nama);
        xemail.setText(email);
        xtext.setText(text);
        xid.setText(String.valueOf(id));

    }

    @Override
    public void onUpdateSuceess() {

        Toast.makeText(EditDataAct.this, "Update Success",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteSuccess() {

        Toast.makeText(EditDataAct.this, "Delete Success",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAddSuccess() {

        Toast.makeText(EditDataAct.this, "Add Success",
                Toast.LENGTH_SHORT).show();

    }


}
