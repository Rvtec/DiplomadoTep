/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import freemarker.template.Configuration;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.get;
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

            return new ModelAndView(atributos, "Login.html");
        }, freeMarkerEngine);
    

    get("/Registro", (request, response)->{
      Map<String, Object> atributos = new HashMap<>();

        return new ModelAndView(atributos, "Registro.html");
    }, freeMarkerEngine );  
    
    }
}
