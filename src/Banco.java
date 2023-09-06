import java.util.ArrayList;

public class Banco {

    private String nome;
    private String endereco;
    private int agencia;
    private ArrayList<Conta> contas = new ArrayList<>();
    private double juros;
    //Taxa de serviços é o limite de transações que pode fazer
    private double taxaDeServico;
    public Banco(String nome, String endereco, int agencia, double juros, double taxaDeServico) {
        this.nome = nome;
        this.endereco = endereco;
        this.agencia = agencia;
        this.juros = juros;
        this.taxaDeServico = taxaDeServico;

        Corrente corrente = new Corrente(123, "123", 0.00, 5,
                new Juridica(3453453, "fvedfytew"));
        contas.add(corrente);

        Poupanca poupanca = new Poupanca(345, "345", 110.00, 3,
                new Juridica(3453453, "fvedfytew"));
        contas.add(poupanca);

        Credito credito= new Credito(345, "345", 110.00, 3,
                new Juridica(3453453, "fvedfytew"));
        contas.add(credito);
    }


    public void verificacaoConta(){

    }

}
