
package com.bazar.bazar.controller;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService iproductoService;
        
    @PostMapping ("/productos/crear")
    public String altaProducto(@RequestBody Producto producto){
        
        iproductoService.altaProducto(producto);
        
        return producto.getNombre() +  " fue dado de alta exitosamente";
    }
    
    @GetMapping ("/productos")
    public List<Producto> listProductos(){
        return iproductoService.getProductos();
    }
    
    @GetMapping ("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
       return iproductoService.getProducto(codigo_producto);
    }
    
    @DeleteMapping ("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        Producto produ = iproductoService.getProducto(codigo_producto);
        iproductoService.deleteProducto(codigo_producto);
        
        return produ.getNombre() + " fue borrado exitosamente";
    }
    
    @PutMapping ("/productos/editar/{codigo_producto}")
    public String editProducto (@PathVariable Long codigo_producto,
                                @RequestParam (required = false, name = "nombre") String nombre,
                                @RequestParam (required = false, name = "marca") String marca,
                                @RequestParam (required = false, name = "costo") Double costo,
                                @RequestParam (required = false, name = "cantidad_disponible") Double cantidad_disponible){
        
        iproductoService.editProducto(codigo_producto, nombre, marca, costo, cantidad_disponible);
              
     return "El producto fue modificado exitosamente";
    }
     
     @GetMapping ("/productos/falta_stock")
     public List<Producto> stockProducto(){
                                    
      return iproductoService.faltaStock();
    }
}
