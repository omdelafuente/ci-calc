package com.oscar.cicalc.service;

import org.springframework.stereotype.Component;

@Component("calculadoraService")
public class CalculadoraService {

    public int sumar(int x, int y){
        return x+y;
    }

    public int multiplicar(int x, int y){
        return x*y;
    }
}
