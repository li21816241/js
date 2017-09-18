package com.wisecard.sst.vo.dao;

public class AppInfo {
    private String id;

    private String termid;

    private String masterkey;

    private String pinkey;

    private String mackey;

    private Integer whitecardcount;

    private String version;

    private String serviceaddr;

    private String monitoraddr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTermid() {
        return termid;
    }

    public void setTermid(String termid) {
        this.termid = termid == null ? null : termid.trim();
    }

    public String getMasterkey() {
        return masterkey;
    }

    public void setMasterkey(String masterkey) {
        this.masterkey = masterkey == null ? null : masterkey.trim();
    }

    public String getPinkey() {
        return pinkey;
    }

    public void setPinkey(String pinkey) {
        this.pinkey = pinkey == null ? null : pinkey.trim();
    }

    public String getMackey() {
        return mackey;
    }

    public void setMackey(String mackey) {
        this.mackey = mackey == null ? null : mackey.trim();
    }

    public Integer getWhitecardcount() {
        return whitecardcount;
    }

    public void setWhitecardcount(Integer whitecardcount) {
        this.whitecardcount = whitecardcount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getServiceaddr() {
        return serviceaddr;
    }

    public void setServiceaddr(String serviceaddr) {
        this.serviceaddr = serviceaddr == null ? null : serviceaddr.trim();
    }

    public String getMonitoraddr() {
        return monitoraddr;
    }

    public void setMonitoraddr(String monitoraddr) {
        this.monitoraddr = monitoraddr == null ? null : monitoraddr.trim();
    }
}