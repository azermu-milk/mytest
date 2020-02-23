package com.example.bean;

import java.util.Date;

public class Bill {
    private Integer bid;
    //账单编码
    private String billCode;
    //商品名称
    private String billName;
    //商品单位
    private String billCom;
    //商品数量
    private int billNum;
    //总金额
    private Double money;
    //供应商
    private Provider provider;
    //供应商id
    private int pid;
    //是否付款 0未付款 1已付款
    private int pay;
    //创建时间
    private Date createDate;

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "bid=" + bid +
                ", billCode='" + billCode + '\'' +
                ", billName='" + billName + '\'' +
                ", billCom='" + billCom + '\'' +
                ", billNum=" + billNum +
                ", money=" + money +
                ", provider=" + provider +
                ", pid=" + pid +
                ", pay=" + pay +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillCom() {
        return billCom;
    }

    public void setBillCom(String billCom) {
        this.billCom = billCom;
    }

    public int getBillNum() {
        return billNum;
    }

    public void setBillNum(int billNum) {
        this.billNum = billNum;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
