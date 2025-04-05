package models;

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
        this.disciplinas.add(disciplina);
        disciplina.professores.add(this);
    }

    // Método para remover uma disciplina do professor
    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
        disciplina.professores.remove(this);
    }

    // Método para exibir as disciplinas do professor
    public void exibirDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }

    // Método para buscar disciplina por código
    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.codigo.equalsIgnoreCase(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    // Método para obter as turmas do professor
    public void obterTurmas() {
        for (Disciplina disciplina : disciplinas) {
            for (Turma turma : disciplina.turmas) {
                System.out.println("Turma: " + turma.nome);
            }
        }
    }
}
