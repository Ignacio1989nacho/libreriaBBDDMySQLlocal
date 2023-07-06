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
        Editorial editorial = (Editorial) EM.createQuery("SELECT e FROM Editorial e WHERE e.id = :id AND e.alta = 1").setParameter("id", id).getSingleResult();
        super.desconectar();
        return editorial;
    }

    public List<Editorial> findAll() {
        super.conectar();
        List<Editorial> listaLibros = EM.createQuery("SELECT e FROM Editorial e").getResultList();
        super.desconectar();
        return listaLibros;
    }
    public List<Editorial> listaEditorialAlta() {
        super.conectar();
        List<Editorial> listaLibros = EM.createQuery("SELECT e FROM Editorial e WHERE e.alta = 1").getResultList();
        super.desconectar();
        return listaLibros;
    }
    public List<Editorial> listaEditorialBaja() {
        super.conectar();
        List<Editorial> listaLibros = EM.createQuery("SELECT e FROM Editorial e WHERE e.alta = 0").getResultList();
        super.desconectar();
        return listaLibros;
    }
    public List<Editorial> buscarEditorial(String nombre) {
        super.conectar();
        List<Editorial> editorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre").setParameter("nombre", nombre).getResultList();
        super.desconectar();
        return editorial;
    }
    public void persistEditorial(Editorial e){
        super.conectar();
        super.guardar(e);
        super.desconectar();
    }
    public void updateEditorial(Editorial e){
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
