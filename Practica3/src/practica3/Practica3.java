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
      
        
        System.out.println(Procesos.obtenerNumeroParr(url));
        
        System.out.println(Procesos.obtenerEstadoConexion(url));
        System.out.println(Procesos.contadorDeLineas(url));
        System.out.println(Procesos.obtenerNumeroImg(url));
        
       
    }
    
    
    
}

/* Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        Elements newsHeadlines = doc.select("#mp-itn b a");
        
        
        System.out.println(newsHeadlines.text());*/