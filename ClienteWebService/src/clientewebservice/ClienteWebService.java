/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientewebservice;

/**
 *
 * @author tepcurso03
 */
public class ClienteWebService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("La suma de 5+10 = "+suma(5,10));
    }

    private static Integer suma(java.lang.Integer a, java.lang.Integer b) {
        clientewebservice.HolaMundoWS_Service service = new clientewebservice.HolaMundoWS_Service();
        clientewebservice.HolaMundoWS port = service.getHolaMundoWSPort();
        return port.suma(a, b);
    }
    
}
