package br.senac.controller;

import br.senac.exception.NegocioException;
import br.senac.model.Produto;
import br.senac.service.ProdutoService;
import java.util.List;

public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    public String cadastrar(String nome, String precoStr, String qtdStr) {
        try {
            Produto produto = service.cadastrar(nome, Double.parseDouble(precoStr), Integer.parseInt(qtdStr));
            return "Produto cadastrado com sucesso: " + produto;
        } catch (NumberFormatException e) {
            return "Erro: preco ou quantidade invalidos.";
        } catch (NegocioException e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String listar() {
        List<Produto> lista = service.listar();
        if (lista.isEmpty()) return "Nenhum produto cadastrado.";
        StringBuilder sb = new StringBuilder();
        lista.forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }

    public String remover(String idStr) {
        try {
            service.remover(Integer.parseInt(idStr));
            return "Produto removido com sucesso.";
        } catch (NumberFormatException e) {
            return "Erro: ID invalido.";
        } catch (NegocioException e) {
            return "Erro: " + e.getMessage();
        }
    }
}
