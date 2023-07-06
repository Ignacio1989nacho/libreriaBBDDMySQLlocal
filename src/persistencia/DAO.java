/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Libro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Libreria2PU");
    protected EntityManager EM = EMF.createEntityManager();

    protected void desconectar() {
        if (EM.isOpen()) {
            EM.close();
        }
    }

    protected void conectar() {
        if (!EM.isOpen()) {
            EM = EMF.createEntityManager();
        }

    }

    protected void actualizar(Object obj) {
        conectar();
        EM.getTransaction().begin();
        EM.merge(obj);
        EM.getTransaction().commit();
        desconectar();
    }

    protected void guardar(Object obj) {
        conectar();
        EM.getTransaction().begin();
        EM.persist(obj);
        EM.getTransaction().commit();
        desconectar();
    }

    protected void eliminar(Object obj) {
//        if (obj instanceof Libro) {
//            Libro libro = (Libro) obj;
//            libro.setAlta(false);
//        }
        conectar();
        EM.getTransaction().begin();
        EM.remove(obj);
        EM.getTransaction().commit();
        desconectar();
    }

}
