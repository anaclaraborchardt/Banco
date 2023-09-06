public class Corrente extends Conta{

    private final int quantidadeTransacoes;
    private double limite;

    public Corrente(int numero, String senha, double saldo, int quantidadeTransacoes, Pessoa titular) {
        super(numero, senha, saldo, quantidadeTransacoes, titular);
        this.quantidadeTransacoes = quantidadeTransacoes;
    }

    public double saque(double valorSaque){
        this.setSaldo(this.getSaldo() - valorSaque);
        return getSaldo();
    }

    public String transferencia(int numeroRecebedora, double valorTransferencia){
        Conta contaRecebedora;
        for(Conta conta : Main.banco.getContas()) {
            if (numeroRecebedora == conta.getNumero()){
                contaRecebedora = Main.banco.getContas().get(numeroRecebedora);
                contaRecebedora.setSaldo(contaRecebedora.getSaldo() + valorTransferencia);
                Main.contaLogada.setSaldo(Main.contaLogada.getSaldo() - valorTransferencia);
                return "Seu novo saldo é ";

            }
        }
        return "A conta não existe";
    }

    @Override
    public String menu() {
        return super.menu() + "4- Saque; 5- Transferência";
    }

}
