package com.modreniraq.cdms.models.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cdmsdb", "ali", "1994");
        if (con != null) {
            return con;
        }
        return null;
    }

    public void CloseConnection(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
