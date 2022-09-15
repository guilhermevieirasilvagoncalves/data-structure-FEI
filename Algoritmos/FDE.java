/*
    @author: Guilherme Vieira Silva Gonçalves
    @course: Ciência da Computação, 3th semester
*/

class No {
    public int valor;
    public No proximo;
    public No primeiro;
    public No ultimo;
    public No(int valor){
      this.valor = valor;
      this.primeiro = null;
    }

    public int getValor(){
      return valor;
    }

}

class FilaDinamicaEncadeada{
    private No primeiro = null;
    private No ultimo = null;
    private int n = 0;

    public boolean enfileira(int valor){
        No novo = new No(valor);
        if(ultimo != null){
            ultimo.proximo = novo;
        }
        else{
            primeiro = novo;
        }
        ultimo = novo;
        n++;  
        return true;

    }

    public boolean desinfileira() {
        if(primeiro != null){
            primeiro = primeiro.proximo;
        }
        System.gc();
        n--;
        return true;
    }

    public void imprime() {
        No atual = primeiro;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}


public class FDE {
    public static void main(String args[ ]){
        FilaDinamicaEncadeada L = new FilaDinamicaEncadeada();
        L.enfileira(3);
        L.enfileira(4);
        L.enfileira(2);
        L.imprime();
        System.out.println("---------------------");
        L.desinfileira();
        L.desinfileira();
        L.imprime();

    }
}
