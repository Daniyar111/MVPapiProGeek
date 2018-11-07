package com.example.daniyar.testmvp.ui.currency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniyar.testmvp.R;
import com.example.daniyar.testmvp.data.network.NetworkBuilder;

public class CurrencyActivity extends AppCompatActivity implements CurrencyContract.View {

    private CurrencyPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        mPresenter = new CurrencyPresenter(NetworkBuilder.initService());
        mPresenter.bind(this);

        mPresenter.getCurrency();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
