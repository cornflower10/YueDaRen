package com.qingmang.moudle.entity;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/22.
 */

public class Service {

    /**
     * cateid : 1
     * goods : {"pageNumber":1,"pageSize":10,"totalCount":1,"pageCount":1,"content":[{"id":5,"createtime":null,"name":"公司注册","type":"job","cateid":1,"catename":"公司注册","poster":"粤大人十年办理经验，交给我们，其他我们办。","price":2000,"state":"active","logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","logos":null,"lights":null,"special":null,"region":null,"protocoltitle":null,"protocolcontent":null,"introduce":null,"flow":null,"guarantee":null,"problem":null}]}
     * cates : [{"id":1,"type":"job","name":"公司注册","sort":1},{"id":2,"type":"job","name":"代理记账","sort":2}]
     */

    private int cateid;
    private GoodsBean goods;
    private List<CatesBean> cates;

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public List<CatesBean> getCates() {
        return cates;
    }

    public void setCates(List<CatesBean> cates) {
        this.cates = cates;
    }

    public static class GoodsBean {
        /**
         * pageNumber : 1
         * pageSize : 10
         * totalCount : 1
         * pageCount : 1
         * content : [{"id":5,"createtime":null,"name":"公司注册","type":"job","cateid":1,"catename":"公司注册","poster":"粤大人十年办理经验，交给我们，其他我们办。","price":2000,"state":"active","logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","logos":null,"lights":null,"special":null,"region":null,"protocoltitle":null,"protocolcontent":null,"introduce":null,"flow":null,"guarantee":null,"problem":null}]
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
             * id : 5
             * createtime : null
             * name : 公司注册
             * type : job
             * cateid : 1
             * catename : 公司注册
             * poster : 粤大人十年办理经验，交给我们，其他我们办。
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
            private int cateid;
            private String catename;
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

            public int getCateid() {
                return cateid;
            }

            public void setCateid(int cateid) {
                this.cateid = cateid;
            }

            public String getCatename() {
                return catename;
            }

            public void setCatename(String catename) {
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

    public static class CatesBean {
        /**
         * id : 1
         * type : job
         * name : 公司注册
         * sort : 1
         */

        private int id;
        private String type;
        private String name;
        private int sort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
