package Controlador;

import Modelo.UsuarioDAO;
import Modelo.Usuarios;
import javax.swing.JOptionPane;
import Vista.frmRegistroUsuario;

/**
 *
 * @author Hanser Perez
 */
public class ControladorRegistro {

    private final UsuarioDAO usuarioDAO;

    public ControladorRegistro() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(String usuario, char[] contrasena, char[] confirmarContrasena, String rolSeleccionado) {

        // Verificar si los campos no están vacíos
        if (usuario.isEmpty() || contrasena.length == 0 || confirmarContrasena.length == 0) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            return; // Salir del método si hay campos vacíos
        }

        String pass = new String(contrasena);
        String passCon = new String(confirmarContrasena);

        if (pass.equals(passCon)) {

            Usuarios mod = new Usuarios();

            mod.setUsuario(usuario);
            mod.setContrasena(pass);
            mod.setRol(rolSeleccionado);

            if (usuarioDAO.insertarUsuario(mod)) {

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");

            } else {

                JOptionPane.showMessageDialog(null, "Error al registrar el usuario");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
    }

}
