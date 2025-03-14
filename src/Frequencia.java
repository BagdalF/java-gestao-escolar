// Classe que representa a frequência de um estudante em uma disciplina em uma data específica.

// Importa a classe LocalDate para manipulação de datas
import java.time.LocalDate;

public class Frequencia {

    // Atributos da classe Frequencia
    public Estudante estudante;
    public Disciplina disciplina;
    public LocalDate data;
    public boolean presente;

    // Construtor da classe Frequencia
    public Frequencia(Estudante estudante, LocalDate data, boolean presente) {
        this.estudante = estudante;
        this.data = data;
        this.presente = presente;
    }

    // Método para exibir os dados da frequência
    public void exibirDados() {
        System.out.println("Estudante: " + estudante.nome);
        System.out.println("Disciplina: " + disciplina.nome);
        System.out.println("Data: " + data);
        System.out.println("Presente: " + presente);
    }

}
