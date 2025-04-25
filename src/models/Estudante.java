package models;

// Classe que representa um estudante, herdando atributos de Pessoa e adicionando matrícula, turma, notas e frequências.
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa {

    // Atributos da classe Estudante
    private int matricula;
    private Turma turma;
    private List<Integer> notas;

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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public void setNotas(List<Integer> notas) {
        this.notas = notas;

    // Método para adicionar nota do estudante
    public void adicionarNota(int nota) {
        this.notas.add(nota);
    }

    // Sobrecarga do método adicionarNota
    private void adicionarNota(List<Integer> notas) {
        this.notas.addAll(notas);
    }

    // Método para exibir notas do estudante
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

    @Override
    public void exibirDadosEspecificos() {
        exibirDados();
        System.out.println("Matrícula: " + this.matricula);
    }
}
