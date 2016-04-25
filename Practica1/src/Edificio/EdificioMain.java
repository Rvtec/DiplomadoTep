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
public class EdificioMain {
    
    public static void main(String [] args){
        
        Edificio edificio1 = new Edificio(4, "Torre Alta",45);
        
        System.out.println("Nombre del edificio: "+edificio1.nombre+"\nNumero de pisos del edificio: "+edificio1.numPisos+ "\nNumero de puerta: "+edificio1.numPuerta);
        
        edificio1.SetEdificio(10, "Edificio TEP", 10);
    }
}
