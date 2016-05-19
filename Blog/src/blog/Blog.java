/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import freemarker.template.Configuration;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;
import spark.template.freemarker.FreeMarkerEngine;

/**
 *
 * @author Owner
 */
public class Blog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        staticFileLocation("/Recursos");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Blog.class, "/Recursos/html");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        //Pantalla de Login
        get("/Login", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();

            List<Articulo> lista = new ArrayList<>();

            Connection con = null;

            try {

                String query = "select * from usuario";
                con = Services.getConexion();
                //
                PreparedStatement prepareStatement = con.prepareStatement(query);
                ResultSet rs = prepareStatement.executeQuery();

                if (!rs.next()) {
                    response.redirect("/Registro");
                }

            } catch (SQLException ex) {
                Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Articulo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return new ModelAndView(atributos, "Login.html");
        }, freeMarkerEngine);

        //Get al blog 
        get("/Blog", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            Services articulo = new Services();
            Services etiquetas = new Services();
            Usuario usu = request.session().attribute("sesion");
            List<Articulo> lista = articulo.getArticulos();
            List<Articulo> listBody = new ArrayList<>();

            //Llamando metodo para listar etiquetas
            atributos.put("etiquetas", etiquetas.getEtiqueta());
            //Llamando metodo para listar los articulos
            atributos.put("articulo", articulo.getArticulos());

            if (usu != null) {

                atributos.put("usuario", usu.getUsuario());

                if (usu.isAdmin()) {
                    String roladmin = "Crear Usuario";
                    atributos.put("roladmin", roladmin);
                }

                if (usu.isAutor()) {
                    String rolautor = "Crear Articulo";
                    atributos.put("rolautor", rolautor);
                }
            } else {
                atributos.put("login", "Login");
            }
            
            //Recorriendo lista de articulos y haciendo substring al cuerpo
            //para enviarlo a la pagina principal
            for (Articulo art : articulo.getArticulos()) {
                
                Articulo artSub = new Articulo();
                artSub.setCuerpo(art.getCuerpo().substring(0, 500) + "  ........");
                artSub.setId(art.getId());
                listBody.add(artSub);
                
            }
            
            

            
            atributos.put("substring", listBody);

            return new ModelAndView(atributos, "BlogHome.html");
        }, freeMarkerEngine);

        //Post al blog, se ejecuta al hacer login
        post("/Blog", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String usuario = request.queryParams("Usuario");
            String contraseña = request.queryParams("password");
            String mensaje = "";
            List<Articulo> listBody = new ArrayList<>();
            Services user = new Services();
            Services articulo = new Services();
            Services etiquetas = new Services();
            

            //Recorriendo lista de articulos y haciendo substring al cuerpo
            //para enviarlo a la pagina principal
            for (Articulo art : articulo.getArticulos()) {
                
                Articulo artSub = new Articulo();
                artSub.setCuerpo(art.getCuerpo().substring(0, 500) + "  ........");
                artSub.setId(art.getId());
                listBody.add(artSub);
                
            }
            //Enviarndo lista de cuerpos con substring
            atributos.put("substring", listBody);

            atributos.put("mensaje", mensaje);
            atributos.put("articulo", articulo.getArticulos());
            //Llamando metodo para listar etiquetas
            atributos.put("etiquetas", etiquetas.getEtiqueta());

            //Autenticacion
            if (user.getUsuario(usuario) != null) {
                if (contraseña.equalsIgnoreCase(user.getUsuario(usuario).getContraseña())) {
                    //Creando sesion
                    request.session(true);
                    request.session().attribute("sesion", user.getUsuario(usuario));

                } else {
                    mensaje = "Contraseña incorrecta";
                    response.redirect("/Login");

                }
            } else {

                mensaje = "Usuario incorrecto";
                response.redirect("/Login");

            }

            //Verificando permisos del usuario 
            if (user.getUsuario(usuario).isAdmin()) {
                String roladmin = "Crear Usuario";
                atributos.put("roladmin", roladmin);
            }

            if (user.getUsuario(usuario).isAutor()) {
                String rolautor = "Crear Articulo";
                atributos.put("rolautor", rolautor);
            }

            //Mandando datos de la sesion
            Usuario usu = request.session().attribute("sesion");

            if (usu != null) {

                atributos.put("usuario", usu.getUsuario());

                if (usu.isAdmin()) {
                    String roladmin = "Crear Usuario";
                    atributos.put("roladmin", roladmin);
                }

                if (usu.isAutor()) {
                    String rolautor = "Crear Articulo";
                    atributos.put("rolautor", rolautor);
                }
            } else {
                atributos.put("login", "Login");
            }

            return new ModelAndView(atributos, "BlogHome.html");
        }, freeMarkerEngine);

        //Para ver articulo completo
        get("/BlogPost", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int id = Integer.parseInt(request.queryParams("id"));
            Services etiquetas = new Services();
            Services articulo = new Services();
            Services comentario = new Services();

            if (!etiquetas.getEtiqueta().isEmpty()) {

                atributos.put("etiquetas", etiquetas.getEtiqueta());
            }

            atributos.put("autor", articulo.getEntrada(id).getAutor());
            atributos.put("titulo", articulo.getEntrada(id).getTitulo());
            atributos.put("cuerpo", articulo.getEntrada(id).getCuerpo());
            atributos.put("id", articulo.getEntrada(id).getId());
            atributos.put("fecha", articulo.getEntrada(id).getFecha());
            atributos.put("imagen", articulo.getEntrada(id).getImagen());

            //Mandando datos de la sesion
            Usuario usu = request.session().attribute("sesion");

            if (usu != null) {

                atributos.put("usuario", usu.getUsuario());

                if (usu.isAdmin()) {
                    String roladmin = "Crear Usuario";
                    atributos.put("roladmin", roladmin);
                }

                if (usu.isAutor()) {
                    String rolautor = "Crear Articulo";
                    atributos.put("rolautor", rolautor);
                }
            } else {
                atributos.put("login", "Login");
            }

            //Listar comentarios
            List<Comentario> comentarios = comentario.getComentarios(id);
            atributos.put("comentarios", comentarios);
            //Enviar el siguiente id de comentario al template
            int idcomentario = comentario.maxComentario() + 1;
            atributos.put("idcomentario", idcomentario);

            return new ModelAndView(atributos, "BlogPost.html");
        }, freeMarkerEngine);

        //Para crear y acceder al articulo creado
        post("/BlogPost", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int id = Integer.parseInt(request.queryParams("id"));
            String titulo = request.queryParams("titulo");
            String cuerpo = request.queryParams("cuerpo");
            String etiquetas = request.queryParams("etiquetas").replace(" ", "");
            String imagen = request.queryParams("imagen");
            Date fecha = new java.util.Date();
            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());

            //Instancia de Services utilizada para crear articulo y etiquetas
            Services articulo = new Services();

            //Instancia de Etiqueta utilizada para crear etiquetas
            Etiqueta etiqueta = new Etiqueta();

            //Objeto tipo usuario utilizado para obtener usuario en sesion
            Usuario usu = request.session().attribute("sesion");

            //Variable creada para tomar el usuario de la sesion en string
            String autor = usu.getUsuario();

            //Instancia de Articulo utilizada para crear el articulo
            Articulo articulo1 = new Articulo(id, titulo, cuerpo, autor, fechasql, imagen);

            //Instancia de Services utilizada para buscar max etiqueta
            Services idMax = new Services();

            //Creando Articulo y Etiquetas
            if (articulo.crearArticulo(articulo1) == true) {
                //For utilizado para separar las etiquetas y mandarlas a la BD
                if (etiquetas != null) {
                    for (String tags : etiquetas.split(",")) {

                        etiqueta.setEtiqueta(tags);
                        etiqueta.setIdarticulo(id);
                        etiqueta.setIdetiqueta(idMax.maxEtiqueta() + 1);
                        articulo.crearEtiqueta(etiqueta);

                    }
                }
            }

            /*atributos.put("autor", articulo.getEntrada(id).getAutor());
            atributos.put("titulo", articulo.getEntrada(id).getTitulo());
            atributos.put("cuerpo", articulo.getEntrada(id).getCuerpo());
            atributos.put("id", articulo.getEntrada(id).getId());
            atributos.put("fecha", articulo.getEntrada(id).getFecha());
            atributos.put("imagen", articulo.getEntrada(id).getImagen());*/
            response.redirect("/BlogPost?id=" + articulo.getEntrada(id).getId());

            return new ModelAndView(atributos, "");
        }, freeMarkerEngine);

        //Pantalla para registrar usuario, se ejecuta desde el login boton registrar
        get("/Registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String mensaje = "";
            atributos.put("mensaje", mensaje);
            return new ModelAndView(atributos, "Registro.html");
        }, freeMarkerEngine);

        //Tomando datos del registro
        post("/Registro", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String nombre = request.queryParams("Nombre");
            String username = request.queryParams("Usuario");
            String contraseña = request.queryParams("Contraseña");
            String adm = request.queryParams("Admin");
            String aut = request.queryParams("Autor");
            String mensaje = null;

            //Llevando los checkbox a tipo boolean
            boolean admin;
            boolean autor;
            if ("TRUE".equals(adm)) {
                admin = true;
            } else {
                admin = false;
            }

            if ("TRUE".equals(aut)) {
                autor = true;
            } else {
                autor = false;
            }

            Usuario usuario = new Usuario(username, nombre, contraseña, admin, autor);
            Services servicio = new Services();

            if (servicio.crearUsuario(usuario) != null) {
                mensaje = servicio.crearUsuario(usuario);
            } else {
                mensaje = "";
            }

            atributos.put("mensaje", mensaje);

            return new ModelAndView(atributos, "Registro.html");
        }, freeMarkerEngine);

        get("/Entrada", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            Services id = new Services();
            int idart;
            Usuario sesion = request.session().attribute("sesion");

            if (sesion == null) {
                response.redirect("/Login");
            }

            //Llamando metodo maxArticulo para determinar el mayor articulo
            //y luego aumentar 1 para guardar nuevo articulo
            idart = id.maxArticulo() + 1;

            atributos.put("id", idart);

            return new ModelAndView(atributos, "BlogEntrada.html");
        }, freeMarkerEngine);

        get("/Logout", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();

            request.session().invalidate();
            response.redirect("/Blog");

            return new ModelAndView(atributos, "BlogHome.html");
        }, freeMarkerEngine);

        post("/Comentario", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            String comentario = request.queryParams("comentario");
            int idcomentario = Integer.parseInt(request.queryParams("idcomentario"));
            int idarticulo = Integer.parseInt(request.queryParams("idarticulo"));

            Usuario sesion = request.session().attribute("sesion");
            String autor = sesion.getUsuario();
            Services articulo = new Services();

            Comentario comentario1 = new Comentario(idcomentario, comentario, autor, idarticulo);

            //Guardando comentario
            Services savecoment = new Services();

            savecoment.crearComentario(comentario1);

            atributos.put("comentario", comentario1);
            response.redirect("/BlogPost?id=" + idarticulo);
            return new ModelAndView(atributos, "");
        }, freeMarkerEngine);

        get("/BorrarArt", (request, response) -> {
            Map<String, Object> atributos = new HashMap<>();
            int id = Integer.parseInt(request.queryParams("id"));
            Services servicio = new Services();

            servicio.borrarArticulo(id);

            response.redirect("/Blog");
            return new ModelAndView(atributos, "");
        }, freeMarkerEngine);

    }

}
