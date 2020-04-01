package com.example.bean;

/**
 * Create by Administrator on 2020/3/31.
 */
//属性名最好和数据库字段名一样
public class Role {

    private int id;
    private String name;

    public Role() {
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
}
