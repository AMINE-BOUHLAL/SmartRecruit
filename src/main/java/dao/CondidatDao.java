package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CondidatDao {
    Connection connection;
    private String url = "jdbc:mysql://localhost:3306/emploi";
    private String username = "root";
    private String password = "";

    public CondidatDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            // Correction de la requête SQL (suppression de la virgule après `cv`)
            String condidat = "CREATE TABLE IF NOT EXISTS condidat (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nom VARCHAR(100) NOT NULL, " +
                    "prenom VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(255), " +
                    "tel VARCHAR(20), " +
                    "`cv` VARCHAR(255) " +  // Suppression de la virgule ici
                    ");";

            statement.executeUpdate(condidat);
            System.out.println("Table 'condidat' created successfully (if it did not exist already).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test de la classe
    public static void main(String[] args) {
        CondidatDao condidatDao = new CondidatDao();
        System.out.println("Connexion et création de la table testées avec succès.");
    }
}
