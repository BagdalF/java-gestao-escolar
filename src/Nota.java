// Classe que representa uma nota atribuída a um estudante em uma avaliação.

public class Nota {

    // Atributos da classe Nota
    public Estudante estudante;
    public Avaliacao avaliacao;
    public double valor;

    // Construtor da classe Nota
    public Nota(Estudante estudante, Avaliacao avaliacao, double valor) {
        this.estudante = estudante;
        this.avaliacao = avaliacao;
        this.valor = valor;
    }

    // Método para exibir os dados da nota
    public void exibirDados() {
        System.out.println("Estudante: " + estudante.nome);
        System.out.println("Avaliação: " + avaliacao.nome);
        System.out.println("Valor: " + valor);
    }
}
