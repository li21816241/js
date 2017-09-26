package com.wisecard.sst.vo.dao;

public class DevInfo {
	
    private String id;

    private String company;

    private String model;

    private Integer devices;

    private String mechanism;

    private String descript;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getDevices() {
        return devices;
    }

    public void setDevices(Integer devices) {
        this.devices = devices;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism == null ? null : mechanism.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
    
    static public String getDevName( int i ){
    	switch( i ){
    	case 1: return "cardreader";
    	case 2: return "pinpad";
    	case 4: return "receipt";
    	case 8: return "a4printer";
    	case 16: return "figure";
    	case 32: return "qr";
    	case 64: return "cam";
    	case 128: return "siu";
    	case 256: return "issusecard";
    	}
    	return "";
    }
    static public String getDevId( int i ){
    	switch( i ){
    	case 1: return "cardreader";
    	case 2: return "pinpad";
    	case 4: return "receipt";
    	case 8: return "a4printer";
    	case 16: return "figure";
    	case 32: return "qr";
    	case 64: return "cam";
    	case 128: return "siu";
    	case 256: return "issusecard";
    	}
    	return "";
    }
    static public int getDevType( int i ){
    	switch( i ){
    	case 1: return 1;
    	case 2: return 2;
    	case 4: return 0;
    	case 8: return 1;
    	case 16: return 0;
    	case 32: return 1;
    	case 64: return 1;
    	case 128: return 1;
    	case 256: return 1;
    	}
    	return 0;
    }
}