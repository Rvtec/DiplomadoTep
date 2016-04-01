/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiColeccion;

import Edificio.Edificio;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rvargas
 */
public class PruebaColecciones {
    
    public static void main (String [] args){
    
    MiColeccion miCol1 = new MiColeccion();
    MiColeccion miCol2 = new MiColeccion(5);
    ArrayList<String> listaArr = new ArrayList<String>();
    LinkedList linkList = new LinkedList();
   
    
    miCol2.add(new Edificio(5,"Torre",54));
    miCol2.add(new Edificio(6,"Torre",54));
    miCol2.add(new Edificio(7,"Torre",54));
    listaArr.add("Hola");
    listaArr.add("Mundo");
    listaArr.add("Java");
    linkList.add(1);
    linkList.add(2);
    linkList.add(3);
    
        //System.out.println(miCol2.size());
        
        recorrerLista(miCol2);
   
    
    }
    
    
    
    public static void recorrerLista(List<java.util.List> lista){

          for(java.util.List li : lista){
          
              System.out.println(li.getClass().getName());
          }
        
       }
}


