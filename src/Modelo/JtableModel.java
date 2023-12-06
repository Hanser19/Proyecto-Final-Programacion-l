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

    public static DefaultTableModel ModeloNuevoProveedor() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pais");
        modelo.addColumn("Telefono");
        modelo.addColumn("RNC");

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

    public static DefaultTableModel ModeloBuscarProveedores() {

        modelo = new DefaultTableModel();

        modelo.addColumn("SuplidorID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pais");
        modelo.addColumn("Telefono");
        modelo.addColumn("RNC");

        for (String[] i : Suplidores.select()) {
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

    public static DefaultTableModel ModeloBuscarProveedorFiltro(int numero, int index) {

        modelo = new DefaultTableModel();

        modelo.addColumn("SuplidorID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Pais");
        modelo.addColumn("Telefono");
        modelo.addColumn("RNC");

        modelo.addRow(Suplidores.getSuplidorPorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarCategoria() {

        modelo = new DefaultTableModel();

        modelo.addColumn("CategoriaID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");

        for (String[] categoria : Categorias.select()) {
            modelo.addRow(categoria);
        }

        return modelo;
    }

    public static DefaultTableModel modeloBuscarCategoriaFiltro(int numero, int index) {

        modelo = new DefaultTableModel();

        modelo.addColumn("CategoriaID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");

        modelo.addRow(Categorias.getCategoriaPorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel modeloNuevaCategoria() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");

        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarClientes() {

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Genero");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");

        for (String[] i : Clientes.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloNuevoCliente() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Genero");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarClienteFiltro(int numero, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Genero");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");

        modelo.addRow(Clientes.getClientePorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarUsuarios() {

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Rol");

        for (String[] i : Usuarios.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarUsuarioFiltro(int id, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Rol");

        modelo.addRow(Usuarios.getUsuarioPorFiltro(id, index));

        return modelo;
    }

}
