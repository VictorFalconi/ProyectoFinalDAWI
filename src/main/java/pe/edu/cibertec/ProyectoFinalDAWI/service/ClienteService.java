package pe.edu.cibertec.ProyectoFinalDAWI.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoFinalDAWI.model.bd.Cliente;
import pe.edu.cibertec.ProyectoFinalDAWI.repository.ClienteRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ClienteService implements IClienteService{
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
