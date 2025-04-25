package models;

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    // Atributos da classe Disciplina
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private List<Professor> professores;
    private List<Turma> turmas;

    // Construtor da classe Disciplina
    public Disciplina(
            int codigo,
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
  
    // Getters and Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    // Método para adicionar uma turma à disciplina
    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    // Método para remover uma turma da disciplina
    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    // Sobrecarga do método adicionarProfessor
    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
        professor.adicionarDisciplina(this);
    }

    private void adicionarProfessor(List<Professor> professores) {
        for (Professor professor : professores) {
            adicionarProfessor(professor); // Reutiliza o método existente
        }
    }

    // Método para remover um professor da disciplina
    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
        professor.removeDisciplina(this);
    }

    // Método para buscar um professor pelo nome
    public Professor buscarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    // Método para exibir turmas da disciplina
    public void exibirTurmas() {
        // Composição: A disciplina mantém uma relação com as turmas
        for (Turma turma : turmas) {
            System.out.println("Turma: " + turma.getNome());
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
