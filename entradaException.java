
	import java.util.Scanner;
	 
	public class entradaException {
	 
	    private static Scanner scanner = new Scanner(System.in);
	 
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
	 
	}


