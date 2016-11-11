package instituicaoEnsino;


public class Curso {
    
    private int id;
    private int codigo;
    private String nome;
    private String turno;

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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public Curso(int codigo, String nome, String turno){
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;       
    }
    
    public static void ImprimirDados(Curso c){
        System.out.println("Código: " + c.getCodigo());
        System.out.println("Nome: " + c.getNome());
    }
}
