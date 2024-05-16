
package com.dao;

import com.entities.Complaint;
import com.entities.Police;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliceDao {
    private Connection con;

    public PoliceDao(Connection con) {
        this.con = con;
    }

    public PoliceDao() {
    }
    
    //for insert
      public boolean policeRegister(Police p) {
          boolean success = false;
          
          try{
              String sql = "INSERT INTO police(id, name, email, station, designation, pfilename, gender, cont_no, pstatus) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
              try(PreparedStatement ps = con.prepareStatement(sql)){
                  ps.setInt(1, p.getId());
                  ps.setString(2, p.getName());
                  ps.setString(3, p.getEmail());
                  ps.setString(4, p.getStation());
                  ps.setString(5, p.getDesignation());
                  ps.setString(6, p.getPfilename());
                  ps.setString(7, p.getGender());
                  ps.setString(8, p.getCont_no());
                  ps.setString(9, p.getPstatus());
                  
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
 
      //get complaint by id
    public Police getPoliceById(int id) throws SQLException
    {
        Police p = new Police();
        
        try{
            String query = "SELECT * FROM police WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                p.setpId(rs.getInt(1));
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setStation(rs.getString("station"));
                p.setDesignation(rs.getString("designation"));
                p.setGender(rs.getString("gender"));
                p.setCont_no(rs.getString("cont_no"));
                p.setPstatus(rs.getString("pstatus"));
            }
            
        }catch(Exception e){
            
        }
        
        return p;
    }
    
    //update the complaint
    public int updatePolice(Police p) throws SQLException
    {
        int status=0;
        
        String query = "update police set pstatus=? where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, p.getPstatus());
        ps.setInt(2, p.getId());
        
        status=ps.executeUpdate();
        
        con.close();
        
        return status;
    }
    
      //get complaint by id
    public List<Police> getPoliceinfo() {
    
        PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<Police> list = new ArrayList<Police>();
        
        try{
            String query = "SELECT * from police";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next()){
            Police p = new Police();
            //p.setpId(rs.getInt(1));
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setStation(rs.getString("station"));
                p.setDesignation(rs.getString("designation"));
                p.setGender(rs.getString("gender"));
                p.setCont_no(rs.getString("cont_no"));
                p.setPstatus(rs.getString("pstatus"));
            list.add(p);
            
        }
            
        }catch(Exception e){
            
        }
        
        return list;
    }
    
}
    

