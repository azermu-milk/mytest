package com.example.entities;

import java.util.Objects;

/**
 * @className Region
 * @date 2021/4/20 19:20
 * @description
 **/
public class Region {
    private String id;
    private String region;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Region region1 = (Region) o;
        return Objects.equals(id, region1.id) &&
                Objects.equals(region, region1.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, region);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id='" + id + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
