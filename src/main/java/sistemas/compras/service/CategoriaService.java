package sistemas.compras.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemas.compras.model.Categoria;
import sistemas.compras.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar categorias
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar por ID
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de categoria inválido: " + id));
    }

    // Salvar categoria (serve para criar ou atualizar)
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Excluir categoria
    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }
}
