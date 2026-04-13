package br.senac.controller;

import br.senac.exception.NegocioException;
import br.senac.model.Cliente;
import br.senac.service.ClienteService;
import java.util.List;

public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    public String cadastrar(String nome, String email, String cpf) {
        try {
            return "Cliente cadastrado: " + service.cadastrar(nome, email, cpf);
        } catch (NegocioException e) {
            return "Erro: " + e.getMessage();
        }
    }

    public String listar() {
        List<Cliente> lista = service.listar();
        if (lista.isEmpty()) return "Nenhum cliente cadastrado.";
        StringBuilder sb = new StringBuilder();
        lista.forEach(c -> sb.append(c).append("\n"));
        return sb.toString();
    }
}
