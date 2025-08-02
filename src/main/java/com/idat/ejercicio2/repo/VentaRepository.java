package com.idat.ejercicio2.repo;

import com.idat.ejercicio2.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository <Venta,String>{

}
