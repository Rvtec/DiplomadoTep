/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import freemarker.template.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author Owner
 */
public class Blog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        staticFileLocation("/Recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Blog.class, "/Recursos/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/Login", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();

            List<Articulo> lista = new ArrayList<>();

            Connection con = null;

            try {

                String query = "select * from usuario";
                con = Services.getConexion();
                //
                PreparedStatement prepareStatement = con.prepareStatement(query);
                ResultSet rs = prepareStatement.executeQuery();
                if (!rs.next()) {
                    response.redirect("/Registro");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return new ModelAndView(atributos, "Login.html");
        }, freeMarkerEngine);

        post("/Blog", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();

            return new ModelAndView(atributos, "Login.html");
        }, freeMarkerEngine);

        get("/Registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String mensaje = "";
            atributos.put("mensaje", mensaje);
            return new ModelAndView(atributos, "Registro.html");
        }, freeMarkerEngine);

        //Tomando datos del registro
        post("/Registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String nombre = request.queryParams("Nombre");
            String username = request.queryParams("Usuario");
            String contraseña = request.queryParams("Contraseña");
            String adm = request.queryParams("Admin");
            String aut = request.queryParams("Autor");
            String mensaje = null;
            
//Llevando los checkbox a tipo boolean
            boolean admin;
            boolean autor;
            if ("TRUE".equals(adm)) {
                admin = true;
            } else {
                admin = false;
            }

            if ("TRUE".equals(aut)) {
                autor = true;
            } else {
                autor = false;
            }
            Usuario usuario = new Usuario(username, nombre, contraseña, admin, autor);
            Services servicio= new Services();
            
            if(servicio.crearUsuario(usuario)!= null){
            mensaje=servicio.crearUsuario(usuario);
            }
            else{
            mensaje= "";
            }
            
            
            atributos.put("mensaje", mensaje);
            //System.out.println(nombre + "  " + username + "  " + contraseña + "  " + admin + "  " + autor);
            return new ModelAndView(atributos, "Registro.html");
        }, freeMarkerEngine);
    }
}
