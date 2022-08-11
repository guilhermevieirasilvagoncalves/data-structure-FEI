import java.util.ArrayList;
import java.util.List;

public class OracleDataBase implements BaseDados{
    public List<Aluno> getAlunos(){
        List<Aluno> lista = new ArrayList<>();
        lista.add(new Aluno("Guilherme").addNota(4f).addNota(5.6f));
        lista.add(new Aluno("João").addNota(7f).addNota(9.6f));
        return lista;
    }
}
