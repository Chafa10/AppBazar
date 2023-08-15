
package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @PostMapping ("/clientes/crear")
    public String altaCliente(@RequestBody Cliente cliente){
        
        clienteService.altaCliente(cliente);
        
        return "El cliente fue dado de alta";
    }
    
    @GetMapping ("/clientes")
    public List<Cliente> listaClientes(){
        return clienteService.getClientes();
    }
    
    @GetMapping ("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente){
        return clienteService.getCliente(id_cliente);
    }
    
    @DeleteMapping ("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
        
        return "El cliente fue borrado";
    }
    
     @PutMapping ("/clientes/editar{id_cliente}")
    public String editCliente (@PathVariable Long id_cliente,
                                   @RequestParam (required = false, name = "nombre") String nombre,
                                   @RequestParam (required = false, name = "apellido")String apellido,
                                   @RequestParam (required = false, name = "dni") String dni){
        
        clienteService.editCliente(id_cliente, nombre, apellido, dni);
                            
          
          return "El cliente fue editado exitosamente"; 
    }
   
}
