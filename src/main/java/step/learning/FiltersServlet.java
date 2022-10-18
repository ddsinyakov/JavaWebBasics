package step.learning;

import step.learning.services.database.DataBaseProvider;
import step.learning.services.database.MySQLProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/filters")
public class FiltersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sql = "SELECT COUNT(*) FROM Users";
        DataBaseProvider db = (DataBaseProvider) req.getAttribute("DataService");

        String result = "No users";

        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            if(res.next()) {
                result = "" + res.getInt(1);
            }
        }
        catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }

        req.setAttribute("Count", result);
        req.getRequestDispatcher("WEB-INF/filters.jsp").forward(req, resp);
    }
}
