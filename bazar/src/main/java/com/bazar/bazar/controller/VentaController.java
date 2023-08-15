
package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService ventaService;
    
    @PostMapping ("/ventas/crear")
    public String altaVenta(@RequestBody Venta venta){
        ventaService.altaVenta(venta);
        
        return "La venta se realizo con exito";
    }
    
    @GetMapping ("/ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }
    
    @GetMapping ("/ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta){
        return ventaService.getVenta(codigo_venta);
    }
    
    @DeleteMapping ("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        ventaService.deleteVenta(codigo_venta);
        
        return "La venta ha sido eliminada";
    }
    
    @PutMapping ("/ventas/editar({codigo_venta}")
    public String editVentas (@PathVariable Long codigo_venta,
                              @RequestParam (required = false, name = "fecha_venta") LocalDate fecha_venta,
                              @RequestParam (required = false, name = "total") Double total,
                              @RequestParam (required = false, name = "listaProductos") List<Producto> listaProductos,
                              @RequestParam (required = false, name = "unCliente") Cliente uncliente){
        ventaService.editVenta(codigo_venta, fecha_venta, total, uncliente, listaProductos);
        
        
        
        return "Venta modificada exitosamente";
    }
    
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public ResponseEntity<List<Producto>> productosDeUnaVenta (@PathVariable Long codigo_venta){
        
        Optional<Venta> ventaOpcional = ventaService.ventaById(codigo_venta);
        if(ventaOpcional.isPresent()){
            Venta venta = ventaOpcional.get();
            List<Producto> listaProductosVenta = venta.getListaProductos();
            return new ResponseEntity<>(listaProductosVenta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
           
    }
}
