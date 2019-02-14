package com.oscar.cicalc.web;

import com.oscar.cicalc.service.CalculadoraService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CalculadoraControllerTest {

    private CalculadoraService calcService = mock(CalculadoraService.class);

    private CalculadoraController sut = new CalculadoraController(calcService);

    @Test
    public void shouldCallServiceAdd(){
        int x = 10;
        int y = 10;

        sut.add(x, y);

        verify(calcService).sumar(x, y);
    }

    @Test
    public void shouldCallServiceMultiply(){
        int x = 10;
        int y = 10;

        sut.multiply(x, y);

        verify(calcService).multiplicar(x, y);
    }

}
