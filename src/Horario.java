// Classe que representa o horário de uma disciplina com atributos como dia da semana, hora de início, hora de fim, disciplina, professor e turma.

public class Horario {

    // Atributos da classe Horario
    public String diaSemana;
    public String horaInicio;
    public String horaFim;
    public Disciplina disciplina;
    public Professor professor;
    public Turma turma;

    // Construtor da classe Horario
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

    // Método para exibir os dados do horário
    public void exibirDados() {
        System.out.println("Dia da Semana: " + diaSemana);
        System.out.println("Hora de Início: " + horaInicio);
        System.out.println("Hora de Fim: " + horaFim);
        System.out.println("Disciplina: " + disciplina.nome);
        System.out.println("Professor: " + professor.nome);
        System.out.println("Turma: " + turma.nome);
    }
}
