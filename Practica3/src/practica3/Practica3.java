/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Owner
 */
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       
        String url;
        
        
        Procesos pagina1= new Procesos();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite una URL: ");
        url= in.nextLine();
      
        
        
        if(Procesos.obtenerEstadoConexion(url) == 200){
        
        System.out.println("El numero de <p> en la URL digitada es: "+Procesos.obtenerNumeroParr(url));
        System.out.println("El numero de lineas en la URL digitada es: "+Procesos.contadorDeLineas(url));
        System.out.println("El numero de imagenes en la URL digitada es: "+Procesos.obtenerNumeroImg(url));
        System.out.println("El numero de formularios en la URL digitada es: "+Procesos.obtenerNumeroForm(url));
        
        }
        else if(Procesos.obtenerEstadoConexion(url) != 0){
            System.out.println("El estado de la URL digitada no es OK");
        }
        else{
            System.out.println("La URL digitada no es valida");
        }
       
    }
    
    
    
}

/* Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");
        
        
        System.out.println(newsHeadlines.text());*/