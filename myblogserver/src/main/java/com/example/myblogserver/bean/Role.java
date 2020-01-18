package com.example.myblogserver.bean;

/**
 * Create by Administrator on 2019/12/25.
 */
public class Role {
    private String name;
    private Long id;

    public Role() {
    }

    public Role(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
