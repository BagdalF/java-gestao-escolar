
import java.util.ArrayList;
import java.util.List;

public class Turma {

    public String idTurma;
    public String nome;
    public List<Avaliacao> avaliacoes;
    public List<Disciplina> disciplinas;
    public List<Estudante> estudantes;

    public Turma(String idTurma, String nome, List<Disciplina> disciplinas) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.estudantes = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
    }

    public void adicionarEstudante(Estudante estudante) {
    }

    public void removerEstudante(Estudante estudante) {
    }

    public void exibirEstudantes() {
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
    }

    public void removerAvaliacao(Avaliacao avaliacao) {
    }

    public void exibirAvaliacoes() {
    }

    public void exibirHorarios() {
    }

}
