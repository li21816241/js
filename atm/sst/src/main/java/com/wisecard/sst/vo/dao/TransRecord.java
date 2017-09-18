package com.wisecard.sst.vo.dao;

import java.util.Date;

public class TransRecord {
    private Integer id;

    private String appid;

    private Integer requistid;

    private Integer responseid;

    private Date transtime;

    private Integer transtype;

    private Integer cardno;

    private String psasn;

    private Integer atc;

    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Integer getRequistid() {
        return requistid;
    }

    public void setRequistid(Integer requistid) {
        this.requistid = requistid;
    }

    public Integer getResponseid() {
        return responseid;
    }

    public void setResponseid(Integer responseid) {
        this.responseid = responseid;
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public Integer getTranstype() {
        return transtype;
    }

    public void setTranstype(Integer transtype) {
        this.transtype = transtype;
    }

    public Integer getCardno() {
        return cardno;
    }

    public void setCardno(Integer cardno) {
        this.cardno = cardno;
    }

    public String getPsasn() {
        return psasn;
    }

    public void setPsasn(String psasn) {
        this.psasn = psasn == null ? null : psasn.trim();
    }

    public Integer getAtc() {
        return atc;
    }

    public void setAtc(Integer atc) {
        this.atc = atc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}