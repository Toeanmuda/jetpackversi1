package com.example.user.jetpackversi1.ui.SKU;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.user.jetpackversi1.App;
import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.AppDatabase;
import com.example.user.jetpackversi1.dao.Datasku;

import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.SkuDataBinding;
import com.example.user.jetpackversi1.ui.Login.Login;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import dagger.Module;
import es.dmoral.toasty.Toasty;

@Module
public class SkuForm extends AppCompatActivity implements SkuContract {
    @Inject
    AppDatabase appDatabase;
    SkuDataBinding skuDataBinding;
    SKUAdapter skuAdapter;
    ArrayList<Datasku> ini= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getNetComponent().inject(this);

        skuAdapter= new SKUAdapter(this,appDatabase);
        skuDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_sku_form);
        skuDataBinding.setViewModel(ViewModelProviders.of(this,new SkuViewModelFactory(this,this,appDatabase)).get(SkuViewModel.class));
        skuDataBinding.recycle1.setAdapter(skuAdapter);
        skuDataBinding.recycle1.setLayoutManager(new LinearLayoutManager(this));

        skuDataBinding.getViewModel().getIni().observe(this, new Observer<List<Datasku>>() {
            @Override
            public void onChanged(@Nullable List<Datasku> data) {

                skuAdapter.setmUsers(data);
            }

        });
    }

    @Override
    public void OnSuccess(Datasku message) {
        Toasty.error(this,"ini", Toast.LENGTH_SHORT).show();
        insertData(message);
    }
    @SuppressLint("StaticFieldLeak")
    private void insertData(final Datasku user){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                //Menjalankan proses insert data
                return appDatabase.dataskuDao().insertuser(user);
            }

            @Override
            protected void onPostExecute(Long status) {
                //Menandakan bahwa data berhasil disimpan
                Toast.makeText(SkuForm.this, "Status Row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
    @Override
    public void OnError(String message) {
        Toasty.error(this,message, Toast.LENGTH_SHORT).show();
    }
}
