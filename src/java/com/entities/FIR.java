
package com.entities;

import java.sql.Date;

public class FIR {
    private int fid;
    private int id;
    private String section;
    private String complaint_type;
    private Date Reg_date;
    private String fir_detail;
    private String fir_start_date;
    private String fir_end_date;
    private String status;
    private Complaint complaint;
    private String cstatus;
    private String name;
    private String station;
    private String chstatus;

    public FIR() {
    }

    public FIR(int fid, int id, String section, String complaint_type, Date Reg_date, String fir_detail, String fir_start_date, String fir_end_date, String status) {
        this.fid = fid;
        this.id = id;
        this.section = section;
        this.complaint_type = complaint_type;
        this.Reg_date = Reg_date;
        this.fir_detail = fir_detail;
        this.fir_start_date = fir_start_date;
        this.fir_end_date = fir_end_date;
        this.status = status;
    }

    public FIR(int id, String section, String complaint_type, Date Reg_date, String fir_detail, String fir_start_date, String fir_end_date, String status) {
        this.id = id;
        this.section = section;
        this.complaint_type = complaint_type;
        this.Reg_date = Reg_date;
        this.fir_detail = fir_detail;
        this.fir_start_date = fir_start_date;
        this.fir_end_date = fir_end_date;
        this.status = status;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getComplaint_type() {
        return complaint_type;
    }

    public void setComplaint_type(String complaint_type) {
        this.complaint_type = complaint_type;
    }

    public Date getReg_date() {
        return Reg_date;
    }

    public void setReg_date(Date Reg_date) {
        this.Reg_date = Reg_date;
    }

    public String getFir_detail() {
        return fir_detail;
    }

    public void setFir_detail(String fir_detail) {
        this.fir_detail = fir_detail;
    }

    public String getFir_start_date() {
        return fir_start_date;
    }

    public void setFir_start_date(String fir_start_date) {
        this.fir_start_date = fir_start_date;
    }

    public String getFir_end_date() {
        return fir_end_date;
    }

    public void setFir_end_date(String fir_end_date) {
        this.fir_end_date = fir_end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public String getStation() {
        return station;
    }
    public void setStation(String station) {
        this.station = station;
    }
    
    public String getChstatus() {
        return chstatus;
    }

    public void setChstatus(String chstatus) {
        this.chstatus = chstatus;
    }
    
}
