package br.senac.service;

import br.senac.exception.NegocioException;

public class CalculadoraEstoque {

    public double calcularValorTotal(double precoUnitario, int quantidade) {
        if (precoUnitario < 0) {
            throw new NegocioException("Preco unitario invalido.");
        }
        if (quantidade < 0) {
            throw new NegocioException("Quantidade invalida.");
        }
        return precoUnitario * quantidade;
    }
}
