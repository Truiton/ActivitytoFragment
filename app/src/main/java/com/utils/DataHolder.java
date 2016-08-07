package com.utils;

/**
 * Created by apple1 on 06/08/16.
 */

public class DataHolder {
    private String data;
    public String getData() {return data;}
    public void setData(String data) {this.data = data;}

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}
}
