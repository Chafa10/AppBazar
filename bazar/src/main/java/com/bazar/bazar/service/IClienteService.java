
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import java.util.List;





public interface IClienteService {
    
    public void altaCliente(Cliente cliente);
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Long id_cliente);
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Long id_cliente, String nombre, String apellido, String dni);
    
}
