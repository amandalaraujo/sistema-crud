import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ClienteDAO c1 = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n*--- Menu ---*");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Cliente");
            System.out.println("3 - Atualizar Cliente");
            System.out.println("4 - Deletar Cliente");
            System.out.println("5 - Sair");
            System.out.println("Informe a opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch(opcao) {
                case 1 -> {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    Cliente novo = new Cliente(nome, email);
                    c1.inserir(novo);
                    System.out.println("Cliente cadastrado com sucesso!");
                }

                case 2 -> {
                    List<Cliente> clientes = c1.listar();
                    System.out.println("\n *--- Lista de Clientes ---*");
                    for(Cliente c : clientes) {
                        System.out.println(c); // Usa o toString()
                    }
                }

                case 3 -> {
                    System.out.println("ID do Cliente a atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.println("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Novo email: ");
                    String email = scanner.nextLine();

                    Cliente atualizado = new Cliente(id, nome, email);
                    c1.atualizar(atualizado);
                    System.out.println("Cliente atualizado!");
                }

                case 4 -> {
                    System.out.println("ID do cliente a deletar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    c1.deletar(id);
                    System.out.println("Cliente deletado!");
                }

                case 5 -> System.out.println("Saindo...");

                default -> System.out.println("Opcao invalida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}