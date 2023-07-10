package persistencia;

import entidad.Prestamo;
import java.util.List;

public class PrestamoDAO extends DAO {

    public List<Prestamo> findAll() {
        List<Prestamo> listaPrestamos = null;
        try {
            listaPrestamos = EM.createQuery("SELECT p FROM Prestamo p").getResultList();
            if (!listaPrestamos.isEmpty()) {
                return listaPrestamos;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        return listaPrestamos;
    }

    public void persistPrestamo(Prestamo p) {
        //super.conectar();
        super.guardar(p);
        //super.desconectar();

    }

}
