// Este arquivo implementa o padrão de projeto Adapter, que permite que um objeto Estudante seja tratado como um Professor.
// Ele adapta a interface de Estudante para ser compatível com a de Professor, facilitando a reutilização de código.

package models;

// Adapter: Permite que um Estudante seja tratado como um Professor
public class EstudanteParaProfessorAdapter extends Professor {

    private Estudante estudante;

    // O construtor adapta os dados de Estudante para o formato esperado por Professor
    public EstudanteParaProfessorAdapter(Estudante estudante, int idProfessor) {
        // Chama o construtor de Professor usando dados do estudante
        super(estudante.getNome(), estudante.getCpf(), estudante.getEmail(), estudante.getTelefone(), idProfessor);
        this.estudante = estudante;
    }

    // Sobrescreve métodos de Professor para usar dados do Estudante
    @Override
    public void exibirDadosEspecificos() {
        System.out.println("Este professor foi promovido a partir de um estudante.");
        estudante.exibirDadosEspecificos();
    }
}
