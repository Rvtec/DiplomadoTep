/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientoestudiante;

import freemarker.template.Configuration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

        List<Estudiante> coleccion = new ArrayList<>();

        staticFileLocation("/Recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(MantenimientoEstudiante.class, "/Recursos/html");
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
            String telefono = request.queryParams("Telefono");

            Estudiante estudiante1 = new Estudiante(matricula, nombre, apellido, telefono);

            Map<String, Object> atributos = new HashMap<>();

            atributos.put("titulo", "Estudiantes");

            boolean found = false;
            int pos = 0;
            
                for (int i = 0; i < coleccion.size(); i++) {

                    if (coleccion.get(i).matricula == matricula) {
                        found = true;
                        pos = i;
                    }
                
            }

            if (found == true) {
                Collections.replaceAll(coleccion, coleccion.get(pos), estudiante1);
                

            } else {
                coleccion.add(estudiante1);
                
            }

            atributos.put("estudiante", coleccion);

            return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);

        get("/borrarEstudiante", (request, response) -> {
            String nombre = request.queryParams("borrarNombre");
            String matricula = request.queryParams("borrarMatricula");
            String apellido = request.queryParams("borrarApellido");
            String telefono = request.queryParams("borrarTelefono");

            matricula = matricula.replace(",", "");

            for (int i = 0; i < coleccion.size(); i++) {

                //Recorriendo el ArrayList y eliminando cuando sea igual a los
                //parametros recibidos
                String val = coleccion.get(i).toString();
                
                if (val.equals(nombre + apellido + telefono + matricula)) {
                    coleccion.remove(i);
                }

            }

            Map<String, Object> atributos = new HashMap<>();

            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", coleccion);
            //Enviando el map a la vista
            return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);

        get("/estudiantes", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", coleccion);
            return new ModelAndView(atributos, "estudiantes.ftl");
            
        }, freeMarkerEngine);

        get("/modificarEstudiante", (request, response) -> {

            String nombre = request.queryParams("nombre");
            String matricula = request.queryParams("matricula");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");

            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            atributos.put("nombre", nombre);
            atributos.put("matricula", matricula);
            atributos.put("apellido", apellido);
            atributos.put("telefono", telefono);

            return new ModelAndView(atributos, "formularioModif.ftl");
        }, freeMarkerEngine);
    }

    public static void guardar(Estudiante estudiante) {

    }

}
