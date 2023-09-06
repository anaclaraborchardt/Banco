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

    public void realizarPagamento(){
    }

    //Verifica se a conta em que o usuario está tentando pagar é válida
    public double pagamento(double valorPagamento){
        this.setSaldo(this.getSaldo() - valorPagamento);
        return this.saldo;
    }

    public double credito(double valorCreditado){
        this.setSaldo(this.getSaldo() + valorCreditado);
        return this.saldo;
    }

    public String saldo(){
        return "O saldo atual é R$ " + this.saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    public void setQuantidadeTransacoes(int quantidadeTransacoes) {
        this.setQuantidadeTransacoes(this.getQuantidadeTransacoes() + 1);
    }

    public String menu() {
        return "Digite a operação desejada\n" +
                "1- Pagamento;\n" +
                "2- Crédito;\n" +
                "3- Ver saldo\n";
    }


}
