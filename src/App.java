
/**
 * Classe principal do Sistema de Gestão Acadêmica.
 * Esta classe contém o método main e os menus para gerenciar professores, estudantes, disciplinas e turmas.
 */

// Importa a classe Scanner para leitura de dados do console
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcaoPrincipal;

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

            // Direciona para o menu correspondente
            switch (opcaoPrincipal) {
                case 1:
                    menuProfessores(scanner);
                    break;
                case 2:
                    menuEstudantes(scanner);
                    break;
                case 3:
                    menuDisciplinas(scanner);
                    break;
                case 4:
                    menuTurmas(scanner);
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

    // ====================== MENU PROFESSORES ======================
    public static void menuProfessores(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE PROFESSORES =====");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Exibir Professores");
            System.out.println("3. Exibir Dados de um Professor (Turmas e Disciplinas)");
            System.out.println("4. Adicionar Disciplina a um Professor");
            System.out.println("5. Remover Disciplina de um Professor");
            System.out.println("6. Remover Professor");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProfessor(scanner);
                    break;
                case 2:
                    exibirProfessores();
                    break;
                case 3:
                    exibirDadosProfessor(scanner);
                    break;
                case 4:
                    adicionarDisciplinaProfessor(scanner);
                    break;
                case 5:
                    removerDisciplinaProfessor(scanner);
                    break;
                case 6:
                    removerProfessor(scanner);
                    break;
                case 7:
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    // Funções para Professores (vazias para implementação futura)
    public static void cadastrarProfessor(Scanner scanner) {
        // Implementar cadastro de professor
    }

    public static void exibirProfessores() {
        // Implementar exibição de professores
    }

    public static void exibirDadosProfessor(Scanner scanner) {
        // Implementar exibição de dados de um professor
    }

    public static void adicionarDisciplinaProfessor(Scanner scanner) {
        // Implementar adição de disciplina a um professor
    }

    public static void removerDisciplinaProfessor(Scanner scanner) {
        // Implementar remoção de disciplina de um professor
    }

    public static void removerProfessor(Scanner scanner) {
        // Implementar remoção de professor
    }

    // ====================== MENU ESTUDANTES ======================
    public static void menuEstudantes(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE ESTUDANTES =====");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Exibir Estudantes");
            System.out.println("3. Exibir Dados de um Estudante (Notas, Média e Frequência)");
            System.out.println("4. Adicionar Nota");
            System.out.println("5. Remover Nota");
            System.out.println("6. Adicionar Frequência");
            System.out.println("7. Remover Frequência");
            System.out.println("8. Remover Estudante");
            System.out.println("9. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEstudante(scanner);
                    break;
                case 2:
                    exibirEstudantes();
                    break;
                case 3:
                    exibirDadosEstudante(scanner);
                    break;
                case 4:
                    adicionarNotaEstudante(scanner);
                    break;
                case 5:
                    removerNotaEstudante(scanner);
                    break;
                case 6:
                    adicionarFrequenciaEstudante(scanner);
                    break;
                case 7:
                    removerFrequenciaEstudante(scanner);
                    break;
                case 8:
                    removerEstudante(scanner);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

    // Funções para Estudantes
    public static void cadastrarEstudante(Scanner scanner) {
        // Implementar cadastro de estudante
    }

    public static void exibirEstudantes() {
        // Implementar exibição de estudantes
    }

    public static void exibirDadosEstudante(Scanner scanner) {
        // Implementar exibição de dados de um estudante
    }

    public static void adicionarNotaEstudante(Scanner scanner) {
        // Implementar adição de nota a um estudante
    }

    public static void removerNotaEstudante(Scanner scanner) {
        // Implementar remoção de nota de um estudante
    }

    public static void adicionarFrequenciaEstudante(Scanner scanner) {
        // Implementar adição de frequência a um estudante
    }

    public static void removerFrequenciaEstudante(Scanner scanner) {
        // Implementar remoção de frequência de um estudante
    }

    public static void removerEstudante(Scanner scanner) {
        // Implementar remoção de estudante
    }

    // ====================== MENU DISCIPLINAS ======================
    public static void menuDisciplinas(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE DISCIPLINAS =====");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Exibir Disciplinas");
            System.out.println("3. Exibir Dados de uma Disciplina");
            System.out.println("4. Exibir Dados de uma Disciplina em uma Turma (Professor, Horários, Avaliações)");
            System.out.println("5. Adicionar Professor a uma Disciplina");
            System.out.println("6. Remover Professor de uma Disciplina");
            System.out.println("7. Adicionar Turma a uma Disciplina");
            System.out.println("8. Remover Turma de uma Disciplina");
            System.out.println("9. Adicionar Horário a uma Disciplina");
            System.out.println("10. Remover Horário de uma Disciplina");
            System.out.println("11. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarDisciplina(scanner);
                    break;
                case 2:
                    exibirDisciplinas();
                    break;
                case 3:
                    exibirDadosDisciplina(scanner);
                    break;
                case 4:
                    exibirDadosDisciplinaTurma(scanner);
                    break;
                case 5:
                    adicionarProfessorDisciplina(scanner);
                    break;
                case 6:
                    removerProfessorDisciplina(scanner);
                    break;
                case 7:
                    adicionarTurmaDisciplina(scanner);
                    break;
                case 8:
                    removerTurmaDisciplina(scanner);
                    break;
                case 9:
                    adicionarHorarioDisciplina(scanner);
                    break;
                case 10:
                    removerHorarioDisciplina(scanner);
                    break;
                case 11:
                    return; // Sai do menu de disciplinas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 11); // O menu continua até que o usuário escolha "Voltar"
    }

    // Funções para Disciplinas (a serem implementadas futuramente)
    public static void cadastrarDisciplina(Scanner scanner) {
        // Implementar cadastro de disciplina
    }

    public static void exibirDisciplinas() {
        // Implementar exibição de disciplinas
    }

    public static void exibirDadosDisciplina(Scanner scanner) {
        // Implementar exibição de dados de uma disciplina
    }

    public static void exibirDadosDisciplinaTurma(Scanner scanner) {
        // Implementar exibição de dados de uma disciplina em uma turma
    }

    public static void adicionarProfessorDisciplina(Scanner scanner) {
        // Implementar adição de professor a uma disciplina
    }

    public static void removerProfessorDisciplina(Scanner scanner) {
        // Implementar remoção de professor de uma disciplina
    }

    public static void adicionarTurmaDisciplina(Scanner scanner) {
        // Implementar adição de turma a uma disciplina
    }

    public static void removerTurmaDisciplina(Scanner scanner) {
        // Implementar remoção de turma de uma disciplina
    }

    public static void adicionarHorarioDisciplina(Scanner scanner) {
        // Implementar adição de horário a uma disciplina
    }

    public static void removerHorarioDisciplina(Scanner scanner) {
        // Implementar remoção de horário de uma disciplina
    }

    // ====================== MENU TURMAS ======================
    public static void menuTurmas(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE TURMAS =====");
            System.out.println("1. Criar Turma");
            System.out.println("2. Exibir Turmas");
            System.out.println("3. Exibir Dados de uma Turma (Disciplinas, Estudantes, etc.)");
            System.out.println("4. Exibir Avaliações de uma Turma");
            System.out.println("5. Exibir Avaliações de uma Turma em uma Disciplina");
            System.out.println("6. Exibir Horários de uma Turma");
            System.out.println("7. Adicionar Estudante a uma Turma");
            System.out.println("8. Remover Estudante de uma Turma");
            System.out.println("9. Adicionar Avaliação a uma Turma");
            System.out.println("10. Remover Avaliação de uma Turma");
            System.out.println("11. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    criarTurma(scanner);
                    break;
                case 2:
                    exibirTurmas();
                    break;
                case 3:
                    exibirDadosTurma(scanner);
                    break;
                case 4:
                    exibirAvaliacoesTurma(scanner);
                    break;
                case 5:
                    exibirAvaliacoesTurmaDisciplina(scanner);
                    break;
                case 6:
                    exibirHorariosTurma(scanner);
                    break;
                case 7:
                    adicionarEstudanteTurma(scanner);
                    break;
                case 8:
                    removerEstudanteTurma(scanner);
                    break;
                case 9:
                    adicionarAvaliacaoTurma(scanner);
                    break;
                case 10:
                    removerAvaliacaoTurma(scanner);
                    break;
                case 11:
                    return; // Sai do menu de turmas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 11); // O menu continua até que o usuário escolha "Voltar"
    }

    // Funções para Turmas (a serem implementadas futuramente)
    public static void criarTurma(Scanner scanner) {
        // Implementar criação de turma
    }

    public static void exibirTurmas() {
        // Implementar exibição de turmas
    }

    public static void exibirDadosTurma(Scanner scanner) {
        // Implementar exibição de dados de uma turma
    }

    public static void exibirAvaliacoesTurma(Scanner scanner) {
        // Implementar exibição de avaliações de uma turma
    }

    public static void exibirAvaliacoesTurmaDisciplina(Scanner scanner) {
        // Implementar exibição de avaliações de uma turma em uma disciplina
    }

    public static void exibirHorariosTurma(Scanner scanner) {
        // Implementar exibição de horários de uma turma
    }

    public static void adicionarEstudanteTurma(Scanner scanner) {
        // Implementar adição de estudante a uma turma
    }

    public static void removerEstudanteTurma(Scanner scanner) {
        // Implementar remoção de estudante de uma turma
    }

    public static void adicionarAvaliacaoTurma(Scanner scanner) {
        // Implementar adição de avaliação a uma turma
    }

    public static void removerAvaliacaoTurma(Scanner scanner) {
        // Implementar remoção de avaliação de uma turma
    }
}
