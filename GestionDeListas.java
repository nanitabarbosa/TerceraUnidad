import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeListas {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Introduce un índice para acceder a la lista: ");
            int indice = scanner.nextInt();
            
            // Intentamos acceder al índice proporcionado
            System.out.println("Elemento en el índice " + indice + ": " + lista.get(indice));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: El índice proporcionado está fuera de los límites de la lista.");
        }
    }
}