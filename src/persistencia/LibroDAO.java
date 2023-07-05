/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidad.Libro;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LibroDAO extends DAO {

    public Libro buscarUnLibro(Integer id) {
        Libro obj = EM.find(Libro.class, id);
        Libro libro = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.id = :id AND l.alta = 1").setParameter("id", id).getSingleResult();
        return libro;
    }

    public List<Libro> listaLibros() {
        List<Libro> listaLibros = EM.createQuery("SELECT l FROM Libro l WHERE l.alta = 1").getResultList();
        return listaLibros;
    }
      public List<Libro> buscarLibro(String titulo) {
        List<Libro> libro = EM.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo AND l.alta = 0").setParameter("titulo", titulo).getResultList();
        return libro;
    }
    
       public void updateLibro(Libro l){
        super.actualizar(l);
    }  
    

}
