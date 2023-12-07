/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import static Controlador.ConexionSQL.close;
import static Controlador.ConexionSQL.getConection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cajor
 */
public class Gastos extends ConexionSQL {

    public int Gst_ID;
    public String Gst_Descripcion;
    public String Gst_Fecha;
    public Double Gst_Total;
    private static String query;

    public Gastos(String Gst_Descripcion, String Gst_Fecha, Double Gst_Total) {
        this.Gst_Descripcion = Gst_Descripcion;
        this.Gst_Fecha = Gst_Fecha;
        this.Gst_Total = Gst_Total;
        insert();
        asignarId();
    }

    public int getGst_ID() {
        return Gst_ID;
    }

    public void setGst_ID(int Gst_ID) {
        this.Gst_ID = Gst_ID;
    }

    public String getGst_Descripcion() {
        return Gst_Descripcion;
    }

    public void setGst_Descripcion(String Gst_Descripcion) {
        this.Gst_Descripcion = Gst_Descripcion;
    }

    public String getGst_Fecha() {
        return Gst_Fecha;
    }

    public void setGst_Fecha(String Gst_Fecha) {
        this.Gst_Fecha = Gst_Fecha;
    }

    public Double getGst_Total() {
        return Gst_Total;
    }

    public void setGst_Total(Double Gst_Total) {
        this.Gst_Total = Gst_Total;
    }

    @Override
    protected void insert() {
        query = "INSERT INTO Gastos(Descripcion, Fecha, Total) VALUES(?,?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Gst_Descripcion);
            stm.setString(2, Gst_Fecha);
            stm.setDouble(3, Gst_Total);

            stm.executeUpdate();
            System.out.print("Se agrego el gasto correctamente correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }

    public static ArrayList<Integer> getIdGastos() {

        ArrayList<Integer> Gastos_IDs = new ArrayList<>();
        query = "SELECT GastoID FROM Gastos";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Gastos_IDs.add(resultSet.getInt("GastoID"));
            }
            return Gastos_IDs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Gastos_IDs;
    }

    private void asignarId() {
        query = "select GastoID from Gastos WHERE Numero = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, Gst_ID);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.Gst_ID = resultSet.getInt("GastoID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Se agrego id correctamente el id es: " + this.Gst_ID);
        }
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * from Gastos";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[4];
                filas[0] = resultSet.getString("GastoID");
                filas[1] = resultSet.getString("Descripcion");
                filas[2] = resultSet.getString("Fecha");
                filas[3] = resultSet.getString("Total");
                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static void Delete(int id) {
        query = "DELETE FROM Gastos WHERE GastoID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Gasto eliminado correctamente");

        }
    }

    public static String[] getGastoPorFiltro(int id, int index) {
        String[] fila = new String[4];
        query = "Select * from Gastos where GastoID = ?";

        if (index == 0) {
            query = "Select * from Gastos where GastoID = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("GastoID");
                fila[1] = resultSet.getString("Descripcion");
                fila[2] = resultSet.getString("Fecha");
                fila[3] = resultSet.getString("Total");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static void update(int id, String Descripcion, String Fecha, Double Total) {
        query = "UPDATE Gastos SET Descripcion = ?, Fecha = ?, Total = ? WHERE GastoID = ?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Descripcion);
            stm.setString(2, Fecha);
            stm.setDouble(3, Total);
            stm.setInt(4, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Se actualizo el gasto correctamente.");
        }
    }
}
