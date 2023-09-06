import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        dadosConta();
    }

    public static void dadosConta(){
        int tentativas = 0;
        do {
            System.out.println("Insira o número da conta");
            int numero = sc.nextInt();
            while (tentativas < 3) {
            System.out.println("Insira a senha");
            String senha = sc.next();

                boolean encontrado = false;
                    if (senha.equals(pessoa.getSenha())) {
                        encontrado = true;
                        System.out.println("Bem-vindo!");
                        break;
                    } else {
                        System.out.println("Senha incorreta. Tente novamente.");
                        tentativas++;
                    }
                }


        }while(!true);

    }

}
