package mss.modern_school_system;

import java.sql.*;

public class DBConnector {

    String url = "jdbc:mysql://localhost:3300/bobfi";
    String username = "root";
    String password = ""; //Magni064fg$
    Connection con;
    Statement statement;
    ResultSet result;

    public DBConnector() {
        try{
            con = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(String query) throws SQLException {
        result = statement.executeQuery(query);
    }

}
