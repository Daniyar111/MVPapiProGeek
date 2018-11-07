package com.example.daniyar.testmvp;

import android.app.Application;
import android.content.Context;

import com.example.daniyar.testmvp.data.network.NetworkBuilder;
import com.example.daniyar.testmvp.data.network.RetrofitService;

public class TestApplication extends Application {

    private RetrofitService mService;

    @Override
    public void onCreate() {
        super.onCreate();

        mService = NetworkBuilder.initService();
    }

    public static TestApplication get(Context context){
        return (TestApplication) context.getApplicationContext();
    }

    public RetrofitService getService() {
        return mService;
    }
}
