public class Juridica extends Pessoa{

    private long cnpj;
    private String razaoSocial;

    public Juridica(long cnpj, String razaoSocial, String nome, String endereco){
        super(nome, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }


}
