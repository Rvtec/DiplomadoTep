/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

/**
 *
 * @author Owner
 */
public class Comentario  {
    
    private int idcomentario;
    private String comentario;
    private String autor;
    private int idarticulo;

    /**
     * @return the idcomentario
     */
    public int getIdcomentario() {
        return idcomentario;
    }

    /**
     * @param idcomentario the idcomentario to set
     */
    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
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
     * @return the idarticulo
     */
    public int getIdarticulo() {
        return idarticulo;
    }

    /**
     * @param idarticulo the idarticulo to set
     */
    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }
    
}
