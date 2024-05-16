/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection con;

    public UserDAO(Connection con) {
        super();
        this.con = con;
    }
    
    public boolean userRegister(User u)
    {
        boolean f=false;
        
        try{
            String sql = "insert into reg(name, email, password) values(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            
            int i=ps.executeUpdate();
            if(i==1)
            {
                f=true;
            }  
           
        }catch(Exception e)
        {
            out.println(e);
        }
        
        return f;
    }
    
    public User loginuser(String e, String p)
    {
        User user=null;
        try{
            String sql="select * from reg where email=? and password=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, e);
            ps.setString(2, p);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                user=new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
            
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return user;
    }

   public boolean updateUser(User user)
   {
       boolean f=false;
       try{
           String query="update reg set name=?, email=?, password=? where id=?";
           PreparedStatement p=con.prepareStatement(query);
           p.setString(1, user.getName());
           p.setString(2, user.getEmail());
           p.setString(3, user.getPassword());
           p.setInt(4, user.getId());
           
           p.executeUpdate();
           f=true;
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       return f;
   }
    
   
    public User getUserByEmail(String email) {
        User user = null;

        try {
            String query = "SELECT * FROM reg WHERE email=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
              //  user.setDate(rs.getDate("date_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    public User getUserById(int id) {
        User user = null;

        try {
            String query = "SELECT * FROM reg WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
              //  user.setDate(rs.getDate("date_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}


