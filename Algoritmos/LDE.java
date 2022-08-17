class No<T>{
    public T valor;
    public No<T> proximo;

}

class listaDinamicaEncadeada<T extends Comparable<T>>{
    private No<T> primeiro = null;

    public boolean insere(T valor){
        No<T> novo = new No<>();
        novo.valor = valor;
        novo.proximo = null;
        
        No<T> anterior = null;
        No<T> atual = this.primeiro;

        while(atual != null && atual.valor.compareTo(valor) < 0){
            anterior = atual;
            atual = atual.proximo;
        }
        if(anterior != null){
            anterior.proximo = novo;
        }
        else{
            this.primeiro = novo;
        }
        novo.proximo = atual;
        return true;

    }

    public void imprime(){
        No<T> atual = this.primeiro;
        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        
    }

}

// Lista Dinamica encadeada 

// 1° criar o nó
// 2° preencher
// 3° fazer as conexões
// 4° n++

public class LDE{
    public static void main(String[] args){
       listaDinamicaEncadeada<Integer> lde = new listaDinamicaEncadeada<>();
       lde.insere(5);
       lde.insere(9);
       lde.insere(3);
       lde.insere(8);
       lde.insere(18);

       lde.imprime();
    }
}
