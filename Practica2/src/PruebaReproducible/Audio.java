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
public class Audio implements ReproductorMedia {

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo Audio");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo Audio");
    }

    @Override
    public void rebobinar() {
        System.out.println("Rebobinando Audio");
    }

    @Override
    public void avanzar() {
        System.out.println("Avanzando Audio");
    }

    @Override
    public void grabar() {
        System.out.println("Grabando Audio");
    }
    
}
