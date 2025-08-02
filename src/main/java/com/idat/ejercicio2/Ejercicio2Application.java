package com.idat.ejercicio2;

import com.idat.ejercicio2.model.Venta;
import com.idat.ejercicio2.repo.VentaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Ejercicio2Application {

	@Autowired
	private VentaRepository ventaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio2Application.class, args);
	}

	@PostConstruct
	void init() {
		Venta v1 = new Venta();
		v1.setCodVenta("V001");
		v1.setFechaVenta(LocalDate.of(2025, 6, 15));
		v1.setProducto("ARROZ");
		v1.setPrecio(5.2);
		v1.setCantidad(100);

		ventaRepository.save(v1);
	}
}