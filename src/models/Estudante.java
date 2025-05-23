package models;

// Classe que representa um estudante, herdando atributos de Pessoa e adicionando matrícula, turma, notas e frequências.
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estudante extends Pessoa implements Serializable {
    private static final long serialVersionUID = 3L;

    // Atributos da classe Estudante
    private int matricula;
    private Turma turma;
    private List<Integer> notas;

    // Construtor padrão
    public Estudante() {
        super("", "", "", "");
        this.matricula = 0;
        this.turma = null;
        this.notas = new ArrayList<>();
    }

    // Construtor da classe Estudante
    public Estudante(
            String nome,
            String cpf,
            String email,
            String telefone,
            int matricula,
            Turma turma,
            List<Integer> notas
    ) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.turma = turma;
        this.notas = new ArrayList<>();
    }

    // Getters and Setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Agregação: Permite acessar a turma associada à turma
    public Turma getTurma() {
        return turma;
    }

    // Associação: Permite modificar a turma do estudante e atualiza a relação na turma
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;
    }

    public void adicionarNota(int nota) {
        this.notas.add(nota);
    }

    // Sobrecarga do método adicionarNota
    public void adicionarNota(List<Integer> notas) {
        Collections.addAll(this.notas, notas.toArray(new Integer[0]));
    }

    public void exibirNotas() {
        for (int i = 0; i < this.notas.size(); i++) {
            System.out.println("Nota " + (i + 1) + ": " + this.notas.get(i));
        }
        System.out.println("Nota Média:" + calcularMedia());
    }

    private float calcularMedia() {
        float soma = 0;
        for (int nota : this.notas) {
            soma += nota;
        }
        return soma / this.notas.size();
    }

    // Método para verificar se o estudante está em mais de uma turma
    public boolean estaEmMaisDeUmaTurma(List<Turma> outrasTurmas) {
        for (Turma outraTurma : outrasTurmas) {
            if (!Collections.disjoint(Collections.singleton(this), outraTurma.getEstudantes())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void exibirDadosEspecificos() {
        exibirDados();
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Turma: " + this.turma.getNome());

        exibirNotas();
    }

    public void exibirDadosEspecificos(List<Turma> outrasTurmas) {
        exibirDados();
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Turma: " + this.turma.getNome());
        if (estaEmMaisDeUmaTurma(outrasTurmas)) {
            System.out.println("O estudante está em mais de uma turma.");
        }
        exibirNotas();
    }
}
