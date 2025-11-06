package sistemas.compras.repository;
// Define o pacote onde o repositório está localizado.
// "repository" é a parte do sistema responsável por conversar com o banco de dados.

import org.springframework.data.jpa.repository.JpaRepository;
// Importa a interface JpaRepository, que contém vários métodos prontos para usar (como salvar, listar e deletar).

import sistemas.compras.model.Categoria;
// Importa a classe Categoria, que representa a tabela do banco que esse repositório vai manipular.

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
// Cria a interface CategoriaRepository que herda (extends) JpaRepository.
// <Categoria, Long> → o primeiro é o tipo da entidade (Categoria) e o segundo é o tipo do ID (Long).
// O JpaRepository já traz métodos prontos como save(), findAll(), deleteById() etc.
// Não precisa escrever código dentro das chaves porque o Spring gera tudo automaticamente.
