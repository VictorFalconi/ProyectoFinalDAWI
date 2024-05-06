package pe.edu.cibertec.ProyectoFinalDAWI.service;


import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> listarClientes();
    void registrarCliente(Cliente cliente);
}
