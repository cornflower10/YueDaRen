package com.qingmang.moudle.entity;

/**
 * Created by xiejingbao on 2018/3/21.
 */

public class Adress {


    /**
     * id : 1
     * customerid : 1
     * collector : 老崔
     * mobile : 15190565321
     * province : 江苏
     * city : 苏州
     * areas : 相城
     * address : 文创园88-1#10楼
     */

    private int id;
    private int customerid;
    private String collector;
    private String mobile;
    private String province;
    private String city;
    private String areas;
    private String address;
    private int top;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
