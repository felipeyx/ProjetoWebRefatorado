package br.senac.service;

import br.senac.exception.NegocioException;
import br.senac.model.Produto;
import br.senac.repository.ProdutoRepository;

public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrar(String nome, double preco, int quantidade) {
        validarNome(nome);
        validarPreco(preco);
        validarQuantidade(quantidade);
        return repository.salvar(new Produto(0, nome, preco, quantidade));
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NegocioException("O nome do produto nao pode ser vazio.");
        }
    }

    private void validarPreco(double preco) {
        if (preco < 0) {
            throw new NegocioException("O preco nao pode ser negativo.");
        }
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new NegocioException("A quantidade nao pode ser negativa.");
        }
    }
}
