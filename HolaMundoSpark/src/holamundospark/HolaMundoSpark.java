/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundospark;

import freemarker.template.Configuration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Session;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author tepcurso03
 */
public class HolaMundoSpark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //indicando los recursos publicos.
        staticFileLocation("/publico");

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
        /**
         * Debes estar autenticado. http://localhost:4567/zonaadmin/
         */
        get("/zonaadmin/", (request, response) -> "Zona Admin Barcamp 2014");
        /**
         * Se ejecuta antes de un request. Podemos modificar las llamada.
         */
        before((request, response) -> {
            System.out.println("Filtro Before -> Realizando llamada a la ruta: " + request.pathInfo());
        });

        /**
         * Luego de la ejecución permute interceptar el response...
         */
        after((request, response) -> {
            System.out.println("Filtro After -> Incluyendo Header...");
            response.header("barcamp", "2016");
            response.header("otroHeader", "Cualquier Cosa");
        });

        /**
         * Se ejecuta antes de un request. Podemos modificar las llamada.
         */
        before("/zonaadmin/*", (request, response) -> {
            Usuario usuario = request.session(true).attribute("usuario");
            if (usuario == null) {
                //parada del request, enviando un codigo.
                halt(401, "No puede acceder a esta ruta sin autenticacion");
            }
        });

        /**
         * Registra elementos en el ambito web de sesion.
         * http://localhost:4567/autenticar/barcamp/2014
         */
        get("/autenticar/:usuario/:contrasena", (request, response) -> {
            //
            Session session = request.session(true);

            //
            Usuario usuario = null;//FakeServices.getInstancia().autenticarUsuario(request.params("usuario"), request.params("contrasena"));
            if (request.params("usuario").equalsIgnoreCase("barcamp") && request.params("contrasena").equalsIgnoreCase("2014")) {
                usuario = new Usuario("Barcamp", "2014");
            }

            if (usuario == null) {
                halt(401, "Credenciales no validas...");
            }

            session.attribute("usuario", usuario);
            response.redirect("/zonaadmin/");

            return "";
        });

//*********************ENLAZANDO FREEMAKER************************
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(HolaMundoSpark.class, "/Recursos/");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/entrada", (req, res) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Titulo de la pagina " + new Date());

            return new ModelAndView(attributes, "entrada.ftl");
        }, freeMarkerEngine);

//***************UTILIZANDO FORMULARIO PARA OBTENER DATOS***********************
        /**
         * http://localhost:4567/formulario
         */
        get("/formulario/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario en FreeMarker");
            return new ModelAndView(attributes, "formulario.ftl");
        }, freeMarkerEngine);

        post("/procesarFormulario/", (request, response) -> {
            //obteniendo la matricula.

            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String carrera = request.queryParams("carrera");

            Estudiante estudiante = new Estudiante(matricula, nombre, carrera);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Procesando Estudiante");
            attributes.put("estudiante", estudiante);

            //enviando los parametros a la vista.
            return new ModelAndView(attributes, "formularioProcesado.ftl");
        }, freeMarkerEngine); //

        //*************************UTILIZANDO CSS**************************** 
        /**
         * http://localhost:4567/datosEstudiante
         */
        get("/datosEstudiante/:matricula", (request, response) -> {
            //obteniendo la matricula.
            Estudiante estudiante = new Estudiante(Integer.parseInt(request.params("matricula")), "Estudiante", "Carrera");//FakeServices.getInstancia().getEstudianteMatricula(Integer.parseInt(request.params("matricula")));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            //enviando los parametros a la vista.
            return new ModelAndView(attributes, "datosEstudiante.ftl");
        }, freeMarkerEngine); //

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
