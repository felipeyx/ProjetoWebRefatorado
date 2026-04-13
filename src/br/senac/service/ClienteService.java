package br.senac.service;

import br.senac.exception.NegocioException;
import br.senac.model.Cliente;
import br.senac.repository.ClienteRepository;
import java.util.List;

public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrar(String nome, String email, String cpf) {
        validarNome(nome);
        validarEmail(email);
        validarCpf(cpf);
        return repository.salvar(new Cliente(0, nome, email, cpf));
    }

    public List<Cliente> listar() {
        return repository.listarTodos();
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NegocioException("Nome do cliente nao pode ser vazio.");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new NegocioException("E-mail invalido.");
        }
    }

    private void validarCpf(String cpf) {
        if (cpf == null || cpf.replaceAll("[^0-9]", "").length() != 11) {
            throw new NegocioException("CPF invalido. Informe 11 digitos.");
        }
    }
}
