package br.senac.service;

import br.senac.exception.NegocioException;
import br.senac.model.Produto;
import br.senac.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProdutoServiceTest {

    @Test
    void deveCadastrarProdutoValido() {
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);

        Produto produto = service.cadastrar("Mouse", 120.0, 5);

        assertNotNull(produto);
        assertEquals("Mouse", produto.getNome());
        assertEquals(120.0, produto.getPreco());
        assertEquals(5, produto.getQuantidade());
    }

    @Test
    void deveLancarExcecaoQuandoPrecoForNegativo() {
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);

        assertThrows(NegocioException.class, () -> service.cadastrar("Teclado", -1.0, 2));
    }
}
