
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {

    public int idProfessor;
    public List<Disciplina> disciplinas;

    public Professor(
            String nome,
            String cpf,
            String email,
            String telefone,
            int idProfessor
    ) {
        super(nome, cpf, email, telefone);

        this.idProfessor = idProfessor;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
    }

    public void removeDisciplina(Disciplina disciplina) {
    }

    public void exibirDisciplinas() {
    }

    public void obterTurmas() {
    }
}
