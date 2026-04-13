package br.senac;

import br.senac.controller.ClienteController;
import br.senac.controller.ProdutoController;
import br.senac.exception.NegocioException;
import br.senac.repository.ClienteRepository;
import br.senac.repository.ProdutoRepository;
import br.senac.service.ClienteService;
import br.senac.service.ProdutoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTES - SISTEMA REFATORADO (ETAPA 6) ===\n");

        ProdutoRepository produtoRepository = new ProdutoRepository();
        ProdutoService produtoService = new ProdutoService(produtoRepository);
        ProdutoController produtoController = new ProdutoController(produtoService);

        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);

        System.out.println("--- Produtos ---");
        System.out.println(produtoController.cadastrar("Notebook Dell", "4500.00", "10"));
        System.out.println(produtoController.cadastrar("Mouse Logitech", "150.00", "50"));
        System.out.println(produtoController.cadastrar("Teclado Mecanico", "350.00", "30"));
        System.out.println(produtoController.listar());
        System.out.println(produtoController.remover("2"));
        System.out.println(produtoController.listar());
        System.out.println(produtoController.cadastrar("", "100", "2"));
        System.out.println(produtoController.cadastrar("Produto X", "-10", "2"));

        System.out.println("--- Clientes ---");
        System.out.println(clienteController.cadastrar("Ana Silva", "ana@email.com", "12345678901"));
        System.out.println(clienteController.cadastrar("Carlos Souza", "carlos@email.com", "98765432100"));
        System.out.println(clienteController.listar());
        System.out.println(clienteController.cadastrar("João", "emailinvalido", "11122233344"));

        System.out.println("--- Excecao ---");
        try {
            produtoService.remover(99);
        } catch (NegocioException e) {
            System.out.println("NegocioException capturada: " + e.getMessage());
        }

        System.out.println("\n=== FIM DOS TESTES ===");
    }
}
