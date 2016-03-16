/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdenNumerico;

/**
 *
 * @author Owner
 */
public class OrdenNumerico {
    public static int menor,medio,mayor;
    
    public static void main(String[] args){
        
        int primerNumero,segundoNumero,tercerNumero;
        
        System.out.println("Valores numericos: "+args[0]+" "+args[1]+" "+args[2]);
         
         primerNumero= Integer.parseInt(args[0]);
         segundoNumero= Integer.parseInt(args[1]);
         tercerNumero= Integer.parseInt(args[2]);
        
         compararValor(primerNumero, segundoNumero, tercerNumero);
         
         if(menor == primerNumero && medio==segundoNumero && mayor==tercerNumero){
             
             System.out.println("Las cantidades introducidas están en orden numérico");
         }
         else{
             System.out.println("Las cantidades introducidas no están en orden numérico");
             System.out.println("El orden correcto es: " +menor+" "+medio+" "+mayor);
             
         }
    }

    public static void compararValor(int n1, int n2, int n3){
        
        
        if (n1 > n2 && n1>n3){
            
            mayor=n1;
        }
        
        else if (n2>n1 && n2 > n3){
            mayor=n2;
        }
        else {
            mayor=n3;
        }
        
        if (n1 < n2 && n1<n3){
            menor= n1;
        }
        else if (n2 <n1 && n2<n3){
            menor=n2;
        }
        else {
            menor=n3;
        }
        medio= (n1+n2+n3) - (mayor+menor);
        
        
    }
}
