package sistemas.compras.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import sistemas.compras.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Usado no Service para verificar se já existe um produto com o mesmo nome
    Optional<Produto> findByNome(String nome);
}
