import java.util.Scanner;

public class DivisionPorCero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce el primer número: ");
            int num1 = scanner.nextInt();
            System.out.print("Introduce el segundo número: ");
            int num2 = scanner.nextInt();
            
            // Intentamos realizar la división
            if (num2 == 0) {
                throw new ArithmeticException("No se puede dividir por cero.");
            }
            System.out.println("Resultado de la división: " + num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

