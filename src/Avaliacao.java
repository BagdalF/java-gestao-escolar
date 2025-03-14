// Classe que representa uma avaliação com atributos como id, nome, data, peso e disciplina.

// Importa a classe LocalDate para manipulação de datas
import java.time.LocalDate;

public class Avaliacao {

    // Atributos da classe Avaliacao
    public int idAvaliacao;
    public String nome;
    public LocalDate data;
    public double peso;
    public Disciplina disciplina;

    // Construtor da classe Avaliacao
    public Avaliacao(
            int idAvaliacao,
            String nome,
            LocalDate data,
            double peso,
            Disciplina disciplina
    ) {
        this.idAvaliacao = idAvaliacao;
        this.nome = nome;
        this.data = data;
        this.peso = peso;
        this.disciplina = disciplina;
    }

    // Método para exibir os dados da avaliação
    public void exibirDados() {
        System.out.println("ID: " + idAvaliacao);
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Peso: " + peso);
        System.out.println("Disciplina: " + disciplina.nome);
    }

}
