package sistemas.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sistemas.compras.model.Categoria;
import sistemas.compras.repository.CategoriaRepository;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/categoria";
    }

    @GetMapping("/categoria")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categoria";
    }

    @GetMapping("/categoria/nova")
    public String novaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping("/categoria/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categoria";
    }
    // Método para excluir uma categoria pelo ID
    @GetMapping("/categoria/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id) {
    categoriaRepository.deleteById(id); // Apaga do banco
    return "redirect:/categoria"; // Redireciona para a listagem correta
    }
// Método para exibir o formulário de edição
    @GetMapping("/categoria/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("ID de categoria inválido: " + id));

    model.addAttribute("categoria", categoria);
    return "formCategoria"; // usa o mesmo formulário de cadastro
    }

// Método para atualizar a categoria (usa o mesmo /categoria/salvar)
    @PostMapping("/categoria/atualizar")
    public String atualizarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria); // o save atualiza se já existir ID
        return "redirect:/categoria";
}

}
