public class Corrente extends Conta{
    private double limite;

    public Corrente(int numero, String senha, double saldo, int quantidadeTransacoes, Pessoa titular) {
        super(numero, senha, saldo, quantidadeTransacoes, titular);
    }

    public String saque(double valorSaque){
        double novoSaldo = this.getSaldo() - valorSaque;
        if(novoSaldo<0){
            return "Saldo insuficiente";
        }
        this.setSaldo(this.getSaldo() - valorSaque);
        return "getSaldo()";
    }

    public double transferencia(Conta contaRecebedora, double valorTransferencia){
                Main.contaLogada.setSaldo(Main.contaLogada.getSaldo() - valorTransferencia);
                contaRecebedora.setSaldo(contaRecebedora.getSaldo() + valorTransferencia);

                return Main.contaLogada.getSaldo();
    }

    @Override
    public String menu() {
        return super.menu() + "4- Saque;" +
                "\n 5- Transferência";
    }

}
