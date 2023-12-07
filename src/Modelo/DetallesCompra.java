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
public class DetallesCompra extends ConexionSQL {

    private int DC_ID;
    private String Suplidor;
    private String DC_Fecha;
    private String DC_Articulo;
    private int DC_Cantidad;
    private double DC_PrecioCompra;
    private int compraID;
    private static String query;
    private static int compraIDMomento;

    public DetallesCompra(String SuplidorID, String DC_Fecha, String DC_Articulo, int DC_Cantidad, double DC_PrecioCompra, int compraid) {
        this.Suplidor = SuplidorID;
        this.DC_Fecha = DC_Fecha;
        this.DC_Articulo = DC_Articulo;
        this.DC_Cantidad = DC_Cantidad;
        this.DC_PrecioCompra = DC_PrecioCompra;
        this.compraID = compraid;
        insert();
        System.out.print("Detalle creado correctamente");
    }

    @Override
    protected void insert() {
        query = "INSERT INTO DetallesCompra (Suplidor, Fecha, Articulo, Cantidad, PrecioCompra) VALUES (?, ?, ?, ?, ?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Suplidor);
            stm.setString(2, DC_Fecha);
            stm.setString(3, DC_Articulo);
            stm.setInt(4, DC_Cantidad);
            stm.setDouble(5, DC_PrecioCompra);

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
        query = "SELECT Suplidor, Fecha, Articulo, Cantidad, PrecioCompra FROM DetallesCompra";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] fila = new String[5];
                fila[0] = resultSet.getString("Suplidor");
                fila[1] = resultSet.getString("Fecha");
                fila[2] = resultSet.getString("Articulo");
                fila[3] = resultSet.getString("Cantidad");
                fila[4] = resultSet.getString("PrecioCompra");
                datos.add(fila);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;

    }

    public static void Delete(int id) {
        query = "DELETE FROM DetallesCompra WHERE DetallesCompraID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Registro eliminado correctamente");
        }
    }
}
