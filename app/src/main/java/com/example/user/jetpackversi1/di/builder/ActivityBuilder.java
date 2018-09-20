package com.example.user.jetpackversi1.di.builder;

import com.example.user.jetpackversi1.ui.Login.Login;
import com.example.user.jetpackversi1.ui.MainActivity;
import com.example.user.jetpackversi1.ui.SKU.SkuForm;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules={Login.class})
  abstract Login bindLoginActivity();

  @ContributesAndroidInjector(modules = {})
  abstract MainActivity bindMainActivity();

  @ContributesAndroidInjector(modules = {})
  abstract SkuForm bindSkuForm();
}
