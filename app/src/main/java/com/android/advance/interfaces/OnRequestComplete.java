package com.android.advance.interfaces;

import com.android.advance.model.TypeList;

public interface OnRequestComplete {
    void onRequestComplete(TypeList typeList);
    void onRequestError(String errorMsg);
}
