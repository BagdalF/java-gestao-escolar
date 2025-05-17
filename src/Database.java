
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
        Professor professor1 = EntityFactory.criarProfessor("João Silva", "12345678900", "joao@escola.com", "123456789", 1);
        Professor professor2 = EntityFactory.criarProfessor("Maria Oliveira", "98765432100", "maria@escola.com", "987654321", 2);
        professores.add(professor1);
        professores.add(professor2);

        // Populando disciplinas
        Disciplina disciplina1 = EntityFactory.criarDisciplina(1, "Matemática", "Matemática básica", 60);
        Disciplina disciplina2 = EntityFactory.criarDisciplina(2, "Português", "Gramática e literatura", 60);
        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);

        // Associando professores às disciplinas
        disciplina1.adicionarProfessor(professor1);
        disciplina2.adicionarProfessor(professor2);

        // Populando estudantes
        Estudante estudante1 = EntityFactory.criarEstudante("Carlos Souza", "11122233344", "carlos@escola.com", "111222333", 1, null, new ArrayList<>());
        Estudante estudante2 = EntityFactory.criarEstudante("Ana Lima", "55566677788", "ana@escola.com", "555666777", 2, null, new ArrayList<>());
        estudantes.add(estudante1);
        estudantes.add(estudante2);

        // Populando turmas
        List<Disciplina> disciplinasTurma1 = new ArrayList<>();
        disciplinasTurma1.add(disciplina1);
        disciplinasTurma1.add(disciplina2);
        Turma turma1 = EntityFactory.criarTurma(1, "Turma A", disciplinasTurma1);
        turmas.add(turma1);

        // Associando estudantes à turma
        turma1.adicionarEstudante(estudante1);
        turma1.adicionarEstudante(estudante2);
    }
}
