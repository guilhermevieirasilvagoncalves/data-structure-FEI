#include <iostream>

using namespace std;

class IFila{
    public:
        virtual bool enfileira(int valor) = 0;
        virtual int desinfileira() = 0;
        virtual bool isEmpty() = 0;
        virtual ~IFila() = default;
};

class FilaEstaticaCircular : public IFila{
    private:
        int *v;
        int TAM;
        int i,f;
    public:
        FilaEstaticaCircular(int TAM);
        bool enfileira(int valor){
             if((f+1) % TAM == i) return false;
            v[f] = valor;
            f = (f+1) % TAM;
            return true;
        }
        int desinfileira(){
            if(i == f) throw invalid_argument("A FILA ESTÁ CHEIA");
            int t = v[i];
            i = (i + 1) % TAM;
            return t;
        }
        bool isEmpty(){
            return i == f;
        }
};

FilaEstaticaCircular::FilaEstaticaCircular(int TAM){
    this->v = new int[TAM + 1];
    this->TAM = TAM + 1;
    this->i = 0;
    this->f = 0;
}

int main(){
    IFila *f = new FilaEstaticaCircular(5);
    f->enfileira(5);
    f->enfileira(2);
    f->enfileira(7);
    f->enfileira(1);
    f->enfileira(3);
    while(!f->isEmpty()){
        int x = f->desinfileira();
        cout << x << endl;
    }
}