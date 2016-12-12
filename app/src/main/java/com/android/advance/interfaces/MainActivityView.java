package com.android.advance.interfaces;

import android.content.Context;

import com.android.advance.model.TypeList;

public interface MainActivityView {
    void showIpInfo(TypeList typeList);

    void startLoading();

    void stopLoading();

    void showMessage(String msg);

    Context getAppContext();
}
