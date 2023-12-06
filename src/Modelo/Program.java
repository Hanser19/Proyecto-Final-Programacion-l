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
    private static final ArrayList<Productos> productos = new ArrayList<>();

    public static void setCajas(int num) {
        cajas.add(new Cajas(num));
    }

    public static void setProductos(int codigo, String nombre, double precioVenta, double precioCompra, int categoria, int suplidor) {
        productos.add(new Productos(codigo, nombre, precioVenta, precioCompra, categoria, suplidor));
    }

    public static void deleteCaja(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Cajas.Delete(id);
    }

    public static void updateCaja(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String numeroC = fila[1];
        Cajas.update(id, numeroC);
    }

    public static boolean VerificarNumCaja(int num) {
        for (int i : Cajas.getNumerosCajas()) {
            if (i == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean VerificarCodigoProducto(int num) {
        for (int i : Productos.getCodigoProducto()) {
            if (i == num) {
                return false;
            }
        }
        return true;
    }
    
    public static void deleteProducto(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Productos.Delete(id);
    }
    
    public static void updateProducto(String[] fila) {
        int codigo = Integer.parseInt(fila[1]);
        String nombre = fila[2];
        double precioVenta = Double.parseDouble(fila[4]);
        double precioCompra = Double.parseDouble(fila[5]);
        int categoriaId = Integer.parseInt(fila[6]);
        int suplidorId = Integer.parseInt(fila[7]);
        
        Productos.update(codigo, nombre, precioVenta, precioCompra, categoriaId, suplidorId);
    }
}
