package persistencia;

import entidad.Cliente;
import java.util.List;

public class ClienteDAO extends DAO {

    public Cliente buscarCliente(Long dni) {
        super.conectar();
        Cliente cliente = null;
        try {
            cliente = (Cliente) EM.createQuery("SELECT c FROM Cliente c WHERE c.dni = :dni").setParameter("dni", dni).getSingleResult();
            if (cliente != null) {
                return cliente;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return cliente;
    }

    public List<Cliente> findAll() {
        super.conectar();
        List<Cliente> listaCliente = null;
        try {
            listaCliente = EM.createQuery("SELECT c FROM Cliente c").getResultList();
            if (!listaCliente.isEmpty()) {
                return listaCliente;
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        super.desconectar();
        return listaCliente;
    }

    public void guardarCliente(Cliente c) {
        super.conectar();
        super.guardar(c);
        super.desconectar();
    }

    public void updateCliente(Cliente c) {
        super.conectar();
        super.actualizar(c);
        super.desconectar();
    }

    public void deleteCliente(Cliente c) {
        super.conectar();
        super.eliminar(c);
        super.desconectar();
    }

}
