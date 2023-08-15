
package com.bazar.bazar.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaAux {
    
    private Double monto;
    private int cantidad_ventas;

    public VentaAux() {
    }

    public VentaAux(Double monto, int cantidad_ventas) {
        this.monto = monto;
        this.cantidad_ventas = cantidad_ventas;
    }
    
    
}
