package com.example.daniyar.testmvp.data.network;

import com.example.daniyar.testmvp.config.AppConstants;
import com.example.daniyar.testmvp.data.entity.CurrencyModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET(AppConstants.END_POINT)
    Call<CurrencyModel> getLatestCurrency(@Query("access_key") String key);
}
