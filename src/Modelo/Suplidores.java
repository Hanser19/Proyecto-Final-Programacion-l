/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hanser Perez
 */
public class Suplidores extends ConexionSQL {

    private int ID;
    private String Nombre;
    private String Direccion;
    private String Ciudad;
    private String Pais;
    private String Telefono;
    private int RNC;
    private static String query;

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public String getTelefono() {
        return Telefono;
    }

    public int getRNC() {
        return RNC;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setRNC(int RNC) {
        this.RNC = RNC;
    }

    public Suplidores(String Nombre, String Direccion, String Ciudad, String Pais, String Telefono, int RNC) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Ciudad = Ciudad;
        this.Pais = Pais;
        this.Telefono = Telefono;
        this.RNC = RNC;
        insert();
        asignarId();
    }

    @Override
    public void insert() {

        query = "INSERT INTO Suplidores (Nombre, Direccion, Ciudad, Pais, Telefono, RNC) VALUES(?,?,?,?,?,?)";

        try {

            stm = getConection().prepareStatement(query);

            stm.setString(1, Nombre);
            stm.setString(2, Direccion);
            stm.setString(3, Ciudad);
            stm.setString(4, Pais);
            stm.setString(5, Telefono);
            stm.setInt(6, RNC);

            stm.executeUpdate();

            System.out.print("Se agrego el proveedor correctamente");

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            close(getConection(), stm);
        }
    }
    
    

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * from Suplidores";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {

                String[] filas = new String[7];
                filas[0] = resultSet.getString("SuplidorID");
                filas[1] = resultSet.getString("Nombre");
                filas[2] = resultSet.getString("Direccion");
                filas[3] = resultSet.getString("Ciudad");
                filas[4] = resultSet.getString("Pais");
                filas[5] = resultSet.getString("Telefono");
                filas[6] = resultSet.getString("RNC");

                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    private void asignarId() {
        query = "select SuplidorID from Suplidores WHERE RNC = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, RNC);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.RNC = resultSet.getInt("RNC");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("se agrego el RNC correctamente el RNC es: " + this.RNC);
        }
    }

    public static void Delete(int id) {
        query = "DELETE FROM Suplidores WHERE SuplidorID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Proveedor eliminada correctamente");
        }
    }

    public static void update(int SuplidorID, String Nombre, String Direccion, String Ciudad, String Pais, String Telefono, int RNC) {

        query = "UPDATE Suplidores SET Nombre=?, Direccion=?, Ciudad=?, Pais=?, Telefono=?, RNC=?  WHERE SuplidorID=?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Nombre);
            stm.setString(2, Direccion);
            stm.setString(3, Ciudad);
            stm.setString(4, Pais);
            stm.setString(5, Telefono);
            stm.setInt(6, RNC);
            stm.setInt(7, SuplidorID);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Proveedor Actualizado Correctamente");
        }
    }

    public static ArrayList<Integer> getIDSuplidores() {
        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT SuplidorID FROM Suplidores";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("SuplidorID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    public static String[] getSuplidorPorFiltro(int numero, int index) {

        String[] fila = new String[7];

        query = "Select * from Suplidores where RNC = ?";

        if (index == 0) {

            query = "Select * from Suplidores where SuplidorID = ?";

        } else {
            query = "Select * from Suplidores where RNC = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, numero);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("SuplidorID");
                fila[1] = resultSet.getString("Nombre");
                fila[2] = resultSet.getString("Direccion");
                fila[3] = resultSet.getString("Ciudad");
                fila[4] = resultSet.getString("Pais");
                fila[5] = resultSet.getString("Telefono");
                fila[6] = resultSet.getString("RNC");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static ArrayList<Integer> getRNCsuplidor() {

        ArrayList<Integer> rncList = new ArrayList<>();
        query = "SELECT RNC FROM Suplidores";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                // Obtener el RNC como un entero
                int rnc = resultSet.getInt("RNC");
                rncList.add(rnc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return rncList;
    }

}
