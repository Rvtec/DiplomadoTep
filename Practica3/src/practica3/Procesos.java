/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Owner
 */
public class Procesos {
    
    public static int contadorDeLineas(String url) throws IOException {
       
        
        URL pagina = null;
        BufferedReader in = null;
        int countador = 0;

        try {
            
            pagina = new URL(url);
            in = new BufferedReader(new InputStreamReader(pagina.openStream()));

            while ((in.readLine()) != null) {
                countador++;
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            if (
                    in != null) {
                in.close();
            }
        }

        return countador;
    }
    
    public static int obtenerEstadoConexion(String url) {
		
    if (url == null || url.length() == 0){
          throw new IllegalArgumentException("Debe digitar una URL");
            
    }
    
    else if(url.startsWith("http") || url.startsWith("HTTP")){
        
        Connection.Response respuesta = null;
    
    try {
	respuesta = Jsoup.connect(url).ignoreHttpErrors(true).execute();
    } catch (IOException ex) {
	System.out.println("Excepción al obtener el estado: " + ex.getMessage());
    }
    return respuesta.statusCode();
        
    }
    else{
        
        return 0;
    }
    
}
    
    public static int obtenerNumeroParr(String url) throws IOException{
        
        Document parr =  Jsoup.connect(url).get();
        Elements parrafos= parr.select("p");
        return parrafos.size();
    }
    
    public static int obtenerNumeroImg(String url) throws IOException{
        
        Document img =  Jsoup.connect(url).get();
        Elements imagenes= img.select("img");
        
        return imagenes.size();
    }
    
    public static int obtenerNumeroForm (String url) throws IOException{
    
        Document formu =  Jsoup.connect(url).get();
        Elements form= formu.select("form");
        
        return form.size();
    }
    
}
