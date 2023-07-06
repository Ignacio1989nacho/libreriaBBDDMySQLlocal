package servicio;

import entidad.Autor;
import entidad.Editorial;
import entidad.Libro;
import java.util.List;
import java.util.Scanner;
import persistencia.AutorDAO;
import persistencia.EditorialDAO;
import persistencia.LibroDAO;

public class ServicioLibro {

    private LibroDAO libroDao = new LibroDAO();
    private Scanner LEER = new Scanner(System.in).useDelimiter("\n");
    private AutorDAO autorDao = new AutorDAO();
    private EditorialDAO editorialDao = new EditorialDAO();

    public void crearLibro() {
        Libro libro = new Libro();
        try{
        System.out.println("Ingresa el titulo del Libro: ");
        libro.setTitulo(LEER.next());
        System.out.println("Ingresa el año de salida:");
        libro.setAnio(LEER.nextInt());
        System.out.println("Cantidad de ejemplares:");
        libro.setEjemplares(LEER.nextInt());
        System.out.println("Cantidad de ejemplares Prestados:");
        libro.setEjemplaresPrestados(LEER.nextInt());
        }catch(Exception e){System.out.println("Error al ingresar un dato del libro"+e);}
        libro.setEjemplaresRestantes((libro.getEjemplares() - libro.getEjemplaresPrestados()));
        cargarAutor(libro);
        cargarEditorial(libro);
        libroDao.persistLibro(libro);
    }

    public void cargarAutor(Libro libro) {
        int op = 0;
        System.out.println("Ingresa el nombre del autor:");
        String nombre = LEER.next();
        List<Autor> listaAutores = autorDao.buscarAutor(nombre);
        if (listaAutores.isEmpty() || listaAutores == null) {
            System.out.println("El autor no existe");
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(true);
            autorDao.persistAutor(autor);
            libro.setAutor(autor);
        } else {
            try{
            System.out.println("AUTORES - INGRESE EL NUMERO CORRESPONDIENTE:");
            int cont = 0;
            for (Autor autores : listaAutores) {
                cont++;
                System.out.println(cont + " - " + autores.getNombre());
            }
            op = LEER.nextInt();
            }catch(Exception e){System.out.println("Error al seleccionar un autor"+ e);}
            libro.setAutor(listaAutores.get(op - 1));
        }

    }

    public void cargarEditorial(Libro libro) {
        int op = 0;
        System.out.println("Ingresa el nombre de la editorial:");
        String nombre = LEER.next();
        List<Editorial> listaEditorial = editorialDao.buscarEditorial(nombre);
        if (listaEditorial.isEmpty() || listaEditorial == null) {
            System.out.println("la editorial no existe");
            Editorial editorial = new Editorial();
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            editorialDao.persistEditorial(editorial);
            libro.setEditorial(editorial);
        } else {
            try{
            System.out.println("EDITORIALES - INGRESE EL NUMERO CORRESPONDIENTE:");
            int cont = 0;
            for (Editorial editorial : listaEditorial) {
                cont++;
                System.out.println(cont + " - " + editorial.getNombre());
            }
            op = LEER.nextInt();
            }catch(Exception e){System.out.println("Error al seleccionar una editorial"+e);}
            libro.setEditorial(listaEditorial.get(op - 1));
        }
    }

    public void findAllLibrosAlta() {
        List<Libro> listaLibro = libroDao.findAll();
        for (Libro libro : listaLibro) {
            System.out.println(libro);
        }      
    }
    
    public void eliminarLibroFisico(){
        int id = 0 ;
        findAllLibrosAlta();
        try{
        System.out.println("Ingresa el id del libro a eliminar:");
        id = LEER.nextInt();
        }catch(Exception e){System.out.println("Error al ingresar el id del libro"+e);}
        Libro libro = libroDao.buscarUnLibroAlta(id);
        libroDao.eliminarFisico(libro);
    }
    
    public void updateLibro(){
        int op = 0;
        findAllLibrosAlta();
        
        System.out.println("Escoge el nombre del libro para modificar:");
        String libro = LEER.next();

        Libro l = libroDao.buscarLibro(libro).get(0);
        try{
        System.out.println("Que deseas modificar?:\n1 - Titulo\n2 - Alta\n3 - Año\n4 - Ejemplares\n5 - Ejemplares Prestados\n6 - Autor\n7 - Editorial\n8 - TODOS LOS LIBROS");
        op = LEER.nextInt();
        switch (op) {
            case 1:
                System.out.println("Ingresa el nuevo nombre del libro");
                l.setTitulo(LEER.next());
                break;
            case 2:
                System.out.println("Escoge (1)ALTA - (2)BAJA");
                int opcion = LEER.nextInt();
                if (opcion == 1) {libroDao.libroAlta(l);}
                if (opcion == 2) {libroDao.libroBaja(l);}
                break;
            case 3:
                System.out.println("Ingresa el año");
                l.setAnio(LEER.nextInt());
                break;
            case 4:
                System.out.println("Ingresa los Ejemplares:");
                l.setEjemplares(LEER.nextInt());
                break;
            case 5:
                System.out.println("Ingresa los ejemplares prestados:");
                l.setEjemplaresPrestados(LEER.nextInt());
                break;
            case 6:
                cargarAutor(l);
                break;
            case 7:
                cargarEditorial(l);
                break;
            case 8:
                findAllLibrosAlta();
                break;
            default:
                System.out.println("Opcion no correspondiente.");

        }
        }catch(Exception e){System.out.println("Error al seleccionar una opcion"+e);}
        libroDao.updateLibro(l);
    
    }

}
