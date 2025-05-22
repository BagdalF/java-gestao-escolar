// Este arquivo implementa o padrão de projeto Factory Method, que é utilizado para criar objetos de forma encapsulada.
// Ele fornece métodos estáticos para instanciar diferentes entidades do sistema, como Professor, Estudante, Disciplina e Turma.

package models;

import java.util.ArrayList;
import java.util.List;

public class EntityFactory {

    // Factory Method: Cria instâncias de Professor
    public static Professor criarProfessor(String nome, String cpf, String email, String telefone, int idProfessor) {
        return new Professor(nome, cpf, email, telefone, idProfessor);
    }

    // Factory Method: Cria instâncias de Estudante
    public static Estudante criarEstudante(String nome, String cpf, String email, String telefone, int matricula, Turma turma, List<Integer> notas) {
        if (notas == null) {
            notas = new ArrayList<>();
        }
        return new Estudante(nome, cpf, email, telefone, matricula, turma, notas);
    }

    // Factory Method: Cria instâncias de Disciplina
    public static Disciplina criarDisciplina(int codigo, String nome, String descricao, int cargaHoraria) {
        return new Disciplina(codigo, nome, descricao, cargaHoraria);
    }

    // Factory Method: Cria instâncias de Turma
    public static Turma criarTurma(int idTurma, String nome, List<Disciplina> disciplinas) {
        return new Turma(idTurma, nome, disciplinas);
    }
}
