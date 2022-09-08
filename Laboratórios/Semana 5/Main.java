class No {
    public int valor;
    public No proximo;
  }
  
  class ListaEncadeada {
    public No primeiro = null;
    public void print() {
      No atual = primeiro;
      while(atual!=null){
        System.out.printf("%d ", atual.valor);
        atual = atual.proximo;
      }
        System.out.println();
    }
    public No elementoCentral(){
        int index = 0;
        No atual = primeiro;
        while(atual != null){
            atual = atual.proximo;
            index++;
        }
        if(index % 2 != 0){
            int posi = Math.round(index/2);
            int i = 0;
            atual = primeiro;
            while(i != posi){
                atual = atual.proximo;
                i++;
            }
            return atual;
        }
        else{
            int posi = (index/2) - 1;
            int i = 0;
            atual = primeiro;
            while(i != posi){
                atual = atual.proximo;
                i++;
            }
            return atual;
        }
    }
  }
  
  
  public class Main {
    public static ListaEncadeada criaListaTeste(int nmax){
      ListaEncadeada lista = new ListaEncadeada();
      No primeiro=null;
      No ultimo=null;
      for (int i = 0; i < nmax; i++) {
        No novo = new No();
        novo.proximo=null;
        novo.valor = i;
        if(primeiro == null)
          primeiro=novo;
        else{
          ultimo.proximo = novo;
        }
        ultimo = novo;
      }
      lista.primeiro = primeiro;
      return lista;
    }
    public static void main(String[] args) {
      int exemplos[] = {6,2,7,8,12,3}; 
      for (int i = 0; i < exemplos.length; i++) {
        ListaEncadeada l = criaListaTeste(exemplos[i]);
        l.print();
        No central = l.elementoCentral();
        System.out.println(central.valor);
      }
    }
  }
  