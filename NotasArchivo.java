import java.io.*;
import java.util.*;

public class NotasArchivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> notas = new ArrayList<>();
        
        // Ingresar notas
        System.out.println("Introduce las notas. Escribe 'fin' para terminar.");
        while (true) {
            System.out.print("Nota: ");
            String nota = scanner.nextLine();
            if (nota.equalsIgnoreCase("fin")) {
                break;
            }
            notas.add(nota);
        }
        
        // Guardar notas en un archivo de texto
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("notas.txt"))) {
            for (String nota : notas) {
                writer.write(nota);
                writer.newLine();
            }
            System.out.println("Notas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las notas: " + e.getMessage());
        }

        // Leer las notas desde el archivo
        System.out.println("\nNotas guardadas en el archivo:");
        try (BufferedReader reader = new BufferedReader(new FileReader("notas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer las notas: " + e.getMessage());
        }
    }
}