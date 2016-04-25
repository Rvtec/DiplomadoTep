/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModificarEstudiante;

/**
 *
 * @author Owner
 */
public class Estudiante {
    
    String nombre;
    String apellido;
    int matricula;
    int edad;
    String sexo;
    
    public Estudiante(){
        
    }
    
    public void setNombre(String nombre){
        this.nombre= nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido= apellido;
    }
public void setEdad(int edad){
        this.edad= edad;
    }
public void obtenerMatricula(int matricula){
        this.matricula= matricula;
    }
public void setSexo(String sexo){
        this.sexo= sexo;
    }

public void infoEst(String est){
    System.out.println("\nDatos del "+ est +":\n"+"Nombre: "+ nombre +" Apellido: "+ apellido +" Edad: "+ edad +" Matricula: " +matricula+" Sexo: "+sexo );

}
}

