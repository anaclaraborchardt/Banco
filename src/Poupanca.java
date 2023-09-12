public class Poupanca extends Conta{


    public Poupanca(int numero, String senha, double saldo, int quantidadeTransacoes, Pessoa titular) {
        super(numero, senha, saldo, quantidadeTransacoes, titular);
    }

    public double saque(double valorSaque){
        this.setSaldo(this.getSaldo() - valorSaque);
        return getSaldo();
    }

    @Override
    public String menu() {
        return super.menu() + "4- Saque";
    }
}
