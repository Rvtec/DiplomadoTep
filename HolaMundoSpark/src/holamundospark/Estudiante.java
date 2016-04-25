package holamundospark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tepcurso03
 */
public class Estudiante {

    int matricula;
    String nombre;
    String carrera;

    /**
     *
     */
    public Estudiante() {

    }

    @Override
    public String toString() {
        return String.format("matricula: %d, Nombre: %s, Carrera: %s", matricula, nombre, carrera);
    }

    /**
     *
     * @param matricula
     * @param nombre
     * @param carrera
     */
    public Estudiante(int matricula, String nombre, String carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getMatricula() {
        return matricula;

    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

}
