/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Editorial;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class EditorialDAO extends DAO {

    public Editorial objec(Integer id) {
        super.conectar();
        //Editorial obj = EM.find(Editorial.class, id);
        Editorial editorial = null;
        try {
            editorial = (Editorial) EM.createQuery("SELECT e FROM Editorial e WHERE e.id = :id AND e.alta = 1").setParameter("id", id).getSingleResult();
            if (editorial != null) {
                return editorial;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return editorial;
    }

    public List<Editorial> findAll() {
        super.conectar();
        List<Editorial> listaEditorial = null;
        try {
            listaEditorial = EM.createQuery("SELECT e FROM Editorial e").getResultList();
            if (!listaEditorial.isEmpty()) {
                return listaEditorial;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaEditorial;
    }

    public List<Editorial> listaEditorialAlta() {
        super.conectar();
        List<Editorial> listaEditorial = null;
        try {
            listaEditorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.alta = 1").getResultList();
            if (!listaEditorial.isEmpty()) {
                return listaEditorial;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaEditorial;
    }

    public List<Editorial> listaEditorialBaja() {
        super.conectar();
        List<Editorial> listaEditorial = null;
        try {
            listaEditorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.alta = 0").getResultList();
            if (!listaEditorial.isEmpty()) {
                return listaEditorial;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaEditorial;
    }

    public List<Editorial> buscarEditorial(String nombre) {
        super.conectar();
        List<Editorial> listaEditorial = null;
        try {
            listaEditorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre AND e.alta = 1").setParameter("nombre", nombre).getResultList();
            if (!listaEditorial.isEmpty()) {
                return listaEditorial;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaEditorial;
    }

    public void persistEditorial(Editorial e) {
        super.conectar();
        super.guardar(e);
        super.desconectar();
    }

    public void updateEditorial(Editorial e) {
        super.conectar();
        super.actualizar(e);
        super.desconectar();
    }

    public void editorialAlta(Editorial l) {
        l.setAlta(true);
        super.conectar();
        updateEditorial(l);
        super.desconectar();
    }

    public void editorialBaja(Editorial l) {
        l.setAlta(false);
        super.conectar();
        updateEditorial(l);
        super.desconectar();
    }
}
