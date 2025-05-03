#MODELS
---

### 1. **Classe `Disciplina`**
   - **Atributos afetados**: `professores` e `turmas`.
   - **Motivo**: Gerenciar melhor as associações entre disciplinas, professores e turmas.

   **Sugestão**:
   Substituir o acesso direto às listas por métodos como `getProfessores()`, `addProfessor(Professor professor)`, `removeProfessor(Professor professor)`, `getTurmas()`, `addTurma(Turma turma)` e `removeTurma(Turma turma)`.

   **Exemplo**:
   ```java
   public List<Professor> getProfessores() {
       return this.professores;
   }

   public void addProfessor(Professor professor) {
       if (!this.professores.contains(professor)) {
           this.professores.add(professor);
           professor.adicionarDisciplina(this); // Atualiza a associação no professor
       }
   }

   public void removeProfessor(Professor professor) {
       if (this.professores.contains(professor)) {
           this.professores.remove(professor);
           professor.removeDisciplina(this); // Remove a associação no professor
       }
   }
   ```

---

### 2. **Classe `Turma`**
   - **Atributos afetados**: `disciplinas` e `estudantes`.
   - **Motivo**: Controlar melhor a adição e remoção de estudantes e disciplinas.

   **Sugestão**:
   Criar métodos como `getDisciplinas()`, `addDisciplina(Disciplina disciplina)`, `removeDisciplina(Disciplina disciplina)`, `getEstudantes()`, `addEstudante(Estudante estudante)` e `removeEstudante(Estudante estudante)`.

   **Exemplo**:
   ```java
   public void addEstudante(Estudante estudante) {
       if (!this.estudantes.contains(estudante)) {
           this.estudantes.add(estudante);
           estudante.setTurma(this); // Atualiza a referência no estudante
       }
   }

   public void removeEstudante(Estudante estudante) {
       if (this.estudantes.contains(estudante)) {
           this.estudantes.remove(estudante);
           estudante.setTurma(null); // Remove a referência no estudante
       }
   }
   ```

---

### 3. **Classe `Estudante`**
   - **Atributos afetados**: `turma`.
   - **Motivo**: Garantir que a associação entre estudante e turma seja consistente.

   **Sugestão**:
   Criar métodos como `getTurma()` e `setTurma(Turma turma)` para encapsular a lógica de associação.

   **Exemplo**:
   ```java
   public Turma getTurma() {
       return this.turma;
   }

   public void setTurma(Turma turma) {
       if (this.turma != null) {
           this.turma.removeEstudante(this); // Remove o estudante da turma anterior
       }
       this.turma = turma;
       if (turma != null && !turma.getEstudantes().contains(this)) {
           turma.addEstudante(this); // Adiciona o estudante à nova turma
       }
   }
   ```

---

### 4. **Classe `Professor`**
   - **Atributos afetados**: `disciplinas`.
   - **Motivo**: Gerenciar melhor a relação entre professores e disciplinas.

   **Sugestão**:
   Criar métodos como `getDisciplinas()`, `addDisciplina(Disciplina disciplina)` e `removeDisciplina(Disciplina disciplina)`.

   **Exemplo**:
   ```java
   public void addDisciplina(Disciplina disciplina) {
       if (!this.disciplinas.contains(disciplina)) {
           this.disciplinas.add(disciplina);
           disciplina.addProfessor(this); // Atualiza a associação na disciplina
       }
   }

   public void removeDisciplina(Disciplina disciplina) {
       if (this.disciplinas.contains(disciplina)) {
           this.disciplinas.remove(disciplina);
           disciplina.removeProfessor(this); // Remove a associação na disciplina
       }
   }
   ```

---

#CONTROLLERS

---

### **1. `ProfessorController`**
- **Objetivo**: Gerenciar as associações entre professores e disciplinas.
- **Sugestões**:
  - Utilize métodos como `getDisciplinas()` e `setDisciplinas()` no modelo `Professor` para encapsular a lógica de manipulação.
  - No controller, valide se a disciplina já está associada antes de adicionar ou remover.

**Exemplo**:
```java
public static void adicionarDisciplinaProfessor(Scanner scanner, List<Professor> professores, List<Disciplina> disciplinas) {
    System.out.print("Digite o ID do professor: ");
    int idProfessor = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Digite o código da disciplina: ");
    String codigoDisciplina = scanner.nextLine();

    Professor professor = professores.stream()
            .filter(p -> p.idProfessor == idProfessor)
            .findFirst()
            .orElse(null);

    Disciplina disciplina = disciplinas.stream()
            .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
            .findFirst()
            .orElse(null);

    if (professor != null && disciplina != null) {
        professor.adicionarDisciplina(disciplina);
        System.out.println("Disciplina adicionada ao professor com sucesso.");
    } else {
        System.out.println("Professor ou disciplina não encontrado.");
    }
}
```

---

### **2. `EstudanteController`**
- **Objetivo**: Gerenciar as associações entre estudantes e turmas.
- **Sugestões**:
  - Utilize métodos como `setTurma()` no modelo `Estudante` para garantir que a associação seja consistente.
  - No controller, valide se o estudante já pertence à turma antes de adicionar.

**Exemplo**:
```java
public static void adicionarEstudanteTurma(Scanner scanner, List<Estudante> estudantes, List<Turma> turmas) {
    System.out.print("Digite a matrícula do estudante: ");
    String matricula = scanner.nextLine();
    System.out.print("Digite o ID da turma: ");
    int idTurma = scanner.nextInt();
    scanner.nextLine();

    Estudante estudante = estudantes.stream()
            .filter(e -> e.matricula.equalsIgnoreCase(matricula))
            .findFirst()
            .orElse(null);

    Turma turma = turmas.stream()
            .filter(t -> t.idTurma == idTurma)
            .findFirst()
            .orElse(null);

    if (estudante != null && turma != null) {
        estudante.setTurma(turma);
        System.out.println("Estudante adicionado à turma com sucesso.");
    } else {
        System.out.println("Estudante ou turma não encontrado.");
    }
}
```

---

### **3. `DisciplinaController`**
- **Objetivo**: Gerenciar as associações entre disciplinas, professores e turmas.
- **Sugestões**:
  - Utilize métodos como `addProfessor()` e `addTurma()` no modelo `Disciplina` para encapsular a lógica.
  - No controller, valide se a associação já existe antes de adicionar.

**Exemplo**:
```java
public static void adicionarTurmaDisciplina(Scanner scanner, List<Disciplina> disciplinas, List<Turma> turmas) {
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
```

---

### **4. `TurmaController`**
- **Objetivo**: Gerenciar as associações entre turmas, estudantes e disciplinas.
- **Sugestões**:
  - Utilize métodos como `addEstudante()` e `addDisciplina()` no modelo `Turma` para encapsular a lógica.
  - No controller, valide se o estudante ou disciplina já está associado antes de adicionar.

**Exemplo**:
```java
public static void adicionarDisciplinaTurma(Scanner scanner, List<Turma> turmas, List<Disciplina> disciplinas) {
    System.out.print("Digite o ID da turma: ");
    int idTurma = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Digite o código da disciplina: ");
    String codigoDisciplina = scanner.nextLine();

    Turma turma = turmas.stream()
            .filter(t -> t.idTurma == idTurma)
            .findFirst()
            .orElse(null);

    Disciplina disciplina = disciplinas.stream()
            .filter(d -> d.codigo.equalsIgnoreCase(codigoDisciplina))
            .findFirst()
            .orElse(null);

    if (turma != null && disciplina != null) {
        turma.disciplinas.add(disciplina);
        System.out.println("Disciplina adicionada à turma com sucesso.");
    } else {
        System.out.println("Turma ou disciplina não encontrada.");
    }
}
```

---

# Modificações necessárias na classe App:

1. **Manipulação de associações entre `Professor` e `Disciplina`:**
   - Substituir o acesso direto às listas por métodos como `addDisciplina()` e `removeDisciplina()` ao associar ou desassociar disciplinas de professores.

2. **Manipulação de associações entre `Estudante` e `Turma`:**
   - Utilizar o método `setTurma()` para garantir que a associação entre estudantes e turmas seja consistente.

3. **Manipulação de associações entre `Turma` e `Disciplina`:**
   - Substituir o acesso direto às listas por métodos como `addDisciplina()` e `removeDisciplina()` ao associar ou desassociar disciplinas de turmas.

4. **Manipulação de associações entre `Disciplina` e `Turma`/`Professor`:**
   - Utilizar os métodos `addProfessor()` e `addTurma()` para gerenciar as associações de forma encapsulada.