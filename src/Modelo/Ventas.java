/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import static Controlador.ConexionSQL.close;
import static Controlador.ConexionSQL.getConection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Manuel
 */
public class Ventas extends ConexionSQL {

    String fecha;
    double total;
    static String query;

    public Ventas(String fecha, double total) {
        this.fecha = fecha;
        this.total = total;
        insert();
    }

    @Override
    protected void insert() {
        query = "INSERT INTO Ventas (Fecha, Total) VALUES(?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, fecha);
            stm.setDouble(2, total);

            stm.executeUpdate();
            System.out.print("Se agrego el producto correctamente");

        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * from Ventas";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[3];
                filas[0] = resultSet.getString("VentasID");
                filas[1] = resultSet.getString("Fecha");
                filas[2] = resultSet.getString("Total");
                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }
}
