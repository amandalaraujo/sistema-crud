// Conexao com o Banco e Funções CRUD 'ClienteDAO.java'
/*
    Etapas:
    - Conectar ao SQLite
    - Criar tabela
    - Implementar metodos:
        1. inserirClientes
        2. listarClientes
        3. atualizarCliente
        4. deletarCliente
*/

import java.sql.*; // Importando tudo do pacote java.sql
import java.util.ArrayList; // Implementacao baseada em arrays
import java.util.List; // Colecao ordenada de elementos

public class ClienteDAO{
    private final String URL = "jdbc:sqlite:clientes.db";
    // jdbc: → diz ao Java que esta usando o Java Database Connectivity
    // sqlite: → Diz que o tipo de banco é SQLite
    // clientes.db → Nome do arquivo do banco de dados

    public ClienteDAO() {
        criarTabelaCliente();
    }

    private void criarTabelaCliente() {
        String sql = """
            CREATE TABLE IF NOT EXISTS cliente (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                email TEXT NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(URL); // Abre conexao com o SQLite
             Statement stmt = conn.createStatement()) { // Cria um comando SQL
            stmt.execute(sql); // Executa o SQL que cria a tabela
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }

    // Metodos de Inserir, Atualizar e Deletar Clientes
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, email) VALUES (?, ?)";

        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente " + e.getMessage());
        }
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try(Connection conn = DriverManager.getConnection(URL);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                clientes.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return clientes;
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setInt(3, cliente.getID());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try(Connection conn = DriverManager.getConnection(URL);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("Erro ao deletar cliente " + e.getMessage());
        }
    }
}