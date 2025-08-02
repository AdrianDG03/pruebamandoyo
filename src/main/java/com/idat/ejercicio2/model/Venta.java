package com.idat.ejercicio2.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Venta {
    @Id
    @Column(name = "cod_venta")
    private String codVenta;
    private LocalDate fechaVenta;
    private String producto;
    private double precio;
    private int cantidad;

    public double getImporteVenta() {
        return precio * cantidad;
    }

    public double getPorcemtajeDescuento() {
        return cantidad > 100 ? 0.10 : 0.05;
    }

    public double getImporteDescuento(){
        return getImporteVenta() * getPorcemtajeDescuento();
    }

    public double getImportePagar() {
        return getImporteVenta() - getImporteDescuento();
    }
}
