package com.android.advance.model;

import java.util.List;

/**
 * Created by dinislam on 12/9/16.
 */
public class TypeList {

    private List<List<Object>> userTypeList = null;

    private Integer status;

    /**
     *
     * @return
     *     The userTypeList
     */
    public List<List<Object>> getUserTypeList() {
        return userTypeList;
    }

    /**
     *
     * @param userTypeList
     *     The userTypeList
     */
    public void setUserTypeList(List<List<Object>> userTypeList) {
        this.userTypeList = userTypeList;
    }

    /**
     *
     * @return
     *     The status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @param status
     *     The status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

}

