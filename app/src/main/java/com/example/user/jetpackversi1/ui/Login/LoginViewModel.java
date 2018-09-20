package com.example.user.jetpackversi1.ui.Login;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.example.user.jetpackversi1.dao.AppDatabase;

import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.data.model.UserModel;

import com.example.user.jetpackversi1.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginViewModel extends ViewModel {

    private UserModel user;
    private LoginContract loginContract;
    private ApiInterface apiInterface;
   Retrofit retrofit;
   private AppDatabase appDatabase;

    public LiveData<Integer> getDatanama() {
        return datanama;
    }

    public MutableLiveData<String> getDatapass() {
        return datapass;
    }




    public LoginViewModel(Context application, LoginContract loginContract, ApiInterface apiInterface, AppDatabase appDatabase) {
        this.loginContract = loginContract;
        this.user= new UserModel();
        this.apiInterface=apiInterface;
        this.appDatabase=appDatabase;
        datanama=appDatabase.userDao().datajumlah();
        ini=appDatabase.userDao().loadAll();
    }
    public final LiveData<Integer> datanama;
    public final MutableLiveData<String> datapass = new MutableLiveData<>();

    private final LiveData<List<userdata>> ini;
    public LiveData<List<userdata>> getIni() {
        return ini;
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
                    //datanama.postValue(s.toString());
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
                datapass.postValue(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
       // loginContract.login();

        if(isEmailAndPasswordValid(user.getUserName(),user.getPassword())==null)
          loginaction(user.getUserName(),user.getPassword());
        else loginContract.OnError(isEmailAndPasswordValid(user.getUserName(),user.getPassword()));
    }

    public String isEmailAndPasswordValid(String email, String password)
    {
        if (TextUtils.isEmpty(email)) {
            return "Email anda belum diisi";
        }

        if (TextUtils.isEmpty(password)){
            return "Password anda Belum diisi";
        }
        return null;
    }


    public void loginaction(String email,String password){
        //isShownLoader.setValue(true);
        loginContract.OnSuccess("OK","sukses","sukses");
        /*
        String ini="0000";
      //  UserModel user1 = ;
        Log.i("user",email);
        Log.i("pass",password);
        //Log.i("usersa",user1.getUserName());
       // Log.i("passsa",user1.getPassword());

         apiInterface.postLogin2(new UserModel(email, password, ini)).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if (response.isSuccessful()) {
                    // parse into model
                    UserModel profile = response.body();
                    Log.i("login",profile.getStatus().getLogin());
                    if(profile.getStatus().getLogin().equals("OK")){
                        loginContract.OnSuccess("OK",response.body().getUserName(),response.body().getImeiNumber());
                    }
                    else{
                        loginContract.OnError(profile.getStatus().getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                loginContract.OnError(t.toString());
            }
        });
*/
    }

    public void onLoginClickenext (View view){
        loginContract.clickbutton3();
    }
}
