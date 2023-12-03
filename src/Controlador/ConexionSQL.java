/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexionSQL {
    
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String hostName = "LocalHost";
    private static String port = "3306";
    private static String DBName = "provisional";
    
    private static String url = "jdbc:mysql://" + hostName + ":" + port + "/" + DBName + "?useSSL=false";
    
    private static String userName = "root";
    private static String password = "admin";
    
    private static Connection conn;
    
    
    public static Connection Conection(){
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            
            if(conn != null){
                System.out.println("Conexion exitosa");
            }
            
        }catch (SQLException e) {
            System.out.println("Conexion fallida");
            e.printStackTrace();
	}catch(ClassNotFoundException e){
            System.out.println("Conexion fallida");
            e.printStackTrace();
        }
        
        return conn;
    }
}
