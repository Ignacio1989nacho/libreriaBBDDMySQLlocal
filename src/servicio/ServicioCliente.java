/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Cliente;
import java.util.Scanner;
import persistencia.ClienteDAO;
import persistencia.LibroDAO;

/**
 *
 * @author Usuario
 */
public class ServicioCliente {

    private final Scanner LEER = new Scanner(System.in).useDelimiter("\n");
    private ClienteDAO clienteDao = new ClienteDAO();

    public void crearCliente() {
        Cliente cliente = new Cliente();
        System.out.println("Ingrese el nombre del cliente:");
        cliente.setNombre(LEER.next());
        System.out.println("Ingrese el apellido del cliente:");
        cliente.setApellido(LEER.next());
        System.out.println("Ingrese el Telefono del cliente:");
        cliente.setTelefono(LEER.next());
        System.out.println("Ingrese el dni del cliente:");
        cliente.setDni(LEER.nextLong());
        clienteDao.guardarCliente(cliente);
    }

}
