package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends ConexionBD {

    String INSERTAR_USUARIO = "INSERT INTO usuarios (usuario, contrasena, rol) VALUES (?, ?, ?)";
    String BUSCAR_USUARIO = "SELECT id, usuario, contrasena, rol FROM usuarios WHERE usuario = ?";

    public boolean insertarUsuario(Usuarios usuario) {

        PreparedStatement ps = null;
        Connection con = getConexion();

        try {

            ps = con.prepareStatement(INSERTAR_USUARIO);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            ps.setString(3, usuario.getRol());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean IniciarSesion(Usuarios usuario) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        try {
            ps = con.prepareStatement(BUSCAR_USUARIO);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {

                if (usuario.getContrasena().equals(rs.getString(3))) {

                    usuario.setId(rs.getInt(1));
                    usuario.setUsuario(rs.getString(2));
                    usuario.setContrasena(rs.getString(3));
                    usuario.setRol(rs.getString(4));
                    return true;
                    
                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
