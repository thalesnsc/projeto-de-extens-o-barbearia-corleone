import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private String statusPagamento;

    public Cliente(String nome, String statusPagamento) {
        this.nome = nome;
        this.statusPagamento = statusPagamento;
    }

    public String getNome() {
        return nome;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + " | Status de Pagamento: " + statusPagamento);
    }
}

class BarbeariaCorleone {
    private ArrayList<Cliente> clientes;

    public BarbeariaCorleone() {
        clientes = new ArrayList<>();
        inicializarClientes();
    }

    private void inicializarClientes() {
        // Adicionando 5 clientes para exemplo
        clientes.add(new Cliente("João", "Pago"));
        clientes.add(new Cliente("Pedro", "Devendo"));
        clientes.add(new Cliente("Carlos", "Não-pagou"));
        clientes.add(new Cliente("Lucas", "Pago"));
        clientes.add(new Cliente("Henrique", "Não-pagou"));
    }

    public void exibirClientes() {
        System.out.println("Lista de clientes e seus status de pagamento:");
        for (Cliente cliente : clientes) {
            cliente.exibirDetalhes();
        }
    }

    public void atualizarStatusPagamento(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Cliente encontrado: " + cliente.getNome());
                System.out.println("Status atual: " + cliente.getStatusPagamento());
                System.out.print("Digite o novo status (Pago/Devendo/Não-pagou): ");
                String novoStatus = sc.nextLine();
                cliente.setStatusPagamento(novoStatus);
                System.out.println("Status de pagamento atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void consultarStatusCliente(String nomeCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                cliente.exibirDetalhes();
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }
}

public class SistemaPDVBarbearia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarbeariaCorleone barbearia = new BarbeariaCorleone();

        while (true) {
            System.out.println("\n--- Sistema PDV - Barbearia Corleone ---");
            System.out.println("1. Exibir todos os clientes");
            System.out.println("2. Consultar status de pagamento de um cliente");
            System.out.println("3. Atualizar status de pagamento de um cliente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    barbearia.exibirClientes();
                    break;
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeConsulta = scanner.nextLine();
                    barbearia.consultarStatusCliente(nomeConsulta);
                    break;
                case 3:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeAtualizar = scanner.nextLine();
                    barbearia.atualizarStatusPagamento(nomeAtualizar);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
