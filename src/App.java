
/**
 * Classe principal do Sistema de Gestão Acadêmica.
 * Esta classe contém o método main e os menus para gerenciar professores, estudantes, disciplinas e turmas.
 */
import controllers.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.*;

public class App {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcaoPrincipal;

            // Inicializa as listas de professores, estudantes, disciplinas e turmas
            List<Professor> professores = new ArrayList<>();
            List<Estudante> estudantes = new ArrayList<>();
            List<Disciplina> disciplinas = new ArrayList<>();
            List<Turma> turmas = new ArrayList<>();

            try {
                // Carrega os dados das listas a partir dos arquivos
                professores = (List<Professor>) Database.carregarLista("professores.ser");
                estudantes = (List<Estudante>) Database.carregarLista("estudantes.ser");
                disciplinas = (List<Disciplina>) Database.carregarLista("disciplinas.ser");
                turmas = (List<Turma>) Database.carregarLista("turmas.ser");

                // Verifica se as listas estão vazias e inicializa com dados padrão, se necessário
                if (professores.isEmpty() || estudantes.isEmpty() || disciplinas.isEmpty() || turmas.isEmpty()) {
                    System.out.println("Dados não encontrados. Inicializando com dados padrão...");
                    Database.popularInicial(professores, estudantes, disciplinas, turmas);
                }
            } catch (Exception e) {
                System.out.println("Erro ao carregar dados. Inicializando com dados padrão... \n" + e.getLocalizedMessage());
                Database.popularInicial(professores, estudantes, disciplinas, turmas);
            }

            do {
                // Exibe o menu principal
                System.out.println("\n===== SISTEMA DE GESTÃO ACADÊMICA =====");
                System.out.println("1. Gerenciar Professores");
                System.out.println("2. Gerenciar Estudantes");
                System.out.println("3. Gerenciar Disciplinas");
                System.out.println("4. Gerenciar Turmas");
                System.out.println("5. Sair");

                opcaoPrincipal = capturarEntradaInteira(scanner);

                // Utilizei a sugestão do Visual Studio Code para converter a estrutura switch tradicional para o formato moderno
                // "rule switch" (com ->), que foi introduzido a partir do Java 14 e estabilizado no Java 17.
                // Essa mudança torna o código mais limpo, legível e menos propenso a erros, eliminando
                // a necessidade do uso de break.
                // Direciona para o menu correspondente com base na opção escolhida
                switch (opcaoPrincipal) {
                    case 1 -> menuProfessores(scanner, professores, disciplinas, estudantes);
                    case 2 -> menuEstudantes(scanner, estudantes, turmas);
                    case 3 -> menuDisciplinas(scanner, disciplinas, professores, turmas);
                    case 4 -> menuTurmas(scanner, turmas, estudantes, disciplinas);
                    case 5 -> System.out.println("Saindo do sistema...");
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcaoPrincipal != 5);

            // Salva os dados ao sair do sistema
            System.out.println("Salvando dados...");
            Database.salvarDados(professores, estudantes, disciplinas, turmas);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Por favor, tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro inesperado ocorreu. Por favor, tente novamente.\n" + e.getLocalizedMessage());
        }
    }

    // Método auxiliar para capturar a entrada do usuário e garantir o tratamento de erros
    public static int capturarEntradaInteira(Scanner scanner) {
        int entrada = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("\nEscolha uma opção: ");
                entrada = scanner.nextInt();
                System.out.println("\n");
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número natural.");
            } finally {
                scanner.nextLine();
            }

        }

        return entrada;
    }

    // ====================== MENU PROFESSORES ======================
    /**
     * Menu para gerenciar professores. Permite cadastrar, exibir,
     * adicionar/remover disciplinas e remover professores.
     */
    public static void menuProfessores(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas, List<Estudante> estudantes) {
        int opcao;
        do {

            System.out.println("\n===== GERENCIAMENTO DE PROFESSORES =====");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Exibir Professores");
            System.out.println("3. Exibir Dados de um Professor (Ids iniciam em 1)");
            System.out.println("4. Adicionar Disciplina a um Professor");
            System.out.println("5. Remover Disciplina de um Professor");
            System.out.println("6. Remover Professor");
            System.out.println("7. Promover Estudante para Professor");
            System.out.println("8. Voltar");

            opcao = capturarEntradaInteira(scanner);

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1 -> ProfessorController.cadastrarProfessor(scanner, professores);
                case 2 -> ProfessorController.exibirProfessores(professores);
                case 3 -> ProfessorController.exibirDadosProfessor(scanner, professores);
                case 4 -> ProfessorController.adicionarDisciplinaProfessor(scanner, professores, disciplinas);
                case 5 -> ProfessorController.removerDisciplinaProfessor(scanner, professores, disciplinas);
                case 6 -> ProfessorController.removerProfessor(scanner, professores);
                case 7 -> ProfessorController.promoverEstudanteParaProfessor(scanner, estudantes, professores);
                case 8 -> {
                    return; // Retorna ao menu principal
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    // ====================== MENU ESTUDANTES ======================
    /**
     * Menu para gerenciar estudantes. Permite cadastrar, exibir,
     * adicionar/remover notas e remover estudantes.
     */
    public static void menuEstudantes(Scanner scanner, List<Estudante> estudantes, List<Turma> turmas) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE ESTUDANTES =====");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Exibir Estudantes");
            System.out.println("3. Exibir Dados de um Estudante (Ids iniciam em 1)");
            System.out.println("4. Adicionar Nota");
            System.out.println("5. Remover Nota");
            System.out.println("6. Remover Estudante");
            System.out.println("7. Voltar");

            opcao = capturarEntradaInteira(scanner);

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1 -> EstudanteController.cadastrarEstudante(scanner, estudantes);
                case 2 -> EstudanteController.exibirEstudantes(estudantes);
                case 3 -> EstudanteController.exibirDadosEstudante(scanner, estudantes, turmas);
                case 4 -> EstudanteController.adicionarNotaEstudante(scanner, estudantes);
                case 5 -> EstudanteController.removerNotaEstudante(scanner, estudantes);
                case 6 -> EstudanteController.removerEstudante(scanner, estudantes);
                case 7 -> {
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    // ====================== MENU DISCIPLINAS ======================
    public static void menuDisciplinas(Scanner scanner, List<Disciplina> disciplinas, List<Professor> professores, List<Turma> turmas) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE DISCIPLINAS =====");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Exibir Disciplinas");
            System.out.println("3. Exibir Dados de uma Disciplina");
            System.out.println("4. Exibir Dados de uma Disciplina em uma Turma (Ids iniciam em 1)");
            System.out.println("5. Adicionar Professor a uma Disciplina");
            System.out.println("6. Remover Professor de uma Disciplina");
            System.out.println("7. Adicionar Turma a uma Disciplina");
            System.out.println("8. Remover Turma de uma Disciplina");
            System.out.println("9. Voltar");

            opcao = capturarEntradaInteira(scanner);

            switch (opcao) {
                case 1 -> DisciplinaController.cadastrarDisciplina(scanner, disciplinas);
                case 2 -> DisciplinaController.exibirDisciplinas(disciplinas);
                case 3 -> DisciplinaController.exibirDadosDisciplina(scanner, disciplinas);
                case 4 -> DisciplinaController.exibirDadosDisciplinaTurma(scanner, disciplinas, turmas);
                case 5 -> DisciplinaController.adicionarProfessorDisciplina(scanner, professores, disciplinas);
                case 6 -> DisciplinaController.removerProfessorDisciplina(scanner, professores, disciplinas);
                case 7 -> DisciplinaController.adicionarTurmaDisciplina(scanner, turmas, disciplinas);
                case 8 -> DisciplinaController.removerTurmaDisciplina(scanner, turmas, disciplinas);
                case 9 -> {
                    return; // Sai do menu de disciplinas e volta ao menu principal
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

    // ====================== MENU TURMAS ======================
    public static void menuTurmas(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes, List<Disciplina> disciplinas) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE TURMAS =====");
            System.out.println("1. Criar Turma");
            System.out.println("2. Exibir Turmas");
            System.out.println("3. Exibir Dados de uma Turma (Ids iniciam em 1)");
            System.out.println("4. Adicionar Estudante a uma Turma");
            System.out.println("5. Remover Estudante de uma Turma");
            System.out.println("6. Exibir Estudantes de uma Turma");
            System.out.println("7. Buscar Estudante de uma Turma pelo Nome");
            System.out.println("8. Exibir Disciplinas de uma Turma");
            System.out.println("9. Voltar");

            opcao = capturarEntradaInteira(scanner);

            switch (opcao) {
                case 1 -> TurmaController.criarTurma(scanner, turmas, disciplinas);
                case 2 -> TurmaController.exibirTurmas(turmas);
                case 3 -> TurmaController.exibirDadosTurma(scanner, turmas);
                case 4 -> TurmaController.adicionarEstudanteTurma(scanner, turmas, estudantes);
                case 5 -> TurmaController.removerEstudanteTurma(scanner, turmas, estudantes);
                case 6 -> TurmaController.exibirEstudantesTurma(scanner, turmas);
                case 7 -> TurmaController.buscarEstudantePorNome(scanner, turmas);
                case 8 -> TurmaController.exibirDisciplinas(scanner, turmas);
                case 9 -> {
                    return; // Sai do menu de turmas e volta ao menu principal
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

}
