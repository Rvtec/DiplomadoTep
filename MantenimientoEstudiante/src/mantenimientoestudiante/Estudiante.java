/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mantenimientoestudiante;

/**
 *
 * @author rvargas
 */
public class Estudiante {
    
    int matricula;
    String nombre;
    String apellido;
    String telefono;
    
    Estudiante(int matricula,String nombre, String apellido,String telefono){
        this.apellido =apellido;
        this.matricula = matricula;
        this.nombre= nombre;
        this.telefono= telefono;
    }
    
}
