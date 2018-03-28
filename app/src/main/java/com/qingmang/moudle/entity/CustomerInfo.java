package com.qingmang.moudle.entity;

import java.io.Serializable;

/**
 * Created by xiejingbao on 2018/3/24.
 */

public class CustomerInfo implements Serializable{


    /**
     * id : 1
     * name : 老崔
     * mobile : 15190565321
     * password : null
     * avatar : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/loan/default_portrait.png
     * type : personal
     * mode : normal
     * state : active
     * email : 992007738@qq.com
     * createtime : 1521425060000
     * token : d19fe3f49b8f4a9a8829acf80f5c5407
     * checkin : 100
     * consume : 20000
     * audit : 1
     * auditid : null
     * company : null
     * legal : null
     * licence : null
     * result : null
     * score : 0
     * couponum : 0
     * ordersnum : 11
     * province : 江苏省
     * city : 苏州市
     * district : 相城区
     * address : 文创园88-1
     * realname : 老崔
     * idcard : 410000000000000000
     */

    private int id;
    private String name;
    private String mobile;
    private Object password;
    private String avatar;
    private String type;
    private String mode;
    private String state;
    private String email;
    private long createtime;
    private String token;
    private int checkin;
    private int consume;
    private int audit;
    private Object auditid;
    private Object company;
    private Object legal;
    private Object licence;
    private Object result;
    private int score;
    private int couponum;
    private int ordersnum;
    private String province;
    private String city;
    private String district;
    private String address;
    private String realname;
    private String idcard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCheckin() {
        return checkin;
    }

    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public Object getAuditid() {
        return auditid;
    }

    public void setAuditid(Object auditid) {
        this.auditid = auditid;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public Object getLegal() {
        return legal;
    }

    public void setLegal(Object legal) {
        this.legal = legal;
    }

    public Object getLicence() {
        return licence;
    }

    public void setLicence(Object licence) {
        this.licence = licence;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCouponum() {
        return couponum;
    }

    public void setCouponum(int couponum) {
        this.couponum = couponum;
    }

    public int getOrdersnum() {
        return ordersnum;
    }

    public void setOrdersnum(int ordersnum) {
        this.ordersnum = ordersnum;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
