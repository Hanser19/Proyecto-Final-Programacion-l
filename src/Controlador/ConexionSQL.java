package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConexionSQL {
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String hostName = "LocalHost";
    private static String port = "3306";
    private static String DBName = "provisional";
    
    private static String url = "jdbc:mysql://" + hostName + ":" + port + "/" + DBName + "?useSSL=false";
    
    private static String userName = "root";
    private static String password = "admin";
    
    private static Connection conn;
    protected static PreparedStatement stm;
    protected static ResultSet resultSet;
    
    public static Connection getConection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            if(conn != null){
                System.out.println("Conexion exitosa");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Conexion fallida");
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void insert();
}
