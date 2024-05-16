
package com.entities;

import java.sql.Date;

public class report {
    private int rid;
    private Date cdate;
    private String name;
    private String section;
    private String cdetail;
    private String add;
    private String imgname;
    private String doc;
    private String anote;
    private int fid;
    private int chid;
    
    private String pimg = null;
    private String pdoc = null;

    public report() {
    }

    public report(int rid, Date cdate, String name, String section, String cdetail, String add, String imgname, String doc, String anote) {
        this.rid = rid;
        this.cdate = cdate;
        this.name = name;
        this.section = section;
        this.cdetail = cdetail;
        this.add = add;
        this.imgname = imgname;
        this.doc = doc;
        this.anote = anote;
    }

    public report(Date cdate, String name, String section, String cdetail, String add, String imgname, String anote) {
        this.cdate = cdate;
        this.name = name;
        this.section = section;
        this.cdetail = cdetail;
        this.add = add;
        this.imgname = imgname;
        //this.doc = doc;
        this.anote = anote;
    }

    public report(Date cdate, String name, String section, String cdetail, String add, String imgname, String doc, String anote, int fid, int chid) {
        this.cdate = cdate;
        this.name = name;
        this.section = section;
        this.cdetail = cdetail;
        this.add = add;
        this.imgname = imgname;
        this.doc = doc;
        this.anote = anote;
        this.fid = fid;
        this.chid = chid;
    }

    public report(int fid, int chid, String date, String name, String section, String cdetail, String add, String imgname, String docname, String anote) {
        this.fid = fid;
        this.chid = chid;
        this.cdate = cdate;
        this.name = name;
        this.section = section;
        this.cdetail = cdetail;
        this.add = add;
        this.imgname = imgname;
        this.doc = doc;
        this.anote = anote;
    }

    
    public int getRId() {
        return rid;
    }

    public void setRId(int id) {
        this.rid = id;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCdetail() {
        return cdetail;
    }

    public void setCdetail(String cdetail) {
        this.cdetail = cdetail;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getAnote() {
        return anote;
    }

    public void setAnote(String anote) {
        this.anote = anote;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getChid() {
        return chid;
    }

    public void setChid(int chid) {
        this.chid = chid;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPdoc() {
        return pdoc;
    }

    public void setPdoc(String pdoc) {
        this.pdoc = pdoc;
    }
    
    
    
    
}
