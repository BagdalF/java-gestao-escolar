package models;

// Classe que representa uma turma com atributos como id, nome, avaliações, disciplinas e estudantes.
// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Serializable {
    private static final long serialVersionUID = 4L;

    // Atributos da classe Turma
    private int idTurma;
    private String nome;
    // Composição: Uma turma possui uma lista de disciplinas e estudantes
    private List<Disciplina> disciplinas;
    private List<Estudante> estudantes;

    // Construtor da classe Turma
    public Turma(int idTurma, String nome, List<Disciplina> disciplinas) {
        this.idTurma = idTurma;
        this.nome = nome;
        this.disciplinas = disciplinas;
        this.estudantes = new ArrayList<>();
    }

    // Getters and Setters
    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    // Associação: Adiciona um estudante à turma e atualiza a relação no estudante
    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
        estudante.setTurma(this);
    }

    // Sobrecarga do método adicionarEstudante
    private void adicionarEstudante(List<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            adicionarEstudante(estudante);
        }
    }

    // Composição: Remove um estudante da turma e atualiza a relação no estudante
    public void removerEstudante(Estudante estudante) {
        this.estudantes.remove(estudante);
        estudante.setTurma(null);
    }

    public void exibirEstudantes() {
        for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }

    // Método para buscar um estudante pelo nome
    public Estudante buscarEstudantePorNome(String nome) {
        for (Estudante estudante : estudantes) {
            if (estudante.getNome().equalsIgnoreCase(nome)) {
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
