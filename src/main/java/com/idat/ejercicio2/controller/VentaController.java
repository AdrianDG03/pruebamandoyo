package com.idat.ejercicio2.controller;


import com.idat.ejercicio2.model.Venta;
import com.idat.ejercicio2.repo.VentaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("")
    ModelAndView index() {
        List<Venta> ventas = ventaRepository.findAll();
        return new ModelAndView("index").addObject("ventas", ventas);
    }
    @GetMapping("/nueva")
    ModelAndView nueva() {
        return new ModelAndView("nueva").addObject("venta", new Venta());
    }
    @PostMapping("/nueva")
    String crear(Venta venta, RedirectAttributes ra) {
        ventaRepository.save(venta);
        ra.addFlashAttribute("msgExito","Venta agregado exitosamente");
        return "redirect:/";
    }
    @GetMapping("/{codVenta}/editar")
    ModelAndView editar(@PathVariable String codVenta) {
        Venta venta = ventaRepository.findById(codVenta).orElseThrow(EntityNotFoundException::new);
        return new ModelAndView("editar").addObject("venta", venta);
    }
    @PostMapping("/{codVenta}/editar")
    String actualizar(@PathVariable String codVenta, Venta venta, RedirectAttributes ra) {
        venta.setCodVenta(codVenta);
        ventaRepository.save(venta);
        ra.addFlashAttribute("msgExito","Venta actualizada exitosamente");
        return "redirect:/";
    }
    @GetMapping("/{codVenta}/eliminar")
    String eliminar(@PathVariable String codVenta, RedirectAttributes ra) {
        Venta venta = ventaRepository.findById(codVenta).orElseThrow(EntityNotFoundException::new);
        ventaRepository.delete(venta);
        ra.addFlashAttribute("msgExito","Venta eliminada exitosamente");
        return "redirect:/";
    }
}
