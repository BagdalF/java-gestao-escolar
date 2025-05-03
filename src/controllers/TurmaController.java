package controllers;
// Nova classe para gerenciar turmas

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;

public class TurmaController {

    // Métodos auxiliares (criarTurma, exibirTurmas, etc.)
    // Copiados da classe App e ajustados para esta classe
    public static void criarTurma(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
        int idTurma = turmas.size() + 1;

        System.out.print("Digite o nome da turma: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o número de disciplinas que a turma terá: ");
        int numDisciplinas = scanner.nextInt();
        scanner.nextLine();

        List<Disciplina> disciplinasTurma = new ArrayList<>();
        for (int i = 0; i < numDisciplinas; i++) {
            if (disciplinas.isEmpty()) {
                System.out.println("Nenhuma disciplina cadastrada.");
                break;
            }

            System.out.print("Digite o ID da disciplina: ");
            int idDisciplina = scanner.nextInt();
            scanner.nextLine();

            Disciplina disciplina = null;
            for (Disciplina d : disciplinas) {
                if (d.getCodigo() == idDisciplina) {
                    disciplina = d;
                    break; // Interrompe o loop assim que a turma é encontrada
                }
            }

            if (disciplina != null) {
                disciplinasTurma.add(disciplina);
                System.out.println("Disciplina " + disciplina.getNome() + " adicionada à turma.");
            } else {
                System.out.println("Disciplina não encontrada.");
            }
        }

        Turma turma = new Turma(idTurma, nome, disciplinasTurma);
        turmas.add(turma);
        System.out.println("Turma criada com sucesso!");
    }

    public static void exibirTurmas(List<Turma> turmas) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        for (Turma turma : turmas) {
            System.out.println("ID: " + turma.getIdTurma() + ", Nome: " + turma.getNome());
        }
    }

    public static void exibirDadosTurma(Scanner scanner, List<Turma> turmas) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getIdTurma() == idTurma) {
                turma = t;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        if (turma != null) {
            turma.exibirEstudantes();
            turma.exibirDisciplinas();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public static void adicionarEstudanteTurma(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        // Composição: Uma turma mantém uma relação com os estudantes
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a matrícula do estudante: ");
        int matricula = scanner.nextInt();

        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getIdTurma() == idTurma) {
                turma = t;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        Estudante estudante = null;
        for (Estudante e : estudantes) {
            if (e.getMatricula() == matricula) {
                estudante = e;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        if (turma != null && estudante != null) {
            turma.adicionarEstudante(estudante);
            System.out.println("Estudante " + estudante.getNome() + " adicionado à turma " + turma.getNome() + ".");
        } else {
            System.out.println("Turma ou estudante não encontrado.");
        }
    }

    public static void removerEstudanteTurma(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        // Composição: Remove a relação entre a turma e o estudante
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a matrícula do estudante: ");
        int matricula = scanner.nextInt();

        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getIdTurma() == idTurma) {
                turma = t;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        Estudante estudante = null;
        for (Estudante e : estudantes) {
            if (e.getMatricula() == matricula) {
                estudante = e;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        if (turma != null && estudante != null) {
            turma.removerEstudante(estudante);
            System.out.println("Estudante " + estudante.getNome() + " removido da turma " + turma.getNome() + ".");
        } else {
            System.out.println("Turma ou estudante não encontrado.");
        }
    }

    public static void exibirEstudantesTurma(Scanner scanner, List<Turma> turmas) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.getIdTurma() == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            System.out.println("Estudantes da turma " + turma.getNome() + ":");
            turma.exibirEstudantes();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public static void buscarEstudantePorNome(Scanner scanner, List<Turma> turmas) {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o nome do estudante: ");
        String nomeEstudante = scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.getIdTurma() == idTurma)
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
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        Turma turma = turmas.stream()
                .filter(t -> t.getIdTurma() == idTurma)
                .findFirst()
                .orElse(null);

        if (turma != null) {
            System.out.println("Disciplinas da turma " + turma.getNome() + ":");
            turma.exibirDisciplinas();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
}
