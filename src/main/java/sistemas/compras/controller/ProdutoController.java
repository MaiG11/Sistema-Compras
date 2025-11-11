package sistemas.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sistemas.compras.model.Categoria;
import sistemas.compras.model.Produto;
import sistemas.compras.repository.ProdutoRepository;
import sistemas.compras.repository.CategoriaRepository;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/produto")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produto";
    }

    @GetMapping("/produto/novo")
    public String novoProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "formProduto";
    }

   @PostMapping("/produto/salvar")
   public String salvarProduto(Produto produto) {
    // Busca a categoria completa no banco antes de salvar o produto
    Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));
    
    produto.setCategoria(categoria);
    produtoRepository.save(produto);
    return "redirect:/produto";
   }
// Método para excluir um produto pelo ID
    @GetMapping("/produto/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id); // Apaga do banco
        return "redirect:/produto"; // Redireciona de volta à lista de produtos
    }
// Método para exibir o formulário de edição
    @GetMapping("/produto/editar/{id}")
    public String editarProdutoForm(@PathVariable Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("ID de produto inválido: " + id));

    model.addAttribute("produto", produto);
    model.addAttribute("categorias", categoriaRepository.findAll());
    return "formProduto"; // usa o mesmo formulário de cadastro
    }

// Método para atualizar o produto
    @PostMapping("/produto/atualizar")
    public String atualizarProduto(Produto produto) {
        Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
        .orElseThrow(() -> new IllegalArgumentException("Categoria inválida"));
    
    produto.setCategoria(categoria);
    produtoRepository.save(produto);
    return "redirect:/produto";
}

}
