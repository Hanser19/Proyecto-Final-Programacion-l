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
public class Categorias extends ConexionSQL {

    public int Catg_ID;
    public String Catg_Nombre;
    public String Catg_Descripcion;
    private static String query;

    public Categorias(String Catg_Nombre, String Catg_Descripcion) {
        this.Catg_Nombre = Catg_Nombre;
        this.Catg_Descripcion = Catg_Descripcion;
        insert();
        asignarID();
    }

    public int getCatg_ID() {
        return Catg_ID;
    }

    public void setCatg_ID(int Catg_ID) {
        this.Catg_ID = Catg_ID;
    }

    public String getCatg_Nombre() {
        return Catg_Nombre;
    }

    public void setCatg_Nombre(String Catg_Nombre) {
        this.Catg_Nombre = Catg_Nombre;
    }

    public String getCatg_Descripcion() {
        return Catg_Descripcion;
    }

    public void setCatg_Descripcion(String Catg_Descripcion) {
        this.Catg_Descripcion = Catg_Descripcion;
    }

    @Override
    public void insert() {

        query = "INSERT INTO Categorias (Nombre, Descripcion) VALUES(?,?)";

        try {

            stm = getConection().prepareStatement(query);

            stm.setString(1, Catg_Nombre);
            stm.setString(2, Catg_Descripcion);

            stm.executeUpdate();

            System.out.print("Se agrego la categoria correctamente");

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {
            close(getConection(), stm);
        }
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * FROM Categorias";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[3];
                filas[0] = resultSet.getString("CategoriaID");
                filas[1] = resultSet.getString("Nombre");
                filas[2] = resultSet.getString("Descripcion");

                datos.add(filas);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static ArrayList<String> getNombreCategoria() {

        ArrayList<String> nombre = new ArrayList<>();
        query = "SELECT Nombre FROM Categorias";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                nombre.add(resultSet.getString("Nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return nombre;
    }

    private void asignarID() {
        query = "SELECT CategoriaID FROM Categorias WHERE Nombre = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setString(1, Catg_Nombre);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                this.Catg_ID = resultSet.getInt("CategoriaID");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
            System.out.println("Se asignó correctamente el ID de la categoría. El ID de la categoría es: " + this.Catg_ID);
        }
    }

    public static void deleteCategoria(int id) {
        // Actualiza la relación en la tabla "productos"
        query = "UPDATE Productos SET CategoriaID = NULL WHERE CategoriaID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();

            // Ahora puedes eliminar la categoría sin violar la integridad referencial
            query = "DELETE FROM Categorias WHERE CategoriaID = ?";
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();

            System.out.println("Categoría eliminada correctamente");
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
        }
    }

    public static void updateCategoria(int categoriaID, String nombre, String descripcion) {
        query = "UPDATE Categorias SET Nombre=?, Descripcion=? WHERE CategoriaID=?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, nombre);
            stm.setString(2, descripcion);
            stm.setInt(3, categoriaID);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
            System.out.println("Categoría Actualizada Correctamente");
        }
    }

    public static ArrayList<Integer> getIDCategorias() {
        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT CategoriaID FROM Categorias";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("CategoriaID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    public static String[] getCategoriaPorFiltro(int numero, int index) {

        String[] fila = new String[3];

        if (index == 0) {
            query = "SELECT * FROM Categorias WHERE CategoriaID = ?";
        } else {
            query = "SELECT * FROM Categorias WHERE CategoriaID = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, numero);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("CategoriaID");
                fila[1] = resultSet.getString("Nombre");
                fila[2] = resultSet.getString("Descripcion");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, e.g., log or throw
        } finally {
            close(getConection(), stm);
        }

        return fila;
    }

}
