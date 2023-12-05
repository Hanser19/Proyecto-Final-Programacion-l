/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cajor
 */
public final class Cajas extends ConexionSQL {

    private int Caja_ID;
    private String Estado;
    private int Caja_Num;
    private int Caja_EmpID;
    private static String query;

    public Cajas(int Caja_Num) {
        this.Caja_Num = Caja_Num;
        insert();
        asignarId();
    }

    public int getCaja_ID() {
        return Caja_ID;
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
    protected void insert() {
        query = "INSERT INTO Cajas(Numero) VALUES(?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setInt(1, Caja_Num);

            stm.executeUpdate();
            System.out.print("Se agrego la caja correctamente");

        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT CajaID,Numero from Cajas";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[2];
                filas[0] = resultSet.getString("CajaID");
                filas[1] = resultSet.getString("Numero");
                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static ArrayList<Integer> getNumerosCajas() {

        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT Numero FROM Cajas";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("Numero"));
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    private void asignarId() {
        query = "select CajaID from Cajas WHERE Numero = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, Caja_Num);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.Caja_ID = resultSet.getInt("CajaID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("se agrego id correctamente el id es: " + this.Caja_ID);
        }
    }

    public static void Delete(int id) {
        query = "DELETE FROM Cajas WHERE CajaID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Caja eliminada correctamente");
        }
    }

    public static String[] getCajaPorFiltro(int numero, int index) {
        String[] fila = new String[2];
        query = "Select * from Cajas where Numero = ?";

        if (index == 0) {
            query = "Select * from Cajas where CajaID = ?";
        } else {
            query = "Select * from Cajas where Numero = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, numero);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("CajaID");
                fila[1] = resultSet.getString("Numero");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static void update(int id, String numeroC) {
        query = "UPDATE Cajas SET Numero = ? WHERE CajaID = ?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, numeroC);
            stm.setInt(2, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Caja Actualizada correctamente correctamente");
        }
    }
}
