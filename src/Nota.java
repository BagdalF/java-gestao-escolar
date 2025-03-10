
public class Nota {

    public Estudante estudante;
    public Avaliacao avaliacao;
    public double valor;

    public Nota(Estudante estudante, Avaliacao avaliacao, double valor) {
        this.estudante = estudante;
        this.avaliacao = avaliacao;
        this.valor = valor;
    }

    public void exibirDados() {
        System.out.println("Estudante: " + estudante.nome);
        System.out.println("Avaliação: " + avaliacao.nome);
        System.out.println("Valor: " + valor);
    }
}
