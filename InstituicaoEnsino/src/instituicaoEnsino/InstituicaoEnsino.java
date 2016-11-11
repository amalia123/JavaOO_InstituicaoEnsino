package instituicaoEnsino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstituicaoEnsino {

    private static Scanner leitor = new Scanner(System.in);

    private static List<Aluno> alunos;

    public static List<Aluno> getAlunos() {
        return alunos;
    }

    private static List<Curso> cursos;

    public static List<Curso> getCursos() {
        return cursos;
    }
    
    private static List<Matricula> matriculas;
    
    public static List<Matricula> getMatriculas(){
        return matriculas;
    }
    
    

    public static void main(String[] args) {
        int opcao = 0;

        alunos = new ArrayList<Aluno>();

        cursos = new ArrayList<Curso>();
        
        matriculas = new ArrayList<Matricula>();
        
        
        GerarMassaTeste();

        do {
            opcao = Menu();

            switch (opcao) {
                case 1:
                    CadastrarAluno();
                    break;
                case 2:
                    ExibirAlunosCadastrados();
                    break;
                case 3:
                    PesquisarAlunoPorCodigo();
                    break;
                case 4:
                    AlterarAluno();
                    break;
                case 5:
                    ExcluirAluno();
                    break;
                case 6:
                    CadastrarCurso();
                    break;

                case 11:
                    MatricularAluno();
                    break;
                    
                case 12:
                    ExibirMatriculas();
                    break;
            }

        } while (opcao != 16);

    }

    private static int Menu() {
        System.out.println("---------------------");

        // aluno
        System.out.println(" 1 - Cadastrar Aluno ");
        System.out.println(" 2 - Exibir alunos cadastrados ");
        System.out.println(" 3 - Pesquisar aluno por codigo ");
        System.out.println(" 4 - Alterar aluno");
        System.out.println(" 5 - Excluir aluno");

        // curso
        System.out.println(" 6 - Cadastrar Curso ");
        System.out.println(" 7 - Exibir cursos cadastrados ");
        System.out.println(" 8 - Pesquisar curso por codigo ");
        System.out.println(" 9 - Alterar curso");
        System.out.println(" 10 - Excluir curso");

        System.out.println(" 11 - Matricular aluno");
        System.out.println(" 12 - Exibir matriculas");

        System.out.println("16 - SAIR");
        System.out.print("Digite sua opcao:");

        int op = leitor.nextInt();
        leitor.nextLine();
        System.out.println("---------------------");

        return op;
    }

    private static void CadastrarAluno() {
        System.out.println("Cadastrando aluno");

        System.out.print("Digite o codigo: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite o nome do aluno: ");
        String nome = leitor.nextLine();

        Aluno a = new Aluno(cod, nome);

        InstituicaoEnsino.alunos.add(a);
    }

    private static void CadastrarCurso() {
        System.out.println("Cadastrando curso");

        System.out.print("Digite o codigo: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        System.out.print("Digite o nome do curso: ");
        String nome = leitor.nextLine();

        System.out.print("Digite o turno do curso: ");
        String turno = leitor.nextLine();

        Curso c = new Curso(cod, nome, turno);

        InstituicaoEnsino.getCursos().add(c);
    }

    private static void ExibirAlunosCadastrados() {
        for (Aluno a : alunos) {
            Aluno.ImprimirDados(a);
        }
    }

    private static void PesquisarAlunoPorCodigo() {
        System.out.print("Digite o codigo do aluno: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        Aluno a = BuscarAlunoPorCodigo(cod);

        if (a != null) {
            Aluno.ImprimirDados(a);
        } else {
            System.out.println("Aluno não cadastrado");
        }
    }

    private static Aluno BuscarAlunoPorCodigo(int codigo) {
        for (Aluno a : alunos) {
            if (codigo == a.getCodigo()) {
                return a;
            }
        }

        return null;
    }

    private static Curso BuscarCursoPorCodigo(int codigo) {
        for (Curso c : cursos) {
            if (codigo == c.getCodigo()) {
                return c;
            }
        }

        return null;
    }

    private static void AlterarAluno() {
        System.out.print("Digite o codigo do aluno: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        Aluno a = BuscarAlunoPorCodigo(cod);

        if (a != null) {
            System.out.print("Digite o novo codigo (anterior: " + a.getCodigo() + "): ");
            int codAluno = leitor.nextInt();
            leitor.nextLine();
            a.setCodigo(codAluno);

            System.out.print("Digite o novo nome (anterior: " + a.getNome() + "): ");
            String nomeAluno = leitor.nextLine();
            a.setNome(nomeAluno);

            System.out.println("Aluno alterado com sucesso");
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    private static void ExcluirAluno() {
        System.out.print("Digite o codigo do aluno: ");
        int cod = leitor.nextInt();
        leitor.nextLine();

        Aluno a = BuscarAlunoPorCodigo(cod);

        if (a != null) {
            InstituicaoEnsino.alunos.remove(a);
            System.out.println("Aluno removido com sucesso");
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    private static void MatricularAluno() {
        System.out.print("Digite o codigo do aluno: ");
        int codAluno = leitor.nextInt();
        leitor.nextLine();

        Aluno a = BuscarAlunoPorCodigo(codAluno);

        if (a != null) {
            System.out.println("Aluno encontrado:");
            Aluno.ImprimirDados(a);
            
            System.out.print("Digite o codigo do curso: ");
            int codCurso = leitor.nextInt();
            leitor.nextLine();

            Curso c = BuscarCursoPorCodigo(codCurso);
            
            

            if (c != null) {
                
                System.out.println("Curso encontrado:");
                Curso.ImprimirDados(c);
                
                // efetuar a matricula
                Matricula m = new Matricula();
                
                m.setAluno(a);
                m.setCurso(c);
                
                InstituicaoEnsino.matriculas.add(m);
                
                System.out.println("Aluno matriculado com sucesso");
                
            } else {
                System.out.println("Curso não cadastrado");
            }

        } else {
            System.out.println("Aluno não cadastrado");
        }

    }

    private static void ExibirMatriculas() {
        for(Matricula mat : matriculas){
            Matricula.ImprimirDados(mat);
        }
    }

    private static void GerarMassaTeste() {
        for (int i = 0; i < 10; i++) {
            Aluno a = new Aluno(i+100, "Aluno " + (i+100));
            InstituicaoEnsino.alunos.add(a);
        }
        
        for (int i = 0; i < 5; i++) {
            Curso c = new Curso(i+500, "Curso " + (i+500), "noite");
            InstituicaoEnsino.cursos.add(c);
        }
        
        // Aluno 100 --> Curso 500
        Matricula m1 = new Matricula();
        m1.setAluno(InstituicaoEnsino.alunos.get(0));        
        m1.setCurso(InstituicaoEnsino.cursos.get(0));
        InstituicaoEnsino.matriculas.add(m1);
        
        // Aluno 100 --> Curso 501
        Matricula m2 = new Matricula();
        m2.setAluno(InstituicaoEnsino.alunos.get(0));        
        m2.setCurso(InstituicaoEnsino.cursos.get(1));
        InstituicaoEnsino.matriculas.add(m2);

    }

}
