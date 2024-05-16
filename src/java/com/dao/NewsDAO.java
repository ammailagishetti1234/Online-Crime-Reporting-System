
package com.dao;

import com.entities.News;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO {
    private Connection con;
    
    public NewsDAO(Connection con){
        super();
        this.con = con;
    }
    
    public boolean addNews(News n)
    {
        boolean f = false;
        
        try{
            String sql = "insert into news(title, date_time, content) values(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n.getTitle());
            ps.setString(2, n.getDate_time());
            ps.setString(3, n.getContent());
            
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
    
    
    public boolean updateNews(News n)
    {
        boolean f = false;
        
        try{
            String sql = "update news set title=?, date_time=?, content=? where id=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, n.getTitle());
            ps.setString(2, n.getDate_time());
            ps.setString(3, n.getContent());
            
            ps.executeUpdate();
            f=true;
            
        }catch(Exception e)
        {
            out.println(e);
        }

        
        return f;
    }
    
    public List<News> getAllNews() {
        List<News> newsList = new ArrayList<>();

        try (
             Statement statement = con.createStatement()) {

            String query = "SELECT * FROM News";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                News news = new News();
                news.setTitle(resultSet.getString("title"));
                news.setString(resultSet.getString("date_time"));
                news.setContent(resultSet.getString("content"));

                newsList.add(news);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newsList;
    }
    
}
