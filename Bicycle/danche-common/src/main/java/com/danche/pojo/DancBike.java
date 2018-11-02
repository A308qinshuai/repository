package com.danche.pojo;

import java.util.Date;

public class DancBike {
    private Integer id;

    private String bikeid;

    private String user;

    private String psword;

    private String des;

    private String status;

    private Date created;

    private Date updared;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBikeid() {
        return bikeid;
    }

    public void setBikeid(String bikeid) {
        this.bikeid = bikeid == null ? null : bikeid.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPsword() {
        return psword;
    }

    public void setPsword(String psword) {
        this.psword = psword == null ? null : psword.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdared() {
        return updared;
    }

    public void setUpdared(Date updared) {
        this.updared = updared;
    }
}