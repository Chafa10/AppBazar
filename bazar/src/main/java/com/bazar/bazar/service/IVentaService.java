
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



public interface IVentaService {
    
    public void altaVenta (Venta venta);
    
    public List<Venta> getVentas();
    
    public Venta getVenta(Long id_venta);
    
    public void deleteVenta(Long id_venta);
    
    public void editVenta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente, List<Producto> listaProductos);
    
    public Optional<Venta> ventaById(Long codigo_venta);
    
    
    
}
