/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lea
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carrera_id")
    private Integer carreraId;
    @Basic(optional = false)
    @Column(name = "carrera_codigo")
    private String carreraCodigo;
    @Basic(optional = false)
    @Column(name = "carrera_nombre")
    private String carreraNombre;
    @Basic(optional = false)
    @Column(name = "carrera_titulo")
    private String carreraTitulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoCodCarrera")
    private Collection<Curso> cursoCollection;

    public Carrera() {
    }

    public Carrera(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public Carrera(Integer carreraId, String carreraCodigo, String carreraNombre, String carreraTitulo) {
        this.carreraId = carreraId;
        this.carreraCodigo = carreraCodigo;
        this.carreraNombre = carreraNombre;
        this.carreraTitulo = carreraTitulo;
    }

    public Integer getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(Integer carreraId) {
        this.carreraId = carreraId;
    }

    public String getCarreraCodigo() {
        return carreraCodigo;
    }

    public void setCarreraCodigo(String carreraCodigo) {
        this.carreraCodigo = carreraCodigo;
    }

    public String getCarreraNombre() {
        return carreraNombre;
    }

    public void setCarreraNombre(String carreraNombre) {
        this.carreraNombre = carreraNombre;
    }

    public String getCarreraTitulo() {
        return carreraTitulo;
    }

    public void setCarreraTitulo(String carreraTitulo) {
        this.carreraTitulo = carreraTitulo;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carreraId != null ? carreraId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.carreraId == null && other.carreraId != null) || (this.carreraId != null && !this.carreraId.equals(other.carreraId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Carrera[ carreraId=" + carreraId + " ]";
    }
    
}
