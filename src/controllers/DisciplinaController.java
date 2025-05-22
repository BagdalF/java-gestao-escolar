package controllers;

import java.util.List;
import java.util.Scanner;
import models.*;

public class DisciplinaController {
    /**
     * Cadastra uma nova disciplina com os dados fornecidos pelo usuário.
     */
    public static void cadastrarDisciplina(Scanner scanner, List<Disciplina> disciplinas) {
        int codigo = disciplinas.size() + 1;
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a descrição da disciplina: ");
        String descricao = scanner.nextLine();
        int cargaHoraria = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite a carga horária da disciplina: ");
                cargaHoraria = scanner.nextInt();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }

        Disciplina disciplina = EntityFactory.criarDisciplina(codigo, nome, descricao, cargaHoraria);
        disciplinas.add(disciplina); // Adiciona a disciplina à lista de disciplinas
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    /**
     * Exibe todas as disciplinas cadastradas.
     */
    public static void exibirDisciplinas(List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        for (Disciplina disciplina : disciplinas) {
            disciplina.exibirDados();
        }
    }

    /**
     * Exibe os dados de uma disciplina específica com base no código fornecido.
     */
    public static void exibirDadosDisciplina(Scanner scanner, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.print("Digite o código da disciplina: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigo) {
                disciplina = d;
                break;
            }
        }

        if (disciplina != null) {
            disciplina.exibirDados();
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    /**
     * Exibe os dados de uma disciplina e suas turmas associadas.
     */
    public static void exibirDadosDisciplinaTurma(Scanner scanner, List<Disciplina> disciplinas, List<Turma> turmas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.print("Digite o código da disciplina: ");
        int codigo = scanner.nextInt();

        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.getCodigo() == codigo)
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

    /**
     * Adiciona um professor a uma disciplina.
     */
    public static void adicionarProfessorDisciplina(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        // Composição: Uma disciplina possui uma lista de professores
        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break;
            }
        }

        Professor professor = professores.stream()
                .filter(p -> p.getIdProfessor() == idProfessor)
                .findFirst()
                .orElse(null);

        if (disciplina != null && professor != null) {
            disciplina.adicionarProfessor(professor);
            System.out.println("Professor adicionado à disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    /**
     * Remove um professor de uma disciplina.
     */
    public static void removerProfessorDisciplina(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break;
            }
        }

        Professor professor = professores.stream()
                .filter(p -> p.getIdProfessor() == idProfessor)
                .findFirst()
                .orElse(null);

        if (disciplina != null && professor != null) {
            disciplina.removerProfessor(professor);
            System.out.println("Professor removido da disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    /**
     * Adiciona uma turma a uma disciplina.
     */
    public static void adicionarTurmaDisciplina(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        // Composição: Uma disciplina possui uma lista de turmas
        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break;
            }
        }

        Turma turma = turmas.stream()
                .filter(t -> t.getIdTurma() == idTurma)
                .findFirst()
                .orElse(null);

        if (disciplina != null && turma != null) {
            disciplina.adicionarTurma(turma);
            System.out.println("Turma adicionada à disciplina com sucesso.");
        } else {
            System.out.println("Disciplina ou turma não encontrada.");
        }
    }

    /**
     * Remove uma turma de uma disciplina.
     */
    public static void removerTurmaDisciplina(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break;
            }
        }

        Turma turma = turmas.stream()
                .filter(t -> t.getIdTurma() == idTurma)
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
