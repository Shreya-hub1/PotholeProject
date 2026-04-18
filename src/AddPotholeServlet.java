import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddPotholeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String location = request.getParameter("location");
        String area = request.getParameter("area");
        String severity = request.getParameter("severity");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pothole_db",
                "root",
                "India@11"
            );

           PreparedStatement ps = con.prepareStatement(
    "INSERT INTO potholes(location, area, severity, reported_by) VALUES (?, ?, ?, ?)"
);

ps.setString(1, location);
ps.setString(2, area);
ps.setString(3, severity);
ps.setInt(4, 1);

            ps.executeUpdate();

            response.getWriter().println("Data Inserted Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}