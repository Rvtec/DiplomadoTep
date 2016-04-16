/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundospark;

import java.util.Map;
import java.util.Set;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import static spark.Spark.*;

/**
 *
 * @author tepcurso03
 */
public class HolaMundoSpark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // get("/hello/", (req, res) -> "Hello World");
        get("/basico", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
//Conocer header del cliente.
                System.out.println("El navegador o cliente: " + request.userAgent());
                System.out.println("La IP: " + request.ip());
                System.out.println("La puerto: " + request.port());
                System.out.println("Protocolo del HTPP: " + request.protocol());
                System.out.println("Metodo del HTPP: " + request.requestMethod());
                System.out.println("Los headers: ");
                for (String header : request.headers()) {
                    System.out.println("" + header + " = " + request.headers(header));
                }
//
//response.status(201);
//
                return "Otra llamada";
            }
        });

        /**
         * Obteniendo los parametros...
         * http://localhost:4567/parametros?param1=valor1&param2=valor2&paramN=valorN
         */
        get("/parametros/", (request, response) -> {
            return procesarParametros(request, response);
        });

        post("/parametros/", (request, response) -> {
            System.out.println("Metodo " + request.requestMethod());
            return procesarParametros(request, response);
        });

        /**
         * Ejemplos de patrones de rutas http://localhost:4567/rutas/20011126
         */
        get("/rutas/:matricula", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));
            //Consulta Fake a la base de datos...
            //Estudiante estudiante = FakeServices.getInstancia().getEstudianteMatricula(matricula);
            Estudiante estudiante = new Estudiante(matricula, "Estudiante " + matricula, "ISC");

            return estudiante;
        });

        get("/rutas/:matricula/:cedula/:telefono", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));
            //Consulta Fake a la base de datos...
            //Estudiante estudiante = FakeServices.getInstancia().getEstudianteMatricula(matricula);
            Estudiante estudiante = new Estudiante(matricula, "Estudiante " + matricula, "ISC");

            String cedula = request.params("cedula");
            String telefono = request.params("telefono");

            System.out.println("Cedula: " + cedula);
            System.out.println("Telefono: " + telefono);
            return estudiante + " Con cedula: " + cedula + ", telefono: " + telefono;
        });
        /* Ejemplo de uso de comodines en la ruta.
          * http://localhost:4567/rutas/20011126/transferirMonto/100.00/a/20011287
         */
        get("/rutas/:matricula/transferirMonto/*/a/*", (request, response) -> {
            //obtiendo los parametros vía comodines:
            String[] comodines = request.splat();

            //Uso de comodines
            String montoOrigen = comodines[0];
            String matriculaDestino = comodines[1];

            //Omitiendo validaciones....
            Estudiante origen = new Estudiante(Integer.parseInt(request.params("matricula")), "Est1", "ISC");//FakeServices.getInstancia().getEstudianteMatricula(Integer.parseInt(request.params("matricula")));
            Estudiante destino = new Estudiante(Integer.parseInt(matriculaDestino), "Est1", "ISC"); //FakeServices.getInstancia().getEstudianteMatricula(Integer.parseInt(matriculaDestino));

            return String.format("Monto Transferido: $s, del Estudiante %s al %s, realizado con éxito", montoOrigen, origen.getNombre(), destino.getNombre());
        });

        //Capturando Exepcion
        exception(NumberFormatException.class, (e, request, response) -> {
            response.status(500);
            response.body("Error convertiendo un número....");
            e.printStackTrace();
        });

        /**
         * Lista todos los Cookies enviados desde el cliente.
         * http://localhost:4567/listarCookies/
         */
        get("/listarCookies/", (request, response) -> {
            Map<String, String> cookies = request.cookies();
            System.out.println("El cookie: " + request.cookie("nombreCookie"));
            String salida = "";
            System.out.println("La cantidad de elementos:" + cookies.size());
            for (String key : cookies.keySet()) {
                salida += String.format("Cookie %s = %s", key, cookies.get(key)) + "<br/>";
            }
            return salida;
        });

        /**
         * Creando un cookies en Spark.
         * http://localhost:4567/crearCookie/barcamp/2014
         */
        get("/crearCookie/:nombreCookie/:valor", (request, response) -> {
            //creando cookie en para un minuto
            response.cookie(request.params("nombreCookie"), request.params("valor"), 3600);

            return "Cookie creado con exito...";
        });

        /**
         * Registra elementos en el ambito web de sesion.
         * http://localhost:4567/contadorSesion/
         */
        get("/contadorSesion/", (request, response) -> {
            //creando cookie en para un minuto
            Session session = request.session(true);
            Integer contador = session.attribute("contador");
            if (contador == null) {
                contador = 0;
            }
            contador++;
            session.attribute("contador", contador);

            return String.format("Usted a visitado está pagina %d", contador);
        });
    }

    private static Object procesarParametros(Request request, Response response) {
        Set<String> parametros = request.queryParams();
        String salida = "";
        for (String param : parametros) {
            salida += String.format("Parametro[%s] = %s <br/>", param, request.queryParams(param));
        }
        return salida;
    }

}
