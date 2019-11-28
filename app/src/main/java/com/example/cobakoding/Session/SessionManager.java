package com.example.cobakoding.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

    private static SharedPreferences pref;

    private static SharedPreferences prefKeep;

    private Editor editor;

    private Editor editorKeep;

    private static final int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "user-app";

    private static final String PREF_KEEP_NAME = "user-app-keep";

    private static final String IS_LOGIN = "IS_LOGIN";

    private static final String KEY_USER = "KEY_USER";

    private static final String KEY_EMAIL = "KEY_EMAIL";


    private static SessionManager Instance = null;

    Context context;

    private SessionManager (Context context) {
        this.context = context;

        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        prefKeep = context.getSharedPreferences(PREF_KEEP_NAME, PRIVATE_MODE);

        editor = pref.edit();
        editor.apply();

        editorKeep = prefKeep.edit();
        editorKeep.apply();

    }

    public synchronized static SessionManager getInstance(Context context){

        if (Instance == null){

            Instance =new SessionManager(context.getApplicationContext());

        }

        return Instance;

    }

    public void doLogin() {
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public boolean isLogin() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void setEmail(String email) {
        editorKeep.putString(KEY_EMAIL, email);
        editorKeep.commit();
    }

    public String getEmail() {
        return prefKeep.getString(KEY_EMAIL, null);
    }

}
