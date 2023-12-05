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
    private static ArrayList<Cajas> cajas = new ArrayList<Cajas>();
    
    public static void setCajas(int num){
        cajas.add(new Cajas(num));
    }
    
    public static boolean VerificarNumCaja(int num){
        ArrayList<Integer> numeros = Cajas.getNumerosCajas();
        for(int i: numeros){
            if(i == num){
                return false;
            }
        }
        return true;
    }
}
