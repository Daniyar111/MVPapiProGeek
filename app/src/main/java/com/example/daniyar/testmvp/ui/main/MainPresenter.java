package com.example.daniyar.testmvp.ui.main;

import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;

    public MainPresenter(){

    }

    @Override
    public void increaseTextSize(float textSize) {
        Log.d(TAG, "initialIncreaseTextSize: " + textSize);
        textSize += 2.0f;
        if(isViewAttached()){
            Log.d(TAG, "increaseTextSize: " + textSize);
            mView.showText(textSize);
        }
    }

    @Override
    public void decreaseTextSize(float textSize) {
        textSize -= 2.0f;
        if(isViewAttached()){
            Log.d(TAG, "increaseTextSize: " + textSize);
            mView.showText(textSize);
        }
    }

    @Override
    public void bind(MainContract.View view) {
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
