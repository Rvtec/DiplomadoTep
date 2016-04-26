/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientoestudiante;

import freemarker.template.Configuration;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author rvargas
 */
public class MantenimientoEstudiante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        staticFileLocation("/Recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(MantenimientoEstudiante.class, "/Recursos/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        
       get("/formulario", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("guardado","");
            return new ModelAndView(atributos, "formulario.ftl");
        }, freeMarkerEngine);
        
        post("/estudiantesProcesados", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("Matricula"));
            String nombre = request.queryParams("Nombre");
            String apellido= request.queryParams("Apellido");
            String telefono= request.queryParams("Telefono");
            
            Estudiante estudiante1 = new Estudiante(matricula, nombre, apellido, telefono);
            
            Map<String, Object> atributos = new HashMap<>();
            
            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", estudiante1);
            /*
              Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Procesando Estudiante");
            attributes.put("estudiante", estudiante);*/
            
           /* System.out.println(estudiante1.matricula);
            
            return new ModelAndView(estudiante1, "");*/
           
           return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);
        

        get("/estudiantes", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            return new ModelAndView(atributos, "estudiantes.ftl");
        }, freeMarkerEngine);

        

    }

}
