/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Services {

    public Services() {
        registrarDriver();
    }

    /**
     * Metodo para el registro de driver de conexión.
     */
    private void registrarDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexion() {
        String url = "jdbc:h2:tcp://localhost/~/blog";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public Usuario getUsuario(String usuario) {
        Usuario user = null;
        Connection con = null;

        try {

            String query = "select * from usuario where lower (username) = ?";
            con = getConexion();

            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.
            prepareStatement.setString(1, usuario.toLowerCase());
            //Ejecuto...
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                user = new Usuario();
                user.setUsuario(rs.getString("username"));
                user.setNombre(rs.getString("nombre"));
                user.setContraseña(rs.getString("contraseña"));
                user.setAdmin(rs.getBoolean("administrador"));
                user.setAutor(rs.getBoolean("autor"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return user;

    }

    public String crearUsuario(Usuario usuario) {

        String estado = null;
        if (getUsuario(usuario.getUsuario()) == null) {

            Connection con = null;
            try {

                String query = "insert into usuario(username, nombre, contraseña, administrador, autor) values(?,?,?,?,?)";
                con = getConexion();
                //
                PreparedStatement prepareStatement = con.prepareStatement(query);
                //Antes de ejecutar seteo los parametros.
                prepareStatement.setString(1, usuario.getUsuario());
                prepareStatement.setString(2, usuario.getNombre());
                prepareStatement.setString(3, usuario.getContraseña());
                prepareStatement.setBoolean(4, usuario.isAdmin());
                prepareStatement.setBoolean(5, usuario.isAutor());
                //
                 prepareStatement.executeUpdate();
                //estado = fila ;

            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
            estado= "Usuario creado";
        } 
        
    else {
        estado= "El usuario digitado ya existe";
    }
        return estado;
}
    public List<Articulo> getArticulos() {
        
        List<Articulo> lista = new ArrayList<>();
        Connection con = null;
        try {

            String query = "select * from Articulo";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Articulo art = new Articulo();
                art.setAutor(rs.getString("autor"));
                art.setId(rs.getInt("idarticulo"));
                art.setTitulo(rs.getString("titulo"));
                art.setFecha(rs.getDate("fecha"));
                art.setCuerpo(rs.getString("cuerpo"));

                lista.add(art);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;

    }
    
}