package com.android.advance.presenter;

import com.android.advance.interfaces.MainActivityView;
import com.android.advance.interfaces.OnRequestComplete;
import com.android.advance.model.InvokeApi;
import com.android.advance.model.TypeList;


public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void getIpInformation() {
        view.startLoading();
        new InvokeApi(view.getAppContext(), new OnRequestComplete() {
            @Override
            public void onRequestComplete(TypeList infoData) {
                view.stopLoading();
                view.showIpInfo((TypeList) infoData);
            }

            @Override
            public void onRequestError(String errorMsg) {
                view.showMessage(errorMsg);
            }
        });

    }


}
