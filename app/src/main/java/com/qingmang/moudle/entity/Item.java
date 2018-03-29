package com.qingmang.moudle.entity;

/**
 * Created by xiejingbao on 2018/3/29.
 */

public class Item {

    /**
     * key : 服务对象
     * type : 1
     * items : 工人,农民,军人
     */

    private String key;
    private int type;
    private String items;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
