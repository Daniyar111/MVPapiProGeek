package com.example.daniyar.testmvp.ui.currency;

import com.example.daniyar.testmvp.ui.LifeCycle;

public interface CurrencyContract {

    interface View{

    }

    interface Presenter extends LifeCycle<View> {

        void getCurrency();
    }
}
