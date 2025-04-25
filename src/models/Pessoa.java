package models;

// Classe abstrata que representa uma pessoa com atributos básicos como nome, CPF, email e telefone.
public abstract class Pessoa {

    // Atributos da classe Pessoa
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    // Construtor da classe Pessoa
    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método para atualização dos dados da pessoa
    public void atualizarContato(String novoEmail, String novoTelefone) {
        this.email = novoEmail;
        this.telefone = novoTelefone;
    }

    // Método para exibir os dados da pessoa
    // Polimorfismo: Este método pode ser sobrescrito por subclasses
    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefone: " + this.telefone);
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract void exibirDadosEspecificos();
}
