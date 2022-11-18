/*
    @author: Guilherme Vieira Silva Gonçalves
    @course: Ciência da Computação, 4th semester
*/

class No {
    public int valor;
    public No proximo;
    public No topo;
    public No(int valor){
      this.valor = valor;
    }

    public int getValor(){
      return valor;
    }

}

class PilhaDinamicaEncadeada{
    private No topo = null;
    private int n = 0;

    public int getN() {
        return this.n;
    }

    public void setN(int n) {
        this.n = n;
    }


    public boolean empilha(int valor){
        No novo = new No(valor);
        novo.proximo = topo;
        topo = novo;
        n++;  
        return true;

    }

    public No desempilha() {
        No temp = topo;
        topo = topo.proximo;
        System.gc();
        n--;
        return temp;
        
    }

    public void imprime() {
        No atual = topo;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}


public class PDE {
    public static void main(String args[ ]){
        PilhaDinamicaEncadeada L = new PilhaDinamicaEncadeada();
        L.empilha(3);
        L.empilha(4);
        L.empilha(2);
        L.imprime();
        System.out.println("---------------------");
        L.desempilha();
        L.desempilha();
        L.imprime();

    }
}

