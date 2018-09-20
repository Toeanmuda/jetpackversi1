package com.example.user.jetpackversi1.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.user.jetpackversi1.App;
import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.UserDao;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.Login.LoginViewModel;
import com.example.user.jetpackversi1.ui.Login.LoginViewModelFactory;
import com.example.user.jetpackversi1.databinding.MainDataBinding;
import com.example.user.jetpackversi1.ui.SKU.SkuForm;

import javax.inject.Inject;

import dagger.Module;
import es.dmoral.toasty.Toasty;
@Module
public class MainActivity extends AppCompatActivity implements MainContract{
    @Inject
    AppDatabase appDatabase;

    @Inject
    ApiInterface apiInterface;

    MainContract mainContract;

    MainDataBinding mainDataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getNetComponent().inject(this);
        mainDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainDataBinding.setViewModel(ViewModelProviders.of(this,new MainViewModelFactory(this,this,apiInterface,appDatabase)).get(MainActivityModel.class));


    }

    @Override
    public void clickbutton() {

        if (TextUtils.isEmpty(mainDataBinding.username.getText())) {
            Intent replyIntent = new Intent();
            setResult(RESULT_CANCELED, replyIntent);
            finish();
        } else {

            Intent replyIntent = new Intent();
            replyIntent.putExtra("nama",mainDataBinding.username.getText().toString());
            replyIntent.putExtra("nama1",mainDataBinding.password.getText().toString());
            setResult(Activity.RESULT_OK, replyIntent);
            finish();
        }

    }

    @Override
    public void clickbutton1() {
        Intent replyIntent = new Intent();
        setResult(2, replyIntent);
        finish();
    }


}
