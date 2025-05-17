package models;

import java.util.ArrayList;
import java.util.List;

public class EntityFactory {

    public static Professor criarProfessor(String nome, String cpf, String email, String telefone, int idProfessor) {
        return new Professor(nome, cpf, email, telefone, idProfessor);
    }

    public static Estudante criarEstudante(String nome, String cpf, String email, String telefone, int matricula, Turma turma, List<Integer> notas) {
        if (notas == null) {
            notas = new ArrayList<>();
        }
        return new Estudante(nome, cpf, email, telefone, matricula, turma, notas);
    }

    public static Disciplina criarDisciplina(int codigo, String nome, String descricao, int cargaHoraria) {
        return new Disciplina(codigo, nome, descricao, cargaHoraria);
    }

    public static Turma criarTurma(int idTurma, String nome, List<Disciplina> disciplinas) {
        return new Turma(idTurma, nome, disciplinas);
    }
}
