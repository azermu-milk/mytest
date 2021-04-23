package com.example.entities;

/**
 * @className Usera
 * @date 2021/4/20 19:20
 * @description
 **/
public class Usera {
    private int id;
    private String name;
    private int age;
    private Region region;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Usera{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", region='" + region + '\'' +
                '}';
    }
}
