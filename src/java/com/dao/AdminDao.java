/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conn.DbConnect;
import com.entities.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class AdminDao {
     private Connection con;

    public AdminDao(Connection con) {
        this.con = con;
    }
     
    public boolean adminReg(Admin a){
        boolean f = false;
        
        try{
            String sql = "insert into admin(email, password, code) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, a.getEmail());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getCode());
            
            int i=ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }  
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return f;
    }
    
    public boolean isAdminTableEmpty() {
    boolean isEmpty = true;

    try (Connection conn = DbConnect.getConn();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM admin")) {

        // Check if the result set contains any rows
        if (rs.next()) {
            int count = rs.getInt("count");
            isEmpty = (count == 0); // If count is 0, table is empty
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle any SQL exceptions here
    }

    return isEmpty;
}

    
    public Admin loginadmin(String e, String p)
    {
        Admin admin=null;
        try{
            String sql="select * from admin where email=? and password=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, e);
            ps.setString(2, p);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                admin=new Admin();
                admin.setEmail(rs.getString(1));
                admin.setPassword(rs.getString(2));
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return admin;
    }
    
    public boolean updateAdmin(Admin admin)
   {
       boolean f=false;
       try{
           String query="update admin set email=?, password=?";
           PreparedStatement p=con.prepareStatement(query);
           p.setString(1, admin.getEmail());
           p.setString(2, admin.getPassword());
           
           p.executeUpdate();
           f=true;
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       return f;
   }
        
}
