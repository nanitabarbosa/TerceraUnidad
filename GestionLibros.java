import java.io.*;
import java.util.*;

public class GestionLibros {
    private static final String ARCHIVO_LIBROS = "libros.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> libros = new ArrayList<>();

        // Añadir libros
        System.out.println("Añadir libros. Escribe 'fin' para terminar.");
        while (true) {
            System.out.print("Título del libro: ");
            String titulo = scanner.nextLine();
            if (titulo.equalsIgnoreCase("fin")) {
                break;
            }
            libros.add(titulo);
        }

        // Guardar libros en archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_LIBROS))) {
            for (String libro : libros) {
                writer.write(libro);
                writer.newLine();
            }
            System.out.println("Libros guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }

        // Mostrar libros guardados
        System.out.println("\nLibros guardados:");
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_LIBROS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer libros: " + e.getMessage());
        }
    }
}