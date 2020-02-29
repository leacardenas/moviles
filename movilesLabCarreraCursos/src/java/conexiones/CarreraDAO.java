/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import entidades.Carrera;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author lea
 */
public class CarreraDAO extends AbstractFacade<Carrera> implements Serializable{
    private final EntityManagerFactory emf;
    
    private EntityManager em;
    
    public CarreraDAO(EntityManagerFactory emf) {
        super(Carrera.class);
        this.emf = emf;
        em = getEntityManager();
    }
    
    @Override
    protected final EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void crear(Carrera obj){
        try {
            super.persist(obj);
        } catch (Exception e) {
            System.out.print("Error al crear la carrera.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void editar(Carrera obj){
        try {
            super.merge(obj);
        } catch (Exception e) {
            System.out.print("Error al editando la carrera.\n\n Error:" + e + "\n\n");
        }
    }
    
    public void borrar(Carrera obj){
        try {
            super.remove(obj);
        } catch (Exception e) {
            System.out.print("Error al borrando la carrera.\n\n Error:" + e + "\n\n");
        }
    }
    
    public List<Carrera> buscar(Carrera obj){
        try {
            Query q = em.createQuery("Select obj from Carrera obj where obj.carreraCodigo = :codigo")
                    .setParameter("codigo", obj.getCarreraCodigo());
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al buscando las carreras.\n\n Error:" + e + "\n\n");
            return null;
        }
    }
    
    public List<Carrera> todos(){
        try {
            Query q = em.createQuery("Select obj from Carrera obj");
            return q.getResultList();
        } catch (Exception e) {
            System.out.print("Error al recuperando las carreras.\n\n Error:" + e + "\n\n");
        }
        return null;
    }
}
