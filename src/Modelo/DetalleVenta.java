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
public class DetalleVenta extends ConexionSQL {

    private int clienteID;
    private String fecha;
    private int numeroFactura;
    private int ProductoID;
    private int cantidadArticulo;
    private double precioVenta;
    private double total;
    private int ventaID;
    private static String query;
    private static int ventaIDMomento;

    public DetalleVenta(int ClienteID, String fecha, int numeroFactura, int ProductoID, int cantidadArticulo, double precioVenta, double total, int ventaID) {
        this.clienteID = ClienteID;
        this.fecha = fecha;
        this.numeroFactura = numeroFactura;
        this.ProductoID = ProductoID;
        this.cantidadArticulo = cantidadArticulo;
        this.precioVenta = precioVenta;
        this.total = total;
        this.ventaID = ventaID;
        ventaIDMomento = ventaID;
        insert();
        System.out.print("Detalle creado correctamente");
    }

    @Override
    protected void insert() {
        query = "INSERT INTO DetalleVenta (clienteID, fecha, numeroFactura, ProductoID, cantidadArticulo, precioVenta, total, ventasID) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setInt(1, clienteID);
            stm.setString(2, fecha);
            stm.setInt(3, numeroFactura);
            stm.setInt(4, ProductoID);
            stm.setInt(5, cantidadArticulo);
            stm.setDouble(6, precioVenta);
            stm.setDouble(7, total);
            stm.setDouble(8, ventaID);

            stm.executeUpdate();
            System.out.print("Se agrego el producto correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }
    
     public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT clienteID, fecha, numeroFactura, ProductoID, cantidadArticulo, precioVenta, total FROM DetalleVenta where VentasID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setDouble(1, ventaIDMomento);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] fila = new String[7];
                fila[0] = resultSet.getString("clienteID");
                fila[1] = resultSet.getString("numeroFactura");
                fila[2] = resultSet.getString("fecha");
                fila[3] = resultSet.getString("ProductoID");
                fila[4] = resultSet.getString("cantidadArticulo");
                fila[5] = resultSet.getString("precioVenta");
                fila[6] = resultSet.getString("total");
                datos.add(fila);
            }
        } catch (SQLException e) {
            // Manejar la excepción apropiadamente (puedes imprimir el mensaje o lanzar una excepción)
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }
}
