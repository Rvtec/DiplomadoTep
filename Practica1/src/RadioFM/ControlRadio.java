/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadioFM;


/**
 *
 * @author Owner
 */
public class ControlRadio {
 
    double frecuencia=80;
    
    
    public ControlRadio(){
}
    
    public void up(){
    
        if(frecuencia<108){
        frecuencia=frecuencia+0.5;    
        }
        else{
            frecuencia=80;
        }
    }

    public void down(){
    
        if(frecuencia>80){
        frecuencia=frecuencia-0.5;    
        }
        else{
            frecuencia=108;
        }
    }
    
    
}

   
