package com.example.daniyar.testmvp.ui;

public interface LifeCycle<V> {

    void bind(V view);

    void unbind();
}
