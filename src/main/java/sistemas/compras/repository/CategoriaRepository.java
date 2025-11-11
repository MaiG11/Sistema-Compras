package sistemas.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemas.compras.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
