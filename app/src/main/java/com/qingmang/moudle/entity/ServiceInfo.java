package com.qingmang.moudle.entity;

import java.io.Serializable;

/**
 * Created by xiejingbao on 2018/3/24.
 */

public class ServiceInfo implements Serializable{

    /**
     * id : 7
     * createtime : 1521354542000
     * name : 税务服务
     * type : job
     * cateid : 3
     * catename : null
     * poster : 粤大人十年办理经验，交给我们，其他我们办。
     * price : 2000
     * state : active
     * logo : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
     * logos : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg,http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
     * lights : 十年专业服务，王牌一对一服务
     * special : [{"key":"服务对象","type":0},{"key":"服务项目","type":1,"items":"人才引进入户,积分入户"}]
     * region : [{"p":"江苏","c":"南京,无锡,徐州,苏州"},{"p":"上海","c":"上海"},{"p":"浙江","c":"杭州,宁波,温州,绍兴"}]
     * protocoltitle : 户口办理服务协议
     * protocolcontent : 户口办理服务协议内容
     * introduce : <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png" alt="" />
     </p>
     * flow : <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png" alt="" />
     </p>
     * guarantee : <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png" alt="" />
     </p>
     * problem : <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png" alt="" />
     </p>
     <p>
     <img src="http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png" alt="" />
     </p>
     */

    private int id;
    private long createtime;
    private String name;
    private String type;
    private int cateid;
    private Object catename;
    private String poster;
    private int price;
    private String state;
    private String logo;
    private String logos;
    private String lights;
    private String special;
    private String region;
    private String protocoltitle;
    private String protocolcontent;
    private String introduce;
    private String flow;
    private String guarantee;
    private String problem;


    private int num;
    private String choose;
    private String place;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public Object getCatename() {
        return catename;
    }

    public void setCatename(Object catename) {
        this.catename = catename;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogos() {
        return logos;
    }

    public void setLogos(String logos) {
        this.logos = logos;
    }

    public String getLights() {
        return lights;
    }

    public void setLights(String lights) {
        this.lights = lights;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProtocoltitle() {
        return protocoltitle;
    }

    public void setProtocoltitle(String protocoltitle) {
        this.protocoltitle = protocoltitle;
    }

    public String getProtocolcontent() {
        return protocolcontent;
    }

    public void setProtocolcontent(String protocolcontent) {
        this.protocolcontent = protocolcontent;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}
