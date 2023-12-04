package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public abstract class ConexionSQL {
    
    private  String driver = "com.mysql.cj.jdbc.Driver";
    private  String hostName = "LocalHost";
    private  String port = "3306";
    private  String DBName = "provisional";
    
    private  String url = "jdbc:mysql://" + hostName + ":" + port + "/" + DBName + "?useSSL=false";
    
    private  String userName = "root";
    private  String password = "admin";
    
    private Connection conn;
    protected PreparedStatement stm;
    
    public Connection getConection() {
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
