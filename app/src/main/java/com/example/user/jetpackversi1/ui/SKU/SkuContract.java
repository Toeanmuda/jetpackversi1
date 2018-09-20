package com.example.user.jetpackversi1.ui.SKU;

import com.example.user.jetpackversi1.dao.Datasku;

public interface SkuContract {

    void OnSuccess(Datasku data);
    void OnError(String message);
}
