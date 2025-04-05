package controllers;
// Nova classe para gerenciar turmas

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;

public class TurmaController {

    // Métodos auxiliares (criarTurma, exibirTurmas, etc.)
    // Copiados da classe App e ajustados para esta classe
    public static void criarTurma(Scanner scanner, List<Turma> turmas) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome da turma: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o número de disciplinas que a turma terá: ");
        int numDisciplinas = scanner.nextInt();
        scanner.nextLine();

        List<Disciplina> disciplinas = new ArrayList<>();
        for (int i = 0; i < numDisciplinas; i++) {
            System.out.print("Digite o código da disciplina " + (i + 1) + ": ");
            String codigoDisciplina = scanner.nextLine();
            System.out.print("Digite o nome da disciplina " + (i + 1) + ": ");
            String nomeDisciplina = scanner.nextLine();
            System.out.print("Digite a descrição da disciplina " + (i + 1) + ": ");
            String descricaoDisciplina = scanner.nextLine();
            System.out.print("Digite a carga horária da disciplina " + (i + 1) + ": ");
            int cargaHoraria = scanner.nextInt();
            scanner.nextLine();

            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, descricaoDisciplina, cargaHoraria);
            disciplinas.add(disciplina);
        }

        Turma turma = new Turma(idTurma, nome, disciplinas);
        turmas.add(turma);
        System.out.println("Turma criada com sucesso!");
    }

    public static void exibirTurmas(List<Turma> turmas) {
        for (Turma turma : turmas) {
            System.out.println("ID: " + turma.idTurma + ", Nome: " + turma.nome);
        }
    }

    public static void exibirDadosTurma(Scanner scanner, List<Turma> turmas) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            turma.exibirEstudantes();
            turma.exibirDisciplinas();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public static void adicionarEstudanteTurma(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        Estudante estudante = estudantes.stream()
                .filter(e -> e.matricula.equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (turma != null && estudante != null) {
            turma.adicionarEstudante(estudante);
            System.out.println("Estudante " + estudante.nome + " adicionado à turma " + turma.nome + ".");
        } else {
            System.out.println("Turma ou estudante não encontrado.");
        }
    }

    public static void removerEstudanteTurma(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        Estudante estudante = estudantes.stream()
                .filter(e -> e.matricula.equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (turma != null && estudante != null) {
            turma.removerEstudante(estudante);
            System.out.println("Estudante " + estudante.nome + " removido da turma " + turma.nome + ".");
        } else {
            System.out.println("Turma ou estudante não encontrado.");
        }
    }

    public static void exibirEstudantesTurma(Scanner scanner, List<Turma> turmas) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            System.out.println("Estudantes da turma " + turma.nome + ":");
            turma.exibirEstudantes();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public static void buscarEstudantePorNome(Scanner scanner, List<Turma> turmas) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do estudante: ");
        String nomeEstudante = scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            Estudante estudante = turma.buscarEstudantePorNome(nomeEstudante);
            if (estudante != null) {
                System.out.println("Estudante encontrado:");
                estudante.exibirDados();
            } else {
                System.out.println("Estudante não encontrado na turma.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public static void exibirDisciplinas(Scanner scanner, List<Turma> turmas) {
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.idTurma == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            System.out.println("Disciplinas da turma " + turma.nome + ":");
            turma.exibirDisciplinas();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
}
