/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaReproducible;

/**
 *
 * @author Owner
 */
public class Video implements ReproductorMedia   {

    @Override
    public void reproducir() {
        System.out.println("Reproducir Video");
    }

    @Override
    public void detener() {
       System.out.println("Detener Video");
    }

    @Override
    public void rebobinar() {
        System.out.println("Rebobinar Video");
    }

    @Override
    public void avanzar() {
        System.out.println("Avanzar Video");
    }

    @Override
    public void grabar() {
     System.out.println("Grabar Video");
    }
    
}
