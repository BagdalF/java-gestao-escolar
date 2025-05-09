import java.util.ArrayList;
import java.util.List;
import models.*;

public class Database {

    public static void popular(
            List<Professor> professores,
            List<Estudante> estudantes,
            List<Disciplina> disciplinas,
            List<Turma> turmas) {

        // Populando professores
        Professor professor1 = new Professor("João Silva", "12345678900", "joao@escola.com", "123456789", 1);
        Professor professor2 = new Professor("Maria Oliveira", "98765432100", "maria@escola.com", "987654321", 2);
        Professor professor3 = new Professor("Pedro Santos", "33344455566", "pedro@escola.com", "333444555", 3);
        Professor professor4 = new Professor("Clara Mendes", "44455566677", "clara@escola.com", "444555666", 4);
        Professor professor5 = new Professor("Lucas Almeida", "55566677788", "lucas@escola.com", "555666777", 5);
        Professor professor6 = new Professor("Fernanda Costa", "66677788899", "fernanda@escola.com", "666777888", 6);
        
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
        professores.add(professor4);
        professores.add(professor5);
        professores.add(professor6);

        // Populando disciplinas
        Disciplina disciplina1 = new Disciplina(1, "Matemática", "Matemática básica", 80);
        Disciplina disciplina2 = new Disciplina(2, "Português", "Gramática e literatura", 60);
        Disciplina disciplina3 = new Disciplina(3, "História", "História geral", 100);
        Disciplina disciplina4 = new Disciplina(4, "Geografia", "Geografia física e política", 60);
        Disciplina disciplina5 = new Disciplina(5, "Física", "Física básica", 40);
        Disciplina disciplina6 = new Disciplina(6, "Química", "Química geral", 80);
        
        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);
        disciplinas.add(disciplina3);
        disciplinas.add(disciplina4);
        disciplinas.add(disciplina5);
        disciplinas.add(disciplina6);

        // Associando professores às disciplinas
        disciplina1.adicionarProfessor(professor1);
        disciplina2.adicionarProfessor(professor2);
        disciplina3.adicionarProfessor(professor3);
        disciplina4.adicionarProfessor(professor4);
        disciplina5.adicionarProfessor(professor5);
        disciplina6.adicionarProfessor(professor6);

        // Populando estudantes
        Estudante estudante1 = new Estudante("Carlos Souza", "11122233344", "carlos@escola.com", "111222333", 1, null, new ArrayList<>());
        Estudante estudante2 = new Estudante("Ana Lima", "55566677788", "ana@escola.com", "555666777", 2, null, new ArrayList<>());
        Estudante estudante3 = new Estudante("Bruno Ferreira", "22233344455", "bruno@escola.com", "222333444", 3, null, new ArrayList<>());
        Estudante estudante4 = new Estudante("Mariana Silva", "33344455566", "mariana@escola.com", "333444555", 4, null, new ArrayList<>());
        Estudante estudante5 = new Estudante("Renato Lima", "44455566677", "renato@escola.com", "444555666", 5, null, new ArrayList<>());
        Estudante estudante6 = new Estudante("Juliana Costa", "55566677788", "juliana@escola.com", "555666777", 6, null, new ArrayList<>());
        Estudante estudante7 = new Estudante("Gabriel Nunes", "66677788800", "gabriel@escola.com", "666777888", 7, null, new ArrayList<>());
        Estudante estudante8 = new Estudante("Larissa Rocha", "77788899911", "larissa@escola.com", "777888999", 8, null, new ArrayList<>());

        estudantes.add(estudante1);
        estudantes.add(estudante2);
        estudantes.add(estudante3);
        estudantes.add(estudante4);
        estudantes.add(estudante5);
        estudantes.add(estudante6);
        estudantes.add(estudante7);
        estudantes.add(estudante8);

        // Populando turmas
        List<Disciplina> disciplinasTurma1 = new ArrayList<>();
        disciplinasTurma1.add(disciplina1);
        disciplinasTurma1.add(disciplina2);
        Turma turma1 = new Turma(1, "Turma Fundamentos", disciplinasTurma1);

        List<Disciplina> disciplinasTurma2 = new ArrayList<>();
        disciplinasTurma2.add(disciplina3);
        disciplinasTurma2.add(disciplina4);
        Turma turma2 = new Turma(2, "Turma Humanas", disciplinasTurma2);

        List<Disciplina> disciplinasTurma3 = new ArrayList<>();
        disciplinasTurma3.add(disciplina5);
        disciplinasTurma3.add(disciplina6);
        Turma turma3 = new Turma(3, "Turma Exatas", disciplinasTurma3);

        turmas.add(turma1);
        turmas.add(turma2);
        turmas.add(turma3);

        // Associando estudantes à turma
        turma1.adicionarEstudante(estudante1);
        turma1.adicionarEstudante(estudante2);
        turma1.adicionarEstudante(estudante3);
        turma1.adicionarEstudante(estudante4);

        turma2.adicionarEstudante(estudante3);
        turma2.adicionarEstudante(estudante4);
        turma2.adicionarEstudante(estudante5);
        turma2.adicionarEstudante(estudante6);

        turma3.adicionarEstudante(estudante7);
        turma3.adicionarEstudante(estudante8);
        turma3.adicionarEstudante(estudante1);
        turma3.adicionarEstudante(estudante2);
    }
}
