package servicio;

import entidad.Autor;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;

public class ServicioAutor {

    private AutorDAO autorDao = new AutorDAO();
    private Scanner LEER = new Scanner(System.in).useDelimiter("\n");

    public void crearAutor() {
        Autor autor = new Autor();
        System.out.println("Ingresa Autor: ");
        autor.setNombre(LEER.next());
        autorDao.persistAutor(autor);

    }

    public void findAllAutor() {
        listaAutorAlta();
        System.out.println("ingresa el nombre del autor:");
        String autor = LEER.next();

        List<Autor> listaAutor = autorDao.buscarAutor(autor);
        
        if (listaAutor.isEmpty() || listaAutor == null) {
            System.out.println("no existen registros del autor");

        } else {
            for (Autor e : listaAutor) {
                System.out.println(e);
            }
        }

    }

    public void listaAutorAlta() {
        List<Autor> listaAutor = autorDao.findAll();
        for (Autor e : listaAutor) {
            System.out.println(e);
        }
    }

    public void updateAutor() {
        int op = 0;
        listaAutorAlta();
        System.out.println("Escoge el nombre del autor para modificar:");
        String autor = LEER.next();

        Autor a = autorDao.buscarAutor(autor).get(0);
        try{
        System.out.println("Que deseas modificar?:\n1 - Nombre\n2 - Alta");
        op = LEER.nextInt();

        switch (op) {
            case 1:
                System.out.println("Ingresa el nuevo nombre del autor");
                a.setNombre(LEER.next());
                break;
            case 2:
                System.out.println("Escoge (1)ALTA - (2)BAJA");
                int opcion = LEER.nextInt();
                if (opcion == 1) {
                    autorDao.autorAlta(a);
                }
                if (opcion == 2) {
                    autorDao.autorBaja(a);
                }
                break;
            default:
                System.out.println("Opcion no correspondiente.");

        }
        }catch(Exception e){System.out.println("Error al escoger una opcion"+e);}
        autorDao.updateAutor(a);
    }
}
