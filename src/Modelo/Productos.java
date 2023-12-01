/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author cajor
 */
public class Productos {
    public int Prod_ID;
    public String Prod_Nombre;
    public String Prod_Unidades;
    public int Prod_PrecioUnit;

    public int getProd_ID() {
        return Prod_ID;
    }

    public void setProd_ID(int Prod_ID) {
        this.Prod_ID = Prod_ID;
    }

    public String getProd_Nombre() {
        return Prod_Nombre;
    }

    public void setProd_Nombre(String Prod_Nombre) {
        this.Prod_Nombre = Prod_Nombre;
    }

    public String getProd_Unidades() {
        return Prod_Unidades;
    }

    public void setProd_Unidades(String Prod_Unidades) {
        this.Prod_Unidades = Prod_Unidades;
    }

    public int getProd_PrecioUnit() {
        return Prod_PrecioUnit;
    }

    public void setProd_PrecioUnit(int Prod_PrecioUnit) {
        this.Prod_PrecioUnit = Prod_PrecioUnit;
    }

    public int getProd_PrecioCompra() {
        return Prod_PrecioCompra;
    }

    public void setProd_PrecioCompra(int Prod_PrecioCompra) {
        this.Prod_PrecioCompra = Prod_PrecioCompra;
    }

    public String getProd_FechaVencimiento() {
        return Prod_FechaVencimiento;
    }

    public void setProd_FechaVencimiento(String Prod_FechaVencimiento) {
        this.Prod_FechaVencimiento = Prod_FechaVencimiento;
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
    public int Prod_PrecioCompra;
    public String Prod_FechaVencimiento;
    public int Prod_CatgID;
    public int Prod_SupID;
}
