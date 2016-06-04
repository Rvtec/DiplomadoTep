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
@Table(name = "ETIQUETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etiqueta.findAll", query = "SELECT e FROM Etiqueta e"),
    @NamedQuery(name = "Etiqueta.findByIdetiqueta", query = "SELECT e FROM Etiqueta e WHERE e.idetiqueta = :idetiqueta"),
    @NamedQuery(name = "Etiqueta.findByEtiqueta", query = "SELECT e FROM Etiqueta e WHERE e.etiqueta = :etiqueta"),
    @NamedQuery(name = "Etiqueta.findByIdarticulo", query = "SELECT e FROM Etiqueta e WHERE e.idarticulo = :idarticulo")})
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDETIQUETA")
    private Integer idetiqueta;
    @Basic(optional = false)
    @Column(name = "ETIQUETA")
    private String etiqueta;
    @Basic(optional = false)
    @Column(name = "IDARTICULO")
    private int idarticulo;

    public Etiqueta() {
    }

    public Etiqueta(Integer idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public Etiqueta(Integer idetiqueta, String etiqueta, int idarticulo) {
        this.idetiqueta = idetiqueta;
        this.etiqueta = etiqueta;
        this.idarticulo = idarticulo;
    }

    public Integer getIdetiqueta() {
        return idetiqueta;
    }

    public void setIdetiqueta(Integer idetiqueta) {
        this.idetiqueta = idetiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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
        hash += (idetiqueta != null ? idetiqueta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etiqueta)) {
            return false;
        }
        Etiqueta other = (Etiqueta) object;
        if ((this.idetiqueta == null && other.idetiqueta != null) || (this.idetiqueta != null && !this.idetiqueta.equals(other.idetiqueta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejemplojpa.entidades.Etiqueta[ idetiqueta=" + idetiqueta + " ]";
    }
    
}
