package com.example.cobakoding.Dialog;

import android.app.Activity;
import android.app.ProgressDialog;

public class LoadingDialog {

    private ProgressDialog pDialog;
    private Activity activity;

    public LoadingDialog(Activity activity) {
        this.activity = activity;

    }

    public void showDialog(){

        pDialog = new ProgressDialog(activity);
        pDialog.setMessage("Loading Data.");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    public void hideDialog(){

        pDialog.dismiss();
    }


}
