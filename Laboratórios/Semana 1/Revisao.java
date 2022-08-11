public class Revisao {

    public static void main(String[] args) {
        BaseDados base = new OracleDataBase();
        calculadoraNotas calc = new CalculadoraNotaImpl(base);
        calc.imprimeNotas();
        //aluno.imprime();
    }
    
}