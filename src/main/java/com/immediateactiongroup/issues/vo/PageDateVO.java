package com.immediateactiongroup.issues.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beishan on 2017/9/2.
 */
public class PageDateVO<T> {

    private int total;
    private int offset;
    private int limit;

    private List<T> data = new ArrayList<>(10);


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
