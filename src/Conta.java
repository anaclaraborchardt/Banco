import java.util.ArrayList;

public class Conta {

    private int numero;
    private String senha;
    private double saldo;
    private int quantidadeTransacoes;
    private Pessoa titular;

    public Conta(int numero, String senha, double saldo, int quantidadeTransacoes, Pessoa titular) {
        this.numero = numero;
        this.quantidadeTransacoes = quantidadeTransacoes;
        this.saldo = saldo;
        this.senha = senha;
        this.titular = titular;
    }

    public void pagamento(){

    }

    public void debito(){

    }

    public void saldo(){

    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }
}
