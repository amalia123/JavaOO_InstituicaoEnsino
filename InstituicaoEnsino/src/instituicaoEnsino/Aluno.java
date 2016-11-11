package instituicaoEnsino;

public class Aluno {
    
    private int id;
    private int codigo;
    private String nome;

    public int getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public Aluno(){       
        // ---
        this.id = InstituicaoEnsino.getAlunos().size() + 1;
    }
    
    
    public Aluno(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        
        // ---
        this.id = InstituicaoEnsino.getAlunos().size() + 1;
    }
    
    
    public static void ImprimirDados(Aluno aluno){
            System.out.println("----");
            System.out.println("id: " + aluno.getId());
            System.out.println("Codigo: " + aluno.getCodigo());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("----");
    }
    
}
