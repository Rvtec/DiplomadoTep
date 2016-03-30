/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaReproducible;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class PruebaReproducible {
    
    public static void main(String [] args){
    
        //Instanciando Objetos de las clases Audio y Video
        Audio audio1 = new Audio();
        Audio audio2 = new Audio();
        Video video1 = new Video();
        Video video2 = new Video();
        
        //Creando el ArrayList reproductor del tipo de la interfaz ReproductorMedia
        ArrayList<ReproductorMedia> reproductor= new ArrayList<>();
        //Agregando los objetos al ArrayList
        reproductor.add(audio1);
        reproductor.add(audio2);
        reproductor.add(video1);
        reproductor.add(video2);
        
        //Llamando el metodo y pasandole como parametro el ArrayList reproductor
        procesarReproductorMedia(reproductor);
        
       
}
    
//Metodo que recibe como parametro el ArrayList y crea a lista
public static void procesarReproductorMedia(List<ReproductorMedia> lista){
        for( ReproductorMedia rep : lista){
        
            
            //Llamando los metodos de la variable rep que es el tipo ReproductorMedia(Interfaz)
            rep.avanzar();
            rep.detener();
            rep.grabar();
            rep.rebobinar();
            rep.reproducir();
            
            //Imprimiendo la lista
            System.out.println("\n");
            
            
        }
    
        }
}