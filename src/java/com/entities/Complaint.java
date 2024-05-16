package com.entities;

import java.sql.Connection;
import java.sql.Date;
import javax.servlet.http.Part;

public class Complaint {
    private int id;
   
    private String name;
    private String email;
    private String phone_no;
    private String police_city;
    private String police_state;
    private String complaint_detail;
    private String area;
    private String icity;
    private String tcrime;
    private Date date;
    private String accused_name;
    private String accused_add;
    private String accused_phno;
    private String victim_name;
    private String victim_add;
    private String victim_phno;
    private String evidence_detail;
    private String fileName;
    private String status;
    
    private int userId;
    
    private User user; 
    private int areacrimecount;
    private int typecrimecount;
    
    private Date start_date;
    private Date end_date;
    private int crimeCount;
    private Part filePart;
    private Police police;
    private String pstatus;
    private int pId;
    private FIR fir;
    private int fid;
    
    private String evidenceImage="";
    // other fields and methods

    public String getEvidenceImage() {
        return evidenceImage;
    }

    public void setEvidenceImage(String evidenceImage) {
        this.evidenceImage = evidenceImage;
    }

    public Complaint(int id, String name, String email, String phone_no, String police_city, String police_state, String complaint_detail, String area, String icity, String tcrime, Date date, String accused_name, String accused_add, String accused_phno, String victim_name, String victim_add, String victim_phno, String evidence_detail, String fileName, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.police_city = police_city;
        this.police_state = police_state;
        this.complaint_detail = complaint_detail;
        this.area = area;
        this.icity = icity;
        this.tcrime = tcrime;
        this.date = date;
        this.accused_name = accused_name;
        this.accused_add = accused_add;
        this.accused_phno = accused_phno;
        this.victim_name = victim_name;
        this.victim_add = victim_add;
        this.victim_phno = victim_phno;
        this.evidence_detail = evidence_detail;
        this.fileName = fileName;
        this.status = status;
    }

    public Complaint(String name, String email, String phone_no, String police_city, String police_state,  String complaint_detail, String area, String icity, String tcrime, Date date, String accused_name, String accused_add, String accused_phno, String victim_name, String victim_add, String victim_phno, String evidence_detail, String fileName, String status) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.police_city = police_city;
        this.police_state = police_state;
        this.complaint_detail = complaint_detail;
        this.area = area;
        this.icity = icity;
        this.tcrime = tcrime;
        this.date = date;
        this.accused_name = accused_name;
        this.accused_add = accused_add;
        this.accused_phno = accused_phno;
        this.victim_name = victim_name;
        this.victim_add = victim_add;
        this.victim_phno = victim_phno;
        this.evidence_detail = evidence_detail;
        this.fileName = fileName;
        this.status = status;
    }

    public Complaint(int id, int userId, String name, String email, String phone_no, String police_city, String police_state, String complaint_detail, String area, String icity, String tcrime, Date date, String accused_name, String accused_add, String accused_phno, String victim_name, String victim_add, String victim_phno, String evidence_detail, String fileName, String status) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.police_city = police_city;
        this.police_state = police_state;
        this.complaint_detail = complaint_detail;
        this.area = area;
        this.icity = icity;
        this.tcrime = tcrime;
        this.date = date;
        this.accused_name = accused_name;
        this.accused_add = accused_add;
        this.accused_phno = accused_phno;
        this.victim_name = victim_name;
        this.victim_add = victim_add;
        this.victim_phno = victim_phno;
        this.evidence_detail = evidence_detail;
        this.fileName = fileName;
        this.status = status;
    }
    
    

    public Complaint() {
    }

    public Complaint(String city, String area, String tcrime, Date date, int crimeCount) {
        this.area = area;
        this.icity = icity;
        this.tcrime = tcrime;
        this.date = date;
        this.crimeCount = crimeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPolice_city() {
        return police_city;
    }

    public void setPolice_city(String police_city) {
        this.police_city = police_city;
    }

    public String getPolice_state() {
        return police_state;
    }

    public void setPolice_state(String police_state) {
        this.police_state = police_state;
    }

    public String getComplaint_detail() {
        return complaint_detail;
    }

    public void setComplaint_detail(String complaint_detail) {
        this.complaint_detail = complaint_detail;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getIcity() {
        return icity;
    }

    public void setIcity(String icity) {
        this.icity = icity;
    }

    public String getTcrime() {
        return tcrime;
    }

    public void setTcrime(String tcrime) {
        this.tcrime = tcrime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccused_name() {
        return accused_name;
    }

    public void setAccused_name(String accused_name) {
        this.accused_name = accused_name;
    }

    public String getAccused_add() {
        return accused_add;
    }

    public void setAccused_add(String accused_add) {
        this.accused_add = accused_add;
    }

    public String getAccused_phno() {
        return accused_phno;
    }

    public void setAccused_phno(String accused_phno) {
        this.accused_phno = accused_phno;
    }

    public String getVictim_name() {
        return victim_name;
    }

    public void setVictim_name(String victim_name) {
        this.victim_name = victim_name;
    }

    public String getVictim_add() {
        return victim_add;
    }

    public void setVictim_add(String victim_add) {
        this.victim_add = victim_add;
    }

    public String getVictim_phno() {
        return victim_phno;
    }

    public void setVictim_phno(String victim_phno) {
        this.victim_phno = victim_phno;
    }

    public String getEvidence_detail() {
        return evidence_detail;
    }

    public void setEvidence_detail(String evidence_detail) {
        this.evidence_detail = evidence_detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAreacrimecount() {
        return areacrimecount;
    }

    public void setAreacrimecount(int areacrimecount) {
        this.areacrimecount = areacrimecount;
    }

    public int getTypecrimecount() {
        return typecrimecount;
    }

    public void setTypecrimecount(int typecrimecount) {
        this.typecrimecount = typecrimecount;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getCrimeCount() {
        return crimeCount;
    }

    public void setCrimeCount(int crimeCount) {
        this.crimeCount = crimeCount;
    }
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public Part getPart() {
        return filePart;
    }

    public void setPart(Part filePart) {
        this.filePart = filePart;
    }

    
      public Complaint(String area, String tcrime, int areacrimecount, int typecrimecount) {
        this.area = area;
        this.tcrime = tcrime;
        this.areacrimecount = areacrimecount;
        this.typecrimecount = typecrimecount;
    }

    public Complaint(String icity, Date start_date, Date end_date) {
        this.icity = icity;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String filePart(String filePart) {
        return filePart;
    }
    
    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }
    
    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }
    
    public FIR getFIR() {
        return fir;
    }

    public void setFIR(FIR fir) {
        this.fir = fir;
    }
    
     public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    
    
}