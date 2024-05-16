
package com.dao;

import com.conn.DbConnect;
import com.entities.Complaint;
import com.entities.FIR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FIRDao {
    private Connection con;

    public FIRDao(Connection con) {
        this.con = con;
    }

    public FIRDao() {
    }
    
    //for insert
     public boolean firRegister(FIR f){
         boolean success = false;
         
         try{
             String sql = "INSERT INTO fir(id, section, complaint_type, reg_date, fir_detail, fir_start_date, fir_end_date, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
             
             try(PreparedStatement ps = con.prepareStatement(sql)){
                 ps.setInt(1, f.getId()); 
                 ps.setString(2, f.getSection());
                 ps.setString(3, f.getComplaint_type());
                 ps.setDate(4, f.getReg_date());
                 ps.setString(5, f.getFir_detail());
                 ps.setString(6, f.getFir_start_date());
                 ps.setString(7, f.getFir_end_date());
                 ps.setString(8, f.getStatus());
                 
                 int rowsAffected = ps.executeUpdate();
                  if (rowsAffected == 1) {
                  success = true;
                }
             }
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
         return success;
     }
     
     //for to checking fir is registered
     public List<FIR> isFIRregistered(int id) throws SQLException{
         List<FIR> list = new ArrayList<>();
         
         try (Connection conn = DbConnect.getConn();
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM fir WHERE id=?")){
             preparedStatement.setInt(1, id);
             
              try (ResultSet rs = preparedStatement.executeQuery()) {
                  while (rs.next()) {
                    FIR f = new FIR();
                    f.setFid(rs.getInt("fid"));
                    f.setId(rs.getInt("id"));
                    f.setSection(rs.getString("section"));
                    f.setComplaint_type(rs.getString("complaint_type"));
                    f.setReg_date(rs.getDate("reg_date"));
                    f.setFir_detail(rs.getString("fir_detail"));
                    f.setStatus(rs.getString("status"));
                    
                    list.add(f);
              }
             
         }
        return list;
     }
}
     
     //get fir by id
     public FIR getFIRById(int fid)
     {
         FIR f = new FIR();
         try{
            String query = "SELECT * FROM fir WHERE fid=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, fid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                f.setFid(rs.getInt("fid"));
                f.setId(rs.getInt("id"));
                f.setSection(rs.getString("section"));
                f.setComplaint_type(rs.getString("complaint_type"));
                f.setReg_date(rs.getDate("reg_date"));
                f.setFir_detail(rs.getString("fir_detail"));
                f.setFir_start_date(rs.getString("fir_start_date"));
                f.setFir_end_date(rs.getString("fir_end_date"));
                f.setStatus(rs.getString("status"));
                
                f.setName(rs.getString("name"));
                f.setStation(rs.getString("station"));
            
            f.setChstatus(rs.getString("status"));
            }
         }catch(Exception e){
             e.printStackTrace();
         }
        return f;
         
     }
     
     //to display the fir 
   public List<FIR> getFIRinfo() {
       PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<FIR> list = new ArrayList<FIR>();
   try {
        String query = "SELECT * from fir";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            FIR f = new FIR();
            f.setFid(rs.getInt("fid"));
            f.setId(rs.getInt("id"));
            f.setSection(rs.getString("section"));
            f.setComplaint_type(rs.getString("complaint_type"));
            f.setReg_date(rs.getDate("reg_date"));
            f.setFir_detail(rs.getString("fir_detail"));
            f.setFir_start_date(rs.getString("fir_start_date"));
            f.setFir_end_date(rs.getString("fir_end_date"));
            f.setStatus(rs.getString("status"));
            
            list.add(f);
        }
   }catch(Exception e){
       e.printStackTrace();
   }
        return list;
   }
   
   //update FIR status
   public int updateFIR(FIR f) throws SQLException{
       int status=0;
       String query="UPDATE fir set status=? where fid=?";
       PreparedStatement ps=con.prepareStatement(query);
       ps.setString(1, f.getStatus());
        ps.setInt(2, f.getFid());
        
        status=ps.executeUpdate();
        
        con.close();
       
        return status;
   }
   
   
   //display FIR by userId
   public List<FIR> getFIRByUserId(int userId) {
       List<FIR> firList = new ArrayList<>();
            
        try {
            String query="select fir.* from fir JOIN complaint ON fir.id=complaint.id JOIN reg ON complaint.user_id=reg.id where reg.id=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            FIR f = new FIR();
            f.setFid(rs.getInt("fid"));
            f.setId(rs.getInt("id"));
            f.setSection(rs.getString("section"));
            f.setComplaint_type(rs.getString("complaint_type"));
            f.setReg_date(rs.getDate("reg_date"));
            f.setFir_detail(rs.getString("fir_detail"));
            f.setFir_start_date(rs.getString("fir_start_date"));
            f.setFir_end_date(rs.getString("fir_end_date"));
            f.setStatus(rs.getString("status"));
            
            firList.add(f);
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FIRDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return firList;
   }
   
   //get fir detail by user id
   public List<FIR> getFIRDetail(int userId) {
       List<FIR> firdetail = new ArrayList<>();
       
       try{
          String query = "select fir.* from fir JOIN complaint ON fir.id=complaint.id JOIN reg ON complaint.user_id=reg.id where reg.id=?"; 
          PreparedStatement ps = con.prepareStatement(query);
          ps.setInt(1, userId);  
          ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            FIR f = new FIR();
            
            f.setFid(rs.getInt("fid"));
            f.setId(rs.getInt("id"));
            f.setSection(rs.getString("section"));
            f.setComplaint_type(rs.getString("complaint_type"));
            f.setReg_date(rs.getDate("reg_date"));
            f.setFir_detail(rs.getString("fir_detail"));
            f.setFir_start_date(rs.getString("fir_start_date"));
            f.setFir_end_date(rs.getString("fir_end_date"));
            f.setStatus(rs.getString("status"));
            
            firdetail.add(f);
        }
          
       }catch(Exception e){
           
       }
       
        return firdetail;
   }
   
   
    //to display the fir 
   public List<FIR> getAccptedFir1() {
    PreparedStatement ps = null;
    ResultSet rs = null;
   
   List<FIR> list = new ArrayList<FIR>();
   try {
String query = "SELECT f.*, p.name, p.station, c.status AS Chstatus FROM fir f JOIN police p ON f.id = p.id LEFT JOIN chargesheet c ON f.id = c.fid AND c.status = 'Active' WHERE f.status = 'Active'";
     ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            FIR f = new FIR();
            f.setFid(rs.getInt("fid"));
            f.setId(rs.getInt("id"));
            f.setSection(rs.getString("section"));
            f.setComplaint_type(rs.getString("complaint_type"));
            f.setReg_date(rs.getDate("reg_date"));
            f.setFir_detail(rs.getString("fir_detail"));
            f.setFir_start_date(rs.getString("fir_start_date"));
            f.setFir_end_date(rs.getString("fir_end_date"));
            f.setStatus(rs.getString("status"));
            f.setName(rs.getString("name"));
            f.setStation(rs.getString("station"));
            
            f.setName(rs.getString("name"));
            f.setStation(rs.getString("station"));
            
            
            list.add(f);
        }
   }catch(Exception e){
       e.printStackTrace();
   }
        return list;
   }
 
   
   //fir accpeted page
public List<FIR> getAccptedFIR(int fid) throws SQLException {
    
   PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<FIR> list = new ArrayList<FIR>();
   try{
       //String query = "select id, complaint_detail, name, email, phone_no, police_station_city, police_station_state, type_of_crime, accused_name, accused_address, accused_phone_no, victim_name, victim_address, victim_phone_no from Complaint where id=?";
       String query = "SELECT f.*, ch.id AS chid FROM fir f LEFT JOIN chargesheet ch ON f.fid = ch.fid WHERE f.fid=?";
       ps = con.prepareStatement(query);
       ps.setInt(1, fid);
        rs = ps.executeQuery();
        while(rs.next()){
            FIR f = new FIR(); 
               f.setFid(rs.getInt("fid"));
            f.setId(rs.getInt("id"));
            f.setSection(rs.getString("section"));
            f.setComplaint_type(rs.getString("complaint_type"));
            f.setReg_date(rs.getDate("reg_date"));
            f.setFir_detail(rs.getString("fir_detail"));
            f.setFir_start_date(rs.getString("fir_start_date"));
            f.setFir_end_date(rs.getString("fir_end_date"));
            f.setStatus(rs.getString("status"));
//            f.setName(rs.getString("name"));
//            f.setStation(rs.getString("station"));
            
//            f.setName(rs.getString("name"));
//            f.setStation(rs.getString("station"));
            
               list.add(f);
        }
   }catch(Exception e){
       e.printStackTrace();
   }
    return list;
}

}
