import java.util.Scanner;

public class EntradaException {
	 private static Scanner scanner = new Scanner(System.in);
	 
	    public static long scannerLong() {
	        long l;
	        while (true) {
	            try {
	                l = scanner.nextLong();
	                break;
	            } catch (Exception InputMismatchException) {
	                System.out.println("Não é um numéro inteiro grande.");
	                scanner.next();
	                
	            }
	        }
	        return l;
	    }
	     
	    public static double scannerDouble() {
	        double d;
	        while (true) {
	            try {
	                d = scanner.nextDouble();
	                break;
	            } catch (Exception InputMismatchException) {
	                System.out.println("Não é um numéro double.");
	                scanner.next();
	            }
	        }
	        return d;
	    }
	    public static int scannerInt() {
	        int i;
	        while (true) {
	            try {
	                i = scanner.nextInt();
	                break;
	            } catch (Exception InputMismatchException) {
	                System.out.println("Não é um numéro inteiro.");
	                scanner.next();
	                
	            }
	        }
	        return i;
	    }
}
