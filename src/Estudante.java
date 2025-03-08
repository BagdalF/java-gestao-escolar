
import java.util.ArrayList;
import java.util.List;

public class Estudante extends Pessoa {

    public String matricula;
    public Turma turma;
    public List<Nota> notas;
    public List<Frequencia> frequencias;

    public Estudante(
            String nome,
            String cpf,
            String email,
            String telefone,
            String matricula,
            Turma turma
    ) {
        super(nome, cpf, email, telefone);
        this.matricula = matricula;
        this.turma = turma;
        this.notas = new ArrayList<>();
        this.frequencias = new ArrayList<>();
    }

    public double calcularMedia() {
        return 0;
    }
}
