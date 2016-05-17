/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;
import static spark.Spark.*;

/**
 *
 * @author Owner
 */
public class Claseprueba {
    
    public static void main(String [] args){
    
    get("/prueba" ,(request, response) ->{
        
        request.session().attribute("prueba", "hola");
        
        System.out.println(request.session().attribute("prueba").toString());
        
        return "";
    });
    
}

}