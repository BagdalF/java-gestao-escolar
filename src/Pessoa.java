
public class Pessoa {

    public String nome;
    public String cpf;
    public String email;
    public String telefone;

    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefone: " + this.telefone);
    }
}
