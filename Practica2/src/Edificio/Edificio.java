/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Edificio;

/**
 *
 * @author Owner
 */
public class Edificio {
 int numPisos;
 String nombre;
 int numPuerta;
         
    public Edificio(int numPisos, String nombre, int numPuerta){
           this.numPisos=numPisos;
           this.nombre=nombre;
           this.numPuerta=numPuerta;
}
    public void SetEdificio(int numPisos, String nombre, int numPuerta){
           this.numPisos=numPisos;
           this.nombre=nombre;
           this.numPuerta=numPuerta;
    }
}
