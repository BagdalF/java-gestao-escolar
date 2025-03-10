
import java.util.ArrayList;
import java.util.List;

public class Disciplina {

    public String codigo;
    public String nome;
    public String descricao;
    public int cargaHoraria;
    public List<Professor> professores;
    public List<Turma> turmas;
    public List<Horario> horarios;

    public Disciplina(
            String codigo,
            String nome,
            String descricao,
            int cargaHoraria,
            List<Professor> professores,
            List<Turma> turmas
    ) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professores = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
    }

    public void removerTurma(Turma turma) {
    }

    public void adicionarProfessor(Turma turma) {
    }

    public void removerProfessor(Turma turma) {
    }

    public void adicionarHorario(Horario horario) {
    }

    public void removerHorario(Horario horario) {
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Carga Horária: " + cargaHoraria);
    }
}
