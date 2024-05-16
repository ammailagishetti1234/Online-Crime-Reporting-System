
package com.dao;

import com.conn.DbConnect;
import com.entities.Complaint;
import com.entities.FIR;
import com.entities.chargesheet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class chargesheetDao {
    private Connection con;

    public chargesheetDao(Connection con) {
        this.con = con;
    }

    public chargesheetDao() {
    }
    
public boolean chargesheetreg(chargesheet c) {
    boolean success = false;

    try {
        FIRDao firDao = new FIRDao(con);
        FIR fir = firDao.getFIRById(c.getFid());

        if (fir != null) {
            ComplaintDao complaintDao = new ComplaintDao(con);
            Complaint complaint = complaintDao.getComplaintById(c.getCid());

            if (complaint != null) {
                String sql = "INSERT INTO chargesheet(fid, section, briefdesc, filename, offense, accused, charge_date, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, c.getFid());
                    ps.setString(2, c.getSection());
                    ps.setString(3, c.getBriefdesc());
                    ps.setString(4, c.getFileName());
                    ps.setString(5, c.getOffense());
                    ps.setString(6, c.getAccused());
                    ps.setDate(7, c.getDate());
                    ps.setString(8, c.getStatus());

                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected == 1) {
                        success = true;
                    }
                }
            } else {
                System.out.println("Complaint with id " + c.getCid() + " does not exist.");
            }
        } else {
            System.out.println("FIR with id " + c.getFid() + " does not exist.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return success;
}

        //to display the fir 
   public List<chargesheet> getChargeinfo() {
       PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<chargesheet> list = new ArrayList<chargesheet>();
   
        try{
            String query = "SELECT * from chargesheet";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            chargesheet c = new chargesheet();
            c.setId(rs.getInt("id"));    
           // c.setCid(rs.getInt("cid"));
            c.setSection(rs.getString("section"));
            c.setBriefdesc(rs.getString("briefdesc"));
            c.setFileName(rs.getString("filename"));
            c.setOffense(rs.getString("offense"));
            c.setAccused(rs.getString("accused"));
            c.setDate(rs.getDate("charge_date"));
            c.setStatus(rs.getString("status"));
            
            list.add(c);
            
        }
        
   }catch(Exception e){
       e.printStackTrace();
   }
        return list;
   }
   
   public List<chargesheet> getChargeinfoByFID(int fid) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<chargesheet> list = new ArrayList<chargesheet>();

    try {
        String query = "select * from chargesheet where fid=?";
        ps = con.prepareStatement(query);
        ps.setInt(1, fid);
        rs = ps.executeQuery();
        while (rs.next()) {
            chargesheet c = new chargesheet();
            c.setId(rs.getInt("id"));
            //c.setCid(rs.getInt("cid"));
            c.setSection(rs.getString("section"));
            c.setBriefdesc(rs.getString("briefdesc"));
            c.setFileName(rs.getString("filename"));
            c.setOffense(rs.getString("offense"));
            c.setAccused(rs.getString("accused"));
            c.setDate(rs.getDate("charge_date"));
            c.setStatus(rs.getString("status"));

            list.add(c);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
     return list;
   }
   
   
   public chargesheet getAllDetails(int fid){
       chargesheet ch =null;
       
       try {
       String query = "SELECT fir.id AS fid, fir.*, complaint.*, chargesheet.*\n" +
"FROM fir\n" +
"INNER JOIN complaint ON fir.id = complaint.id\n" +
"INNER JOIN chargesheet ON chargesheet.fid = fir.fid\n" +
"WHERE fir.fid = ?";
       
       PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, fid);
        ResultSet rs = ps.executeQuery();
        Complaint c = new Complaint();
        ch = new chargesheet();
        FIR f = new FIR();
        while(rs.next()){
           
            
            ch.setFid(rs.getInt("fid"));
            ch.setSection(rs.getString("section"));
            ch.setBriefdesc(rs.getString("briefdesc"));
            ch.setAccused(rs.getString("accused"));
            ch.setOffense(rs.getString("offense"));
            ch.setDate(rs.getDate("charge_date"));
            ch.setStatus(rs.getString("status"));
        }
       
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return ch;
   }
   
   public List<chargesheet> getAccptedcharge() {
       PreparedStatement ps = null;
       ResultSet rs = null;
    
    List<chargesheet> list = new ArrayList<chargesheet>();
    
    try{
        String query = "SELECT c.*, r.*\n" +
"FROM chargesheet c\n" +
"LEFT JOIN report r ON c.id = r.chid\n" +
"WHERE c.status = 'Active'";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            chargesheet c = new chargesheet();
            c.setFid(rs.getInt("fid"));
            c.setId(rs.getInt("id"));
            c.setSection(rs.getString("section"));
            c.setBriefdesc(rs.getString("briefdesc"));
            c.setDate(rs.getDate("charge_date"));
            c.setStatus(rs.getString("status"));
            
            list.add(c);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return list;
   }
   
   
   public List<chargesheet> getAccptedcharge1(int id) {
       PreparedStatement ps = null;
    ResultSet rs = null;
    
    List<chargesheet> list = new ArrayList<chargesheet>();
    
    try{
        String query = "SELECT c.*, r.* \n" +
"FROM chargesheet c \n" +
"LEFT JOIN report r ON c.id = r.chid \n" +
"WHERE c.status = 'Active' AND c.id = ?";
        ps = con.prepareStatement(query);
         ps.setInt(1, id); 
        rs = ps.executeQuery();
        while(rs.next()){
            chargesheet c = new chargesheet();
            c.setFid(rs.getInt("fid"));
            c.setId(rs.getInt("id"));
            c.setSection(rs.getString("section"));
            c.setBriefdesc(rs.getString("briefdesc"));
            c.setDate(rs.getDate("charge_date"));
            c.setStatus(rs.getString("status"));
            
            list.add(c);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return list;
   }
   

     public chargesheet getChDetails(int id){
       chargesheet ch =null;
       
       try {
       String query = "SELECT * FROM chargesheet WHERE id=?";
       
       PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        FIR f = new FIR();
        while(rs.next()){
            ch.setFid(rs.getInt("fid"));
            ch.setSection(rs.getString("section"));
            ch.setBriefdesc(rs.getString("briefdesc"));
            ch.setAccused(rs.getString("accused"));
            ch.setOffense(rs.getString("offense"));
            ch.setDate(rs.getDate("charge_date"));
            ch.setStatus(rs.getString("status"));
        }
       
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
       return ch;
   }
     
     //for to checking fir is registered
     public List<chargesheet> ischregistered(int fid) throws SQLException{
         List<chargesheet> list = new ArrayList<>();
         
         try (Connection conn = DbConnect.getConn();
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM chargesheet WHERE fid=?")){
             preparedStatement.setInt(1, fid);
             
              try (ResultSet rs = preparedStatement.executeQuery()) {
                  while (rs.next()) {
                    chargesheet f = new chargesheet();
                    f.setFid(rs.getInt("fid"));
                    f.setId(rs.getInt("id"));
                    f.setSection(rs.getString("section"));
                    f.setBriefdesc(rs.getString("briefdesc"));
                    f.setFileName(rs.getString("filename"));
                    f.setOffense(rs.getString("offense"));
                    f.setAccused(rs.getString("accused"));
                    f.setDate(rs.getDate("charge_date"));
                    f.setStatus(rs.getString("status"));
                    
                    list.add(f);
              }
             
         }
        return list;
     }
}
     
    //get chargesheet by id
public chargesheet getchargesheetById(int id) {
    chargesheet ch = new chargesheet();
    try {
        String query = "SELECT * FROM chargesheet WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ch.setId(rs.getInt("id"));
            ch.setFid(rs.getInt("fid")); // Assuming this is the correct field name for FIR ID
            ch.setSection(rs.getString("section"));
            ch.setBriefdesc(rs.getString("briefdesc"));
            ch.setFileName(rs.getString("filename"));
            ch.setOffense(rs.getString("offense"));
            ch.setAccused(rs.getString("accused"));
            ch.setDate(rs.getDate("charge_date"));
            ch.setStatus(rs.getString("status"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ch;
}


//get chargesheet details by user_id
public List<chargesheet> getChargesheetByUser(int userId){
    List<chargesheet> chdetail = new ArrayList<>();
    
    try{
        String query = "SELECT chargesheet.* FROM chargesheet JOIN fir ON chargesheet.fid = fir.fid WHERE fir.id IN (SELECT id FROM complaint WHERE user_id = ?);";
        PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, userId);  
          ResultSet rs = ps.executeQuery();
          
          while (rs.next()) {
              chargesheet ch = new chargesheet();
              
              ch.setId(rs.getInt("id"));
            ch.setFid(rs.getInt("fid")); 
            ch.setSection(rs.getString("section"));
            ch.setBriefdesc(rs.getString("briefdesc"));
            ch.setFileName(rs.getString("filename"));
            ch.setOffense(rs.getString("offense"));
            ch.setAccused(rs.getString("accused"));
            ch.setDate(rs.getDate("charge_date"));
            ch.setStatus(rs.getString("status"));
            
            chdetail.add(ch);
          }
          
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return chdetail;
}
   
}
