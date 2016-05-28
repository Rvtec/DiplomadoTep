/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pucmm.holamundows.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tepcurso03
 */
@WebService(serviceName = "HolaMundoWS")
public class HolaMundoWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "holamundo")
    public String hello(@WebParam(name = "name") String txt) {
        System.out.println("Ejecutando Hola Mundo");
        return "Hello " + txt + ", desde el WS";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "suma")
    public Integer suma(@WebParam(name = "a") Integer a, @WebParam(name = "b") Integer b) {
        //TODO write your implementation code here:
        System.out.println("Sumando Valores");
        return a+b;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFechaServidor")
    public String getFechaServidor() {
        //TODO write your implementation code here:
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Ejecutando la hora del servidor");
        return df.format(new Date());
    }
}
