
interface IFila{
    boolean enfileira(int valor);
    int desinfileira() throws Exception;
    boolean isEmpty();
}

class FilaEstaticaCircular implements IFila{
    private int v[];
    private int TAM;
    private int i, f;
    public FilaEstaticaCircular(int TAM){
        v = new int [TAM+1];
        this.TAM = TAM + 1;
        this.i = 0;
        this.f = 0;
    }

    @Override
    public boolean enfileira(int valor) {
        if((f+1) % TAM == i) return false;
        v[f] = valor;
        f = (f+1) % TAM;
        return true;
    }

    @Override
    public int desinfileira() throws Exception {
        if(i == f) throw new Exception("A FILA JÁ ESTÁ VAZIA");
        int t = v[i];
        i = (i + 1) % TAM;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return i == f;
    }

}

public class FEC{
    public static void main(String[] args) throws Exception{
        IFila f = new FilaEstaticaCircular(5);
        f.enfileira(5);
        f.enfileira(2);
        f.enfileira(7);
        f.enfileira(1);
        f.enfileira(3);
        while( !f.isEmpty() ){
            int x = f.desinfileira();
            System.out.println(x);
        }

    }
}