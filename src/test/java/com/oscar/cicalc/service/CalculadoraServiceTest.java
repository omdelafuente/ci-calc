package com.oscar.cicalc.service;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CalculadoraServiceTest {


    private CalculadoraService sut = new CalculadoraService();

    @Test
    public void shouldAddNumbers(){
        int x = 10;
        int y = 5;
        int resultadoEsperado = 15;

        int resultado = sut.sumar(x, y);

        assertThat(resultado, equalTo(resultadoEsperado));
    }

    @Test
    public void shouldMultiplyNumbers(){
        int x = 10;
        int y = 5;
        int resultadoEsperado = 50;

        int resultado = sut.multiplicar(x, y);

        assertThat(resultado, equalTo(resultadoEsperado));
    }
}
