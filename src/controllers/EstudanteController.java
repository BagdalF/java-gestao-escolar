package controllers;

// Nova classe para gerenciar estudantes
import java.util.List;
import java.util.Scanner;
import models.*;

public class EstudanteController {

    // Métodos auxiliares (cadastrarEstudante, exibirEstudantes, etc.)
    // Copiados da classe App e ajustados para esta classe
    // Funções para Estudantes
    public static void cadastrarEstudante(Scanner scanner, List<Estudante> estudantes) {
        System.out.print("Digite o nome do estudante: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do estudante: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do estudante: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do estudante: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();

        Estudante estudante = new Estudante(nome, cpf, email, telefone, matricula, null, null);
        estudantes.add(estudante); // Adiciona o estudante à lista de estudantes
        System.out.println("Estudante cadastrado com sucesso!");
    }

    public static void exibirEstudantes(List<Estudante> estudantes) {
                for (Estudante estudante : estudantes) {
            estudante.exibirDados();
        }
    }

    public static void exibirDadosEstudante(Scanner scanner, List<Estudante> estudantes) {
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();

        Estudante estudante = estudantes.stream()
                .filter(e -> e.matricula.equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (estudante != null) {
            estudante.exibirDados();
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    public static void adicionarNotaEstudante(Scanner scanner, List<Estudante> estudantes) {
        // Composição: Um estudante possui uma lista de notas
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite a nota a ser adicionada: ");
        int nota = scanner.nextInt();
        scanner.nextLine();

        Estudante estudante = estudantes.stream()
                .filter(e -> e.matricula.equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (estudante != null) {
            estudante.adicionarNota(nota);
            System.out.println("Nota adicionada ao estudante com matrícula " + matricula + ".");
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    public static void removerNotaEstudante(Scanner scanner, List<Estudante> estudantes) {
        // Composição: Remove uma nota da lista de notas do estudante
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();
        System.out.print("Digite a nota a ser removida: ");
        int nota = scanner.nextInt();
        scanner.nextLine();

        Estudante estudante = estudantes.stream()
                .filter(e -> e.matricula.equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);

        if (estudante != null) {
            estudante.notas.remove((Integer) nota);
            System.out.println("Nota removida do estudante com matrícula " + matricula + ".");
        } else {
            System.out.println("Estudante não encontrado.");
        }
    }

    public static void removerEstudante(Scanner scanner, List<Estudante> estudantes) {
        System.out.print("Digite a matrícula do estudante: ");
        String matricula = scanner.nextLine();
        estudantes.removeIf(e -> e.matricula.equalsIgnoreCase(matricula)); // Remove o estudante da lista
        System.out.println("Estudante com matrícula " + matricula + " removido com sucesso.");
    }
}
