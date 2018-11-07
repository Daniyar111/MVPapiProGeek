package com.example.daniyar.testmvp.ui.main;

import com.example.daniyar.testmvp.ui.LifeCycle;

public interface MainContract {

    interface View{

        void showText(float textSize);
    }

    interface Presenter extends LifeCycle<View> {

        void increaseTextSize(float textSize);

        void decreaseTextSize(float textSize);
    }
}
