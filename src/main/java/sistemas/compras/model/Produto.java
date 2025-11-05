package sistemas.compras.model;
// Define o pacote onde essa classe está localizada.
// Aqui organizamos as classes do tipo "modelo", que representam tabelas do banco.

import jakarta.persistence.Entity;
// Importa a anotação @Entity, que transforma a classe em uma tabela no banco de dados.

import jakarta.persistence.GeneratedValue;
// Importa a anotação usada para gerar o valor do ID automaticamente.

import jakarta.persistence.GenerationType;
// Importa o tipo de estratégia usada para gerar o ID (neste caso, AUTO_INCREMENT).

import jakarta.persistence.Id;
// Importa a anotação que marca o campo como chave primária (ID da tabela).

import jakarta.persistence.ManyToOne;
// Importa a anotação que indica um relacionamento de muitos para um.
// Exemplo: muitos produtos podem pertencer a uma categoria.

@Entity
// Indica que essa classe representa uma tabela no banco de dados.
public class Produto {
// Início da classe Produto.

    @Id
    // Indica que esse campo é a chave primária da tabela (identificador único).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Faz o banco gerar o valor do ID automaticamente (1, 2, 3...).
    private Long id;
    // Campo "id" do tipo Long — representa o código do produto no banco.

    private String nome;
    // Campo "nome" — vai armazenar o nome do produto.

    private Double preco;
    // Campo "preco" — vai guardar o valor (preço) do produto.

    @ManyToOne
    // Indica que muitos produtos podem estar ligados a uma única categoria.
    // Exemplo: vários produtos da categoria "Bebidas".
    private Categoria categoria;
    // Campo que cria o relacionamento com a tabela Categoria.

    // ----------- MÉTODOS GET E SET -----------
    // Servem para acessar (get) e alterar (set) os valores dos atributos.

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
    // Retorna o nome do produto.

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Altera o nome do produto.

    public Double getPreco() {
        return preco;
    }
    // Retorna o preço do produto.

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    // Altera o preço do produto.

    public Categoria getCategoria() {
        return categoria;
    }
    // Retorna a categoria a que o produto pertence.

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    // Altera a categoria do produto.
}
