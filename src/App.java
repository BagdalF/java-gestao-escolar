/**
 * Classe principal do Sistema de Gestão Acadêmica.
 * Esta classe contém o método main e os menus para gerenciar professores, estudantes, disciplinas e turmas.
 */

// Importa a classe Scanner para leitura de dados do console
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        scanner.close(); // Fecha o scanner para liberar recursos
    }

    // ====================== MENU PROFESSORES ======================
    /**
     * Menu para gerenciar professores.
     * Permite cadastrar, exibir, adicionar/remover disciplinas e remover professores.
     */
    public static void menuProfessores(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
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

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarProfessor(scanner, professores);
                    break;
                case 2:
                    exibirProfessores(professores);
                    break;
                case 3:
                    exibirDadosProfessor(scanner, professores);
                    break;
                case 4:
                    adicionarDisciplinaProfessor(scanner, professores, disciplinas);
                    break;
                case 5:
                    removerDisciplinaProfessor(scanner, professores, disciplinas);
                    break;
                case 6:
                    removerProfessor(scanner, professores);
                    break;
                case 7:
                    return; // Retorna ao menu principal
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    /**
     * Cadastra um novo professor com os dados fornecidos pelo usuário.
     */
    public static void cadastrarProfessor(Scanner scanner, List<Professor> professores) {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o email do professor: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone do professor: ");
        String telefone = scanner.nextLine();
        int idProfessor = professores.size();
        scanner.nextLine();

        // Cria um novo objeto Professor
        Professor professor = new Professor(nome, cpf, email, telefone, idProfessor);
        professores.add(professor); // Adiciona o professor à lista de professores
        System.out.println("Professor cadastrado com sucesso!");
    }

    /**
     * Exibe os dados de todos os professores cadastrados.
     */
    public static void exibirProfessores(List<Professor> professores) {
        for (Professor professor : professores) {
            professor.exibirDados(); // Chama o método exibirDados da classe Professor
        }
    }

    /**
     * Exibe os dados de um professor específico com base no ID fornecido.
     */
    public static void exibirDadosProfessor(Scanner scanner, List<Professor> professores) {
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        // Busca o professor pelo ID e exibe seus dados
        professores.get(idProfessor).exibirDados();
        System.out.println("Exibindo dados do professor com ID " + idProfessor + "...");
    }

    /**
     * Adiciona uma disciplina a um professor.
     */
    public static void adicionarDisciplinaProfessor(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        // Busca a disciplina pelo código
        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        if (disciplina != null) {
            professores.get(idProfessor).adicionarDisciplina(disciplina);
            System.out.println("Disciplina adicionada ao professor com ID " + idProfessor + ".");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    /**
     * Remove uma disciplina de um professor.
     */
    public static void removerDisciplinaProfessor(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o código da disciplina: ");
        String codigoDisciplina = scanner.nextLine();

        // Busca a disciplina pelo código
        Disciplina disciplina = disciplinas.stream()
                .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
                .findFirst()
                .orElse(null);

        if (disciplina != null) {
            professores.get(idProfessor).removeDisciplina(disciplina);
            System.out.println("Disciplina removida do professor com ID " + idProfessor + ".");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    /**
     * Remove um professor com base no ID fornecido.
     */
    public static void removerProfessor(Scanner scanner, List<Professor> professores) {
        System.out.print("Digite o ID do professor: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        professores.removeIf(p -> p.idProfessor == idProfessor); // Remove o professor da lista
        System.out.println("Professor com ID " + idProfessor + " removido com sucesso.");
    }

    // ====================== MENU ESTUDANTES ======================
    /**
     * Menu para gerenciar estudantes.
     * Permite cadastrar, exibir, adicionar/remover notas e remover estudantes.
     */
    public static void menuEstudantes(Scanner scanner, List<Estudante> estudantes) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE ESTUDANTES =====");
            System.out.println("1. Cadastrar Estudante");
            System.out.println("2. Exibir Estudantes");
            System.out.println("3. Exibir Dados de um Estudante (Notas, Média e Frequência)");
            System.out.println("4. Adicionar Nota");
            System.out.println("5. Remover Nota");
            System.out.println("6. Remover Estudante");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarEstudante(scanner, estudantes);
                    break;
                case 2:
                    exibirEstudantes(estudantes);
                    break;
                case 3:
                    exibirDadosEstudante(scanner, estudantes);
                    break;
                case 4:
                    adicionarNotaEstudante(scanner, estudantes);
                    break;
                case 5:
                    removerNotaEstudante(scanner, estudantes);
                    break;
                case 6:
                    removerEstudante(scanner, estudantes);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 9);
    }

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

    // ====================== MENU DISCIPLINAS ======================
    public static void menuDisciplinas(Scanner scanner, List<Disciplina> disciplinas, List<Professor> professores, List<Turma> turmas) {
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
                    cadastrarDisciplina(scanner, disciplinas);
                    break;
                case 2:
                    exibirDisciplinas(disciplinas);
                    break;
                case 3:
                    exibirDadosDisciplina(scanner, disciplinas);
                    break;
                case 4:
                    exibirDadosDisciplinaTurma(scanner, disciplinas, turmas);
                    break;
                case 5:
                    adicionarProfessorDisciplina(scanner, professores, disciplinas);
                    break;
                case 6:
                    removerProfessorDisciplina(scanner, professores, disciplinas);
                    break;
                case 7:
                    adicionarTurmaDisciplina(scanner, turmas, disciplinas);
                    break;
                case 8:
                    removerTurmaDisciplina(scanner, turmas, disciplinas);
                    break;
                case 9:
                    return; // Sai do menu de disciplinas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 11); // O menu continua até que o usuário escolha "Voltar"
    }

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
        scanner.nextLine();

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

    // ====================== MENU TURMAS ======================
    public static void menuTurmas(Scanner scanner, List<Turma> turmas, List<Estudante> estudantes) {
        int opcao;
        do {
            System.out.println("\n===== GERENCIAMENTO DE TURMAS =====");
            System.out.println("1. Criar Turma");
            System.out.println("2. Exibir Turmas");
            System.out.println("3. Exibir Dados de uma Turma");
            System.out.println("4. Adicionar Estudante a uma Turma");
            System.out.println("5. Remover Estudante de uma Turma");
            System.out.println("6. Exibir Estudantes de uma Turma");
            System.out.println("7. Buscar Estudante de uma Turma pelo Nome");
            System.out.println("8. Exibir Disciplinas de uma Turma");
            System.out.println("9. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    criarTurma(scanner, turmas);
   
                case 2:
                    exibirTurmas(turmas);
                    break;
                case 3:
                    exibirDadosTurma(scanner, turmas);
                    break;
                case 4:
                    adicionarEstudanteTurma(scanner, turmas, estudantes);
                    break;
                case 5:
                    removerEstudanteTurma(scanner, turmas, estudantes);
                    break;
                case 6:
                    exibirEstudantesTurma(scanner, turmas);
                    break;
                case 7:
                    buscarEstudantePorNome(scanner, turmas);
                    break;
                case 8:
                    exibirDisciplinas(scanner, turmas);
                    break;
                case 9:
                    return; // Sai do menu de turmas e volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
    }

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
