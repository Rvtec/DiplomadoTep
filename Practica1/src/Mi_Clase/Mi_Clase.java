/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mi_Clase;

/**
 *
 * @author rvargas
 */
public class Mi_Clase {
    
    static int valor_clase=0;
    int valor_instancia;
    
    public Mi_Clase(){
        aumentarValorMi_Clase();
    }
    
    public void aumentarValorMi_Clase(){
        valor_clase=valor_clase+1;
    }
    
    public void imprimirValor_Clase(){
        System.out.println(valor_clase);
    }
    
   
    
  
}
