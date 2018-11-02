package com.danche.pojo;

import java.util.Date;

public class DancVnumber {
    private Integer id;

    private String vnumber;

    private String name;

    private String des;

    private Date created;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVnumber() {
        return vnumber;
    }

    public void setVnumber(String vnumber) {
        this.vnumber = vnumber == null ? null : vnumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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