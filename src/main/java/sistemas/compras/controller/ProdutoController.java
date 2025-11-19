package sistemas.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sistemas.compras.model.Produto;
import sistemas.compras.service.ProdutoService;
import sistemas.compras.service.CategoriaService;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/produto")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produto";
    }

    @GetMapping("/produto/novo")
    public String novoProdutoForm(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "formProduto";
    }

    @PostMapping("/produto/salvar")
    public String salvarProduto(@ModelAttribute Produto produto, Model model) {
        try {
            produtoService.salvar(produto);
            return "redirect:/produto";
        } catch (IllegalArgumentException e) {
            model.addAttribute("produto", produto);
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("erro", e.getMessage()); // envia a mensagem para o HTML
            return "formProduto"; // volta ao formulário
        }
    }

    @GetMapping("/produto/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoService.excluir(id);
        return "redirect:/produto";
    }

    @GetMapping("/produto/editar/{id}")
    public String editarProdutoForm(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);

        model.addAttribute("produto", produto);
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "formProduto";
    }

    @PostMapping("/produto/atualizar")
    public String atualizarProduto(@ModelAttribute Produto produto, Model model) {
        try {
            produtoService.atualizar(produto);
            return "redirect:/produto";
        } catch (IllegalArgumentException e) {
            model.addAttribute("produto", produto);
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("erro", e.getMessage());
            return "formProduto";
    }
  }
}
