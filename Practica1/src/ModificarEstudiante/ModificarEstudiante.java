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
public class ModificarEstudiante {
    
    public static void main (String [] args){
        
        Estudiante primerEstudiante= new Estudiante();
        Estudiante segundoEstudiante= new Estudiante();
        Estudiante tercerEstudiante= new Estudiante();
        Estudiante cuartoEstudiante= new Estudiante();
        Estudiante quintoEstudiante= new Estudiante();
        
        /*seteando datos del primer estudiante*/
        primerEstudiante.setNombre("Ryan");
        primerEstudiante.setApellido("Vargas");
        primerEstudiante.setEdad(23);
        primerEstudiante.obtenerMatricula(20111111);
        primerEstudiante.setSexo("Masculino");
        primerEstudiante.infoEst("primer estudiante");
        
         /*seteando datos del segundo estudiante*/
        segundoEstudiante.setNombre("Pablo");
        segundoEstudiante.setApellido("Perez");
        segundoEstudiante.setEdad(27);
        segundoEstudiante.obtenerMatricula(20102345);
        segundoEstudiante.setSexo("Masculino");
        segundoEstudiante.infoEst("segundo estudiante");
        
           /*seteando datos del tercer estudiante*/
        tercerEstudiante.setNombre("Juan");
        tercerEstudiante.setApellido("Polanco");
        tercerEstudiante.setEdad(25);
        tercerEstudiante.obtenerMatricula(20095345);
        tercerEstudiante.setSexo("Masculino");
        tercerEstudiante.infoEst("tercer estudiante");
        
           /*seteando datos del cuarto estudiante*/
        cuartoEstudiante.setNombre("Maria");
        cuartoEstudiante.setApellido("Gutierrez");
        cuartoEstudiante.setEdad(30);
        cuartoEstudiante.obtenerMatricula(2014456);
        cuartoEstudiante.setSexo("Femenino");
        cuartoEstudiante.infoEst("cuarto estudiante");
           
        /*seteando datos del quinto estudiante*/
        quintoEstudiante.setNombre("Manny");
        quintoEstudiante.setApellido("Maldonado");
        quintoEstudiante.setEdad(43);
        quintoEstudiante.obtenerMatricula(20051113);
        quintoEstudiante.setSexo("Masculino");
        quintoEstudiante.infoEst("quinto estudiante");
    }
}
