import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco("Santo André", "Centro", 543534, 0.5, 0.9);
    static Conta contaLogada;

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Banco");
        dadosConta();
    }

    public static void dadosConta(){
        System.out.println(banco.getContas());
        do {

            //Solicita ao usuário o número e a senha da conta
            System.out.println("Insira o número da conta");
            int numero = sc.nextInt();
            System.out.println("Insira a senha");
            String senha = sc.next();

                    //variável para buscar a conta
                    Conta validaConta = banco.buscaConta(numero, senha);

                    //se o retorno for uma conta, ou seja, diferente de nulo,
                    //ele atribui a conta logada à conta que foi encontrada
                    if (validaConta != null) {
                        contaLogada = validaConta;
                    }

        } while (contaLogada == null);
        menu();
    }

    public static void menu(){
        System.out.println("Bem vindo " + contaLogada.getTitular() + "!");
        System.out.println(contaLogada);
        System.out.println(contaLogada.getQuantidadeTransacoes());

        int opcao;
            do{
                System.out.println("Digite a operação desejada");
                //Pegando o menu das classes, ele vai retornar as opções que cada classe tem
                System.out.println(contaLogada.menu());
                opcao = sc.nextInt();

        switch(opcao) {
            case 1 -> pagamento();
            case 2 -> credito();
            case 3 -> System.out.println(contaLogada.saldo());
            case 4 -> transferencia();
            case 5 -> saque();
            case 6 -> System.exit(0);
            }
            quantidadeTransacoes();
        }while(opcao != 6);
    }

    private static void credito(){
        System.out.println("Digite o valor a ser depositado ");
        double valorCreditado = sc.nextDouble();
        contaLogada.setQuantidadeTransacoes();

        System.out.println("Você creditou " + valorCreditado);
        System.out.println("\nSeu saldo agora é R$ " + contaLogada.credito(valorCreditado));
    }

    private static void pagamento(){
        System.out.println("Digite o valor a ser pago: ");
        double valorPagamento = sc.nextDouble();
        contaLogada.setQuantidadeTransacoes();

        System.out.println("Você pagou " + valorPagamento);
        System.out.println("\nSeu saldo agora é R$ " + contaLogada.pagamento(valorPagamento));
    }

    private static void transferencia(){
        if(contaLogada instanceof Corrente){
            System.out.println("Digite o valor a ser transferido: ");
            double valorTransferencia = sc.nextDouble();
            System.out.println("Digite o número da conta que deseja transferir");
            int numeroRecebedora = sc.nextInt();
            if(banco.buscaContaRecebedora(numeroRecebedora) != null) {
                Conta contaRecebedora;
                contaRecebedora = banco.buscaContaRecebedora(numeroRecebedora);
                contaLogada.setQuantidadeTransacoes();
                System.out.println("\nSeu saldo agora é R$ " + ((Corrente) contaLogada).transferencia(contaRecebedora, valorTransferencia));
            }else{
                System.out.println("Conta não encontrada");
            }
            }else {
            System.out.println("Sua conta não é corrente");
        }
    }

    private static void saque(){
        if(contaLogada instanceof Corrente
                || contaLogada instanceof Poupanca){
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = sc.nextDouble();
            contaLogada.setQuantidadeTransacoes();
            if(contaLogada instanceof Corrente) {
                System.out.println("\nSeu saldo agora é R$ " + ((Corrente) contaLogada).saque(valorSaque));
            }else{
                System.out.println("\nSeu saldo agora é R$ " + ((Poupanca) contaLogada).saque(valorSaque));
            }

        }else {
            System.out.println("Sua conta não é corrente, nem poupança");
        }
    }

    private static void quantidadeTransacoes() {
        int quantidadeTransacoes = contaLogada.getQuantidadeTransacoes();

        System.out.println("Você ainda pode fazer " + quantidadeTransacoes + " transações hoje sem pagar taxas");

        if (quantidadeTransacoes == 0) {
            System.out.println("Você já atingiu o limite de transações, a partir de agora será cobrado uma taxa de R$ " + banco.getTaxaDeServico());
            double taxa = banco.getTaxaDeServico() * contaLogada.getSaldo();
            contaLogada.setSaldo(contaLogada.getSaldo() - taxa);
        }
    }
}

