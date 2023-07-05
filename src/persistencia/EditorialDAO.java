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
        //Editorial obj = EM.find(Editorial.class, id);
        Editorial editorial = (Editorial) EM.createQuery("SELECT e FROM Editorial e WHERE e.id = :id AND e.alta = 1").setParameter("id", id).getSingleResult();
        return editorial;
    }

    public List<Editorial> listaEditorial() {
        List<Editorial> listaLibros = EM.createQuery("SELECT e FROM Editorial e WHERE e.alta = 0").getResultList();
        return listaLibros;
    }

    public List<Editorial> buscarEditorial(String nombre) {
        List<Editorial> editorial = EM.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre AND e.alta = 1").setParameter("nombre", nombre).getResultList();
        return editorial;
    }
    
    public void updateEditorial(Editorial e){
        super.actualizar(e);
    }
}
