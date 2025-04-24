package controllers;
// Nova classe para gerenciar professores

import java.util.List;
import java.util.Scanner;
import models.*;

public class ProfessorController {

    // Métodos auxiliares (cadastrarProfessor, exibirProfessores, etc.)
    // Copiados da classe App e ajustados para esta classe
    /**
     * Cadastra um novo professor com os dados fornecidos pelo usuário.
     */
    public static void cadastrarProfessor(Scanner scanner, List<Professor> professores) {
        int idProfessor = professores.size() + 1;
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do professor: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do professor: ");
        String telefone = scanner.nextLine();

        // Cria um novo objeto Professor
        Professor professor = new Professor(nome, cpf, email, telefone, idProfessor);
        professores.add(professor); // Adiciona o professor à lista de professores
        System.out.println("Professor cadastrado com sucesso!");
    }

    /**
     * Exibe os dados de todos os professores cadastrados.
     */
    public static void exibirProfessores(List<Professor> professores) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        for (Professor professor : professores) {
            professor.exibirDados(); // Chama o método exibirDados da classe Professor
        }
    }

    /**
     * Exibe os dados de um professor específico com base no ID fornecido.
     */
    public static void exibirDadosProfessor(Scanner scanner, List<Professor> professores) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        Professor professor = null;
        for (Professor p : professores) {
            if (p.getIdProfessor() == idProfessor) {
                professor = p;
                break;
            }
        }

        if (professor != null) {
            professor.exibirDados();
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    /**
     * Adiciona uma disciplina a um professor.
     */
    public static void adicionarDisciplinaProfessor(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();

        // Busca a disciplina pelo código
        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        if (disciplina != null) {
            professores.get(idProfessor - 1).adicionarDisciplina(disciplina);
            System.out.println("Disciplina adicionada ao professor com ID " + idProfessor + ".");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    /**
     * Remove uma disciplina de um professor.
     */
    public static void removerDisciplinaProfessor(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        int codigoDisciplina = scanner.nextInt();

        // Busca a disciplina pelo código
        Disciplina disciplina = null;
        for (Disciplina d : disciplinas) {
            if (d.getCodigo() == codigoDisciplina) {
                disciplina = d;
                break; // Interrompe o loop assim que a turma é encontrada
            }
        }

        if (disciplina != null) {
            professores.get(idProfessor - 1).removeDisciplina(disciplina);
            System.out.println("Disciplina removida do professor com ID " + idProfessor + ".");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    /**
     * Remove um professor com base no ID fornecido.
     */
    public static void removerProfessor(Scanner scanner, List<Professor> professores) {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        professores.removeIf(p -> p.getIdProfessor() == idProfessor); // Remove o professor da lista
        System.out.println("Professor com ID " + idProfessor + " removido com sucesso.");
    }
}
