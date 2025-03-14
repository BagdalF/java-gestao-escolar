// Classe que representa um estudante, herdando atributos de Pessoa e adicionando matrícula, turma, notas e frequências.

// Importa a classe ArrayList para manipulação de listas dinâmicas
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa {

    // Atributos da classe Estudante
    public String matricula;
    public Turma turma;
    public List<Nota> notas;
    public List<Frequencia> frequencias;

    // Construtor da classe Estudante
    public Estudante(
            String nome,
            String cpf,
            String email,
            String telefone,
            String matricula,
            Turma turma
    ) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.turma = turma;
        this.notas = new ArrayList<>();
        this.frequencias = new ArrayList<>();
    }

    // Método para adicionar uma nota ao estudante
    public void adicionarNota(Nota nota) {
    }

    // Método para remover uma nota do estudante
    public void removerNota(Frequencia frequencia) {
    }

    // Método para adicionar uma frequência ao estudante
    public void adicionarFrequencia(Nota nota) {
    }

    // Método para remover uma frequência do estudante
    public void removerFrequencia(Frequencia frequencia) {
    }

    // Método para exibir as frequências do estudante
    public void exibirFrequencias() {
    }

    // Método para exibir as notas do estudante
    public void exibirNotas() {
    }

    // Método para calcular a média das notas do estudante
    public double calcularMedia() {
        return 0;
    }
}
