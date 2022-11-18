/*
    @author: Guilherme Vieira Silva Gonçalves
    @course: Ciência da Computação, 4th semester
*/

#include <iostream>
#define MAX 10

using namespace std;

class PES{
    private:
        int pilha[MAX];
        int n = 0;
        int topo = -1;

    public:
        bool empilha(int valor){
            if(n >= MAX){
                throw invalid_argument("Pilha Cheia");
                return false;
            }
            topo++;
            pilha[topo] = valor;
            n++;
            return true;
        }
        int desempilha(){
            if(n <= 0){
                throw invalid_argument("Pilha Vazia");
                return -1;
            }
            int temp = pilha[topo];
            topo--;
            n--;
            return temp;
        }
        void imprime(){
            for(int i = topo; i >= 0; i--){
                cout << pilha[i] << endl;
            }
        }

};

int main(){
    PES *P = new PES();
    P->empilha(1);
    P->empilha(3);
    P->empilha(4);
    P->imprime();
    cout << "--------------" << endl;
    P->desempilha();
    P->desempilha();
    P->empilha(3);
    P->imprime();
    
}
