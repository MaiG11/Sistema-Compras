package sistemas.compras.model;
// Define o pacote onde a classe está localizada.
// Pacote é como uma "pasta" dentro do projeto, usada para organizar as classes.

import jakarta.persistence.Entity;
// Importa a anotação @Entity, que transforma a classe em uma tabela no banco de dados.

import jakarta.persistence.GeneratedValue;
// Importa a anotação usada para gerar o ID automaticamente.

import jakarta.persistence.GenerationType;
// Importa o tipo de geração do ID (no caso, AUTO_INCREMENT no banco).

import jakarta.persistence.Id;
// Importa a anotação que marca o campo como chave primária (ID da tabela).

import jakarta.persistence.OneToMany;
// Importa a anotação usada para indicar o relacionamento de "um para muitos".

import java.util.List;
// Importa a classe List, que serve para criar listas (ex: uma categoria com vários produtos).

@Entity
// Indica que essa classe representa uma tabela no banco de dados.
public class Categoria {
// Início da classe Categoria.

    @Id
    // Define o campo abaixo como o identificador único (chave primária).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Faz o banco gerar o valor do ID automaticamente (ex: 1, 2, 3...).
    private Long id;
    // Campo "id" do tipo Long (número inteiro grande).

    private String nome;
    // Campo "nome" que vai guardar o nome da categoria.

    @OneToMany(mappedBy = "categoria")
    // Diz que uma categoria pode ter vários produtos relacionados a ela.
    // "mappedBy = 'categoria'" indica que a relação é controlada pelo campo "categoria" dentro da classe Produto.
    private List<Produto> produtos;
    // Lista de produtos que pertencem a essa categoria.

    // ----------- MÉTODOS GET E SET -----------
    // Servem para acessar e alterar os valores dos atributos acima.

    public Long getId() {
        return id;
    }
    // Retorna o valor do campo id.

    public void setId(Long id) {
        this.id = id;
    }
    // Altera o valor do campo id.

    public String getNome() {
        return nome;
    }
    // Retorna o nome da categoria.

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Altera o nome da categoria.

    public List<Produto> getProdutos() {
        return produtos;
    }
    // Retorna a lista de produtos dessa categoria.

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    // Altera a lista de produtos dessa categoria.
}
