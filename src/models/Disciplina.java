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

    // Agregação: Permite acessar a lista de professores associados à disciplinas
    public List<Professor> getProfessores() {
        return professores;
    }

    // Associação: Permite modificar a lista de disciplinas associadas à professores
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    // Agregação: Permite acessar a lista de turmas associadas à turma
    public List<Turma> getTurmas() {
        return turmas;
    }

    // Associação: Permite modificar a lista de disciplinas associadas à turma
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public void removerTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
        professor.adicionarDisciplina(this);
    }

    // Sobrecarga do método adicionarProfessor
    private void adicionarProfessor(List<Professor> professores) {
        for (Professor professor : professores) {
            adicionarProfessor(professor); // Reutiliza o método existente
        }
    }

    public void removerProfessor(Professor professor) {
        this.professores.remove(professor);
        professor.removeDisciplina(this);
    }

    public Professor buscarProfessorPorNome(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public void exibirTurmas() {
        // Composição: A disciplina mantém uma relação com as turmas
        for (Turma turma : turmas) {
            System.out.println("Turma: " + turma.getNome());
        }
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Carga Horária: " + cargaHoraria);
    }
}
