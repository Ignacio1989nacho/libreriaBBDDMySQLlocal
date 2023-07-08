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

    public Libro buscarUnLibroAlta(Integer id) {
        super.conectar();
        //Libro obj = EM.find(Libro.class, id);
        Libro libro = null;
        try {
            libro = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.id = :id AND l.alta = 1").setParameter("id", id).getSingleResult();
            if (libro != null) {
                return libro;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return libro;
    }

    public Libro buscarUnLibroBaja(Integer id) {
        super.conectar();
        //Libro obj = EM.find(Libro.class, id);
        Libro libro = null;
        try {
            libro = (Libro) EM.createQuery("SELECT l FROM Libro l WHERE l.id = :id AND l.alta = 0").setParameter("id", id).getSingleResult();
            if (libro != null) {
                return libro;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return libro;
    }

    public List<Libro> findAll() {
        super.conectar();
        List<Libro> libro = null;
        try {
            libro = EM.createQuery("SELECT l FROM Libro l").getResultList();
            if (!libro.isEmpty()) {
                return libro;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return libro;
    }

    public List<Libro> listaLibrosAlta() {
        super.conectar();
        List<Libro> listaLibros = null;
        try {
            listaLibros = EM.createQuery("SELECT l FROM Libro l WHERE l.alta = 1").getResultList();
            if (!listaLibros.isEmpty()) {
                return listaLibros;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaLibros;
    }

    public List<Libro> listaLibrosBaja() {
        super.conectar();
        List<Libro> listaLibros = null;
        try {
            listaLibros = EM.createQuery("SELECT l FROM Libro l WHERE l.alta = 0").getResultList();
            if (!listaLibros.isEmpty()) {
                return listaLibros;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaLibros;
    }

    public List<Libro> buscarLibro(String titulo) {
        super.conectar();
        List<Libro> libro = null;
        try {
            libro = EM.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getResultList();
            if (!libro.isEmpty()) {
                return libro;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        super.desconectar();
        return libro;
    }

    public void persistLibro(Libro l) {
        super.conectar();
        super.guardar(l);
        super.desconectar();
    }

    public void updateLibro(Libro l) {
        super.conectar();
        super.actualizar(l);
        super.desconectar();
    }

    public void libroAlta(Libro l) {
        l.setAlta(true);
        super.conectar();
        updateLibro(l);
        super.desconectar();
    }

    public void libroBaja(Libro l) {
        l.setAlta(false);
        super.conectar();
        updateLibro(l);
        super.desconectar();
    }

    public void eliminarFisico(Libro l) {
        super.conectar();
        super.eliminar(l);
        super.desconectar();

    }
}
