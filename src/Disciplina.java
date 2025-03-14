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
    public List<Horario> horarios;

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
        this.horarios = new ArrayList<>();
    }

    // Método para adicionar uma turma à disciplina
    public void adicionarTurma(Turma turma) {
    }

    // Método para remover uma turma da disciplina
    public void removerTurma(Turma turma) {
    }

    // Método para adicionar um professor à disciplina
    public void adicionarProfessor(Professor professor) {
    }

    // Método para remover um professor da disciplina
    public void removerProfessor(Professor professor) {
    }

    // Método para adicionar um horário à disciplina
    public void adicionarHorario(Horario horario) {
    }

    // Método para remover um horário da disciplina
    public void removerHorario(Horario horario) {
    }

    // Método para exibir os dados da disciplina
    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Carga Horária: " + cargaHoraria);
    }
}
