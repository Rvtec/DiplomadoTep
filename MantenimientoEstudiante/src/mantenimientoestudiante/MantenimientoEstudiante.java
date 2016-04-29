/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientoestudiante;

import freemarker.template.Configuration;
import java.util.ArrayList;
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
            int matricula = Integer.parseInt(request.queryParams("Matricula"));
            String nombre = request.queryParams("Nombre");
            String apellido = request.queryParams("Apellido");
            String telefono = request.queryParams("Telefono");

            Estudiante estudiante1 = new Estudiante(matricula, nombre, apellido, telefono);

            Map<String, Object> atributos = new HashMap<>();

            atributos.put("titulo", "Estudiantes");
            coleccion.add(estudiante1);
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

                String val = coleccion.get(i).toString();
                System.out.println(val);
                if (val.equals(nombre + apellido + telefono + matricula)) {
                    coleccion.remove(i);
                }

            }

            Map<String, Object> atributos = new HashMap<>();

            atributos.put("titulo", "Estudiantes");
            atributos.put("estudiante", coleccion);

            return new ModelAndView(atributos, "estudiantesProcesados.ftl");
        }, freeMarkerEngine);

        get("/estudiantes", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            atributos.put("titulo", "Estudiantes");
            //atributos.put("estudiante", estudiante1);
            return new ModelAndView(atributos, "estudiantes.ftl");
        }, freeMarkerEngine);

    }

    public static void guardar(Estudiante estudiante) {

    }

}
