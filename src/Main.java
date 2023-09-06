import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco("Santo André", "Centro", 543534, 0.5, 0.9);
    static Conta contaLogada;

    public static void main(String[] args) {
        banco.cadastroConta();
        dadosConta();

    }

    public static void dadosConta(){
        boolean numeroValido = false;
        boolean senhaValida = false;
        do {
            System.out.println("Insira o número da conta");
            int numero = sc.nextInt();
            System.out.println("Insira a senha");
            String senha = sc.next();
            for(Conta conta : banco.getContas()) {
                if (numero == conta.getNumero()) {
                    System.out.println("Número válido");
                    numeroValido = true;
                }
                    if (senha.equals(conta.getSenha())) {
                        System.out.println("Senha válida");
                        senhaValida = true;
                }
                if(senhaValida && numeroValido){
                    contaLogada = conta;
                }
            }
        } while (!numeroValido && !senhaValida) ;
            menu();
    }

    public static void menu(){
        System.out.println("Bem vindo Usuário!\n");
        System.out.println(contaLogada);
        int opcao;
            do{
                System.out.println("Digite a operação desejada\n" +
                "1- Pagamento;\n" +
                "2- Crédito;\n" +
                "3- Ver saldo;\n" +
                "4- Transferência;\n" +
                "5- Saque\n" +
                "6- Sair\n");
                opcao = sc.nextInt();

        switch(opcao) {
            case 1 -> pagamento();
            case 2 -> credito();
            case 3 -> System.out.println(contaLogada.saldo());
            case 4 -> transferencia();
            case 5 -> saque();
            case 6 -> System.exit(0);
            }
        }while(opcao != 6);
    }

    private static void credito(){
        System.out.println("Digite o valor a ser depositado ");
        double valorCreditado = sc.nextDouble();
//        implementaTaxaServico();

        System.out.println("Você creditou " + valorCreditado);
        System.out.println("\nSeu saldo agora é R$ " + contaLogada.credito(valorCreditado));
    }

    private static void pagamento(){
        System.out.println("Digite o valor a ser pago: ");
        double valorPagamento = sc.nextDouble();
//        implementaTaxaServico();

        System.out.println("Você pagou " + valorPagamento);
        System.out.println("\nSeu saldo agora é R$ " + contaLogada.pagamento(valorPagamento));
    }

    private static void transferencia(){
        if(contaLogada instanceof Corrente){
            System.out.println("Digite o valor a ser transferido: ");
            double valorTransferencia = sc.nextDouble();
//            implementaTaxaServico();
            System.out.println("Digite o número da conta que deseja transferir");
//            System.out.println("\nSeu saldo agora é R$ " + contaLogada.transferencia(numeroRecebedora, valorTransferencia));
        }else {
            System.out.println("Sua conta não é corrente");
        }
    }

    private static void saque(){
        if(contaLogada instanceof Corrente
                || contaLogada instanceof Poupanca){
            System.out.println("Digite o valor que deseja sacar: ");
            double valorSaque = sc.nextDouble();
//            implementaTaxaServico();
//            System.out.println("\nSeu saldo agora é R$ " + contaLogada.saque(numeroRecebedora, valorTransferencia));

        }else {
            System.out.println("Sua conta não é corrente");
        }
    }

//    private static void implementaTaxaServico() {
//        contaLogada.setQuantidadeTransacoes(contaLogada.getQuantidadeTransacoes());
//        if (contaLogada.getQuantidadeTransacoes() == 3) {
//            contaLogada.setSaldo(contaLogada.getSaldo() - (banco.getTaxaDeServico() * contaLogada.getSaldo()));
//            System.out.println("Será implementada uma taxa de serviço");
//        }
//    }


}
