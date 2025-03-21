// Classe que representa um estudante, herdando atributos de Pessoa e adicionando matrícula, turma, notas e frequências.

public class Estudante extends Pessoa {

    // Atributos da classe Estudante
    public String matricula;
    public Turma turma;

    // Construtor da classe Estudante
    public Estudante(
            String nome,
            String cpf,
            String email,
            String telefone,
            String matricula,
            Turma turma
    ) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.turma = turma;
    }

    // Método para exibir dados do estudante
    public void exibirDados() {
    }
}
