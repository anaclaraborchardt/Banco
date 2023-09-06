public class Credito extends Conta {

    private int diaFatura;
    private double limite;

    public Credito(int numero, String senha, double saldo, int quantidadeTransacoes, Pessoa titular) {
        super(numero, senha, saldo, quantidadeTransacoes, titular);
    }
}
