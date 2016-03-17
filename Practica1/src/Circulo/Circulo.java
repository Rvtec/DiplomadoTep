/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Circulo;

/**
 *
 * @author Owner
 */
public class Circulo {
    public static void main(String[] args){
        
        DatosCirculo circulo1= new DatosCirculo(5);
        
        circulo1.calcArea();
        circulo1.calcPerimetro();
        
        System.out.println("El area del circulo es: "+circulo1.area +"\nEl perimetro es igual a: "+circulo1.perimetro );
        
       
        }
    
}
