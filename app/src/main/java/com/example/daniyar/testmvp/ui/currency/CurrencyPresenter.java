package com.example.daniyar.testmvp.ui.currency;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.daniyar.testmvp.config.AppConstants;
import com.example.daniyar.testmvp.data.entity.CurrencyModel;
import com.example.daniyar.testmvp.data.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class CurrencyPresenter implements CurrencyContract.Presenter {

    private CurrencyContract.View mView;
    private RetrofitService mRetrofitService;

    CurrencyPresenter(RetrofitService retrofitService){
        mRetrofitService = retrofitService;
    }

    @Override
    public void getCurrency() {
        mRetrofitService.getLatestCurrency(AppConstants.API_KEY).enqueue(new Callback<CurrencyModel>() {
            @Override
            public void onResponse(@NonNull Call<CurrencyModel> call, @NonNull Response<CurrencyModel> response) {
                if(response.isSuccessful() && response.body() != null){
                    Log.d(TAG, "onResponse: " + response.body());
                }
                else{
                    Log.d(TAG, "onResponse: fail" );
                }
            }

            @Override
            public void onFailure(@NonNull Call<CurrencyModel> call, @NonNull Throwable t) {

            }
        });
    }

    @Override
    public void bind(CurrencyContract.View view) {
        mView = view;
    }

    @Override
    public void unbind() {
        mView = null;
    }

    private boolean isViewAttached(){
        return mView != null;
    }
}
