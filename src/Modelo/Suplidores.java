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
public class Suplidores extends ConexionSQL {

    public int Sup_ID;
    public String Sup_Nombre;
    public String Sup_Direccion;
    public String Sup_Ciudad;
    public String Sup_Pais;
    public int Sup_Telefono;
    public String Sup_Correo;
    public String Sup_Pag_Web;
    public int Sup_RNC;
    private static String query;

    public int getSup_ID() {
        return Sup_ID;
    }

    public void setSup_ID(int Sup_ID) {
        this.Sup_ID = Sup_ID;
    }

    public String getSup_Nombre() {
        return Sup_Nombre;
    }

    public void setSup_Nombre(String Sup_Nombre) {
        this.Sup_Nombre = Sup_Nombre;
    }

    public String getSup_Direccion() {
        return Sup_Direccion;
    }

    public void setSup_Direccion(String Sup_Direccion) {
        this.Sup_Direccion = Sup_Direccion;
    }

    public String getSup_Ciudad() {
        return Sup_Ciudad;
    }

    public void setSup_Ciudad(String Sup_Ciudad) {
        this.Sup_Ciudad = Sup_Ciudad;
    }

    public String getSup_Pais() {
        return Sup_Pais;
    }

    public void setSup_Pais(String Sup_Pais) {
        this.Sup_Pais = Sup_Pais;
    }

    public int getSup_Telefono() {
        return Sup_Telefono;
    }

    public void setSup_Telefono(int Sup_Telefono) {
        this.Sup_Telefono = Sup_Telefono;
    }

    public String getSup_Correo() {
        return Sup_Correo;
    }

    public void setSup_Correo(String Sup_Correo) {
        this.Sup_Correo = Sup_Correo;
    }

    public String getSup_Pag_Web() {
        return Sup_Pag_Web;
    }

    public void setSup_Pag_Web(String Sup_Pag_Web) {
        this.Sup_Pag_Web = Sup_Pag_Web;
    }

    public int getSup_RNC() {
        return Sup_RNC;
    }

    public void setSup_RNC(int Sup_RNC) {
        this.Sup_RNC = Sup_RNC;
    }

    @Override
    protected void insert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static ArrayList<Integer> getIDSuplidores() {
        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT SuplidorID FROM Suplidores";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("SuplidorID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }
}
