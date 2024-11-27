import java.util.Scanner;

// Excepción personalizada
class NumeroNegativoException extends Exception {
    public NumeroNegativoException(String message) {
        super(message);
    }
}

public class RaizCuadrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce un número para calcular su raíz cuadrada: ");
            double num = scanner.nextDouble();
            
            // Verificamos si el número es negativo
            if (num < 0) {
                throw new NumeroNegativoException("No se puede calcular la raíz cuadrada de un número negativo.");
            }
            
            System.out.println("La raíz cuadrada de " + num + " es: " + Math.sqrt(num));
        } catch (NumeroNegativoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
