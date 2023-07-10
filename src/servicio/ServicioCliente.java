/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Cliente;
import java.util.List;
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
/**
 * METODO CREA EL CLIENTE SETEA TODOS SUS ATRIBUTOS Y LOS GUARDA EN LA BBDD
 */
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
    /**
     * METODO BUSCA UN CLIENTE EN LA BBDD POR DNI
     * @param dni SOLICITAMOS DNI(LONG) al USUARIO
     */
    public void buscar(Long dni){
       Cliente c = clienteDao.buscarCliente(dni); 
       System.out.println("Nombre: "+c.getNombre()+"\n"+"Apellido: "+c.getApellido());
        
    }
    
    /**
     * METODO DEVUELVE LA LISTA COMPLETA DE CLIENTES
     */
    public void findAllClientes(){
    
    List<Cliente> listaClientes = clienteDao.findAll();
        for (Cliente c : listaClientes) {
            System.out.println("Nombre: "+c.getNombre()+"\n"+"Apellido: "+c.getApellido()+"\n"+"DNI: "+c.getDni());
        }
    }
    
    /**
     * METODO MODIFICA UN CLIENTE SELECCIONADO POR EL USUARIO
     */
    public void updateCliente(){
        System.out.println("Ingresa el dni del cliente a modificar:");
        Long dni = LEER.nextLong();
        Cliente c = clienteDao.buscarCliente(dni);
        System.out.println("MODIFICAR:\n1 - Nombre\n2 - Apellido\n3 - DNI\n4 - TEL");
        int op = LEER.nextInt();
        switch(op){
            case 1:
                System.out.println("NUEVO NOMBRE:");
                c.setNombre(LEER.next());
                break;
            case 2:
                System.out.println("NUEVO APELLIDO:");
                c.setApellido(LEER.next());
                break;
            case 3:
                System.out.println("NUEVO DNI:");
                c.setDni(LEER.nextLong());
                break;
            case 4:
                System.out.println("NUEVO TELEFONO");
                c.setTelefono(LEER.next());
                break;
            default:
                System.out.println("Escoge una opcion valida");
        }
        clienteDao.updateCliente(c);
        
    }
}
