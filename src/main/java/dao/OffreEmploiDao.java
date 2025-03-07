package dao;

import model.OffreEmploi;

import java.sql.*;

public class OffreEmploiDao {
    Connection connection;
    private String url = "jdbc:mysql://localhost:3306/emploi";
    private String username = "root";
    private String password = "";
    public OffreEmploiDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String OFFRE = "CREATE TABLE IF NOT EXISTS offre (" +
                    "idOffre INT AUTO_INCREMENT PRIMARY KEY, " +
                    "titre VARCHAR(100) NOT NULL, " +
                    "description VARCHAR(100) NOT NULL, " +
                    "datePublication DATE ," +
                    "location  VARCHAR(100) ," +
                    "expérience INT " +
                    ");";


            statement.executeUpdate(OFFRE);
            System.out.println("Table 'offre' created successfully (if it did not exist already).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createOffre(OffreEmploi offreEmploi){
        String sql = "INSERT INTO offre (titre ,description,datePublication) VALUES (?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setString(1,offreEmploi.getTitre());
            preparedStatement.setString(1,offreEmploi.getTitre());
            preparedStatement.setString(1,offreEmploi.getTitre());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }












    // Test de la classe
    public static void main(String[] args) {
        OffreEmploiDao offreEmploiDao = new OffreEmploiDao();
        System.out.println("Connexion et création de la table testées avec succès.");
    }
}
