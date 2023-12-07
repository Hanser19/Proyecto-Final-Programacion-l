package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class ConexionSQL {
    
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String hostName = "localhost";
    private static final String port = "3306";
    private static final String DBName = "provisional";
    
    private static final String url = "jdbc:mysql://" + hostName + ":" + port + "/" + DBName + "?useSSL=false";
    
    private static final String userName = "root";
    private static final String password = "1234";
    
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
        }
        return conn;
    }

    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
                System.out.println("Stm cerrado correctamente");
            }
            if (connection != null) {
                try (connection) {
                    System.out.println("Conexcion cerrado correctamente");
                }
            }
        } catch (SQLException e) {
        }
    }
    protected abstract void insert();
}
