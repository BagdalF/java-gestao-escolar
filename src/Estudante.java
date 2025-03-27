// Classe que representa um estudante, herdando atributos de Pessoa e adicionando matrícula, turma, notas e frequências.

import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa {

    // Atributos da classe Estudante
    public String matricula;
    public Turma turma;
    public List<Integer> notas;

    // Construtor da classe Estudante
    public Estudante(
            String nome,
            String cpf,
            String email,
            String telefone,
            String matricula,
            Turma turma,
            List<Integer> notas
    ) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.turma = turma;
        this.notas = new ArrayList<Integer>();
    }

    // Método para exibir dados do estudante
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Turma: " + (this.turma != null ? this.turma.nome : "Sem turma"));
    }

    // Método para adicionar nota do estudante
    public void adicionarNota(int nota) {
        this.notas.add(nota);
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
}
