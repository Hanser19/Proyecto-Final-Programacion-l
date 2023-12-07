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
 * @author cajor
 */
public class Ingresos extends ConexionSQL {

    public int Ing_ID;
    public String Ing_Descripcion;
    public String Ing_Fecha;
    public double Ing_Total;
    private static String query;

    public int getIng_ID() {
        return Ing_ID;
    }

    public void setIng_ID(int Ing_ID) {
        this.Ing_ID = Ing_ID;
    }

    public String getIng_Descripcion() {
        return Ing_Descripcion;
    }

    public void setIng_Descripcion(String Ing_Descripcion) {
        this.Ing_Descripcion = Ing_Descripcion;
    }

    public String getIng_Fecha() {
        return Ing_Fecha;
    }

    public void setIng_Fecha(String Ing_Fecha) {
        this.Ing_Fecha = Ing_Fecha;
    }

    public double getTotal() {
        return Ing_Total;
    }

    public void setTotal(int Total) {
        this.Ing_Total = Total;
    }

    public Ingresos(String Ing_Descripcion, String Ing_Fecha, Double Ing_Total) {
        this.Ing_Descripcion = Ing_Descripcion;
        this.Ing_Fecha = Ing_Fecha;
        this.Ing_Total = Ing_Total;
        insert();
        asignarId();
    }

    @Override
    public void insert() {
        query = "INSERT INTO Ingresos (Descripcion, Fecha, Total) VALUES(?,?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Ing_Descripcion);
            stm.setString(2, Ing_Fecha);
            stm.setDouble(3, Ing_Total); // Se utiliza BigDecimal para Total

            stm.executeUpdate();

            System.out.print("Se agregó el ingreso correctamente");

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
        }
    }

    private void asignarId() {
        query = "SELECT IngresoID FROM Ingresos WHERE Descripcion = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setString(1, Ing_Descripcion);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                this.Ing_ID = resultSet.getInt("IngresoID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
            System.out.println("Se agregó el ID de ingreso correctamente. El ID de ingreso es: " + this.Ing_ID);
        }
    }

    public static ArrayList<String[]> selectIngresos() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * FROM Ingresos";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[4];
                filas[0] = resultSet.getString("IngresoID");
                filas[1] = resultSet.getString("Descripcion");
                filas[2] = resultSet.getString("Fecha");
                filas[3] = resultSet.getString("Total");

                datos.add(filas);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static ArrayList<Integer> getIDIngresos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT IngresoID FROM Ingresos";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("IngresoID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    public static String[] getIngresoPorFiltro(int id, int index) {
        String[] fila = new String[4];
        query = "SELECT * FROM Ingresos WHERE IngresoID = ?";

        if (index == 0) {
            query = "SELECT * FROM Ingresos WHERE IngresoID = ?";
        } else {
            query = "SELECT * FROM Ingresos WHERE Descripcion = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("IngresoID");
                fila[1] = resultSet.getString("Descripcion");
                fila[2] = resultSet.getString("Fecha");
                fila[3] = resultSet.getString("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción de manera adecuada, por ejemplo, registra o lanza
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static void deleteIngreso(int id) {
        query = "DELETE FROM Ingresos WHERE IngresoID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción de manera adecuada, por ejemplo, registrándola o lanzándola
        } finally {
            close(getConection(), stm);
            System.out.println("Ingreso eliminado correctamente");
        }
    }

    public static void updateIngreso(int IngresoID, String Descripcion, String Fecha, Double Total) {

        query = "UPDATE Ingresos SET Descripcion=?, Fecha=?, Total=? WHERE IngresoID=?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Descripcion);
            stm.setString(2, Fecha);
            stm.setDouble(3, Total);
            stm.setInt(4, IngresoID);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Ingreso Actualizado Correctamente");
        }
    }
}
