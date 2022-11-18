  import java.util.LinkedList;
  import java.util.Queue;
  import java.util.Scanner;
  import java.util.Stack;

  class WcMProblem{
    public String expression;

      public String getExpression() {
          return this.expression;
      }
  }

  public class Main {

    public static boolean process(WcMProblem spec) {
      String input = spec.getExpression();
      int count = 0;
      Queue<Character> M = new LinkedList<>();
      Stack<Character> W = new Stack<Character>();
      boolean troca = true;
      for(int i = 0; i < input.length();i++){ 
        if((input.charAt(i) < 'a' && input.charAt(i) > 'c')){ 
        return false;
      }
          if(input.charAt(i) != 'c'){
              if(troca){
                Character p = input.charAt(i);
                M.add(p);
        } else{
              Character p = input.charAt(i);
              W.push(p);
        }   
          }
          else {
        troca = false;
        count++;
      }
      }
      if(count != 1){
      return false;
    }
      while(!W.empty() && !M.isEmpty()){ 
      char m = M.element(); 
      char w = W.peek(); 
      //System.out.println(m);
      //System.out.println(w);
      W.pop(); M.remove(); 
      if(m != w){ 
          return false;
      }
    }
      if(!W.empty() || !M.isEmpty()){
        return false;
      }
      return true;
    }

    public static void main(String[] args) {
      WcMProblem spec = new WcMProblem();
      try (Scanner s = new Scanner(System.in)) {
        spec.expression = s.nextLine();
      }
      boolean result = Main.process(spec);
      System.out.println(result ? "válida" : "inválida");
    }
  }