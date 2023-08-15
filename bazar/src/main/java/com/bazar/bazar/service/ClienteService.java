
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public void altaCliente(Cliente cliente) {
       clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente getCliente(Long id_cliente) {
       return clienteRepo.findById(id_cliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void editCliente(Long id_cliente, String nombre, String apellido, String dni) {
        Cliente cli = this.getCliente(id_cliente);
        if(nombre != null) cli.setNombre(nombre);
        if(apellido != null)  cli.setApellido(apellido);
        if(dni != null) cli.setDni(dni);
         
    
        
        this.clienteRepo.save(cli);
                
    }
    
    


  
    
}
