
package com.dao;

import com.conn.DbConnect;
import com.entities.FIR;
import com.entities.chargesheet;
import com.entities.report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class reportDao {
    private Connection con;

    public reportDao(Connection con) {
        this.con = con;
    }

    public reportDao() {
    }
    
    public boolean regreport(report r){
        boolean success = false;
        
        try{
            chargesheetDao dao = new chargesheetDao(con);
            List<chargesheet> ch = dao.getChargeinfoByFID(r.getFid());
            
            if(ch != null){
                FIRDao firDao = new FIRDao(con);
                FIR fir = firDao.getFIRById(r.getFid());
                
                if(fir != null){
            String sql = "INSERT into report(chid, crdate, pname, section, cdetail, paddress, pimgfilename, note) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            
            try(PreparedStatement ps = con.prepareStatement(sql)){
               // ps.setInt(1, r.getFid());
                ps.setInt(1, r.getChid());
                ps.setDate(2, r.getCdate());
                ps.setString(3, r.getName());
                ps.setString(4, r.getSection());
                ps.setString(5, r.getCdetail());
                ps.setString(6, r.getAdd());
                ps.setString(7, r.getImgname());
               // ps.setString(9, r.getDoc());
                ps.setString(8, r.getAnote());
                
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                success = true;
                }
            }
            } else{
                  //for fir  
                  System.out.println("FIR with id " + r.getFid() + " does not exist.");
                }
            } else {
               //for chargesheet 
               System.out.println("chargesheet with id " + r.getFid() + " does not exist.");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return success;
    }
    
     //for to checking fir is registered
     public List<report> isReportReg(int id) throws SQLException{
         List<report> list = new ArrayList<>();
         
         try (Connection conn = DbConnect.getConn();
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM report WHERE chid=?")){
             preparedStatement.setInt(1, id);
             
              try (ResultSet rs = preparedStatement.executeQuery()) {
                  while (rs.next()) {
                    report r = new report();
                    r.setChid(rs.getInt("chid"));
                    r.setRId(rs.getInt("id"));
                    r.setName(rs.getString("pname"));
                    r.setSection(rs.getString("section"));
                    r.setCdetail(rs.getString("cdetail"));
                    r.setAdd(rs.getString("paddress"));
                    r.setImgname(rs.getString("pimgfilename"));
                  //  r.setSection(rs.getString("pdocfilename"));
                    
                    list.add(r);
              }
         }
        return list;
     }
}
     
      //for to checking fir is registered
     public List<report> isReportReg1(int id) throws SQLException{
         List<report> list = new ArrayList<>();
         
         try (Connection conn = DbConnect.getConn();
                 PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM report WHERE id=?")){
             preparedStatement.setInt(1, id);
             
              try (ResultSet rs = preparedStatement.executeQuery()) {
                  while (rs.next()) {
                    report r = new report();
                    r.setChid(rs.getInt("chid"));
                    r.setRId(rs.getInt("id"));
                    r.setCdate(rs.getDate("crdate"));
                    r.setName(rs.getString("pname"));
                    r.setSection(rs.getString("section"));
                    r.setCdetail(rs.getString("cdetail"));
                    r.setAdd(rs.getString("paddress"));
                    r.setImgname(rs.getString("pimgfilename"));
                    
                    list.add(r);
              }
         }
        return list;
     }
         
     
}
}
