package com.benouada.damine.wirelesshomeapplication.api.common;

// Service CallBack
public interface IServiceCallBack<T> {

    public void start();

    public void success(T value);

    public void failure(String error);

    public void finish();
}
