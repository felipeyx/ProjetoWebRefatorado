package br.senac.repository;

import br.senac.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente salvar(Cliente cliente) {
        if (cliente.getId() == 0) {
            cliente.setId(proximoId++);
            clientes.add(cliente);
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getId() == cliente.getId()) {
                    clientes.set(i, cliente);
                    return cliente;
                }
            }
        }
        return cliente;
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    public boolean remover(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }
}
