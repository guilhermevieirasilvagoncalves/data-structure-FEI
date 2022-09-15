class FilaVaziaException extends Exception{
      public FilaVaziaException() {
            super("Fila Vazia!");
      }
}
interface IFila{
      public boolean enfileira(int valor);
      public int desenfileira() throws FilaVaziaException;
      public int capacidade();
      public int tamanho();
}
class FilaEstaticaCircular implements IFila {
      int v[];
      int i=0;
      int f=0;
      int n=0;
      int cap;
      public FilaEstaticaCircular(int Capacidade) {
            cap = Capacidade+1; //Sentinela
            v = new int[cap];
      }
      @Override
      public boolean enfileira(int valor) {
            if((f+1) % cap == i) return false;
            v[f] = valor;
            f = (f+1) % cap;
            n++;
            return true;
      }
      @Override
      public int desenfileira() throws FilaVaziaException {
            if (i==f)
                  throw new FilaVaziaException();
            
            int t = v[i];
            i = (i + 1) % cap;
            n--;
            return t;
      }
      @Override
      public int capacidade() {
            return cap;
      }
      @Override
      public int tamanho() {
            return n;
      }

}

public class as{
      public static void main(String args[]) throws FilaVaziaException{
            IFila f = new FilaEstaticaCircular(10);
            f.enfileira(1);
            f.enfileira(2);
            f.enfileira(3);
            System.out.println(f.desenfileira());
            System.out.println(f.desenfileira());
            System.out.println(f.tamanho());
            f.enfileira(4);
            f.enfileira(5);
            f.enfileira(6);
            System.out.println(f.tamanho());
            f.enfileira(7);
            System.out.println(f.desenfileira());
            System.out.println(f.tamanho());
            f.enfileira(8);
            f.enfileira(9);
            System.out.println(f.desenfileira());
            f.enfileira(10);
            System.out.println(f.tamanho());
            
            while(f.tamanho()>0){
                  System.out.println(f.desenfileira());
            }
      }
}
