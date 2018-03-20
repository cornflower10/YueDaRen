package com.qingmang.moudle.entity;

import java.util.List;

/**
 * Created by xiejingbao on 2018/3/20.
 */

public class Order {

    /**
     * pageNumber : 1
     * pageSize : 10
     * totalCount : 8
     * pageCount : 1
     * content : [{"id":18,"customerid":1,"createtime":1521429529000,"goodsid":1,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":2000,"leavemsg":"请尽快办理！","step":"wait","steps":null},{"id":7,"customerid":1,"createtime":1521362447000,"goodsid":1,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":2000,"leavemsg":"请尽快办理！","step":"wait","steps":null}]
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
         * id : 18
         * customerid : 1
         * createtime : 1521429529000
         * goodsid : 1
         * specials : [{"key":"服务对象","type":0,"value":"老崔"},{"items":"人才引进入户,积分入户","key":"服务项目","type":1,"value":"人才引进入户"}]
         * choose : null
         * num : 1
         * price : 2000
         * amount : 2000
         * leavemsg : 请尽快办理！
         * step : wait
         * steps : null
         */

        private int id;
        private int customerid;
        private long createtime;
        private int goodsid;
        private String specials;
        private Object choose;
        private int num;
        private int price;
        private int amount;
        private String leavemsg;
        private String step;
        private Object steps;

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

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public String getSpecials() {
            return specials;
        }

        public void setSpecials(String specials) {
            this.specials = specials;
        }

        public Object getChoose() {
            return choose;
        }

        public void setChoose(Object choose) {
            this.choose = choose;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getLeavemsg() {
            return leavemsg;
        }

        public void setLeavemsg(String leavemsg) {
            this.leavemsg = leavemsg;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public Object getSteps() {
            return steps;
        }

        public void setSteps(Object steps) {
            this.steps = steps;
        }
    }
}
