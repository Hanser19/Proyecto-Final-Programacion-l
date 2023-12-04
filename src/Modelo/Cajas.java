/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cajor
 */
public class Cajas extends ConexionSQL{
    private int Caja_ID;
    private String Estado;
    private int Caja_Num;
    private int Caja_EmpID;
    
    public Cajas(int Caja_Num) {
        this.Caja_Num = Caja_Num;
        insert();
    }

    public int getCaja_ID() {
        return Caja_ID;
    }

    public void setCaja_ID(int Caja_ID) {
        this.Caja_ID = Caja_ID;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCaja_Num() {
        return Caja_Num;
    }

    public void setCaja_Num(int Caja_Num) {
        this.Caja_Num = Caja_Num;
    }

    public int getCaja_EmpID() {
        return Caja_EmpID;
    }

    public void setCaja_EmpID(int Caja_EmpID) {
        this.Caja_EmpID = Caja_EmpID;
    }
    
   @Override
    public void insert() {
        String query = "INSERT INTO Cajas(Numero) VALUES(?)";

        try {
           stm = getConection().prepareStatement(query);
            
           stm.setInt(1, Caja_Num);
            
           stm.executeUpdate();
           System.out.print("Se agrego la caja correctamente");        
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }
}
