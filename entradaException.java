
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
	                System.out.println("N�o � um num�ro inteiro.");
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
	                System.out.println("N�o � um num�ro double.");
	                scanner.next();
	            }
	        }
	        return d;
	    }
	 
	}


