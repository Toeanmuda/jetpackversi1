package com.example.user.jetpackversi1.ui.Login;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.jetpackversi1.App;
import com.example.user.jetpackversi1.R;
import com.example.user.jetpackversi1.dao.AppDatabase;

import com.example.user.jetpackversi1.dao.Datasku;
import com.example.user.jetpackversi1.dao.userdata;
import com.example.user.jetpackversi1.databinding.LoginDataBinding;

import com.example.user.jetpackversi1.rest.ApiInterface;
import com.example.user.jetpackversi1.ui.MainActivity;
import com.example.user.jetpackversi1.ui.SKU.SkuForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import es.dmoral.toasty.Toasty;

@Module
public class Login extends AppCompatActivity implements LoginContract {

    @Inject
    ApiInterface apiInterface;

    @Inject
    AppDatabase appDatabase;

    LoginAdapter loginAdapter;

        public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    LoginDataBinding loginDataBinding;
    LoginViewModel loginViewModel;
    LoginContract loginContract;
    Application application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getNetComponent().inject(this);
        loginAdapter= new LoginAdapter(this,appDatabase);

        //AndroidInjection.inject(this);
       //((App) getApplication()).getNetComponent().inject(this);

        loginDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginDataBinding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this,this,apiInterface,appDatabase)).get(LoginViewModel.class));

        loginDataBinding.recycle.setAdapter(loginAdapter);
        loginDataBinding.recycle.setLayoutManager(new LinearLayoutManager(this));

        loginDataBinding.getViewModel().getIni().observe(this, new Observer<List<userdata>>() {
          @Override
         public void onChanged(@Nullable List<userdata> userdata) {

              loginAdapter.setmUsers(userdata);
           }

        });



        loginDataBinding.getViewModel().getDatanama().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer s) {
                loginDataBinding.datanama1.setText("jumlah data="+String.valueOf(s));
            }
        });




      loginDataBinding.getViewModel().getDatapass().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
           //     loginDataBinding.datapass1.setText(String.valueOf(loginAdapter.getItemCount()));
            }
        });




    }



/*
    public void login(View v) {
        if(retrofit!=null) {
            Log.i("usersa=", "gagal");

            String user = loginDataBinding.username.getText().toString();
            String pass = loginDataBinding.password.getText().toString();
            Log.i("usersa=", user);
            Log.i("passsa=", pass);
            if (loginDataBinding.getViewModel().isEmailAndPasswordValid(user, pass) == null) {
                // loginDataBinding.getViewModel().loginaction(user,pass);
                String ini = "0000";
                UserModel user1 = new UserModel(user, pass, ini);
                ApiInterface getApiInterface = retrofit.create(ApiInterface.class);
                Call<UserModel> call = getApiInterface.postLogin2(user1);
                Log.i("user", user);
                Log.i("pass", pass);
                Log.i("usersa", user1.getUserName());
                Log.i("passsa", user1.getPassword());
                call.enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if (response.isSuccessful()) {
                            // parse into model
                            UserModel profile = response.body();
                            Log.i("login", profile.getStatus().getLogin());
                            if (profile.getStatus().getLogin().equals("OK")) {
                                Toasty.success(Login.this, "OK", Toast.LENGTH_SHORT).show();

                            } else {
                                Toasty.error(Login.this, profile.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        Toasty.error(Login.this, t.toString(), Toast.LENGTH_SHORT).show();

                    }
                });

            } else
                Toasty.error(this, loginDataBinding.getViewModel().isEmailAndPasswordValid(user, pass), Toast.LENGTH_SHORT).show();
        }
        else{
            Log.w("FAILED","NULL");
        }
    }
*/
    @Override
    public void openMainActivity() {

    }



    @Override
    public void OnSuccess(String message,String inu, String itu) {
        Toasty.success(this,message, Toast.LENGTH_SHORT).show();
     //  startActivity(new Intent(this, MainActivity.class));

        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);


      //  userdata ini=new userdata(itu,inu);
        //insertData(ini);
      //  userdata word = new userdata("ini","itu");
        //insertData(word);
       // database.userDao().deleteAll();

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            userdata word = new userdata(data.getStringExtra("nama1"),data.getStringExtra("nama"),false);
           // appDatabase.userDao().deleteitem(word);
            insertData(word);
            //updatedata(data.getStringExtra("nama"),data.getStringExtra("nama1"));
        }
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == 2) {
           appDatabase.userDao().deleteAll();
            finish();
            startActivity(getIntent());
        }
        else {
        }
    }

    //
    //@SuppressLint("StaticFieldLeak")
   // private void insertData(final userdata user){

        //Menjalankan proses insert data
    //}

    private void updatedata(String name, String id){
        appDatabase.userDao().update(name,id);
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
                Toast.makeText(Login.this, "Status Row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }



    @Override
    public void OnError(String message) {
        Toasty.error(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickbutton3() {

        String[][] A={{"2FF1CEBD-62EC-42FE-A2A3-6DD5F573879D","1","1","59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4",
                "00000000-0000-0000-0000-000000000002", "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"},
                {"9D2CAA66-7B8F-448A-8E10-FEBACEE0087E", "1", "1", "59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4", "00000000-0000-0000-0000-000000000001",
                        "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"},{ "EB617F61-0A70-412F-9CE5-A621F3CF9E94", "1", "1", "59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4",
                "00000000-0000-0000-0000-000000000000", "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"}};
/*
        String[] B={"2FF1CEBD-62EC-42FE-A2A3-6DD5F573879D","1","1","59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4",
                "00000000-0000-0000-0000-000000000002", "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"};

        String[] C= {"9D2CAA66-7B8F-448A-8E10-FEBACEE0087E", "1", "1", "59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4", "00000000-0000-0000-0000-000000000001",
                "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"};

        String[] D={ "EB617F61-0A70-412F-9CE5-A621F3CF9E94", "1", "1", "59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4",
                "00000000-0000-0000-0000-000000000000", "BOX", "2", "204", "0", "false", "0001-01-01T00:00:00+07:00"};

*/

String AB="[\n" +
        "  {\n" +
        "    \"trcSid\": \"2FF1CEBD-62EC-42FE-A2A3-6DD5F573879D\",\n" +
        "    \"trcType\": 1,\n" +
        "    \"coType\": 1,\n" +
        "    \"ptSid\": \"59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4\",\n" +
        "    \"skuSid\": \"00000000-0000-0000-0000-000000000002\",\n" +
        "    \"skuUnit\": \"BOX\",\n" +
        "    \"pckg\": 2,\n" +
        "    \"trcQty\": 204,\n" +
        "    \"trcAccept\": 0,\n" +
        "    \"isSync\": false,\n" +
        "    \"postDate\": \"0001-01-01T00:00:00+07:00\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"trcSid\": \"9D2CAA66-7B8F-448A-8E10-FEBACEE0087E\",\n" +
        "    \"trcType\": 1,\n" +
        "    \"coType\": 1,\n" +
        "    \"ptSid\": \"59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4\",\n" +
        "    \"skuSid\": \"00000000-0000-0000-0000-000000000001\",\n" +
        "    \"skuUnit\": \"BOX\",\n" +
        "    \"pckg\": 2,\n" +
        "    \"trcQty\": 204,\n" +
        "    \"trcAccept\": 0,\n" +
        "    \"isSync\": false,\n" +
        "    \"postDate\": \"0001-01-01T00:00:00+07:00\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"trcSid\": \"EB617F61-0A70-412F-9CE5-A621F3CF9E94\",\n" +
        "    \"trcType\": 1,\n" +
        "    \"coType\": 1,\n" +
        "    \"ptSid\": \"59EDF6F3-04EA-441B-8FF8-2F8F1D3DA6B4\",\n" +
        "    \"skuSid\": \"00000000-0000-0000-0000-000000000000\",\n" +
        "    \"skuUnit\": \"BOX\",\n" +
        "    \"pckg\": 2,\n" +
        "    \"trcQty\": 204,\n" +
        "    \"trcAccept\": 0,\n" +
        "    \"isSync\": false,\n" +
        "    \"postDate\": \"0001-01-01T00:00:00+07:00\"\n" +
        "  }\n" +
        "]";


        try {


            List<Datasku> dataa= new ArrayList<>();
            JSONArray jsonArray = new JSONArray(AB);
            for (int i = 0; i < jsonArray.length(); i++) {
               // JSONObject data=jsonArray.getJSONObject(i);
              //  dataa.add(data[i]);

                //JsonObject gson1 = new JsonParser().parse(data.toString()).getAsJsonObject();
               // JSONObject jo2 = new JSONObject(gson1.toString());


               // JsonParser p = new JsonParser();
                //JsonElement r = p.parse(data.toString());
                //JsonObject ob = r.getAsJsonObject();


                //Datasku ini=new Datasku();
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Datasku>>(){}.getType();
                List<Datasku> posts = gson.fromJson(AB,listType);
                Log.d("datanya", posts.get(i).toString());
                dataa.add(posts.get(i));

            }
            appDatabase.dataskuDao().insertMultipleMovies(dataa);

            startActivity(new Intent(this, SkuForm.class));


        } catch (JSONException e) {
            e.printStackTrace();
        }



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
                //Toast.makeText(Login.this, "Status Row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

}
