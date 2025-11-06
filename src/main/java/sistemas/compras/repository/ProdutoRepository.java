package sistemas.compras.repository;
// Define o pacote onde o repositório está localizado.

import org.springframework.data.jpa.repository.JpaRepository;
// Importa a interface JpaRepository, que fornece métodos prontos para acessar o banco.

import sistemas.compras.model.Produto;
// Importa a classe Produto, que é a tabela que esse repositório vai manipular.

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
// Cria a interface ProdutoRepository que herda JpaRepository.
// <Produto, Long> → o primeiro é o tipo da entidade (Produto) e o segundo é o tipo do ID (Long).
// Assim, o Spring cria automaticamente os comandos SQL (SELECT, INSERT, DELETE, UPDATE) sem você precisar digitar.
