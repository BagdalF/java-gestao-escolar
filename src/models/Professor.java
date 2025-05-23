package models;

// Classe que representa um professor, herdando atributos de Pessoa e adicionando id e disciplinas.
// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos da classe Professor
    private int idProfessor;
    private List<Disciplina> disciplinas;

    // Construtor padrão
    public Professor() {
        super("", "", "", "");
        this.idProfessor = 0;
        this.disciplinas = new ArrayList<>();
    }

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

    // Agregação: Permite acessar a lista de disciplinas associadas à disciplina
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    // Associação: Permite modificar a lista de disciplinas associadas à disciplina
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        disciplina.getProfessores().add(this);
    }

    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
        disciplina.getProfessores().remove(this);
    }

    public void exibirDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }

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

    //Polimorfismo: Sobrescreve o método exibirDados da classe Pessoa
    @Override
    public void exibirDadosEspecificos() {
        exibirDados();
        System.out.println("ID curricular: " + this.idProfessor);
    }
}
