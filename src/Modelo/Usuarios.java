package Modelo;

/**
 *
 * @author Carlos
 */
public class Usuarios {
    
    private int id;
    private String usuario;
    private String contrasena;
    private String rol;

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
    
    
}
