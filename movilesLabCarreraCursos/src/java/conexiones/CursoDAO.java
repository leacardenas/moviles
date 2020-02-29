/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import entidades.Curso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
/**
 *
 * @author leaca
 */
public class CursoDAO extends AbstractFacade<Curso> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public CursoDAO(EntityManagerFactory emf) {
        super(Curso.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void crear(Curso obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear el curso.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void editar(Curso obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando el curso.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void borrar(Curso obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando el curso.\n\n Error:" + e + "\n\n");
        }
    }
    
    public List<Curso> buscar(Curso obj){
        try {
            Query q = em.createQuery("Select obj from Curso obj where obj.cursoCodigo = :codigo")
                    .setParameter("codigo", obj.getCursoCodigo());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al buscando los cursos.\n\n Error:" + e + "\n\n");
            return null;
        }
    }
    
    public List<Curso> todos(){
        try {
            Query q = em.createQuery("Select obj from Curso obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando los cursos.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}