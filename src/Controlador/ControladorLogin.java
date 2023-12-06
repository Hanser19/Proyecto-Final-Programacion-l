/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioDAO;
import Modelo.Usuarios;
import javax.swing.JOptionPane;
import Vista.frmRegistroUsuario;
import Vista.frmLogin;

/**
 *
 * @author Hanser Perez
 */
public class ControladorLogin {

    private final UsuarioDAO usuarioDAO;

    public ControladorLogin() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void IniciarSesion(String usuario, char[] contrasena) {

        String pass = new String(contrasena);

        Usuarios mod = new Usuarios();
        mod.setUsuario(usuario);
        mod.setContrasena(pass);

        if (usuarioDAO.IniciarSesion(mod)) {

            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
            new PantallaCarga.frmPantallaCarga(null, true).setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Verifica tus credenciales");
        }
    }
}
