package com.example.bean;

/**
 * Create by Administrator on 2020/4/1.
 */
public class RespBean {

    private String status;
    private String msg;

    public RespBean(String status, String msg) {

    }

    public RespBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
