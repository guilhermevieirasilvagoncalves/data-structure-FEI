import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private List<Float> notas = new ArrayList<>();
    
    public Aluno(String nome){
        this.setNome(nome);
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public List<Float> getNotas(){
        return notas;
    }

    public Aluno addNota(float nota){
        notas.add(nota);
        return this;
    }

    public void imprime(){
        System.out.println("nome: " + this.nome);
    }

}
