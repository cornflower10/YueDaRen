package com.qingmang.moudle.entity;

/**
 * Created by xiejingbao on 2018/3/24.
 */

public class CustomerInfo {


    /**
     * id : 1
     * name : 老崔
     * mobile : 15190565321
     * password : null
     * type : personal
     * mode : normal
     * state : active
     * email : 992007738@qq.com
     * createtime : 1521425060000
     * token : d19fe3f49b8f4a9a8829acf80f5c5407
     * checkin : 100
     * consume : 20000
     * audit : 0
     */

    private int id;
    private String name;
    private String mobile;
    private Object password;
    private String type;
    private String mode;
    private String state;
    private String email;
    private long createtime;
    private String token;
    private int checkin;
    private int consume;
    private int audit;
    private int score;
    private int couponum;
    private int ordersnum;

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
}
