// Classe que representa um professor, herdando atributos de Pessoa e adicionando id e disciplinas.

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    // Atributos da classe Professor
    public int idProfessor;
    public List<Disciplina> disciplinas;

    // Construtor da classe Professor
    public Professor(
            String nome,
            String cpf,
            String email,
            String telefone,
            int idProfessor
    ) {
        super(nome, cpf, email, telefone);

        this.idProfessor = idProfessor;
        this.disciplinas = new ArrayList<>();
    }

    // Método para adicionar uma disciplina ao professor
    public void adicionarDisciplina(Disciplina disciplina) {
    }

    // Método para remover uma disciplina do professor
    public void removeDisciplina(Disciplina disciplina) {
    }

    // Método para exibir as disciplinas do professor
    public void exibirDisciplinas() {
    }

    // Método para obter as turmas do professor
    public void obterTurmas() {
    }
}
