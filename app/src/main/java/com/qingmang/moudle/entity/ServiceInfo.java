package com.qingmang.moudle.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xiejingbao on 2018/3/24.
 */

public class ServiceInfo implements Serializable{

    /**
     * id : 41
     * createtime : 1522658196000
     * name : 社保代缴
     * type : citizen
     * cateid : null
     * catename : null
     * poster : 社保是养老及享受市民服务的基本要求。
     * price : 2000
     * state : active
     * logo : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
     * logos : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg,http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
     * lights : 十年专业服务，王牌一对一服务
     * special : [{"key":"服务对象","type":1,"items":"工人,农民,军人"},{"key":"服务项目","type":1,"items":"人才引进入户,积分入户"}]
     * specials : [{"key":"服务对象","type":1,"items":"工人,农民,军人","value":null},{"key":"服务项目","type":1,"items":"人才引进入户,积分入户","value":null}]
     * region : [{"p":"全市","c":"全区"}]
     * regions : [{"p":"全市","c":"全区"}]
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
     * ordersday : null
     * ordersmonth : null
     * orderstotal : null
     */

    private int id;
    private long createtime;
    private String name;
    private String type;
    private Object cateid;
    private Object catename;
    private String poster;
    private int price;
    private String state;
    private String logo;
    private String logos;
    private String lights;
    private String special;
    private String region;
    private String introduce;
    private String flow;
    private String guarantee;
    private String problem;
    private Object ordersday;
    private Object ordersmonth;
    private Object orderstotal;
    private List<SpecialsBean> specials;
    private List<RegionsBean> regions;
    private String choose;
    private String place;
    private int num;

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public Object getCateid() {
        return cateid;
    }

    public void setCateid(Object cateid) {
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

    public Object getOrdersday() {
        return ordersday;
    }

    public void setOrdersday(Object ordersday) {
        this.ordersday = ordersday;
    }

    public Object getOrdersmonth() {
        return ordersmonth;
    }

    public void setOrdersmonth(Object ordersmonth) {
        this.ordersmonth = ordersmonth;
    }

    public Object getOrderstotal() {
        return orderstotal;
    }

    public void setOrderstotal(Object orderstotal) {
        this.orderstotal = orderstotal;
    }

    public List<SpecialsBean> getSpecials() {
        return specials;
    }

    public void setSpecials(List<SpecialsBean> specials) {
        this.specials = specials;
    }

    public List<RegionsBean> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionsBean> regions) {
        this.regions = regions;
    }

    public static class SpecialsBean {
        /**
         * key : 服务对象
         * type : 1
         * items : 工人,农民,军人
         * value : null
         */

        private String key;
        private int type;
        private String items;
        private Object value;

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

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public static class RegionsBean {
        /**
         * p : 全市
         * c : 全区
         */

        private String p;
        private String c;

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}
