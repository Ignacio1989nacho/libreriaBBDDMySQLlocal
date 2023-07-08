package servicio;

import entidad.Editorial;
import java.util.List;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class ServicioEditorial {
    
    private Scanner LEER = new Scanner(System.in).useDelimiter("\n");
    private EditorialDAO editorialDao = new EditorialDAO();
    
    public void crearEditorial() {
        Editorial editorial = new Editorial();
        System.out.println("Ingresa la editorial: ");
        editorial.setNombre(LEER.next());
        editorialDao.persistEditorial(editorial);
        
    }
    
    public void listaEditorialAlta() {
        List<Editorial> listaEditorial = editorialDao.findAll();
        for (Editorial e : listaEditorial) {
            System.out.println(e);
        }
    }
    
    public void findAllEditorial() {
        listaEditorialAlta();
        System.out.println("ingresa el nombre de la editorial:");
        String editorial = LEER.next();
        
        List<Editorial> listaEditorial = editorialDao.buscarEditorial(editorial);
        
        if (listaEditorial.isEmpty() || listaEditorial == null) {
            System.out.println("no existen registros de esa editorial");
            
        } else {
            for (Editorial e : listaEditorial) {
                System.out.println(e);
            }
        }
        
    }
    
    public void updateEditorial() {
        int op = 0;
        listaEditorialAlta();
        System.out.println("Escoge una editorial para modificar:");
        String editorial = LEER.next();
        
        Editorial e = editorialDao.buscarEditorial(editorial).get(0);
        try{
        System.out.println("Que deseas modificar?:\n1 - Nombre\n2 - Alta");
        op = LEER.nextInt();
        
        switch (op) {
            case 1:
                System.out.println("Ingresa el nuevo nombre de la editorial");
                e.setNombre(LEER.next());
                break;
            case 2:
                System.out.println("Escoge (1)ALTA - (2)BAJA");
                int opcion = LEER.nextInt();
                if (opcion == 1) { editorialDao.editorialAlta(e);}  
                if (opcion == 2) { editorialDao.editorialBaja(e);} 
                break;
            default:
                System.out.println("Opcion no correspondiente.");
            
        }
        }catch(Exception ex){System.out.println("Error al escoger una opcion"+ex);}
        editorialDao.updateEditorial(e);
    }
    
}
