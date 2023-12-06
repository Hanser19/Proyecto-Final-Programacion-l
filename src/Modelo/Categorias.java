package Modelo;

import Controlador.ConexionSQL;
import static Controlador.ConexionSQL.close;
import static Controlador.ConexionSQL.getConection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cajor
 */
public class Categorias extends ConexionSQL {

    private int Catg_ID;
    private String Catg_Nombre;
    private String Catg_Descripcion;
    private static String query;

    public int getCatg_ID() {
        return Catg_ID;
    }

    public void setCatg_ID(int Catg_ID) {
        this.Catg_ID = Catg_ID;
    }

    public String getCatg_Nombre() {
        return Catg_Nombre;
    }

    public void setCatg_Nombre(String Catg_Nombre) {
        this.Catg_Nombre = Catg_Nombre;
    }

    public String getCatg_Descripcion() {
        return Catg_Descripcion;
    }

    public void setCatg_Descripcion(String Catg_Descripcion) {
        this.Catg_Descripcion = Catg_Descripcion;
    }

    public static ArrayList<Integer> getIDCategorias() {
        ArrayList<Integer> numeros = new ArrayList<>();
        query = "SELECT CategoriaID FROM Categorias";

        try {
            stm = getConection().prepareStatement(query);
            resultSet = stm.executeQuery();

            while (resultSet.next()) {
                numeros.add(resultSet.getInt("CategoriaID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }

        return numeros;
    }

    @Override
    protected void insert() {
        query = "INSERT INTO Categorias (Catg_Nombre, Catg_Descripcion) VALUES (?, ?)";

        try {
            stm = getConection().prepareStatement(query);
            stm.setString(1, getCatg_Nombre());
            stm.setString(2, getCatg_Descripcion());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(getConection(), stm);
        }
    }
}
