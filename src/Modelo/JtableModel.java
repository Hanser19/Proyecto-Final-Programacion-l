/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Manuel
 */
public class JtableModel {

    private static DefaultTableModel modelo;

    public static DefaultTableModel ModeloBuscarCajas() {

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Numero de caja");

        for (String[] i : Cajas.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloNuevaCaja() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Numero de caja");
        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarCajaFiltro(int numero, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Numero de caja");

        modelo.addRow(Cajas.getCajaPorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarProducto() {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Unidades");
        modelo.addColumn("Precio de venta");
        modelo.addColumn("Precio de compra");
        modelo.addColumn("CategoriaID");
        modelo.addColumn("SuplidorID");

        for (String[] i : Productos.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloNuevoProducto() {
        modelo = new DefaultTableModel();

        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio de venta");
        modelo.addColumn("Precio de compra");
        modelo.addColumn("CategoriaID");
        modelo.addColumn("SuplidorID");

        modelo.addRow(new Object[]{});
        
        return modelo;
    }
    
     public static DefaultTableModel ModeloBuscarProductoFiltro(int numero, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Unidades");
        modelo.addColumn("Precio de venta");
        modelo.addColumn("Precio de compra");
        modelo.addColumn("CategoriaID");
        modelo.addColumn("SuplidorID");

        modelo.addRow(Productos.getProductoPorFiltro(numero, index));

        return modelo;
    }

}
