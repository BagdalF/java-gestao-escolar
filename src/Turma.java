// Classe que representa uma turma com atributos como id, nome, avaliações, disciplinas e estudantes.

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Turma {

    // Atributos da classe Turma
    public int idTurma;
    public String nome;
    public List<Disciplina> disciplinas;
    public List<Estudante> estudantes;

    // Construtor da classe Turma
    public Turma(int idTurma, String nome, List<Disciplina> disciplinas) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.estudantes = new ArrayList<>();
    }

    // Método para adicionar um estudante à turma
    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
        estudante.turma = this;
    }

    // Método para remover um estudante da turma
    public void removerEstudante(Estudante estudante) {
        this.estudantes.remove(estudante);
        estudante.turma = null;
    }

    // Método para exibir os estudantes da turma
    public void exibirEstudantes() {
        for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }

    // Método para buscar um estudante pelo nome
    public Estudante buscarEstudantePorNome(String nome) {
        for (Estudante estudante : estudantes) {
            if (estudante.nome.equalsIgnoreCase(nome)) {
                return estudante;
            }
        }
        return null; 
    }
    
    // Método para exibir as disciplinas da turma
    public void exibirDisciplinas() {
        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }
    
}
