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

    public static DefaultTableModel ModeloBuscarGastos() {

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");

        for (String[] i : Gastos.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloNuevoGasto() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");
        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarGastoFiltro(int numero, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");

        modelo.addRow(Gastos.getGastoPorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarCuentas() {

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Saldo");
        modelo.addColumn("Fecha Limite");
        modelo.addColumn("Estado");
        modelo.addColumn("SuplidorId");
        modelo.addColumn("GastoId");

        for (String[] i : Cuentas_Pagar.select()) {
            modelo.addRow(i);
        }

        return modelo;
    }

    public static DefaultTableModel ModeloNuevoCuenta() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Descripcion");
        modelo.addColumn("Saldo");
        modelo.addColumn("Fecha Limite");
        modelo.addColumn("Estado");
        modelo.addColumn("SuplidorId");
        modelo.addColumn("GastoId");
        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarCuentaFiltro(int numero, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Saldo");
        modelo.addColumn("Fecha Limite");
        modelo.addColumn("Estado");
        modelo.addColumn("SuplidorId");
        modelo.addColumn("GastoId");

        modelo.addRow(Cuentas_Pagar.getCuentaPorFiltro(numero, index));

        return modelo;
    }

    public static DefaultTableModel ModeloNuevoIngreso() {

        modelo = new DefaultTableModel();

        modelo.addColumn("Descripción");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");

        // Añadir una fila vacía para permitir la edición
        modelo.addRow(new Object[]{});

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarIngresoFiltro(int id, int index) {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");

        modelo.addRow(Ingresos.getIngresoPorFiltro(id, index));

        return modelo;
    }

    public static DefaultTableModel ModeloBuscarIngresos() {
        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Fecha");
        modelo.addColumn("Total");

        for (String[] i : Ingresos.selectIngresos()) {
            modelo.addRow(i);
        }

        return modelo;
    }
}
