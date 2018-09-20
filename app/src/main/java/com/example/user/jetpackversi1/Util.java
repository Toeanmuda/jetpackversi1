package com.example.user.jetpackversi1;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Patterns;

import java.io.IOException;
import java.io.InputStream;

public class Util {

  public static final String BASE_URL = "http://sadix.net/sadixapi/";
  public static final String dbName = "dbMahasiswa";
  public static boolean isEmailValid(String paramString)
  {
    return Patterns.EMAIL_ADDRESS.matcher(paramString).matches();
  }

}
