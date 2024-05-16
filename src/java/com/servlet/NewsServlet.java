
package com.servlet;

import com.conn.DbConnect;
import com.dao.NewsDAO;
import com.entities.News;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String date_time = request.getParameter("date_time");
        String content = request.getParameter("content");
        
        News n = new News(title, date_time, content);
        
        NewsDAO dao=new NewsDAO(DbConnect.getConn()); 
        
        //boolean f=dao.addNews(n);
        
        boolean f = dao.updateNews(n);
        
        HttpSession session=request.getSession();
        
        if(f){
            out.println("<html><head><script type='text/javascript'>");
    out.println("alert('News Updated successful;ly..!!');");
    out.println("window.location.href='admin.jsp'");
    out.println("</script></head></html>");

        }else{
            out.println("<html><head><script type='text/javascript'>");
            out.println("alert('Something went wrong!');");
            out.println("window.location.href='admin.jsp'");
            out.println("</script></head></html>");
        }
    }
    
}
