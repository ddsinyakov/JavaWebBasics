package step.learning;

import step.learning.services.database.DataBaseProvider;
import step.learning.services.database.MySQLProvider;

import javax.inject.Singleton;
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
import java.util.ArrayList;
import java.util.List;

@Singleton
@WebServlet("/filters")
public class FiltersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get users count

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

        // get list o users

        sql = "SELECT * FROM Users";
        List<String> users = new ArrayList<>();

        try (Statement statement = db.getConnection().createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                users.add(res.getString("name") + " " + res.getString("login"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Query error: " + ex.getMessage());
        }

        // manage

        req.setAttribute("Count", result);
        req.setAttribute("Users", users.toArray(new String[0]));

        req.getRequestDispatcher("WEB-INF/filters.jsp").forward(req, resp);
    }
}
