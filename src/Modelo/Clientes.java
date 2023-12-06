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
public class Clientes extends ConexionSQL {

    public int Client_ID;
    public String Client_Nombre;
    public String Client_Apellidos;
    public String Client_Genero;
    public String Client_Direccion;
    public int Client_Telefono;
    private static String query;

    public Clientes(String Client_Nombre, String Client_Apellidos, String Client_Genero, String Client_Direccion, int Client_Telefono) {
        this.Client_Nombre = Client_Nombre;
        this.Client_Apellidos = Client_Apellidos;
        this.Client_Genero = Client_Genero;
        this.Client_Direccion = Client_Direccion;
        this.Client_Telefono = Client_Telefono;
        insert();
        asignarId();
    }

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int Client_ID) {
        this.Client_ID = Client_ID;
    }

    public String getClient_Nombre() {
        return Client_Nombre;
    }

    public void setClient_Nombre(String Client_Nombre) {
        this.Client_Nombre = Client_Nombre;
    }

    public String getClient_Apellidos() {
        return Client_Apellidos;
    }

    public void setClient_Apellidos(String Client_Apellidos) {
        this.Client_Apellidos = Client_Apellidos;
    }

    public String getClient_Genero() {
        return Client_Genero;
    }

    public void setClient_Genero(String Client_Genero) {
        this.Client_Genero = Client_Genero;
    }

    public String getClient_Direccion() {
        return Client_Direccion;
    }

    public void setClient_Direccion(String Client_Direccion) {
        this.Client_Direccion = Client_Direccion;
    }

    public int getClient_Telefono() {
        return Client_Telefono;
    }

    public void setClient_Telefono(int Client_Telefono) {
        this.Client_Telefono = Client_Telefono;
    }

    @Override
    public void insert() {
        query = "INSERT INTO Clientes(Nombre, Apellidos, Genero, Direccion, Telefono) VALUES(?,?,?,?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Client_Nombre);
            stm.setString(2, Client_Apellidos);
            stm.setString(3, Client_Genero);
            stm.setString(4, Client_Direccion);
            stm.setInt(5, Client_Telefono);

            stm.executeUpdate();
            System.out.print("Se agrego el cliente correctamente correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }

    public static ArrayList<Integer> getIdClientes() {

        ArrayList<Integer> Cliente_IDs = new ArrayList<>();
        query = "SELECT ClienteID FROM Clientes";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                Cliente_IDs.add(resultSet.getInt("ClienteID"));
            }
            return Cliente_IDs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Cliente_IDs;
    }

    private void asignarId() {
        query = "select ClienteID from Clientes WHERE Numero = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, Client_ID);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.Client_ID = resultSet.getInt("ClienteID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Se agrego id correctamente el id es: " + this.Client_ID);
        }
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * from Clientes";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[6];
                filas[0] = resultSet.getString("ClienteID");
                filas[1] = resultSet.getString("Nombre");
                filas[2] = resultSet.getString("Apellidos");
                filas[3] = resultSet.getString("Genero");
                filas[4] = resultSet.getString("Direccion");
                filas[5] = resultSet.getString("Telefono");
                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static void Delete(int id) {
        query = "DELETE FROM Clientes WHERE ClienteID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Cliente eliminado correctamente");

        }
    }

    public static String[] getClientePorFiltro(int id, int index) {
        String[] fila = new String[6];
        query = "Select * from Clientes where ClienteID = ?";

        if (index == 0) {
            query = "Select * from Clientes where ClienteID = ?";
        } else {
            query = "Select * from Clientes where Nombre = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("ClienteID");
                fila[1] = resultSet.getString("Nombre");
                fila[2] = resultSet.getString("Apellidos");
                fila[3] = resultSet.getString("Genero");
                fila[4] = resultSet.getString("Direccion");
                fila[5] = resultSet.getString("Telefono");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static void update(int id, String Nombre, String Apellidos, String Genero, String Direccion, int Telefono) {
        query = "UPDATE Clientes SET Nombre = ?, Apellidos = ?, Genero = ?, Direccion = ?, Telefono = ? WHERE ClienteID = ?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Nombre);
            stm.setString(2, Apellidos);
            stm.setString(3, Genero);
            stm.setString(4, Direccion);
            stm.setInt(5, Telefono);
            stm.setInt(6, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Se actualizo el cliente correctamente.");
        }
    }

}
