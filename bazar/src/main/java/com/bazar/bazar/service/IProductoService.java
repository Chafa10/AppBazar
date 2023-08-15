
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void altaProducto(Producto producto);
    
    public List<Producto> getProductos();
    
    public Producto getProducto(Long id_producto);
    
    public void deleteProducto(Long id_producto);
    
    public void editProducto(Long Codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible);
    
    public List<Producto> faltaStock();
}
