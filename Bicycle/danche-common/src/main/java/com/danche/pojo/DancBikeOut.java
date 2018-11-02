package com.danche.pojo;

import java.util.Date;

public class DancBikeOut {
    private Integer id;

    private String bike;

    private String des;

    private Date created;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBike() {
        return bike;
    }

    public void setBike(String bike) {
        this.bike = bike == null ? null : bike.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}