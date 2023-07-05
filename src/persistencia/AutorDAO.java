/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Autor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AutorDAO extends DAO {

    public Autor objec(Integer id) {
        //Autor obj = EM.find(Autor.class, id);
        Autor autor = (Autor) EM.createQuery("SELECT a FROM Autor a WHERE a.id = :id AND a.alta = 1").setParameter("id", id).getSingleResult();
        return autor;
    }

    public List<Autor> listaAutor() {
        List<Autor> listaLibros = EM.createQuery("SELECT a FROM Autor a WHERE a.alta = 0").getResultList();
        return listaLibros;
    }

    public List<Autor> buscarAutor(String nombre) {
        List<Autor> autor = EM.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.alta = 1").setParameter("nombre", nombre).getResultList();
        return autor;
    }

    public void updateAutor(Autor a) {
        super.actualizar(a);
    }
}
