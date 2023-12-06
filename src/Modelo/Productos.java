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
 * @author cajor
 */
public class Productos extends ConexionSQL {

    public int Prod_ID;
    public int Prod_Codigo;
    public String Prod_Nombre;
    public int Prod_Unidades;
    public double Prod_PrecioUnit;
    public double Prod_PrecioCompra;
    public int Prod_CatgID;

    public Productos(int Prod_Codigo, String Prod_Nombre, double Prod_PrecioUnit, double Prod_PrecioCompra, int Prod_CatgID, int Prod_SupID) {
        this.Prod_Codigo = Prod_Codigo;
        this.Prod_Nombre = Prod_Nombre;
        this.Prod_PrecioUnit = Prod_PrecioUnit;
        this.Prod_PrecioCompra = Prod_PrecioCompra;
        this.Prod_CatgID = Prod_CatgID;
        this.Prod_SupID = Prod_SupID;
        insert();
        asignarId();
    }
    public int Prod_SupID;
    private static String query;

    public int getProd_ID() {
        return Prod_ID;
    }

    public String getProd_Nombre() {
        return Prod_Nombre;
    }

    public void setProd_Nombre(String Prod_Nombre) {
        this.Prod_Nombre = Prod_Nombre;
    }

    public void setProd_PrecioUnit(int Prod_PrecioUnit) {
        this.Prod_PrecioUnit = Prod_PrecioUnit;
    }

    public void setProd_PrecioCompra(int Prod_PrecioCompra) {
        this.Prod_PrecioCompra = Prod_PrecioCompra;
    }

    public int getProd_CatgID() {
        return Prod_CatgID;
    }

    public void setProd_CatgID(int Prod_CatgID) {
        this.Prod_CatgID = Prod_CatgID;
    }

    public int getProd_SupID() {
        return Prod_SupID;
    }

    public void setProd_SupID(int Prod_SupID) {
        this.Prod_SupID = Prod_SupID;
    }

    private void asignarId() {
        query = "select ProductoID from Productos WHERE Codigo = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, this.Prod_Codigo);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.Prod_ID = resultSet.getInt("ProductoID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("se agrego id correctamente el id es: " + this.Prod_ID);
        }
    }

    public static ArrayList<Integer> getCodigoProducto() {

        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT Codigo FROM Productos";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("Codigo"));
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    @Override
    protected void insert() {
        query = "INSERT INTO Productos(Codigo,Nombre,PrecioUnitario,PrecioCompra,CategoriaID,SuplidorID) VALUES(?,?,?,?,?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setInt(1, Prod_Codigo);
            stm.setString(2, Prod_Nombre);
            stm.setDouble(3, Prod_PrecioUnit);
            stm.setDouble(4, Prod_PrecioCompra);
            stm.setInt(5, Prod_CatgID);
            stm.setInt(6, Prod_SupID);

            stm.executeUpdate();
            System.out.print("Se agrego el producto correctamente");

        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
    }

    public static String[] getProductoPorFiltro(int numero, int index) {
        String[] fila = new String[8];

        if (index == 0) {
            query = "SELECT * FROM Productos where ProductoID = ?";
        } else {
            query = "SELECT * FROM Productos where Codigo = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, numero);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {

                fila[0] = resultSet.getString("ProductoID");
                fila[1] = resultSet.getString("Codigo");
                fila[2] = resultSet.getString("Nombre");
                fila[3] = resultSet.getString("Unidades");
                fila[4] = resultSet.getString("PrecioUnitario");
                fila[5] = resultSet.getString("PrecioCompra");
                fila[6] = resultSet.getString("CategoriaID");
                fila[7] = resultSet.getString("SuplidorID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * FROM Productos";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] fila = new String[8];
                fila[0] = resultSet.getString("ProductoID");
                fila[1] = resultSet.getString("Codigo");
                fila[2] = resultSet.getString("Nombre");
                fila[3] = resultSet.getString("Unidades");
                fila[4] = resultSet.getString("PrecioUnitario");
                fila[5] = resultSet.getString("PrecioCompra");
                fila[6] = resultSet.getString("CategoriaID");
                fila[7] = resultSet.getString("SuplidorID");
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

    public static void Delete(int id) {
        query = "DELETE FROM Productos WHERE ProductoID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Producto eliminado correctamente");
        }
    }

    public static void update(int codigo, String nombre, double precioVenta, double precioCompra, int categoriaId, int suplidorId) {
        query = "UPDATE Productos "
                + "SET Nombre = ?, PrecioUnitario = ?, PrecioCompra = ?, CategoriaID = ?, SuplidorID = ? "
                + "WHERE Codigo = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setString(1, nombre);
            stm.setDouble(2, precioVenta);
            stm.setDouble(3, precioCompra);
            stm.setInt(4, categoriaId);
            stm.setInt(5, suplidorId);
            stm.setInt(6, codigo);

            stm.executeUpdate();

        } catch (SQLException e) {
            // Manejar la excepción apropiadamente (puedes imprimir el mensaje o lanzar una excepción)
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }

}
