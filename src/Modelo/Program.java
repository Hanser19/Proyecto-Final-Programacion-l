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
    private static ArrayList<Suplidores> proveedores = new ArrayList<>();
    private static ArrayList<Categorias> categorias = new ArrayList<>();
    private static final ArrayList<Productos> productos = new ArrayList<>();
    private static ArrayList<Clientes> clientes = new ArrayList<>();
    private static ArrayList<Gastos> gastos = new ArrayList<>();
    private static ArrayList<Cuentas_Pagar> cuentas = new ArrayList<>();
    private static ArrayList<DetalleVenta> detallesVentas = new ArrayList<>();
    private static ArrayList<Ventas> ventas = new ArrayList<>();
    private static ArrayList<DetallesCompra> detallesCompra = new ArrayList<>();
    private static ArrayList<Compras> compras = new ArrayList<>();

    public static void setCajas(int num) {
        cajas.add(new Cajas(num));
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

    public static void setProductos(int codigo, String nombre, double precioVenta, double precioCompra, int categoria, int suplidor) {
        productos.add(new Productos(codigo, nombre, precioVenta, precioCompra, categoria, suplidor));
    }

    public static boolean VerificarCodigoCuenta(int num) {
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

    public static void setProvedor(String Nombre, String Direccion, String Ciudad, String Pais, String Telefono, int RNC) {
        proveedores.add(new Suplidores(Nombre, Direccion, Ciudad, Pais, Telefono, RNC));
    }

    public static void deleteProveedor(String[] fila) {

        int id = Integer.parseInt(fila[0]);
        Suplidores.Delete(id);
    }

    public static void updateProveedor(String[] fila) {

        int id = Integer.parseInt(fila[0]);
        String nombre = fila[1];
        String direccion = fila[2];
        String ciudad = fila[3];
        String pais = fila[4];
        String telefono = fila[5];
        int rnc = Integer.parseInt(fila[6]);

        Suplidores.update(id, nombre, direccion, ciudad, pais, telefono, rnc);
    }

    public static boolean VerificarRNC(int rncToVerify) {
        ArrayList<Integer> rncList = Suplidores.getRNCsuplidor();

        for (int testing : rncList) {

            if (testing == rncToVerify) {
                return false;
            }
        }

        return true;
    }

    public static void setCategorias(String Nombre, String Descripcion) {
        categorias.add(new Categorias(Nombre, Descripcion));
    }

    public static void deleteCategoria(String[] fila) {

        int id = Integer.parseInt(fila[0]);
        Categorias.deleteCategoria(id);
    }

    public static void updateCategoria(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String nombre = fila[1];
        String descripcion = fila[2];

        Categorias.updateCategoria(id, nombre, descripcion);
    }

    public static boolean VerificarCategoria(String Nombre) {
        ArrayList<String> nombre = Categorias.getNombreCategoria();

        for (String testing : nombre) {

            if (testing.equals(Nombre)) {
                return false;
            }
        }

        return true;
    }

    public static void setClientes(String Clt_Nombre, String Clt_Apellidos, String Clt_Genero, String Clt_Direccion, int Clt_Telefono) {
        clientes.add(new Clientes(Clt_Nombre, Clt_Apellidos, Clt_Genero, Clt_Direccion, Clt_Telefono));
    }

    public static boolean VerificarIdCliente(int ClienteID) {
        ArrayList<Integer> Cliente_IDs = Clientes.getIdClientes();
        for (int i : Cliente_IDs) {
            if (i == ClienteID) {
                return false;
            }
        }
        return true;
    }

    public static void deleteCliente(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Clientes.Delete(id);
    }

    public static void updateCliente(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String Nombre = fila[1];
        String Apellidos = fila[2];
        String Genero = fila[3];
        String Direccion = fila[4];
        int Telefono = Integer.parseInt(fila[5]);
        Clientes.update(id, Nombre, Apellidos, Genero, Direccion, Telefono);
    }

    public static void deleteUsuario(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Usuarios.Delete(id);
    }

    public static void updateUsuario(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String user = fila[1];
        String contra = fila[2];
        String rol = fila[3];
        Usuarios.update(id, user, contra, rol);
    }

    public static void setGastos(String descripcion, String fecha, Double total) {
        gastos.add(new Gastos(descripcion, fecha, total));
    }

    public static boolean VerificarIdGasto(int GastoID) {
        ArrayList<Integer> Gasto_IDs = Clientes.getIdClientes();
        for (int i : Gasto_IDs) {
            if (i == GastoID) {
                return false;
            }
        }
        return true;
    }

    public static void deleteGasto(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Gastos.Delete(id);
    }

    public static void updateGasto(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String Descripcion = fila[1];
        String Fecha = fila[2];
        Double Total = Double.parseDouble(fila[3]);
        Gastos.update(id, Descripcion, Fecha, Total);
    }

    public static void setCuentas(String descripcion, double saldo, String fechaLimt, String estado, int suplidor, int gasto) {
        cuentas.add(new Cuentas_Pagar(descripcion, saldo, fechaLimt, estado, suplidor, gasto));
    }

    public static boolean VerificarIdCuenta(int CuentaID) {
        ArrayList<Integer> Cuentas_IDs = Clientes.getIdClientes();
        for (int i : Cuentas_IDs) {
            if (i == CuentaID) {
                return false;
            }
        }
        return true;
    }

    public static void deleteCuenta(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        Cuentas_Pagar.Delete(id);
    }

    public static void updateCuenta(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String descripcion = fila[1];
        double saldo = Double.parseDouble(fila[2]);
        String fechaLimt = fila[3];
        String estado = fila[4];
        int suplidor = Integer.parseInt(fila[5]);
        int gasto = Integer.parseInt(fila[6]);

        Cuentas_Pagar.update(id, descripcion, saldo, fechaLimt, estado, suplidor, gasto);
    }

    private static ArrayList<Ingresos> ingresos = new ArrayList<Ingresos>();

    public static void setIngresos(String Ing_Descripcion, String Ing_Fecha, Double Ing_Total) {
        ingresos.add(new Ingresos(Ing_Descripcion, Ing_Fecha, Ing_Total));
    }

    public static boolean VerificarIdIngreso(int IngresoID) {
        ArrayList<Integer> Ingreso_IDs = Ingresos.getIDIngresos();
        for (int i : Ingreso_IDs) {
            if (i == IngresoID) {
                return false;
            }
        }
        return true;
    }

    public static void deleteIngreso(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        // Asumiendo que tienes un método deleteIngreso en la clase Ingresos
        Ingresos.deleteIngreso(id);
    }

    public static void updateIngreso(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        String Descripcion = fila[1];
        String Fecha = fila[2];
        Double Total = Double.parseDouble(fila[3]);

        Ingresos.updateIngreso(id, Descripcion, Fecha, Total);
    }

    public static void setDetallesVentas(int ClienteID, String fecha, int numeroFactura, int ProductoID, int cantidadArticulo, double precioVenta, double total, int ventaID) {
        detallesVentas.add(new DetalleVenta(ClienteID, fecha, numeroFactura, ProductoID, cantidadArticulo, precioVenta, total, ventaID));
    }

    public static void setVentas(String fecha, double total) {
        ventas.add(new Ventas(fecha, total));
    }

    public static void deleteDCompra(String[] fila) {
        int id = Integer.parseInt(fila[0]);
        DetallesCompra.Delete(id);
    }

    public static void setDetallesCompra(String suplidor, String fecha, String articulo, int cantidadArticulo, double precioVenta, int CompraID) {
        detallesCompra.add(new DetallesCompra(suplidor, fecha, articulo, cantidadArticulo, precioVenta, CompraID));
    }

    public static void setCompras(String fecha, double total) {
        compras.add(new Compras(fecha, total));
    }
}
