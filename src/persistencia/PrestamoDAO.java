
package persistencia;

import entidad.Prestamo;


public class PrestamoDAO extends DAO{
    
        
    
      public void persistPrestamo(Prestamo p){
        //super.conectar();
        super.guardar(p);
        //super.desconectar();
        
    }
    
}
