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
            if (in != null) {
                in.close();
            }
        }

        return countador;
    }
    
    public static int obtenerEstadoConexion(String url) {
		
    Connection.Response respuesta = null;
	
    try {
	respuesta = Jsoup.connect(url).ignoreHttpErrors(true).execute();
    } catch (IOException ex) {
	System.out.println("Excepción al obtener el estado: " + ex.getMessage());
    }
    return respuesta.statusCode();
}
    
    public static int obtenerNumeroParr(String url) throws IOException{
        Document parr =  Jsoup.connect(url).get();
        try {
            Elements parrafos= parr.select("p");
        }
        catch (IOException ex){
            System.out.println("Error");
        }
        return parrafos.size();
    }
    
    public static int obtenerNumeroImg(String url) throws IOException{
        Document img =  Jsoup.connect(url).get();
        Elements imagenes= img.select("img");
        
        return imagenes.size();
    }
}
