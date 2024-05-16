
package com.entities;

public class Police {
    private int pid;
    private int id;
    private String name;
    private String station;
    private String designation;
    private String pfilename;
    private String gender;
    private String cont_no;
    private String email;
    private String pstatus;
    private Police police;

    public Police() {
    }

    public Police(int id, String name, String station, String designation, String pfilename, String gender, String cont_no, String email, String pstatus) {
        this.id = id;
        this.name = name;
        this.station = station;
        this.designation = designation;
        this.pfilename = pfilename;
        this.gender = gender;
        this.cont_no = cont_no;
        this.email = email;
        this.pstatus = pstatus;
    }

    public Police(String name, String station, String designation, String pfilename, String gender, String cont_no, String email, String pstatus) {
        this.name = name;
        this.station = station;
        this.designation = designation;
        this.pfilename = pfilename;
        this.gender = gender;
        this.cont_no = cont_no;
        this.email = email;
        this.pstatus = pstatus;
    }

 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPfilename() {
        return pfilename;
    }

    public void setPfilename(String pfilename) {
        this.pfilename = pfilename;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCont_no() {
        return cont_no;
    }

    public void setCont_no(String cont_no) {
        this.cont_no = cont_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public int getpId() {
        return pid;
    }

    public void setpId(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Police getPolice() {
        return police;
    }

    public void setPolice(Police police) {
        this.police = police;
    }

   

    
   
    
}
