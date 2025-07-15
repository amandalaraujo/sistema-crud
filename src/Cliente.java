// Cliente.java Define a estrutura do objeto (campos: nome, email...)

public class Cliente {
    private int id;
    private String nome;
    private String email;

    // Construtor padrao (sem parametros)
    public Cliente() {
    }
    // Construtor sem ID (para inserir novos clientes)
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    // Construtor com ID (para buscar ou editar clientes existentes)
    public Cliente(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente [ id= " + id + ", nome= " + nome + ", email=" + email + " ]";
    }
}