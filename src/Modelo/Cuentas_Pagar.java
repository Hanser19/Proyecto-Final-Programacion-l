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
public class Cuentas_Pagar extends ConexionSQL {

    public int CP_ID;
    public String CP_Descripcion;
    public Double CP_Saldo;
    public String CP_FechaLimit;
    public String CP_Estado;
    public int Sup_ID;
    public int Gst_ID;
    private static String query;

    public Cuentas_Pagar(String CP_Descripcion, Double CP_saldo, String CP_FechaLimit, String Estado, int Sup_ID, int Gst_ID) {
        this.CP_Descripcion = CP_Descripcion;
        this.CP_Saldo = CP_saldo;
        this.CP_FechaLimit = CP_FechaLimit;
        this.CP_Estado = Estado;
        this.Sup_ID = Sup_ID;
        this.Gst_ID = Gst_ID;
        insert();
        asignarId();
    }

    public int getCP_ID() {
        return CP_ID;
    }

    public void setCP_ID(int CP_ID) {
        this.CP_ID = CP_ID;
    }

    public String getCP_Descripcion() {
        return CP_Descripcion;
    }

    public void setCP_Descripcion(String CP_Descripcion) {
        this.CP_Descripcion = CP_Descripcion;
    }

    public Double getCP_Saldo() {
        return CP_Saldo;
    }

    public void setCP_Saldo(Double CP_Saldo) {
        this.CP_Saldo = CP_Saldo;
    }

    public String getCP_FechaLimit() {
        return CP_FechaLimit;
    }

    public void setCP_FechaLimit(String CP_FechaLimit) {
        this.CP_FechaLimit = CP_FechaLimit;
    }

    public String getCP_Estado() {
        return CP_Estado;
    }

    public void setCP_Estado(String CP_Estado) {
        this.CP_Estado = CP_Estado;
    }

    public int getSup_ID() {
        return Sup_ID;
    }

    public void setSup_ID(int Sup_ID) {
        this.Sup_ID = Sup_ID;
    }

    public int getGst_ID() {
        return Gst_ID;
    }

    public void setGst_ID(int Gst_ID) {
        this.Gst_ID = Gst_ID;
    }

    @Override
    protected void insert() {
        query = "INSERT INTO CuentasPorPagar(Descripcion, Saldo, FechaLimite, Estado , SuplidorID, GastoID) VALUES(?,?,?,?,?,?)";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, CP_Descripcion);
            stm.setDouble(2, CP_Saldo);
            stm.setString(3, CP_FechaLimit);
            stm.setString(4, CP_Estado);
            stm.setInt(5, Sup_ID);
            stm.setInt(6, Gst_ID);

            stm.executeUpdate();
            System.out.print("Se agrego la cuenta correctamente");

        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
    }

    public static String[] getCuentaPorFiltro(int numero, int index) {
        String[] fila = new String[7];

        if (index == 0) {
            query = "SELECT * FROM CuentasPorPagar where CuentaPorPagarID = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, numero);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {

                fila[0] = resultSet.getString("CuentaPorPagarID");
                fila[1] = resultSet.getString("Descripcion");
                fila[2] = resultSet.getString("Saldo");
                fila[3] = resultSet.getString("FechaLimite");
                fila[4] = resultSet.getString("Estado");
                fila[5] = resultSet.getString("SuplidorID");
                fila[6] = resultSet.getString("GastoID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * FROM CuentasPorPagar";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] fila = new String[7];
                fila[0] = resultSet.getString("CuentaPorPagarID");
                fila[1] = resultSet.getString("Descripcion");
                fila[2] = resultSet.getString("Saldo");
                fila[3] = resultSet.getString("FechaLimite");
                fila[4] = resultSet.getString("Estado");
                fila[5] = resultSet.getString("SuplidorID");
                fila[6] = resultSet.getString("GastoID");
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
        query = "DELETE FROM CuentasPorPagar WHERE CuentaPorPagarID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Cuenta eliminado correctamente");
        }
    }

    public static void update(int id, String descripcion, double saldo, String fechaLimt, String estado, int suplidor, int gasto) {
        query = "UPDATE CuentasPorPagar "
                + "SET Descripcion = ?, Saldo = ?, FechaLimite = ?, Estado = ?, SuplidorID = ?, GastoID = ? "
                + "WHERE CuentaPorPagarID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setString(1, descripcion);
            stm.setDouble(2, saldo);
            stm.setString(3, fechaLimt);
            stm.setString(4, estado);
            stm.setInt(5, suplidor);
            stm.setInt(6, gasto);
            stm.setInt(7, id);

            stm.executeUpdate();

        } catch (SQLException e) {
            // Manejar la excepción apropiadamente (puedes imprimir el mensaje o lanzar una excepción)
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }
    
    private void asignarId() {
        query = "select CuentaPorPagarID from CuentasPorPagar WHERE CuentaPorPagarID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, this.CP_ID);
            resultSet = stm.executeQuery();
            while (resultSet.next()) {
                this.CP_ID = resultSet.getInt("CuentaPorPagarID");
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("se agrego id correctamente el id es: " + this.CP_ID);
        }
    }

    public static ArrayList<Integer> getIDCuenta() {

        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT CuentaPorPagarID FROM CuentasPorPagar";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("CuentaPorPagarID"));
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }
}
