#include <bits/stdc++.h>
#define MAX 10

// Lista Ordenada Sequencial

using namespace std;

class Lista{
    private:
        int v[MAX];
        int n;
    public:
        Lista(){
            n = 0;
        }
        bool insere(int num){
            // dá para inserir?
            if(n >= MAX) return false;
            // qual posição?
            int k = 0;
            for(k = 0; k < n && v[k] <= num;k++);
            for(int i = n-1; i >= k; i--) v[i+1] = v[i];
            v[k] = num;
            n++;
            return true;
        }
        void imprimeTudo(){
            for(int i = 0; i < n; i++){
                cout << v[i] << " ";
            }
        }    
};

// ordenação: 1° testar se da para inserir
// 2° descobrir a posição de inserção
// 3° mover os elementos 
// 4° inserir
// 5° n++

int main(){
    Lista l;
    int i = 0;
    //while(l.insere(i++));
    l.insere(1);
    l.insere(5);
    l.insere(7);
    l.insere(9);
    l.insere(6);
    l.imprimeTudo();
}
