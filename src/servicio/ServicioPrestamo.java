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
    
    public void crearPrestamo(){
        
        Cliente c = clienteDao.buscarCliente(34977524L);
        System.out.println("Ingresa el id del libro:");
        int id = LEER.nextInt();
        Libro l = libroDao.buscarUnLibroAlta(id);

        Prestamo p = new Prestamo(new Date(),new Date(),l,c);
        //Prestamo p = new Prestamo(l,c);
        
        prestamoDao.persistPrestamo(p);
    }
    
}
