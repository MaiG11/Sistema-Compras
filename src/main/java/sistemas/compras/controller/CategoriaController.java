package sistemas.compras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sistemas.compras.model.Categoria;
import sistemas.compras.service.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String home() {
        return "redirect:/categoria";
    }

    @GetMapping("/categoria")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categoria";
    }

    @GetMapping("/categoria/nova")
    public String novaCategoriaForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formCategoria";
    }

    @PostMapping("/categoria/salvar")
    public String salvarCategoria(Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/categoria/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id) {
        categoriaService.excluir(id);
        return "redirect:/categoria";
    }

    @GetMapping("/categoria/editar/{id}")
    public String editarCategoriaForm(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id);
        model.addAttribute("categoria", categoria);
        return "formCategoria";
    }

    @PostMapping("/categoria/atualizar")
    public String atualizarCategoria(Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categoria";
    }
}
