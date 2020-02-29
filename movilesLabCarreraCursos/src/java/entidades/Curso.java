/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lea
 */
@Entity
@Table(name = "curso")
@XmlRootElement
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "curso_id")
    private Integer cursoId;
    @Basic(optional = false)
    @Column(name = "curso_codigo")
    private String cursoCodigo;
    @Basic(optional = false)
    @Column(name = "curso_nombre")
    private String cursoNombre;
    @Basic(optional = false)
    @Column(name = "curso_creditos")
    private int cursoCreditos;
    @Basic(optional = false)
    @Column(name = "curso_horaSem")
    private int cursohoraSem;
    @Column(name = "curso_anno")
    private String cursoAnno;
    @Column(name = "curso_ciclo")
    private String cursoCiclo;
    @JoinColumn(name = "curso_cod_carrera", referencedColumnName = "carrera_id")
    @ManyToOne(optional = false)
    private Carrera cursoCodCarrera;

    public Curso() {
    }

    public Curso(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Curso(Integer cursoId, String cursoCodigo, String cursoNombre, int cursoCreditos, int cursohoraSem) {
        this.cursoId = cursoId;
        this.cursoCodigo = cursoCodigo;
        this.cursoNombre = cursoNombre;
        this.cursoCreditos = cursoCreditos;
        this.cursohoraSem = cursohoraSem;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoCodigo() {
        return cursoCodigo;
    }

    public void setCursoCodigo(String cursoCodigo) {
        this.cursoCodigo = cursoCodigo;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public int getCursoCreditos() {
        return cursoCreditos;
    }

    public void setCursoCreditos(int cursoCreditos) {
        this.cursoCreditos = cursoCreditos;
    }

    public int getCursohoraSem() {
        return cursohoraSem;
    }

    public void setCursohoraSem(int cursohoraSem) {
        this.cursohoraSem = cursohoraSem;
    }

    public String getCursoAnno() {
        return cursoAnno;
    }

    public void setCursoAnno(String cursoAnno) {
        this.cursoAnno = cursoAnno;
    }

    public String getCursoCiclo() {
        return cursoCiclo;
    }

    public void setCursoCiclo(String cursoCiclo) {
        this.cursoCiclo = cursoCiclo;
    }

    public Carrera getCursoCodCarrera() {
        return cursoCodCarrera;
    }

    public void setCursoCodCarrera(Carrera cursoCodCarrera) {
        this.cursoCodCarrera = cursoCodCarrera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoId != null ? cursoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoId == null && other.cursoId != null) || (this.cursoId != null && !this.cursoId.equals(other.cursoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Curso[ cursoId=" + cursoId + " ]";
    }
    
}
