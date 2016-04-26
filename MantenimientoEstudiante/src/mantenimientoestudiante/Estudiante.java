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
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCarrera(int matricula) {
        this.matricula = matricula;
    }

    public String getTelefono() {
        return telefono;

    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

 public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
