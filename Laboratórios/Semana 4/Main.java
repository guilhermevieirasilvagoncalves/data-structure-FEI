
/**
 * @author      : gwachs (gwachs@$HOSTNAME)
 * @file        : Main
 * @created     : quinta set 16, 2021 14:46:40 -03
 */

class No {
    public int valor;
    public No anterior;
    public No proximo;
}

interface ILista {
    boolean insere(int valor);
    boolean remove(int idx);
    void imprime();
    void imprimeReverso();
    int busca(int valor);
}

class Ldde implements ILista {
    private No primeiro = null;
    private No ultimo = null;
    private int n = 0;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public boolean insere(int valor) {
        No novo = new No();
        novo.proximo = null;
        novo.anterior = null;
        novo.valor = valor;
        No anterior = null;
        No atual = primeiro;
        while(atual != null && atual.valor < valor){
            anterior = atual;
            atual = atual.proximo;
        }
        if(anterior != null){
            anterior.proximo = novo;
            
        }
        else primeiro = novo;

        novo.anterior = anterior;

        if(atual != null){
            atual.anterior = novo;
        }
        else ultimo = novo;
        novo.proximo = atual;
        n++;

        return true;
    }

    @Override
    public boolean remove(int idx){
        No novo = new No();
        novo.proximo = null;
        novo.anterior = null;
        No anterior = null;
        No atual = primeiro;
        int index = 0;
        while(atual != null && index != idx){
            anterior = atual;
            atual = atual.proximo;
            index++;
        }
        if(atual == null){
            return false;
        }
        No proximo = atual.proximo;
        if(anterior != null) anterior.proximo = proximo;
        else primeiro = proximo;
        
        if(proximo != null) proximo.anterior = anterior;
        else ultimo = anterior;

        atual = null;
        System.gc();
        n--;
        return true;
       
    }

    @Override
    public void imprime() {
        No atual = primeiro;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }

    @Override
    public void imprimeReverso() {
        No atual = ultimo;
        while(atual != null) {
            System.out.println(atual.valor);
            atual = atual.anterior;
        }
    }

    @Override
    public int busca(int valor) {
    No atual = primeiro;
    int idx = 0;
    while(atual != null && atual.valor < valor){
        atual = atual.proximo;
        idx++;
    }
    if(atual != null && atual.valor == valor){
        return idx;
    }
    else{
        return -1;
    }
}


}


public class Main {
    public static void imprime(ILista l, String titulo) {
        System.out.println("==" + titulo + "==");
        l.imprime();
        System.out.println("=====Reverso====");
        l.imprimeReverso();
        System.out.println("======FIM=======");
    }
    public static void main(String[] args) {
        ILista l = new Ldde();
        l.insere(20);
        l.insere(10);
        l.insere(5);
        l.insere(35);
        l.insere(200);
        imprime(l, "Após Inserções");

        l.remove(3);
        imprime(l, "Após Remove indice 3");

        l.remove(l.busca(10));
        imprime(l, "Após Remove número 10");

        while(l.remove(0));

        imprime(l, "Após Remover todos");
    }
}
