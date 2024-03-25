/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDatabase {

    public connectDatabase() {
    }
    public static Connection TaoKetNoi(){
        String url = "jdbc:mysql://localhost:3306/qlquantrasua";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connectDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet GetData(String q) {
        Connection conn = TaoKetNoi();
        try {
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
    public int EditData(String q) {
        Connection conn = TaoKetNoi();
        try {
            PreparedStatement ps = conn.prepareStatement(q);
            int rs = ps.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            return 0;
        }
    }
    
//    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    static final String DB_URL = "jdbc:sqlserver://localhost;";
//    static final String DATABASENAME = "databaseName=QLQuanTraSua;";
//    static final String USER = "user=sa;";
//    static final String PASS = "password=123";
//
//    public static Connection TaoKetNoi() throws ClassNotFoundException, SQLException{
//        Connection conn = null;
//        Class.forName(JDBC_DRIVER);
//        conn = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
//        return conn;
//    }
}
