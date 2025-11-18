package sistemas.compras.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemas.compras.model.Categoria;
import sistemas.compras.model.Produto;
import sistemas.compras.repository.CategoriaRepository;
import sistemas.compras.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar produtos
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));
    }

    // Salvar produto novo
    public Produto salvar(Produto produto) {

        // 🔥 Validação do desafio: impedir nomes repetidos
        boolean nomeExiste = produtoRepository.findByNome(produto.getNome()).isPresent();
        if (nomeExiste) {
            throw new IllegalArgumentException("Já existe um produto com este nome!");
        }

        // buscar categoria pelo ID (mesmo fluxo do seu controller)
        Long catId = produto.getCategoria() != null ? produto.getCategoria().getId() : null;
        if (catId == null) {
            throw new IllegalArgumentException("Categoria inválida");
        }

        Categoria categoriaExistente = categoriaRepository.findById(catId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));

        produto.setCategoria(categoriaExistente);

        return produtoRepository.save(produto);
    }

    // Excluir produto
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    // Atualizar produto existente
    public Produto atualizar(Produto produto) {

        // buscar produto no banco
        Produto produtoExistente = produtoRepository.findById(produto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Produto inválido: " + produto.getId()));

        // buscar categoria
        Long catId = produto.getCategoria() != null ? produto.getCategoria().getId() : null;
        if (catId == null) {
            throw new IllegalArgumentException("Categoria inválida");
        }

        Categoria categoriaExistente = categoriaRepository.findById(catId)
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));

        // atualizar campos
        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());
        produtoExistente.setCategoria(categoriaExistente);

        return produtoRepository.save(produtoExistente);
    }
}
