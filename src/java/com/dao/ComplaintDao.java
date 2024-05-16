
package com.dao;

import com.conn.DbConnect;
import com.entities.Complaint;
import com.entities.Police;
import com.entities.User;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDao {
    private Connection con;

    public ComplaintDao(Connection con) {
        super();
        this.con = con;
    }

    public ComplaintDao() {
        
    }
    
//for insert
 public boolean complaintRegister(Complaint c) {
    boolean success = false;

    try {
        String sql = "INSERT INTO complaint(user_id, name, email, phone_no, police_station_city, police_station_state, " +
                "complaint_detail, area, incident_city, type_of_crime, date, accused_name, accused_address, " +
                "accused_phone_no, victim_name, victim_address, victim_phone_no, evidence_detail, imageFileName, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Set values for parameters in the PreparedStatement
            ps.setInt(1, c.getUserId());  
            ps.setString(2, c.getName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone_no());
            ps.setString(5, c.getPolice_city());
            ps.setString(6, c.getPolice_state());
            ps.setString(7, c.getComplaint_detail());
            ps.setString(8, c.getArea());
            ps.setString(9, c.getIcity());
            ps.setString(10, c.getTcrime());
            ps.setDate(11, c.getDate());
            ps.setString(12, c.getAccused_name());
            ps.setString(13, c.getAccused_add());
            ps.setString(14, c.getAccused_phno());
            ps.setString(15, c.getVictim_name());
            ps.setString(16, c.getVictim_add());
            ps.setString(17, c.getVictim_phno());
            ps.setString(18, c.getEvidence_detail());
            ps.setString(19, c.getFileName());
            ps.setString(20, c.getStatus());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                success = true;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error in complaintRegister", e);
    }

    return success;
}

//get complaint by id
    public Complaint getComplaintById(int id)
    {
        Complaint c = new Complaint();
        
        try{
            String query = "SELECT * FROM complaint WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt(1));
                c.setUserId(rs.getInt("user_id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone_no(rs.getString("phone_no"));
                c.setPolice_city(rs.getString("police_station_city"));
                c.setPolice_state(rs.getString("police_station_state"));
                c.setComplaint_detail(rs.getString("complaint_detail"));
                c.setArea(rs.getString("area"));
                c.setIcity(rs.getString("incident_city"));
                c.setTcrime(rs.getString("type_of_crime"));
                c.setDate(rs.getDate("date"));
                c.setAccused_name(rs.getString("accused_name")); 
                c.setAccused_add(rs.getString("accused_address"));
                c.setAccused_phno(rs.getString("accused_phone_no"));
                c.setVictim_name(rs.getString("victim_name"));
                c.setVictim_add(rs.getString("victim_address"));
                c.setVictim_phno(rs.getString("victim_phone_no"));
                c.setEvidence_detail(rs.getString("evidence_detail"));
                c.setFileName(rs.getString("imageFileName"));
                c.setStatus(rs.getString("status"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return c;
    }
    
    
    
    //to display the complaint 
   public List<Complaint> getComplaintinfo() {
   PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<Complaint> list = new ArrayList<Complaint>();
   try {
        String query = "SELECT \n" +
"    c.*, \n" +
"    p.pstatus\n" +
"FROM complaint c\n" +
"LEFT JOIN police p ON c.id = p.id;";
        ps = con.prepareStatement(query);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Complaint c = new Complaint();
                c.setId(rs.getInt("id"));
                c.setUserId(rs.getInt("user_id"));
                c.setPolice_city(rs.getString("police_station_city"));
                c.setPolice_state(rs.getString("police_station_state"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone_no(rs.getString("phone_no"));
                c.setComplaint_detail(rs.getString("complaint_detail"));
                c.setArea(rs.getString("area"));
                c.setIcity(rs.getString("incident_city"));
                c.setTcrime(rs.getString("type_of_crime"));
                c.setDate(rs.getDate("date")); 
                c.setAccused_name(rs.getString("accused_name"));
                c.setAccused_add(rs.getString("accused_address"));
                c.setAccused_phno(rs.getString("accused_phone_no"));
                c.setVictim_name(rs.getString("victim_name"));
                c.setVictim_add(rs.getString("victim_address"));
                c.setVictim_phno(rs.getString("victim_phone_no"));
                c.setEvidence_detail(rs.getString("evidence_detail"));
                c.setFileName(rs.getString("imageFileName"));
                c.setStatus(rs.getString("status"));
//                Police p = new Police();
//                p.setPstatus(rs.getString("pstatus"));  

                c.setPstatus(rs.getString("pstatus"));
                list.add(c);
        }
   }catch(Exception e)
   {
       e.printStackTrace();
   }
        return list;
}
    
   //update the complaint
    public int updateComp(Complaint c) throws SQLException
    {
        int status=0;
        String query="update Complaint set user_id=?, name=?, email=?, phone_no=?, police_station_city=?, police_station_state=?, complaint_detail=?, area=?, incident_city=?, type_of_crime=?, date=?, accused_name=?, accused_address=?, accused_phone_no=?, victim_name=?, victim_address=?, victim_phone_no=?, status=? where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1, c.getUserId());
        ps.setString(2, c.getName());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getPhone_no());
        ps.setString(5, c.getPolice_city());
        ps.setString(6, c.getPolice_state());
        ps.setString(7, c.getComplaint_detail());
        ps.setString(8, c.getArea());
        ps.setString(9, c.getIcity());
        ps.setString(10, c.getTcrime());
        ps.setDate(11, new java.sql.Date(c.getDate().getTime()));
        ps.setString(12, c.getAccused_name());
        ps.setString(13, c.getAccused_add());
        ps.setString(14, c.getAccused_phno());
        ps.setString(15, c.getVictim_name());
        ps.setString(16, c.getVictim_add());
        ps.setString(17, c.getVictim_phno());
       // ps.setString(18, c.getEvidence_detail());
        //ps.setString(19, c.getFileName());
        ps.setString(18, c.getStatus());
        ps.setInt(19, c.getId());
        
        status=ps.executeUpdate();
        
        con.close();
        
        return status;
    }
    
    //delete the complaint
    public int delete(int id) 
    {
        int status=0;
        try{
        String query = "delete from Complaint where id=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1, id);
        status = ps.executeUpdate();
        con.close();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return status;
    }
    
     // Check if the phone number exists in the database
    public boolean isPhoneNumberExists(String phoneNumber) throws SQLException {
        String query = "SELECT COUNT(*) FROM complaint WHERE phone_no = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, phoneNumber);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    //display complaint by user id
public List<Complaint> getComplaintDetails1(int userId) {
    List<Complaint> complaintList = new ArrayList<>();

    try {
        String query = "select * from Complaint WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, userId);  
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Complaint c = new Complaint();
            
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
                c.setPhone_no(rs.getString("phone_no"));
                c.setPolice_city(rs.getString("police_station_city"));
                c.setPolice_state(rs.getString("police_station_state"));
                c.setComplaint_detail(rs.getString("complaint_detail"));
                c.setArea(rs.getString("area"));
                c.setIcity(rs.getString("incident_city"));
                c.setTcrime(rs.getString("type_of_crime"));
                c.setDate(rs.getDate("date"));
                c.setAccused_name(rs.getString("accused_name"));  
                c.setAccused_add(rs.getString("accused_address"));
                c.setAccused_phno(rs.getString("accused_phone_no"));
                c.setVictim_name(rs.getString("victim_name"));
                c.setVictim_add(rs.getString("victim_address"));
                c.setVictim_phno(rs.getString("victim_phone_no"));
                c.setEvidence_detail(rs.getString("evidence_detail"));
                c.setFileName(rs.getString("imageFileName"));
                c.setStatus(rs.getString("status"));

            complaintList.add(c);
        }
    } catch (SQLException e) {
        e.printStackTrace(); 
    }

    return complaintList;
}

//fetch complaint using user_id
public List<Complaint> getComplaintsByUserId(int userId) throws SQLException {
    List<Complaint> complaints = new ArrayList<>();
    
    try{
    String sql = "SELECT * FROM Complaint WHERE user_id = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1,userId);
     ResultSet rs = ps.executeQuery();
      while (rs.next()) {
          Complaint c = new Complaint();
            c.setId(rs.getInt("id"));
            c.setUserId(rs.getInt("user_id"));
            c.setName(rs.getString("name"));
            c.setEmail(rs.getString("email"));
            c.setPhone_no(rs.getString("phone_no"));
            c.setPolice_city(rs.getString("police_station_city"));
            c.setPolice_state(rs.getString("police_station_state"));
            c.setComplaint_detail(rs.getString("complaint_detail"));
            c.setArea(rs.getString("area"));
            c.setIcity(rs.getString("incident_city"));
            c.setTcrime(rs.getString("type_of_crime"));
            c.setDate(rs.getDate("date"));
            c.setAccused_name(rs.getString("accused_name"));
            c.setAccused_add(rs.getString("accused_address"));
            c.setAccused_phno(rs.getString("accused_phone_no"));
            c.setVictim_name(rs.getString("victim_name"));
            c.setVictim_add(rs.getString("victim_address"));
            c.setVictim_phno(rs.getString("victim_phone_no"));
            c.setEvidence_detail(rs.getString("evidence_detail"));
            c.setFileName(rs.getString("imageFileName"));
            c.setStatus(rs.getString("status"));
            
            complaints.add(c);
      }
    }
      catch(Exception e){
            e.printStackTrace();  
      }
     
    
    return complaints;
}

//for fir in regfir
public List<Complaint> getComplaintFIR(int id){
 
   PreparedStatement ps = null;
   ResultSet rs = null;
   
   List<Complaint> list = new ArrayList<Complaint>();
   try{
       String query = "SELECT c.*, f.fid AS fir_id FROM complaint c LEFT JOIN fir f ON c.id = f.id WHERE c.id=?";
       ps = con.prepareStatement(query);
       ps.setInt(1, id);
        rs = ps.executeQuery();
        while(rs.next()){
            Complaint c = new Complaint(); 
               c.setId(rs.getInt("id"));
               c.setComplaint_detail(rs.getString("complaint_detail"));
               c.setName(rs.getString("name"));
               c.setEmail(rs.getString("email"));
               c.setPhone_no(rs.getString("phone_no"));
               c.setPolice_city(rs.getString("police_station_city"));
               c.setPolice_state(rs.getString("police_station_state"));
               c.setTcrime(rs.getString("type_of_crime"));
               c.setAccused_name(rs.getString("accused_name"));
               c.setAccused_add(rs.getString("accused_address"));
               c.setAccused_phno(rs.getString("accused_phone_no"));
               c.setVictim_name(rs.getString("victim_name"));
               c.setVictim_add(rs.getString("victim_address"));
               c.setVictim_phno(rs.getString("victim_phone_no"));
               list.add(c);
        }
   }catch(Exception e){
       e.printStackTrace();
   }
    return list;
}

//complaint accpeted page
public List<Complaint> getAccptedComplent() throws SQLException {
    List<Complaint> list=new ArrayList<>();
    
     try (Connection conn = DbConnect.getConn();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT complaint.*, police.Pstatus FROM complaint JOIN police ON police.id = complaint.id WHERE complaint.status = 'Accepted'");
             ResultSet rs = preparedStatement.executeQuery()) {
         while(rs.next()){
             Complaint c = new Complaint();
             c.setId(rs.getInt("id"));
             c.setId(rs.getInt("id"));
               c.setComplaint_detail(rs.getString("complaint_detail"));
               c.setName(rs.getString("name"));
               c.setEmail(rs.getString("email"));
               c.setPhone_no(rs.getString("phone_no"));
               c.setPolice_city(rs.getString("police_station_city"));
               c.setPolice_state(rs.getString("police_station_state"));
               c.setTcrime(rs.getString("type_of_crime"));
               c.setAccused_name(rs.getString("accused_name"));
               c.setAccused_add(rs.getString("accused_address"));
               c.setAccused_phno(rs.getString("accused_phone_no"));
               c.setDate(rs.getDate("date"));
               
               c.setStatus(rs.getString("status"));
               
               c.setPstatus(rs.getString("Pstatus"));
               list.add(c);
         }
     }catch(Exception e){
       e.printStackTrace();
   }
    return list;
}



//crime_graph
public List<Complaint> getCrimeReports(String incident_city, Date start_date, Date end_date) throws SQLException {
    List<Complaint> c = new ArrayList<>();

    String sql = "SELECT area, type_of_crime, COUNT(area) AS area_count, COUNT(type_of_crime) AS type_count FROM Complaint WHERE incident_city=? AND date BETWEEN ? AND ? GROUP BY area, type_of_crime";
   
   PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, incident_city);
    ps.setDate(2, start_date);
    ps.setDate(3, end_date);

    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Complaint crime = new Complaint();

        crime.setIcity(rs.getString("incident_city"));
        crime.setArea(rs.getString("area"));
        crime.setTcrime(rs.getString("type_of_crime"));
        crime.setAreacrimecount(rs.getInt("area_count"));
        crime.setTypecrimecount(rs.getInt("type_count"));

        c.add(crime);
    }
   System.out.println("SQL Query: " + sql + ", incident_city: " + incident_city + ", start_date: " + start_date + ", end_date: " + end_date);

    return c;
}
 
//for choosedata page
  public List<Complaint> getAllCrimeData() throws SQLException {
   PreparedStatement ps = null;
   //ResultSet rs = null;
   
   List<Complaint> list = new ArrayList<Complaint>();
   try {
        String query = "SELECT incident_area AS Area, type_of_crime AS CrimeType, date AS Date, COUNT(*) AS CrimeCount FROM complaint GROUP BY incident_area, type_of_crime, date;";
        ps = con.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String city = resultSet.getString("incident_area");
                String area = resultSet.getString("area");
                String tcrime = resultSet.getString("type_of_crime");
                Date date = resultSet.getDate("date");
                int crimeCount = resultSet.getInt("CrimeCount");

                Complaint crimeData = new Complaint(city, area, tcrime, date, crimeCount);
                // Set other properties as needed
                list.add(crimeData);
            }

   
   }catch(Exception e)
   {
       e.printStackTrace();
   }
        
        return list;
    }


  //get complaint by complaintId
  public Complaint getComplaintByCId(int complaintId) throws SQLException {
    Complaint complaint = null;
    
    try (Connection conn = DbConnect.getConn();
         PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM complaint JOIN fir ON complaint.id = fir.id WHERE fir.fid = ?")) {
        preparedStatement.setInt(1, complaintId);
        try (ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                complaint = new Complaint();
                complaint.setId(rs.getInt("id"));
                complaint.setComplaint_detail(rs.getString("complaint_detail"));
                complaint.setName(rs.getString("name"));
                complaint.setEmail(rs.getString("email"));
                complaint.setPhone_no(rs.getString("phone_no"));
                complaint.setPolice_city(rs.getString("police_station_city"));
                complaint.setPolice_state(rs.getString("police_station_state"));
                complaint.setTcrime(rs.getString("type_of_crime"));
                complaint.setAccused_name(rs.getString("accused_name"));
                complaint.setAccused_add(rs.getString("accused_address"));
                complaint.setAccused_phno(rs.getString("accused_phone_no"));
                complaint.setDate(rs.getDate("date"));
                complaint.setStatus(rs.getString("status"));
                // Assuming 'Pstatus' is fetched from the 'police' table, you may need to modify this line accordingly
                complaint.setPstatus(rs.getString("Pstatus"));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    return complaint;
}

  

}