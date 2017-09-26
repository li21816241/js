package com.wisecard.sst.vo.dao;

import java.util.Date;

public class RecordInfo {
	
    private Integer id;

    private String transtype;

    private Integer transamount;

    private String transaccount;

    private Date transtime;

    private String reqid;

    private String rspid;

    private String tracks;

    private Integer atc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype == null ? null : transtype.trim();
    }

    public Integer getTransamount() {
        return transamount;
    }

    public void setTransamount(Integer transamount) {
        this.transamount = transamount;
    }

    public String getTransaccount() {
        return transaccount;
    }

    public void setTransaccount(String transaccount) {
        this.transaccount = transaccount == null ? null : transaccount.trim();
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public String getReqid() {
        return reqid;
    }

    public void setReqid(String reqid) {
        this.reqid = reqid == null ? null : reqid.trim();
    }

    public String getRspid() {
        return rspid;
    }

    public void setRspid(String rspid) {
        this.rspid = rspid == null ? null : rspid.trim();
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks == null ? null : tracks.trim();
    }

    public Integer getAtc() {
        return atc;
    }

    public void setAtc(Integer atc) {
        this.atc = atc;
    }
}