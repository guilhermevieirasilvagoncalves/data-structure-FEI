/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : main
 * @created     : quarta set 01, 2021 21:38:51 -03
 */

interface ILista{
  public boolean insere(int valor);
  public boolean remove(int idx);
  public int busca(int valor);
  public void imprime();
}

class Lista implements ILista{
  private int n;
  private int capacity;
  private int[] v;
  public Lista(int capacity){
    this.n = 0;
    this.capacity = capacity;
    this.v = new int[this.capacity];
  }

  public boolean insere(int valor){
    if (this.capacity == this.n)
      return false;

    this.v[this.n] = valor;
    this.n++;
    return true;
  }

  public boolean remove(int idx){
    if (idx < 0 || idx >= n)
      return false;

    for (int i = idx; i < n-1; i++) {
      v[i] = v[i+1];
    }
    n--;
    return true;
  }

  public int busca(int valor){
    for (int i = 0; i < n; i++) {
      if(v[i] == valor)
        return i;
    }

    return -1;
  }

  public void imprime(){
    for (int i = 0; i < n; i++) {
      System.out.println(v[i]);
    }
  }

}

class ListaOrdenada implements ILista{
  private int[] v;
  private int n;
  private int capacidade;
  ListaOrdenada(int capacidade){
    this.capacidade = capacidade;
    this.n = 0;
    this.v = new int[capacidade];
  }

  public boolean insere(int valor){
    if(n >= this.capacidade) return false;
    int k = 0;
    for(k = 0; k < n && v[k] <= valor;k++); 
    for(int i = n-1; i >= k; i--) v[i+1] = v[i];
    v[k] = valor;
    n++;
    return true;
    
  }
  public boolean remove(int idx){
    if(this.n != 0){
        for(int i = idx; i < this.n - 1; i++){
            v[i] = v[i+1];
        }
        n--;
        return true;
    }
    return false;
  }
  public int busca(int valor){
    // Implementar BUSCA BINÁRIA
    int esq = 0;
    int dir = n-1;

    while (esq <= dir){
      int pivo = (esq + dir)/2;
      if (valor < v[pivo] ){
        dir = pivo - 1;
      }else if (valor > v[pivo]){
        esq = pivo + 1;
      }else{
        return pivo;
      }
    }
  
    return -1;
  }
  public void imprime(){
    for (int i = 0; i < n; i++) {
      System.out.println(v[i]);
    }
  }
}

public class Main
{
    public static void testa(ILista lista){
      System.out.println("Iniciando teste: ");
        int v[] = {6,3,8,6,4,2,8,0,1};

        for (int i : v) {
          lista.insere(i);
        }
        lista.imprime();
        System.out.println("======");
        lista.remove(3);
        lista.remove(0);
        lista.remove(lista.busca(8));
        lista.imprime();
      System.out.println("Fim do teste: ");
    }
    public static void main(String args[])
    {
      testa(new Lista(10));
      testa(new ListaOrdenada(10));
      testa(new Lista(5));
      testa(new ListaOrdenada(5));
    }
}


