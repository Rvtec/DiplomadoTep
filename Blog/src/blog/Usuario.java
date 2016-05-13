/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

/**
 *
 * @author rvargas
 */
public class Usuario {
    private String usuario;
    private String nombre;
    private String contraseña;
    private boolean admin;
    private boolean autor;

    Usuario(){
    
    }
    
    Usuario(String usuario, String nombre, String contraseña, boolean admin, boolean autor){
        setUsuario(usuario);
        setNombre(nombre);
        setContraseña(contraseña);
        setAdmin(admin);
        setAutor(autor);
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the admin
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * @return the autor
     */
    public boolean isAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(boolean autor) {
        this.autor = autor;
    }
    
    
}
