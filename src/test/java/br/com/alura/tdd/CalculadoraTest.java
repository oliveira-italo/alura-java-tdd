package br.com.alura.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumerosPositivos() {
        int soma = new Calculadora().somar(1, 1);
        assertEquals(2, soma);
    }

}
