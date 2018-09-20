package com.example.user.jetpackversi1.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.data.model.UserModel;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.Login.Login;
import com.example.user.jetpackversi1.ui.Login.LoginContract;

import java.util.List;

import retrofit2.Retrofit;

public class MainActivityModel extends ViewModel {
    private UserModel user;
    private MainContract mainContract;
    private ApiInterface apiInterface;
    Retrofit retrofit;
    private AppDatabase appDatabase;
    Context mcontext;

    public MainActivityModel(Context application, MainContract mainContract, ApiInterface apiInterface, AppDatabase appDatabase) {
       this.mcontext=application;
        this.mainContract = mainContract;
        this.user= new UserModel();
        this.apiInterface=apiInterface;
        this.appDatabase=appDatabase;
     }

    public MainActivityModel(Context application, ApiInterface apiInterface, AppDatabase appDatabase) {
        this.mcontext=application;
        this.user= new UserModel();
        this.apiInterface=apiInterface;
        this.appDatabase=appDatabase;
    }

    @SuppressLint("StaticFieldLeak")
    private void insertData(final userdata user){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                //Menjalankan proses insert data
                return appDatabase.userDao().insertuser(user);
            }

            @Override
            protected void onPostExecute(Long status) {
                //Menandakan bahwa data berhasil disimpan
                Toast.makeText(mcontext, "Status Row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }


    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setUserName(s.toString());
    //            datanama.postValue(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
      //   insertData(new userdata(user.getUserName(),user.getPassword()));
         mainContract.clickbutton();

       }

    public void onLoginClickeddelete(View view){
        appDatabase.userDao().deleteAll();
        mainContract.clickbutton1();
    }

}
