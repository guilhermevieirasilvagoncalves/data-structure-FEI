import java.util.Arrays;
import java.util.Random;

public class BuscaBinaria{
        static int[] criaVetor(int n){
            int x[] = new int[n];
            Random r = new Random();
            for(int i = 0; i < n; i++){
                x[i] = r.nextInt() % 1000;
            }
        
        return x;
    }
    static void imprime(int v[]){
        for (int i : v){
            System.out.printf("%d ",i);
        }
        System.out.println();
    }

    static int buscaLinear(int v[], int elemento){
        for(int i = 0; i < v.length; i++){
            if(v[i] == elemento){
                return i;
            }
        }
        return -1;
    }

    static int buscaBinaria(int v[], int elemento){
        int i = 0;
        int f = v.length - 1;
        while(i <= f){
            int pivo = (i+f)/2;
            if(elemento > v[pivo]) i = pivo + 1;
            else if(elemento < v[pivo]) f = pivo - 1;
            else return pivo;
        }
        return -1;
    }

    static int buscaBinaria(int v[], int elemento, int i, int f){
        if(i>f){
            return -1;
        }
        int pivo = (i+f)/2;
        if(elemento < v[pivo]){
            return buscaBinaria(v, elemento, i, pivo - 1);
        }
        else if(elemento > v[pivo]){
            return buscaBinaria(v, elemento, pivo + 1, f);
        }
        else return pivo;
    }


    public static void main(String args[]){
        for(int n = 100000;n < 1000000;n+=10000){
            int v[] = criaVetor(n);
            Arrays.sort(v);
            long inicio = System.nanoTime();
            buscaLinear(v, 750);
            long linearStep = System.nanoTime();
            buscaBinaria(v, 750);
            long binariaStep = System.nanoTime();
            System.out.printf("%d\t%d\t%d\n",n,linearStep-inicio,binariaStep-linearStep);
        }
    }
        
}
