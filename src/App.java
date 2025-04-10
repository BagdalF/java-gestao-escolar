
/**
 * Classe principal do Sistema de Gestão Acadêmica.
 * Esta classe contém o método main e os menus para gerenciar professores, estudantes, disciplinas e turmas.
 */
// Importa a classe Scanner para leitura de dados do console
import controllers.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import models.*;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;

        // Listas para armazenar os objetos do sistema
        List<Professor> professores = new ArrayList<>();
        List<Estudante> estudantes = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        do {
            // Exibe o menu principal
            System.out.println("\n===== SISTEMA DE GESTÃO ACADÊMICA =====");
            System.out.println("1. Gerenciar Professores");
            System.out.println("2. Gerenciar Estudantes");
            System.out.println("3. Gerenciar Disciplinas");
            System.out.println("4. Gerenciar Turmas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            // Direciona para o menu correspondente com base na opção escolhida
            switch (opcaoPrincipal) {
                case 1:
                    menuProfessores(scanner, professores, disciplinas);
                    break;
                case 2:
                    menuEstudantes(scanner, estudantes);
                    break;
                case 3:
                    menuDisciplinas(scanner, disciplinas, professores, turmas);
                    break;
                case 4:
                    menuTurmas(scanner, turmas, estudantes);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoPrincipal != 5);

        scanner.close();
    }

    public static int exibirMenu(Scanner scanner, String[] opcoes) {
        while (true) {
            try {
                for (int i = 0; i < opcoes.length; i++) {
                    System.out.println((i + 1) + ". " + opcoes[i]);
                }
                System.out.print("Escolha uma opção: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            } finally {
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }


    // ====================== MENU PROFESSORES ======================
    /**
     * Menu para gerenciar professores. Permite cadastrar, exibir,
     * adicionar/remover disciplinas e remover professores.
     */
    public static void menuProfessores(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        int opcao;
        do {
            opcao = exibirMenu(scanner, new String[] {
                "Cadastrar Professor",
                "Exibir Professores",
                "Exibir Dados de um Professor (Turmas e Disciplinas)",
                "Adicionar Disciplina a um Professor",
                "Remover Disciplina de um Professor",
                "Remover Professor",
                "Voltar"
            });

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    ProfessorController.cadastrarProfessor(scanner, professores);
                    break;
                case 2:
                    ProfessorController.exibirProfessores(professores);
                    break;
                case 3:
                    ProfessorController.exibirDadosProfessor(scanner, professores);
                    break;
                case 4:
                    ProfessorController.adicionarDisciplinaProfessor(scanner, professores, disciplinas);
                    break;
                case 5:
                    ProfessorController.removerDisciplinaProfessor(scanner, professores, disciplinas);
                    break;
                case 6:
                    ProfessorController.removerProfessor(scanner, professores);
                    break;
                case 7:
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    // ====================== MENU ESTUDANTES ======================
    /**
     * Menu para gerenciar estudantes. Permite cadastrar, exibir,
     * adicionar/remover notas e remover estudantes.
     */
    public static void menuEstudantes(Scanner scanner, List<Estudante> estudantes) {
        int opcao;
        do {
            opcao = exibirMenu(scanner, new String[] {
                "Cadastrar Estudante",
                "Exibir Estudantes",
                "Exibir Dados de um Estudante (Notas, Média e Frequência)",
                "Adicionar Nota",
                "Remover Nota",
                "Remover Estudante",
                "Voltar"
            });

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    EstudanteController.cadastrarEstudante(scanner, estudantes);
                    break;
                case 2:
                    EstudanteController.exibirEstudantes(estudantes);
                    break;
                case 3:
                    EstudanteController.exibirDadosEstudante(scanner, estudantes);
                    break;
                case 4:
                    EstudanteController.adicionarNotaEstudante(scanner, estudantes);
                    break;
                case 5:
                    EstudanteController.removerNotaEstudante(scanner, estudantes);
                    break;
                case 6:
                    EstudanteController.removerEstudante(scanner, estudantes);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    // ====================== MENU DISCIPLINAS ======================
    public static void menuDisciplinas(Scanner scanner, List<Disciplina> disciplinas, List<Professor> professores, List<Turma> turmas) {
        int opcao;
        do {
            opcao = exibirMenu(scanner, new String[] {
                "Cadastrar Disciplina",
                "Exibir Disciplinas",
                "Exibir Dados de uma Disciplina",
                "Exibir Dados de uma Disciplina em uma Turma (Professor, Horários, Avaliações)",
                "Adicionar Professor a uma Disciplina",
                "Remover Professor de uma Disciplina",
                "Adicionar Turma a uma Disciplina",
                "Remover Turma de uma Disciplina",
                "Voltar"
            });

            switch (opcao) {
                case 1:
                    DisciplinaController.cadastrarDisciplina(scanner, disciplinas);
                    break;
                case 2:
                    DisciplinaController.exibirDisciplinas(disciplinas);
                    break;
                case 3:
                    DisciplinaController.exibirDadosDisciplina(scanner, disciplinas);
                    break;
                case 4:
                    DisciplinaController.exibirDadosDisciplinaTurma(scanner, disciplinas, turmas);
                    break;
                case 5:
                    DisciplinaController.adicionarProfessorDisciplina(scanner, professores, disciplinas);
                    break;
                case 6:
                    DisciplinaController.removerProfessorDisciplina(scanner, professores, disciplinas);
                    break;
                case 7:
                    DisciplinaController.adicionarTurmaDisciplina(scanner, turmas, disciplinas);
                    break;
                case 8:
                    DisciplinaController.removerTurmaDisciplina(scanner, turmas, disciplinas);
                    break;
                case 9:
                    return; // Sai do menu de disciplinas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 11);
    }

    // ====================== MENU TURMAS ======================
    public static void menuTurmas(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        int opcao;
        do {
            opcao = exibirMenu(scanner, new String[] {
                "Criar Turma",
                "Exibir Turmas",
                "Exibir Dados de uma Turma",
                "Adicionar Estudante a uma Turma",
                "Remover Estudante de uma Turma",
                "Exibir Estudantes de uma Turma",
                "Buscar Estudante de uma Turma pelo Nome",
                "Exibir Disciplinas de uma Turma",
                "Voltar"
            });

            switch (opcao) {
                case 1:
                    TurmaController.criarTurma(scanner, turmas);
                    break;
                case 2:
                    TurmaController.exibirTurmas(turmas);
                    break;
                case 3:
                    TurmaController.exibirDadosTurma(scanner, turmas);
                    break;
                case 4:
                    TurmaController.adicionarEstudanteTurma(scanner, turmas, estudantes);
                    break;
                case 5:
                    TurmaController.removerEstudanteTurma(scanner, turmas, estudantes);
                    break;
                case 6:
                    TurmaController.exibirEstudantesTurma(scanner, turmas);
                    break;
                case 7:
                    TurmaController.buscarEstudantePorNome(scanner, turmas);
                    break;
                case 8:
                    TurmaController.exibirDisciplinas(scanner, turmas);
                    break;
                case 9:
                    return; // Sai do menu de turmas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

}
