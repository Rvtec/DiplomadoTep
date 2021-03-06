/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.util.Date;

/**
 *
 * @author Owner
 */
public class Articulo {
    
    private int idarticulo;
    private String titulo;
    private String cuerpo;
    private String autor;
    private java.sql.Date fecha;
    private String imagen;

    
    
    Articulo(int idarticulo, String titulo,String cuerpo, String imagen){
        setId(idarticulo);
        setTitulo(titulo);
        setCuerpo(cuerpo);
        setImagen(imagen);
    }
    
    
    Articulo(){
    
    }
    
    public Articulo(int idarticulo, String titulo,String cuerpo, String autor, java.sql.Date fecha, String imagen){
        setId(idarticulo);
        setTitulo(titulo);
        setCuerpo(cuerpo);
        setAutor(autor);
        setFecha(fecha);
        setImagen(imagen);
    }
    /**
     * @return the id
     */
    public int getId() {
        return idarticulo;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idarticulo = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the fecha
     */
    public java.sql.Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(java.sql.Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
