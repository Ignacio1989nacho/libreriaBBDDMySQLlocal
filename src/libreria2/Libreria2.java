package libreria2;

import java.util.Scanner;
import servicio.ServicioAutor;
import servicio.ServicioCliente;
import servicio.ServicioEditorial;
import servicio.ServicioLibro;
import servicio.ServicioPrestamo;

public class Libreria2 {

    private static Scanner Leer = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        int op = 0;
        boolean log = false;

        do {
            try {
                System.out.println("MENU\n1 - LIBRO\n2 - AUTOR\n3 - EDITORIAL\n4 - CLIENTE\n5 - PRESTAMO LIBRO");
                op = Leer.nextInt();
                switch (op) {
                    case 1:
                        menuLibro();
                        break;
                    case 2:
                        menuAutor();
                        break;
                    case 3:
                        menuEditorial();
                        break;
                    case 4:
                        cliente();
                        break;
                    case 5:
                        prestamo();
                        break;
                    default:
                        System.out.println("SELECCION INCORRECTA.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error al escoger una opcion" + e);
                Leer.nextLine();
            }
        } while (!log);
    }

    public static void menuLibro() {
        ServicioLibro sl = new ServicioLibro();
        int op = 0;
        System.out.println("MENU\n1 - CREAR LIBRO\n2 - MOSTRAR LIBROS\n3 - MODIFICAR LIBRO");
        op = Leer.nextInt();
        switch (op) {
            case 1:
                sl.crearLibro();
                break;
            case 2:
                sl.findAllLibrosAlta();
                break;
            case 3:
                sl.updateLibro();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;

        }

    }

    public static void menuAutor() {
        ServicioAutor sa = new ServicioAutor();
        int op = 0;
        System.out.println("MENU\n1 - CREAR AUTOR\n2 - MOSTRAR AUTORES\n3 - MODIFICAR AUTOR");
        op = Leer.nextInt();
        switch (op) {
            case 1:
                sa.crearAutor();
                break;
            case 2:
                sa.findAllAutor();
                break;
            case 3:
                sa.updateAutor();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;

        }

    }

    public static void menuEditorial() {
        ServicioEditorial se = new ServicioEditorial();
        int op = 0;
        System.out.println("MENU\n1 - CREAR EDITORIAL\n2 - MOSTRAR EDITORIALES\n3 - MODIFICAR EDITORIAL");
        op = Leer.nextInt();
        switch (op) {
            case 1:
                se.crearEditorial();
                break;
            case 2:
                se.findAllEditorial();
                break;
            case 3:
                se.updateEditorial();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;

        }

    }

    public static void cliente() {
        ServicioCliente c = new ServicioCliente();
     
        int op = 0;
        System.out.println("MENU\n1 - CREAR CLIENTE\n2 - MOSTRAR CLIENTES\n3 - MODIFICAR CLIENTE");
        op = Leer.nextInt();
        switch (op) {
            case 1:
                c.crearCliente();
                break;
            case 2:
                c.findAllClientes();
                break;
            case 3:
                c.updateCliente();
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                break;

        }

    }

    public static void prestamo() {
        ServicioPrestamo sp = new ServicioPrestamo();
        //sp.crearPrestamo();
        sp.findListaPrestamos();

    }
}
