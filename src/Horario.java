
public class Horario {

    public String diaSemana;
    public String horaInicio;
    public String horaFim;
    public Disciplina disciplina;
    public Professor professor;
    public Turma turma;

    public Horario(
            String diaSemana,
            String horaInicio,
            String horaFim,
            Disciplina disciplina,
            Professor professor,
            Turma turma
    ) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.disciplina = disciplina;
        this.professor = professor;
        this.turma = turma;
    }

    public void exibirDados() {
        System.out.println("Dia da Semana: " + diaSemana);
        System.out.println("Hora de Início: " + horaInicio);
        System.out.println("Hora de Fim: " + horaFim);
        System.out.println("Disciplina: " + disciplina.nome);
        System.out.println("Professor: " + professor.nome);
        System.out.println("Turma: " + turma.nome);
    }
}
