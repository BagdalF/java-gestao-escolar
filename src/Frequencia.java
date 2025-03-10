
import java.time.LocalDate;

public class Frequencia {

    public Estudante estudante;
    public Disciplina disciplina;
    public LocalDate data;
    public boolean presente;

    public Frequencia(Estudante estudante, LocalDate data, boolean presente) {
        this.estudante = estudante;
        this.data = data;
        this.presente = presente;
    }

    public void exibirDados() {
        System.out.println("Estudante: " + estudante.nome);
        System.out.println("Disciplina: " + disciplina.nome);
        System.out.println("Data: " + data);
        System.out.println("Presente: " + presente);
    }

}
