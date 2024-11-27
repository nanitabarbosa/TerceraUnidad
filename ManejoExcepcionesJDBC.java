import java.sql.*;

public class ManejoExcepcionesJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_de_datos";
    private static final String USER = "usuario";
    private static final String PASSWORD = "contraseña";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos.");

            // Ejemplo de una consulta incorrecta que lanzará una SQLException
            String query = "SELECT * FROM tabla_inexistente"; // Esta tabla no existe
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
            } catch (SQLException e) {
                System.out.println("Error de SQL: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}