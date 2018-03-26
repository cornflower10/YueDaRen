package com.qingmang.moudle.entity;

/**
 * Created by xiejingbao on 2018/3/26.
 */

public class Popup {
    private String key;
    private String name;

    public Popup(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
