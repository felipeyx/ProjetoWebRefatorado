package br.senac.repository;

import br.senac.model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Produto salvar(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(proximoId++);
            produtos.add(produto);
        }
        return produto;
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }
}
