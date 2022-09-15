/*
    @author: Guilherme Vieira Silva Gonçalves
    @course: Ciência da Computação, 3th semester
*/

class No {
    public int valor;
    public No proximo;
    public No(int valor){
      this.valor = valor;
      this.proximo = null;
    }

    public int getValor(){
      return valor;
    }

    public No getProximo(){
      return proximo;
    }
}

class FilaDinamicaEncadeada{
    private No primeiro;
    private int n;
    public FilaDinamicaEncadeada(){
      primeiro = null;
      n = 0;
    }

    public boolean enfileira(int valor){
        No novo = new No(valor);
        No anterior = null;
        No atual = primeiro;
        
        while(atual != null){
            anterior = atual;
            atual = atual.proximo;
        }
        if(anterior != null) anterior.proximo = novo;
        else primeiro = novo;

        novo.proximo = atual;
        n++;  
        return true;

    }

    public boolean desinfileira() {
        No atual = primeiro;
        while(atual != null) atual = atual.proximo;

        if(primeiro == null) return false;
        
        atual = primeiro;
        primeiro = primeiro.proximo;
        
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

