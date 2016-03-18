/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadioFM;


import java.util.Scanner;



/**
 *
 * @author Owner
 */
public class Radio {
    
    
    public static void main (String [] args){
        
        int opcion=0;
        
        ControlRadio radio1= new ControlRadio();
        Scanner sc = new Scanner(System.in);
        
        while(opcion!=3){
            System.out.println();
            System.out.println("Frecuencia actual: "+radio1.frecuencia);
            System.out.println("Presione:");
            System.out.println("1- Para aumentar frecuencia");
            System.out.println("2- Para bajar frecuencia");
            System.out.println("3- Para salir");
            opcion = sc.nextInt();
            if (opcion==1){
                
                radio1.up();
            }
            else{
            radio1.down();
            }
            
            
        }
        
        
        
         
   
     
    }
    
   
}
