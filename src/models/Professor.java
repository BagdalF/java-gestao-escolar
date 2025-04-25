package models;

// Classe que representa um professor, herdando atributos de Pessoa e adicionando id e disciplinas.
// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    // Atributos da classe Professor
    private int idProfessor;
    // Agregação: Um professor pode possuir uma lista de disciplinas
    private List<Disciplina> disciplinas;

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

    // Getters and Setters
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    // Método para adicionar uma disciplina ao professor
    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        disciplina.getProfessores().add(this);
    }

    // Método para remover uma disciplina do professor
    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
        disciplina.getProfessores().remove(this);
    }

    // Método para exibir as disciplinas do professor
    public void exibirDisciplinas() {
        // Agregação: Chama o método exibirDados de cada disciplina
        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }

    // Método para buscar disciplina por código
    public Disciplina buscarDisciplinaPorCodigo(int codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo() == codigo) {
                return disciplina;
            }
        }
        return null;
    }

    // Método para obter as turmas do professor
    public void obterTurmas() {
        for (Disciplina disciplina : disciplinas) {
            for (Turma turma : disciplina.getTurmas()) {
                System.out.println("Turma: " + turma.getNome());
            }
        }
    }

    @Override
    public void exibirDadosEspecificos() {
        exibirDados();
        System.out.println("ID curricular: " + this.idProfessor);
    }
}
