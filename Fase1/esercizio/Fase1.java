package esercizio;

public class Fase1 {

  public static int fibo(int n) {
    double phiLog10 = Math.log10(1.618033989f);
    double fiveSqrtLog10 = Math.log10(Math.sqrt(5));
    int curr = 0, nDigits = 0;
    while (Math.round((long) nDigits + 1) < n) {
      curr++;
      nDigits = (int) (curr * phiLog10 - fiveSqrtLog10);
    }
    return curr--;
  }

  public static void main(String[] args) {
    System.out.println("Result = " + fibo(Integer.parseInt(args[0])));
  }

}
