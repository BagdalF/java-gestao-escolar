package controllers;

// Nova classe para gerenciar disciplinas
import java.util.List;
import java.util.Scanner;
import models.*;

public class DisciplinaController {

    // Funções para Disciplinas
    public static void cadastrarDisciplina(Scanner scanner, List<Disciplina> disciplinas) {
        System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição da disciplina: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a carga horária da disciplina: ");
        int cargaHoraria = scanner.nextInt();

        Disciplina disciplina = new Disciplina(codigo, nome, descricao, cargaHoraria);
        disciplinas.add(disciplina); // Adiciona a disciplina à lista de disciplinas
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    public static void exibirDisciplinas(List<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }

    public static void exibirDadosDisciplina(Scanner scanner, List<Disciplina> disciplinas) {
                System.out.print("Digite o código da disciplina: ");
        String codigo = scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);

        if (disciplina != null) {
            disciplina.exibirDados();
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public static void exibirDadosDisciplinaTurma(Scanner scanner, List<Disciplina> disciplinas, List<Turma> turmas) {
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        if (disciplina != null) {
            System.out.println("Dados da Disciplina:");
            disciplina.exibirDados();
            System.out.println("Turmas associadas:");
            disciplina.exibirTurmas();
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public static void adicionarProfessorDisciplina(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        // Composição: Uma disciplina possui uma lista de professores
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        Professor professor = professores.stream()
                .filter(p -> p.idProfessor == idProfessor)
                .findFirst()
                .orElse(null);

        if (disciplina != null && professor != null) {
            disciplina.adicionarProfessor(professor);
            System.out.println("Professor adicionado à disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    public static void removerProfessorDisciplina(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        Professor professor = professores.stream()
                .filter(p -> p.idProfessor == idProfessor)
                .findFirst()
                .orElse(null);

        if (disciplina != null && professor != null) {
            disciplina.removerProfessor(professor);
            System.out.println("Professor removido da disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    public static void adicionarTurmaDisciplina(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
        // Composição: Uma disciplina possui uma lista de turmas
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (disciplina != null && turma != null) {
            disciplina.adicionarTurma(turma);
            System.out.println("Turma adicionada à disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou turma não encontrada.");
        }
    }

    public static void removerTurmaDisciplina(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (disciplina != null && turma != null) {
            disciplina.removerTurma(turma);
            System.out.println("Turma removida da disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou turma não encontrada.");
        }
    }
}
