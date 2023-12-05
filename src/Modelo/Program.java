/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Juan Manuel
 */
public class Program {
    private static final ArrayList<Cajas> cajas = new ArrayList<>();
    
    public static void setCajas(int num){
        cajas.add(new Cajas(num));
    }
    
    public static void deleteCaja(String[] fila){
        int id = Integer.parseInt(fila[0]);
        Cajas.Delete(id);
    }
    
    public static void updateCaja(String[] fila){
        int id = Integer.parseInt(fila[0]);
        String numeroC = fila[1];
        Cajas.update(id,numeroC);
    }
    
    public static boolean VerificarNumCaja(int num){
        for(int i: Cajas.getNumerosCajas()){
            if(i == num){
                return false;
            }
        }
        return true;
    }
}
