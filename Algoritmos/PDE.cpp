#include <iostream>

using namespace std;

class No{
    public:
        int valor;
        No *proximo;
        No *topo;
        No(int valor){
            this->valor = valor;
        }
};

class PilhaDinamicaEncadeada{
    private:
        No *topo = NULL;
        int n = 0;
    public:
        bool empilha(int valor){
            No *novo = new No(valor);
            novo->proximo = topo;
            topo = novo;
            n++;
            return true;
        }
        No desempilha(){
            No *temp = topo;
            topo = topo->proximo;
            n--;
            return *temp;
        }
        void imprime(){
            No *atual = topo;
            while(atual){
                cout << atual->valor << endl;
                atual = atual->proximo;
            }
        }
};


int main(int argc, char const *argv[])
{
    PilhaDinamicaEncadeada *P = new PilhaDinamicaEncadeada();
    P->empilha(3);
    P->empilha(4);
    P->empilha(2);
    P->imprime();
    cout << "---------------" << endl; 
    P->desempilha();
    P->desempilha();
    P->imprime();
}
