package sistemas.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemas.compras.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
