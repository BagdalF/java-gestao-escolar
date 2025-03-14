// Classe que representa uma turma com atributos como id, nome, avaliações, disciplinas e estudantes.

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Turma {

    // Atributos da classe Turma
    public int idTurma;
    public String nome;
    public List<Avaliacao> avaliacoes;
    public List<Disciplina> disciplinas;
    public List<Estudante> estudantes;

    // Construtor da classe Turma
    public Turma(int idTurma, String nome, List<Disciplina> disciplinas) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.estudantes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    // Método para adicionar um estudante à turma
    public void adicionarEstudante(Estudante estudante) {
    }

    // Método para remover um estudante da turma
    public void removerEstudante(Estudante estudante) {
    }

    // Método para exibir os estudantes da turma
    public void exibirEstudantes() {
    }

    // Método para adicionar uma avaliação à turma
    public void adicionarAvaliacao(Avaliacao avaliacao) {
    }

    // Método para remover uma avaliação da turma
    public void removerAvaliacao(Avaliacao avaliacao) {
    }

    // Método para exibir as avaliações da turma
    public void exibirAvaliacoes() {
    }

    // Método para exibir as avaliações de uma disciplina na turma
    public void exibirAvaliacoesDisciplina() {
    }

    // Método para exibir os horários da turma
    public void exibirHorarios() {
    }

}
