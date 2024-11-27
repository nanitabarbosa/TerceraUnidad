import java.sql.*;
import java.util.Scanner;

public class GestionUsuarios {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            
            while (true) {
                System.out.println("\nGestión de Usuarios");
                System.out.println("1. Añadir Usuario");
                System.out.println("2. Eliminar Usuario");
                System.out.println("3. Actualizar Usuario");
                System.out.println("4. Salir");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer de la entrada
                
                switch (opcion) {
                    case 1:
                        // Añadir usuario
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        String insertSQL = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
                        try (PreparedStatement stmt = connection.prepareStatement(insertSQL)) {
                            stmt.setString(1, nombre);
                            stmt.setString(2, email);
                            stmt.executeUpdate();
                            System.out.println("Usuario añadido.");
                        } catch (SQLException e) {
                            System.out.println("Error al añadir usuario: " + e.getMessage());
                        }
                        break;
                    case 2:
                        // Eliminar usuario
                        System.out.print("ID del usuario a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        String deleteSQL = "DELETE FROM usuarios WHERE id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(deleteSQL)) {
                            stmt.setInt(1, idEliminar);
                            stmt.executeUpdate();
                            System.out.println("Usuario eliminado.");
                        } catch (SQLException e) {
                            System.out.println("Error al eliminar usuario: " + e.getMessage());
                        }
                        break;
                    case 3:
                        // Actualizar usuario
                        System.out.print("ID del usuario a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nuevo email: ");
                        String nuevoEmail = scanner.nextLine();
                        String updateSQL = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
                        try (PreparedStatement stmt = connection.prepareStatement(updateSQL)) {
                            stmt.setString(1, nuevoNombre);
                            stmt.setString(2, nuevoEmail);
                            stmt.setInt(3, idActualizar);
                            stmt.executeUpdate();
                            System.out.println("Usuario actualizado.");
                        } catch (SQLException e) {
                            System.out.println("Error al actualizar usuario: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }
}