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
public class Radio {
    
    public static void main (String [] args){
        
        ControlRadio radio1 = new ControlRadio();
        
        radio1.up();
        System.out.println(radio1.frecuencia);
    }
}
