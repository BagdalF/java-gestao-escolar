
import java.time.LocalDate;

public class Avaliacao {

    public int idAvaliacao;
    public String nome;
    public LocalDate data;
    public double peso;
    public Disciplina disciplina;

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

    public void exibirDados() {
        System.out.println("ID: " + idAvaliacao);
        System.out.println("Nome: " + nome);
        System.out.println("Data: " + data);
        System.out.println("Peso: " + peso);
        System.out.println("Disciplina: " + disciplina.nome);
    }

}
