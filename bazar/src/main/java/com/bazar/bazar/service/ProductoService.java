
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    private IProductoRepository productoRepo;
    
    @Override
    public void altaProducto(Producto producto) {
       productoRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
       return productoRepo.findAll();
    }

    @Override
    public Producto getProducto(Long id_producto) {
        return productoRepo.findById(id_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long id_producto) {
        productoRepo.deleteById(id_producto);
    }

    @Override
    public void editProducto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible) {
       Producto producto = this.getProducto(codigo_producto);
       if(nombre != null) producto.setNombre(nombre);
       if(cantidad_disponible != null)producto.setCantidad_disponible(cantidad_disponible);
       if(costo != null)producto.setCosto(costo);
       if(marca != null)producto.setMarca(marca);
       
       this.productoRepo.save(producto);
       
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listProducto = this.getProductos();
        List<Producto> listaStockProducto = new ArrayList<Producto>();
        
        for (Producto producto : listProducto) {
            if(producto.getCantidad_disponible() < 5){
                listaStockProducto.add(producto);
            }
        }
        return listaStockProducto;
    }

  

    
    
}
