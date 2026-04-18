import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeletePothole extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/pothole_db",
                "root",
                "India@11"
            );

            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM potholes WHERE pothole_id=?"
            );

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                res.getWriter().println("Deleted Successfully");
            } else {
                res.getWriter().println("ID Not Found");
            }

            con.close();

        } catch(Exception e){
            res.getWriter().println(e);
        }
    }
}