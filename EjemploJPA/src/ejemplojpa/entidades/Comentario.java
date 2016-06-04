/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojpa.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tepcurso03
 */
@Entity
@Table(name = "COMENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdcomentario", query = "SELECT c FROM Comentario c WHERE c.idcomentario = :idcomentario"),
    @NamedQuery(name = "Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "Comentario.findByAutor", query = "SELECT c FROM Comentario c WHERE c.autor = :autor"),
    @NamedQuery(name = "Comentario.findByIdarticulo", query = "SELECT c FROM Comentario c WHERE c.idarticulo = :idarticulo")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCOMENTARIO")
    private Integer idcomentario;
    @Basic(optional = false)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @Column(name = "IDARTICULO")
    private int idarticulo;

    public Comentario() {
    }

    public Comentario(Integer idcomentario) {
        this.idcomentario = idcomentario;
    }

    public Comentario(Integer idcomentario, String comentario, String autor, int idarticulo) {
        this.idcomentario = idcomentario;
        this.comentario = comentario;
        this.autor = autor;
        this.idarticulo = idarticulo;
    }

    public Integer getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(Integer idcomentario) {
        this.idcomentario = idcomentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomentario != null ? idcomentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.idcomentario == null && other.idcomentario != null) || (this.idcomentario != null && !this.idcomentario.equals(other.idcomentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejemplojpa.entidades.Comentario[ idcomentario=" + idcomentario + " ]";
    }
    
}
