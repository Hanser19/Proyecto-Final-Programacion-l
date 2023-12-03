/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ConexionSQL.Conection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Juan Manuel
 */
public class Insert {
    
    
    private static PreparedStatement stm;
    
    public static void insertarCaja(int numeroCaja){
        
        try{
            
            String query = "INSERT INTO Cajas(Numero) VALUES(?)";
            
            stm = Conection().prepareStatement(query);
            
            stm.setInt(1, numeroCaja);
            
            stm.executeUpdate();
            System.out.print("Se agrego la caja correctamente");
                   
            Conection().close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
