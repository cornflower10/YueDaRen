package com.qingmang.moudle.entity;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/20.
 */

public class VenService {


    /**
     * pageNumber : 1
     * pageSize : 10
     * totalCount : 4
     * pageCount : 1
     * content : [{"id":1,"createtime":null,"name":"办理户口","type":"citizen","cateid":null,"catename":null,"poster":"粤大人十年户口办理经验，交给我们，其他我们办。","price":2000,"state":"active","logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","logos":null,"lights":null,"special":null,"region":null,"protocoltitle":null,"protocolcontent":null,"introduce":null,"flow":null,"guarantee":null,"problem":null},{"id":2,"createtime":null,"name":"社保代缴","type":"citizen","cateid":null,"catename":null,"poster":"社保是养老及享受市民服务的基本要求。","price":2000,"state":"active","logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","logos":null,"lights":null,"special":null,"region":null,"protocoltitle":null,"protocolcontent":null,"introduce":null,"flow":null,"guarantee":null,"problem":null}]
     */

    private int pageNumber;
    private int pageSize;
    private int totalCount;
    private int pageCount;
    private List<ContentBean> content;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * id : 1
         * createtime : null
         * name : 办理户口
         * type : citizen
         * cateid : null
         * catename : null
         * poster : 粤大人十年户口办理经验，交给我们，其他我们办。
         * price : 2000
         * state : active
         * logo : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
         * logos : null
         * lights : null
         * special : null
         * region : null
         * protocoltitle : null
         * protocolcontent : null
         * introduce : null
         * flow : null
         * guarantee : null
         * problem : null
         */

        private int id;
        private Object createtime;
        private String name;
        private String type;
        private Object cateid;
        private Object catename;
        private String poster;
        private int price;
        private String state;
        private String logo;
        private Object logos;
        private Object lights;
        private Object special;
        private Object region;
        private Object protocoltitle;
        private Object protocolcontent;
        private Object introduce;
        private Object flow;
        private Object guarantee;
        private Object problem;
        private int drawableId;
        private int typeColor;

        public int getTypeColor() {
            return typeColor;
        }

        public void setTypeColor(int typeColor) {
            this.typeColor = typeColor;
        }

        public int getDrawableId() {
            return drawableId;
        }

        public void setDrawableId(int drawableId) {
            this.drawableId = drawableId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getCreatetime() {
            return createtime;
        }

        public void setCreatetime(Object createtime) {
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

        public Object getLogos() {
            return logos;
        }

        public void setLogos(Object logos) {
            this.logos = logos;
        }

        public Object getLights() {
            return lights;
        }

        public void setLights(Object lights) {
            this.lights = lights;
        }

        public Object getSpecial() {
            return special;
        }

        public void setSpecial(Object special) {
            this.special = special;
        }

        public Object getRegion() {
            return region;
        }

        public void setRegion(Object region) {
            this.region = region;
        }

        public Object getProtocoltitle() {
            return protocoltitle;
        }

        public void setProtocoltitle(Object protocoltitle) {
            this.protocoltitle = protocoltitle;
        }

        public Object getProtocolcontent() {
            return protocolcontent;
        }

        public void setProtocolcontent(Object protocolcontent) {
            this.protocolcontent = protocolcontent;
        }

        public Object getIntroduce() {
            return introduce;
        }

        public void setIntroduce(Object introduce) {
            this.introduce = introduce;
        }

        public Object getFlow() {
            return flow;
        }

        public void setFlow(Object flow) {
            this.flow = flow;
        }

        public Object getGuarantee() {
            return guarantee;
        }

        public void setGuarantee(Object guarantee) {
            this.guarantee = guarantee;
        }

        public Object getProblem() {
            return problem;
        }

        public void setProblem(Object problem) {
            this.problem = problem;
        }
    }
}
