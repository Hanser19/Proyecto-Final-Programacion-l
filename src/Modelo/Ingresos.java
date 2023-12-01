/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author cajor
 */
public class Ingresos {
    public int Ing_ID;
    public String Ing_Descripcion;
    public String Ing_Fecha;
    public int Ing_Total;

    public int getIng_ID() {
        return Ing_ID;
    }

    public void setIng_ID(int Ing_ID) {
        this.Ing_ID = Ing_ID;
    }

    public String getIng_Descripcion() {
        return Ing_Descripcion;
    }

    public void setIng_Descripcion(String Ing_Descripcion) {
        this.Ing_Descripcion = Ing_Descripcion;
    }

    public String getIng_Fecha() {
        return Ing_Fecha;
    }

    public void setIng_Fecha(String Ing_Fecha) {
        this.Ing_Fecha = Ing_Fecha;
    }

    public int getTotal() {
        return Ing_Total;
    }

    public void setTotal(int Total) {
        this.Ing_Total = Total;
    }
}
