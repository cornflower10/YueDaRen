package com.qingmang.moudle.entity;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/21.
 */

public class Banner {

    /**
     * pageNumber : 1
     * pageSize : 10
     * totalCount : 4
     * pageCount : 1
     * content : [{"id":10,"title":"资讯标题","createtime":1521267797000,"state":1,"place":"top","top":0,"logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","introduce":"资讯简介","content":"<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png\" alt=\"\" />\r\n<\/p>"},{"id":7,"title":"资讯标题","createtime":1521267794000,"state":1,"place":"top","top":0,"logo":"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg","introduce":"资讯简介","content":"<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093721467099.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093734282963.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093745367087.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093755975151.png\" alt=\"\" />\r\n<\/p>\r\n<p>\r\n\t<img src=\"http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/03/151521093765325928.png\" alt=\"\" />\r\n<\/p>"}]
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
         * id : 10
         * title : 资讯标题
         * createtime : 1521267797000
         * state : 1
         * place : top
         * top : 0
         * logo : http://livehaiyunx.oss-cn-shanghai.aliyuncs.com/picture/2018/02/011517467317803886.jpg
         * introduce : 资讯简介
         * content : <p>
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
        private String title;
        private long createtime;
        private int state;
        private String place;
        private int top;
        private String logo;
        private String introduce;
        private String content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
