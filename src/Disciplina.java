// Classe que representa uma disciplina com atributos como código, nome, descrição e carga horária.

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    // Atributos da classe Disciplina
    public String codigo;
    public String nome;
    public String descricao;
    public int cargaHoraria;
    public List<Professor> professores;
    public List<Turma> turmas;

    // Construtor da classe Disciplina
    public Disciplina(
            String codigo,
            String nome,
            String descricao,
            int cargaHoraria
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    // Método para adicionar uma turma à disciplina
    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    // Método para remover uma turma da disciplina
    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    // Método para adicionar um professor à disciplina
    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
        professor.adicionarDisciplina(this);
    }

    // Método para remover um professor da disciplina
    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
        professor.removeDisciplina(this);
    }

    // Método para buscar um professor pelo nome
    public Professor buscarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.nome.equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    // Método para exibir turmas da disciplina
    public void exibirTurmas() {
        for (Turma turma : turmas) {
            System.out.println("Turma: " + turma.nome);
        }
    }

    // Método para exibir os dados da disciplina
    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Carga Horária: " + cargaHoraria);
    }
}
