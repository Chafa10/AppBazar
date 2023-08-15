
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService{

    
    @Autowired
    private IVentaRepository ventaRepository;
    
    @Override
    public void altaVenta(Venta venta) {
      ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
       return ventaRepository.findAll();
    }

    @Override
    public Venta getVenta(Long id_venta) {
        return ventaRepository.findById(id_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long id_venta) {
        ventaRepository.deleteById(id_venta);
    }

    @Override
    public void editVenta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente, List<Producto> listaProductos) {
       Venta ven = this.getVenta(codigo_venta);
       ven.setFecha_venta(fecha_venta);
       ven.setTotal(total);
       ven.setUnCliente(unCliente);
       ven.setListaProductos(listaProductos);
       
       this.ventaRepository.save(ven);
    }

    @Override
    public Optional<Venta> ventaById(Long codigo_venta) {
       return ventaRepository.findById(codigo_venta);
    }

   

   

    

    

    

    
    
    
}
