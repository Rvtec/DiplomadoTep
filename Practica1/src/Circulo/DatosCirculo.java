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
public class DatosCirculo {
    double radio;
    double area;
    double perimetro;
    
    public DatosCirculo(double radio){
        this.radio=radio;
    }
    
    public void calcArea(){
        area= 3.14 * radio * radio;
    
    }
    
    public void calcPerimetro(){
        perimetro=2*3.14*radio;
        
    }
    
    
}
