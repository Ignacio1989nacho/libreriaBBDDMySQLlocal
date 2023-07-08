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
        super.conectar();
        //Autor obj = EM.find(Autor.class, id);
        Autor autor = (Autor) EM.createQuery("SELECT a FROM Autor a WHERE a.id = :id AND a.alta = 1").setParameter("id", id).getSingleResult();
        super.desconectar();
        return autor;
    }

    public List<Autor> findAll() {
        super.conectar();
        List<Autor> listaAutores = EM.createQuery("SELECT a FROM Autor a ").getResultList();
        super.desconectar();
        return listaAutores;
    }

    public List<Autor> listaAutorBaja() {
        super.conectar();
        List<Autor> listaAutor = EM.createQuery("SELECT a FROM Autor a WHERE a.alta = 0").getResultList();
        super.desconectar();
        return listaAutor;
    }

    public List<Autor> listaAutorAlta() {
        super.conectar();
        List<Autor> listaAutor = EM.createQuery("SELECT a FROM Autor a WHERE a.alta = 1").getResultList();
        super.desconectar();
        return listaAutor;
    }

    public List<Autor> buscarAutor(String nombre) {
        super.conectar();
        List<Autor> autor = EM.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.alta = 1").setParameter("nombre", nombre).getResultList();
        super.desconectar();
        return autor;
    }

    public void persistAutor(Autor a) {
        super.conectar();
        super.guardar(a);
        super.desconectar();
    }

    public void updateAutor(Autor a) {
        super.conectar();
        super.actualizar(a);
        super.desconectar();
    }

    public void autorAlta(Autor l) {
        l.setAlta(true);
        super.conectar();
        updateAutor(l);
        super.desconectar();
    }

    public void autorBaja(Autor l) {
        l.setAlta(false);
        super.conectar();
        updateAutor(l);
        super.desconectar();
    }
}
