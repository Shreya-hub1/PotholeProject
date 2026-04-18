import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdatePothole extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String status = req.getParameter("status");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pothole_db",
                "root",
                "India@11"
            );

            PreparedStatement ps = con.prepareStatement(
                "UPDATE potholes SET status=? WHERE pothole_id=?"
            );

            ps.setString(1, status);
            ps.setInt(2, id);

            ps.executeUpdate();

            res.sendRedirect("view.html");

        } catch(Exception e){
            res.getWriter().println(e);
        }
    }
}