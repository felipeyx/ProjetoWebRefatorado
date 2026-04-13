package br.senac.service;

import br.senac.exception.NegocioException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraEstoqueTest {

    @Test
    void deveCalcularValorTotalCorretamente() {
        CalculadoraEstoque calculadora = new CalculadoraEstoque();
        double resultado = calculadora.calcularValorTotal(100.0, 3);
        assertEquals(300.0, resultado);
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForNegativo() {
        CalculadoraEstoque calculadora = new CalculadoraEstoque();
        assertThrows(NegocioException.class, () -> calculadora.calcularValorTotal(-10.0, 3));
    }
}
