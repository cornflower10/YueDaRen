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
     * content : [{"id":18,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521429529000,"ordersno":"MST2018031911184918","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":2000,"leavemsg":"请尽快办理！","step":"ensure","introduce":"等待支付","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":7,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362447000,"ordersno":"MST201803181640477","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":2000,"leavemsg":"请尽快办理！","step":"ensure","introduce":"等待第一阶段款项支付","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":6,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362445000,"ordersno":"MST201803181640456","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":3000,"leavemsg":"请尽快办理！","step":"stage","introduce":"第一阶段服务进行中","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":5,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362442000,"ordersno":"MST201803181640425","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":4000,"leavemsg":"请尽快办理！","step":"stage","introduce":"第二阶段服务待支付","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":4,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362439000,"ordersno":"MST201803181640394","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":4500,"leavemsg":"请尽快办理！","step":"stage","introduce":"第二阶段服务进行中","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":3,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362438000,"ordersno":"MST201803181640383","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":5000,"leavemsg":"请尽快办理！","step":"stage","introduce":"第三阶段服务待支付","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":2,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362436000,"ordersno":"MST201803181640362","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":6000,"leavemsg":"请尽快办理！","step":"stage","introduce":"订单所有阶段服务已完成","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null},{"id":1,"customerid":1,"cname":"老崔","cmobile":"15190565321","createtime":1521362433000,"ordersno":"MST201803181640331","goodsid":1,"gname":"办理户口","gtype":"citizen","gcateid":null,"gcatename":null,"specials":"[{\"key\":\"服务对象\",\"type\":0,\"value\":\"老崔\"},{\"items\":\"人才引进入户,积分入户\",\"key\":\"服务项目\",\"type\":1,\"value\":\"人才引进入户\"}]","choose":null,"num":1,"price":2000,"amount":6000,"leavemsg":"请尽快办理！","step":"complete","introduce":"订单已完成","addressid":2,"collector":null,"mobile":null,"province":null,"city":null,"areas":null,"address":null,"ticket":0,"invoicetype":0,"invoiceraise":0,"company":null,"taxpayer":null,"steps":null}]
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
         * cname : 老崔
         * cmobile : 15190565321
         * createtime : 1521429529000
         * ordersno : MST2018031911184918
         * goodsid : 1
         * gname : 办理户口
         * gtype : citizen
         * gcateid : null
         * gcatename : null
         * specials : [{"key":"服务对象","type":0,"value":"老崔"},{"items":"人才引进入户,积分入户","key":"服务项目","type":1,"value":"人才引进入户"}]
         * choose : null
         * num : 1
         * price : 2000
         * amount : 2000
         * leavemsg : 请尽快办理！
         * step : ensure
         * introduce : 等待支付
         * addressid : 2
         * collector : null
         * mobile : null
         * province : null
         * city : null
         * areas : null
         * address : null
         * ticket : 0
         * invoicetype : 0
         * invoiceraise : 0
         * company : null
         * taxpayer : null
         * steps : null
         */

        private int id;
        private int customerid;
        private String cname;
        private String cmobile;
        private long createtime;
        private String ordersno;
        private int goodsid;
        private String gname;
        private String gtype;
        private Object gcateid;
        private Object gcatename;
        private String specials;
        private Object choose;
        private int num;
        private int price;
        private int amount;
        private String leavemsg;
        private String step;
        private String introduce;
        private int addressid;
        private Object collector;
        private Object mobile;
        private Object province;
        private Object city;
        private Object areas;
        private Object address;
        private int ticket;
        private int invoicetype;
        private int invoiceraise;
        private Object company;
        private Object taxpayer;
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

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getCmobile() {
            return cmobile;
        }

        public void setCmobile(String cmobile) {
            this.cmobile = cmobile;
        }

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public String getOrdersno() {
            return ordersno;
        }

        public void setOrdersno(String ordersno) {
            this.ordersno = ordersno;
        }

        public int getGoodsid() {
            return goodsid;
        }

        public void setGoodsid(int goodsid) {
            this.goodsid = goodsid;
        }

        public String getGname() {
            return gname;
        }

        public void setGname(String gname) {
            this.gname = gname;
        }

        public String getGtype() {
            return gtype;
        }

        public void setGtype(String gtype) {
            this.gtype = gtype;
        }

        public Object getGcateid() {
            return gcateid;
        }

        public void setGcateid(Object gcateid) {
            this.gcateid = gcateid;
        }

        public Object getGcatename() {
            return gcatename;
        }

        public void setGcatename(Object gcatename) {
            this.gcatename = gcatename;
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

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public int getAddressid() {
            return addressid;
        }

        public void setAddressid(int addressid) {
            this.addressid = addressid;
        }

        public Object getCollector() {
            return collector;
        }

        public void setCollector(Object collector) {
            this.collector = collector;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getAreas() {
            return areas;
        }

        public void setAreas(Object areas) {
            this.areas = areas;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public int getTicket() {
            return ticket;
        }

        public void setTicket(int ticket) {
            this.ticket = ticket;
        }

        public int getInvoicetype() {
            return invoicetype;
        }

        public void setInvoicetype(int invoicetype) {
            this.invoicetype = invoicetype;
        }

        public int getInvoiceraise() {
            return invoiceraise;
        }

        public void setInvoiceraise(int invoiceraise) {
            this.invoiceraise = invoiceraise;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getTaxpayer() {
            return taxpayer;
        }

        public void setTaxpayer(Object taxpayer) {
            this.taxpayer = taxpayer;
        }

        public Object getSteps() {
            return steps;
        }

        public void setSteps(Object steps) {
            this.steps = steps;
        }
    }
}
