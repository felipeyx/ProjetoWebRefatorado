package br.senac.repository;

import br.senac.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public Produto salvar(Produto produto) {
        if (produto.getId() == 0) {
            produto.setId(proximoId++);
            produtos.add(produto);
        } else {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getId() == produto.getId()) {
                    produtos.set(i, produto);
                    return produto;
                }
            }
        }
        return produto;
    }

    public Optional<Produto> buscarPorId(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public boolean remover(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }
}
