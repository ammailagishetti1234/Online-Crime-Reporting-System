 
package com.entities;

import java.sql.Date;

public class chargesheet {
    private int id;
    private int fid;
    private String section;
    private String briefdesc;
    private String fileName;
    private String offense;
    private String accused;
    private Date date;
    private String status;
    private int cid;
    private String complaint_detail;
    private String police_state;
    private String police_city;
    private String accused_phno;
    private String accused_add;
    private String accused_name;
    
    private int crid;

    public chargesheet() {
    }

    public chargesheet(int id, int cid, String section, String briefdesc, String fileName, String offense, String accused, Date date, String status) {
        this.id = id;
        this.cid = cid;
        this.section = section;
        this.briefdesc = briefdesc;
        this.fileName = fileName;
        this.offense = offense;
        this.accused = accused;
        this.date = date;
        this.status = status;
    }

    public chargesheet(int fid, String section, String briefdesc, String fileName, String offense, String accused, Date date, String status) {
        this.fid = fid;
        this.section = section;
        this.briefdesc = briefdesc;
        this.fileName = fileName;
        this.offense = offense;
        this.accused = accused;
        this.date = date;
        this.status = status;
    }

    public chargesheet(int fid, String section, String briefdesc, String fileName, String offense, String accused, Date date, String status, int cid) {
        this.fid = fid;
        this.section = section;
        this.briefdesc = briefdesc;
        this.fileName = fileName;
        this.offense = offense;
        this.accused = accused;
        this.date = date;
        this.status = status;
        this.cid = cid;
    }

    public chargesheet(int fid, int chid, String date, String name, String section, String cdetail, String add, String imgname, String docname, String anote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getBriefdesc() {
        return briefdesc;
    }

    public void setBriefdesc(String briefdesc) {
        this.briefdesc = briefdesc;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getAccused() {
        return accused;
    }

    public void setAccused(String accused) {
        this.accused = accused;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getFid() {
        return fid;
    }
    
    public void setFid(int fid) {
        this.fid = fid;   
    }

}
