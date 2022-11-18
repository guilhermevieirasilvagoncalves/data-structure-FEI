/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : main
 * @created     : quinta out 21, 2021 08:54:56 -03
 */

class No {
    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }
    public int valor;
    public No esq;
    public No dir;
    public No pai;
}

interface ArvBin {
    boolean insere(int valor);
    boolean remove(int valor);
    boolean busca(int valor);
    void imprime();
}

class ArvBinBusca implements ArvBin {
    public No raiz = null;
    private int n = 0;
    private void imprimeErd(No a) {
        if(a != null) {
            imprimeErd(a.esq);
            System.out.print(a.valor + "  ");
            imprimeErd(a.dir);
        }
    }

    public boolean insere(int valor) {
        No novo = new No(valor);

        No anterior = null;
        No atual = raiz;

        while(atual != null) {
            anterior = atual;
            if (valor <= atual.valor)
                atual = atual.esq;
            else
                atual = atual.dir;
        }

        novo.pai = anterior;
        if (anterior != null) {
            if (valor <= anterior.valor) {
                anterior.esq = novo;
            } else {
                anterior.dir = novo;
            }
        } else {
            raiz = novo;
        }
        n++;
        return true;
    }
    public int getN() {
        return n;
    }

    private boolean remove(No x) {
        if(x.dir == null && x.esq == null) {
            if(x.pai == null) {
                raiz = null;
            } else {
                if(x.pai.esq == x) {
                    x.pai.esq = null;
                } else {
                    x.pai.dir = null;
                }
            }
            this.n--;
            return true;
        } 
        if(x.dir == null && x.esq != null){
            No filho = x.esq;
            if(x == raiz){
                raiz = x.esq;
            }
            x.pai.esq = filho;
            filho.pai = x.pai;
            this.n--;
            return true;
        }
        if(x.dir != null && x.esq == null){
            No filho = x.dir;
            if(x == raiz){
                raiz = x.dir;
            }
            x.pai.dir = filho;
            filho.pai = x.pai;
            this.n--;
            return true;
        } 
        else {
            No sucessor = x.dir;
            while(sucessor.esq != null){
                sucessor = sucessor.esq;
            }
            x.valor = sucessor.valor;
            remove(sucessor);
        }
        return true;
    }

    public boolean remove(int valor) {
        No atual = raiz;
        while(atual != null) {
            if (valor < atual.valor)
                atual = atual.esq;
            else if (valor > atual.valor)
                atual = atual.dir;
            else
                return remove(atual);
        }

        return false;

    }

    public boolean busca(int valor) {
        No atual = raiz;
        while(atual != null) {
            if (valor < atual.valor)
                atual = atual.esq;
            else if (valor > atual.valor)
                atual = atual.dir;
            else
                return true;
        }

        return false;
    }

    public void imprime() {
        imprimeErd(raiz);
        System.out.println();
    }

}

public class main {
    private static void testeBusca(ArvBinBusca a, int valor) {
        if (a.busca(valor)) {
            System.out.println("valor " + valor + " encontrado na arvore");
        } else {
            System.out.println("valor " + valor + " NAO encontrado na arvore");
        }
    }
    private static void testeInsere(ArvBinBusca a, int valor) {
        if (a.insere(valor)) {
            System.out.println("valor " + valor + " inserido na arvore");
            a.imprime();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        }
    }
    private static void testeRemove(ArvBinBusca a, int valor) {
        if (a.remove(valor)) {
            System.out.println("valor " + valor + " removido da arvore");
            a.imprime();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        } else {
            System.out.println("valor " + valor + " NAO removido da arvore");
        }
    }
    public static void main(String[] args) {
        ArvBinBusca a = new ArvBinBusca();
        testeInsere(a, 51);
        testeInsere(a, 43);
        testeInsere(a, 5);
        testeInsere(a, 53);
        testeInsere(a, -15);
        testeInsere(a, 36);
        testeInsere(a, 17);
        testeInsere(a, 56);
        testeInsere(a, 55);
        testeInsere(a, 74);
        testeBusca(a, 55);
        testeBusca(a, 2);
        testeBusca(a, 15);
        testeBusca(a, 36);
        testeBusca(a, 22);
        testeBusca(a, -5);
        testeBusca(a, 55);
        testeBusca(a, 74);
        testeRemove(a, 51);
        testeRemove(a, 43);
        testeRemove(a, -15);
        testeRemove(a, 17);
        testeRemove(a, 56);
        testeRemove(a, 36);
        testeRemove(a, 36);
        testeRemove(a, 55);
        testeRemove(a, 74);
        testeRemove(a, 5);
        testeRemove(a, 53);

    }
}
