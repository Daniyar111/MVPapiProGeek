package com.example.daniyar.testmvp.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniyar.testmvp.R;
import com.example.daniyar.testmvp.ui.currency.CurrencyActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View, View.OnClickListener {

    private TextView mTextView;
    private Button mButtonMinus, mButtonPlus, mButtonCurrency;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter();
        mPresenter.bind(this);

        mTextView = findViewById(R.id.textView);
        mButtonMinus = findViewById(R.id.buttonMinus);
        mButtonPlus = findViewById(R.id.buttonPlus);
        mButtonCurrency = findViewById(R.id.buttonCurrency);

        mButtonMinus.setOnClickListener(this);
        mButtonPlus.setOnClickListener(this);
        mButtonCurrency.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonMinus:
                mPresenter.decreaseTextSize(mTextView.getTextSize() / getResources().getDisplayMetrics().scaledDensity);
                break;
            case R.id.buttonPlus:
                mPresenter.increaseTextSize(mTextView.getTextSize() / getResources().getDisplayMetrics().scaledDensity);
                break;
            case R.id.buttonCurrency:
                startActivity(new Intent(this, CurrencyActivity.class));
                break;
        }
    }

    @Override
    public void showText(float textSize) {
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unbind();
    }
}
