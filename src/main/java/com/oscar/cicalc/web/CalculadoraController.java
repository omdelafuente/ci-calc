package com.oscar.cicalc.web;

import com.oscar.cicalc.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
@CrossOrigin
public class CalculadoraController {

    private CalculadoraService calculadoraService;

    @Autowired
    public  CalculadoraController(CalculadoraService calculadoraService){
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/sumar/{x}/{y}")
    public int add(@PathVariable int x, @PathVariable int y) {
        return calculadoraService.sumar(x, y);
    }

    @GetMapping("/multiplicar/{x}/{y}")
    public int multiply(@PathVariable int x, @PathVariable int y) {
        return calculadoraService.multiplicar(x, y);
    }
}
