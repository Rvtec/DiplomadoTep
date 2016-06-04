/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojpa.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tepcurso03
 */
@Entity
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByIdarticulo", query = "SELECT a FROM Articulo a WHERE a.idarticulo = :idarticulo"),
    @NamedQuery(name = "Articulo.findByTitulo", query = "SELECT a FROM Articulo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Articulo.findByCuerpo", query = "SELECT a FROM Articulo a WHERE a.cuerpo = :cuerpo"),
    @NamedQuery(name = "Articulo.findByAutor", query = "SELECT a FROM Articulo a WHERE a.autor = :autor"),
    @NamedQuery(name = "Articulo.findByFecha", query = "SELECT a FROM Articulo a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Articulo.findByImagen", query = "SELECT a FROM Articulo a WHERE a.imagen = :imagen")})
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDARTICULO")
    private Integer idarticulo;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "CUERPO")
    private String cuerpo;
    @Basic(optional = false)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "IMAGEN")
    private String imagen;

    public Articulo() {
    }

    public Articulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Articulo(Integer idarticulo, String titulo, String cuerpo, String autor, Date fecha) {
        this.idarticulo = idarticulo;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public Integer getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Integer idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarticulo != null ? idarticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.idarticulo == null && other.idarticulo != null) || (this.idarticulo != null && !this.idarticulo.equals(other.idarticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejemplojpa.entidades.Articulo[ idarticulo=" + idarticulo + " ]";
    }
    
}
