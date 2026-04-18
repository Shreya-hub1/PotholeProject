import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ViewPotholes extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<h2>Pothole List</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Location</th><th>Area</th><th>Severity</th><th>Status</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pothole_db","root","India@11");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM potholes");

            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt("pothole_id")+"</td>");
                out.println("<td>"+rs.getString("location")+"</td>");
                out.println("<td>"+rs.getString("area")+"</td>");
                out.println("<td>"+rs.getString("severity")+"</td>");
                out.println("<td>"+rs.getString("status")+"</td>");
                out.println("</tr>");
            }

            out.println("</table>");

        } catch(Exception e){
            out.println(e);
        }
    }
}