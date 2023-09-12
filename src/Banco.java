import java.util.ArrayList;

public class Banco {


    private String nome;
    private String endereco;
    private int agencia;
    public ArrayList<Conta> contas = new ArrayList<>();
    private double juros;
    //Taxa de serviços é o limite de transações que pode fazer
    private double taxaDeServico;

    public Banco(String nome, String endereco, int agencia, double juros, double taxaDeServico) {
        this.nome = nome;
        this.endereco = endereco;
        this.agencia = agencia;
        this.juros = juros;
        this.taxaDeServico = taxaDeServico;

        cadastroConta();
    }


    public void cadastroConta(){
        Poupanca poupanca = new Poupanca(345, "345", 110.00, 3,
                new Juridica(3453453, "fvedfytew", "ana", "rua"));
        contas.add(poupanca);

        Credito credito= new Credito(456, "456", 110.00, 3,
                new Juridica(3453453, "fvedfytew", "ana", "rua"));
        contas.add(credito);

        Corrente corrente = new Corrente(123, "123", 0.00, 5,
                new Juridica(3453453, "fvedfytew", "ana", "rua"));
        contas.add(corrente);

    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public double getTaxaDeServico() {
        return taxaDeServico;
    }

    public Conta buscaConta(int numero, String senha){
        boolean numeroValido = false;
        boolean senhaValida = false;
        for(Conta conta : contas) {
            if (numero == conta.getNumero()) {
                numeroValido = true;
            }
            if (senha.equals(conta.getSenha())) {
                senhaValida = true;
            }
            if(senhaValida && numeroValido){
                System.out.println("Conta encontrada");
                return conta;
            }
        }
        return null;
    }

    public Conta buscaContaRecebedora(int numeroRecebedora){
        for(Conta contaRecebedora : contas) {
            if (numeroRecebedora == contaRecebedora.getNumero()) {
                return contaRecebedora;
            }
        }
        return null;

    }


}
