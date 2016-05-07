/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudbd;

import freemarker.template.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
public class CRUDBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        List<Estudiante> coleccion = new ArrayList<>();

        staticFileLocation("/Recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(CRUDBD.class, "/Recursos/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/formulario", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("guardado", "");
            return new ModelAndView(atributos, "formulario.ftl");
        }, freeMarkerEngine);

        post("/estudiantesProcesados", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("Matricula").replace(",", ""));
            String nombre = request.queryParams("Nombre");
            String apellido = request.queryParams("Apellido");
            String carrera = request.queryParams("Carrera");
            String telefono = request.queryParams("Telefono");
            Map<String, Object> atributos = new HashMap<>();
            
            
            Connection con = null;        
        try {
            
            String query = "update estudiante set nombre=?, apellido=?, carrera=?, telefono=? where matricula = ?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.            
            prepareStatement.setString(1, nombre);
            prepareStatement.setString(2, apellido);
            prepareStatement.setString(4, telefono);
            prepareStatement.setString(3, carrera);
            //Indica el where...
            prepareStatement.setInt(5, matricula);
            //
                      
            
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
             con = null;
            try {

                String query = "insert into estudiantes(matricula, nombre, apellido, telefono, carrera) values(?,?,?,?,?)";
                con = getConexion();
                //
                PreparedStatement prepareStatement = con.prepareStatement(query);
                //Antes de ejecutar seteo los parametros.
                prepareStatement.setInt(1, matricula);
                prepareStatement.setString(2, nombre);
                prepareStatement.setString(3, apellido);
                prepareStatement.setString(4, telefono);
                prepareStatement.setString(5, carrera);
                //
                

            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            atributos.put("estudiante", listaEstudiantes());
            atributos.put("titulo", "Estudiantes");
            return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);

        get("/borrarEstudiante", (request, response) -> {
            String nombre = request.queryParams("borrarNombre");
            String matricula = request.queryParams("borrarMatricula");
            String apellido = request.queryParams("borrarApellido");
            String telefono = request.queryParams("borrarTelefono");

            matricula = matricula.replace(",", "");
           

            boolean ok =false;
        
         Connection con = null;        
        try {
            
            String query = "delete from estudiantes where matricula = ?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);           
            
            //Indica el where...
            System.out.println(matricula);
            prepareStatement.setString(1, matricula);
            //
            int fila = prepareStatement.executeUpdate();
            ok = fila > 0 ;            
            
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

            Map<String, Object> atributos = new HashMap<>();

            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", listaEstudiantes());
            //Enviando el map a la vista
            return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);

        get("/estudiantes", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", listaEstudiantes());
            return new ModelAndView(atributos, "estudiantes.ftl");

        }, freeMarkerEngine);

        get("/modificarEstudiante", (request, response) -> {

            String nombre = request.queryParams("nombre");
            String matricula = request.queryParams("matricula");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            String carrera = request.queryParams("carrera");
/*
            matricula = matricula.replace(",", "");
            Connection con = null;        
        try {
            
            String query = "update estudiantes set nombre=?, apellido=?, carrera=?, telefono=? where matricula = ?";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            //Antes de ejecutar seteo los parametros.            
            prepareStatement.setString(1, nombre);
            prepareStatement.setString(2, apellido);
            prepareStatement.setString(4, telefono);
            prepareStatement.setString(3, carrera);
            //Indica el where...
            prepareStatement.setString(5, matricula);
                       
            
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
      
    
            
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("nombre", nombre);
            atributos.put("matricula", matricula);
            atributos.put("apellido", apellido);
            atributos.put("telefono", telefono);
            atributos.put("carrera", carrera);

            return new ModelAndView(atributos, "formularioModif.ftl");
        }, freeMarkerEngine);
    }

    private static Connection getConexion() {
        String url = "jdbc:h2:tcp://localhost/~/Estudiantes";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "sa", "");
        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static List<Estudiante> listaEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        Connection con = null;
        try {

            String query = "select * from estudiantes";
            con = getConexion();
            //
            PreparedStatement prepareStatement = con.prepareStatement(query);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Estudiante est = new Estudiante();
                est.setMatricula(rs.getInt("matricula"));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setCarrera(rs.getString("carrera"));
                est.setTelefono(rs.getString("telefono"));

                lista.add(est);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lista;

    }
    private void registrarDriver(){
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            freemarker.log.Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

