package Modelo;

import Controlador.ConexionSQL;
import static Controlador.ConexionSQL.close;
import static Controlador.ConexionSQL.getConection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Usuarios extends ConexionSQL {

    private int id;
    private String usuario;
    private String contrasena;
    private String rol;
    private static String query;

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void insert() {
    }

    public static ArrayList<String[]> select() {
        ArrayList<String[]> datos = new ArrayList<>();
        query = "SELECT * from Usuarios";

        try {

            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                String[] filas = new String[4];
                filas[0] = resultSet.getString("UsuarioID");
                filas[1] = resultSet.getString("Usuario");
                filas[2] = resultSet.getString("Contraseña");
                filas[3] = resultSet.getString("Rol");
                datos.add(filas);
            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return datos;
    }

    public static void Delete(int id) {
        query = "DELETE FROM Usuarios WHERE UsuarioID = ?";

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
            System.out.println("Usuario eliminado correctamente");
        }
    }

    public static String[] getUsuarioPorFiltro(int id, int index) {
        String[] fila = new String[6];
        query = "Select * from Usuarios where UsuarioID = ?";

        if (index == 0) {
            query = "Select * from Usuarios where UsuarioID = ?";
        } else {
            query = "Select * from Usuarios where Usuario = ?";
        }

        try {
            stm = getConection().prepareStatement(query);
            stm.setInt(1, id);

            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                fila[0] = resultSet.getString("UsuarioID");
                fila[1] = resultSet.getString("Usuario");
                fila[2] = resultSet.getString("Contraseña");
                fila[3] = resultSet.getString("Rol");

            }
        } catch (SQLException e) {
        } finally {
            close(getConection(), stm);
        }
        return fila;
    }

    public static void update(int id, String Nombre, String contra, String rol) {
        query = "UPDATE Usuarios SET Usuario = ?, Contraseña = ?, Rol = ? WHERE UsuarioID = ?";

        try {
            stm = getConection().prepareStatement(query);

            stm.setString(1, Nombre);
            stm.setString(2, contra);
            stm.setString(3, rol);
            stm.setInt(4, id);

            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
            System.out.println("Se actualizo el usuario correctamente.");
        }
    }

}
