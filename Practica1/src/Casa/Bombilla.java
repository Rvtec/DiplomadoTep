/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casa;

/**
 *
 * @author Owner
 */
public class Bombilla {
    
    private boolean encendida;
    public static boolean breaker = true;
    String estado;
    
    public Bombilla() {
    }

    public Bombilla(boolean encendida) {
        this.encendida = encendida;
    }

    public void interruptor() {
        encendida = !encendida;
    }

    public boolean isEncendida() {
 
        
        return encendida && breaker;
    }

    public void setEstado(){
        //Setiando la variable estado dependiendo el retorno de isEncendida
        if(isEncendida()==true){
            estado="Encendida";
        }
        else{
            estado="Apagada";
        }   
    }

    public static void main(String[] args) {
    
         //Instanciando clase Bombilla
        Bombilla bombillo1 = new Bombilla();
        Bombilla bombillo2 = new Bombilla();
        Bombilla bombillo3 = new Bombilla(true);
        //Actualizando Estado
        bombillo1.setEstado();
        bombillo2.setEstado();
        bombillo3.setEstado();
        
        System.out.println("La bombilla 1 esta: " + bombillo1.estado);
        System.out.println("La bombilla 2 esta: " + bombillo2.estado);
        System.out.println("La bombilla 3 esta: " + bombillo3.estado);
        //Accionando Interruptor
        bombillo1.interruptor();
        bombillo2.interruptor();
        bombillo3.interruptor();
        //Actualizando Estado
        bombillo1.setEstado();
        bombillo2.setEstado();
        bombillo3.setEstado();
        
        System.out.println("");
        System.out.println("La bombilla 1 esta: " + bombillo1.estado);
        System.out.println("La bombilla 2 esta: " + bombillo2.estado);
        System.out.println("La bombilla 3 esta: " + bombillo3.estado);
        //Accionando Interruptor
        bombillo1.interruptor();
        bombillo2.interruptor();
        bombillo3.interruptor();
        //Actualizando Estado
        bombillo1.setEstado();
        bombillo2.setEstado();
        bombillo3.setEstado();
        
        System.out.println("");
        System.out.println("La bombilla 1 esta: " + bombillo1.estado);
        System.out.println("La bombilla 2 esta: " + bombillo2.estado);
        System.out.println("La bombilla 3 esta: " + bombillo3.estado);
        //Apagando Breaker
        Bombilla.breaker = false;
        //Actualizando Estado
        bombillo1.setEstado();
        bombillo2.setEstado();
        bombillo3.setEstado();
        
        System.out.println("Breaker apagado....");
        System.out.println("La bombilla 1 esta: " + bombillo1.estado);
        System.out.println("La bombilla 2 esta: " + bombillo2.estado);
        System.out.println("La bombilla 3 esta: " + bombillo3.estado);
        
        //Encendiendo Breaker
         Bombilla.breaker = true;
         
        //Actualizando Estado 
        bombillo1.setEstado();
        bombillo2.setEstado();
        bombillo3.setEstado();
        
        System.out.println("Breaker encendido.....");
        System.out.println("La bombilla 1 esta: " + bombillo1.estado);
        System.out.println("La bombilla 2 esta: " + bombillo2.estado);
        System.out.println("La bombilla 3 esta: " + bombillo3.estado);
    }

}
