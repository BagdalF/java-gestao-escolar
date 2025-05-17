package models;

public class EstudanteParaProfessorAdapter extends Professor {

    private Estudante estudante;

    public EstudanteParaProfessorAdapter(Estudante estudante, int idProfessor) {
        // Chama o construtor de Professor usando dados do estudante
        super(estudante.getNome(), estudante.getCpf(), estudante.getEmail(), estudante.getTelefone(), idProfessor);
        this.estudante = estudante;
    }

    // Se necessário, sobrescreva métodos de Professor para usar dados do estudante
    @Override
    public void exibirDadosEspecificos() {
        System.out.println("Este professor foi promovido a partir de um estudante.");
        estudante.exibirDadosEspecificos();
    }
}
