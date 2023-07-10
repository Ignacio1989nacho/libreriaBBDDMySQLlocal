/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Cliente;
import entidad.Libro;
import entidad.Prestamo;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import persistencia.ClienteDAO;
import persistencia.LibroDAO;
import persistencia.PrestamoDAO;


public class ServicioPrestamo {
    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");
    private PrestamoDAO prestamoDao = new PrestamoDAO();
    private LibroDAO libroDao = new LibroDAO();
    private ClienteDAO clienteDao = new ClienteDAO();
    /**
     * METODO CREA EL PRESTAMO SOLICITANDO AL USUARIO EL ID DEL LIBRO Y EL DNI DEL CLIENTE
     */
    public void crearPrestamo(){
        System.out.println("Ingresa el id del libro:");
        int id = LEER.nextInt();
        System.out.println("Ingresa el dni del cliente:");
        Long dni = LEER.nextLong();
        Cliente c = clienteDao.buscarCliente(dni);
 
        Libro l = libroDao.buscarUnLibroAlta(id);
        Prestamo p = new Prestamo(new Date(),new Date(),l,c);
        prestamoDao.persistPrestamo(p);
    }
    /**
     * METODO MUESTRA TODOS LOS PRESTAMOS ACTUALMENTE DADOS.
     */
    public void findListaPrestamos(){
    
    List<Prestamo> lista = prestamoDao.findAll();
        for (Prestamo prestamo : lista) {
            System.out.println("Apellido: "+prestamo.getCliente().getApellido()+"\nNombre: "+prestamo.getCliente().getNombre()
            +"\nLibro: "+prestamo.getLibro().getTitulo());
        }
    }
}
