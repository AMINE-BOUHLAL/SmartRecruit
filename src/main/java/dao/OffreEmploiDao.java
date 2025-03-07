package dao;

import model.OffreEmploi;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.setString(2,offreEmploi.getDescription());
            preparedStatement.setString(3,offreEmploi.getDatePublication());
            preparedStatement.setString(4,offreEmploi.getLocation());
            preparedStatement.setInt(5,offreEmploi.getExperience());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<OffreEmploi> getAllOffre() {
       List<OffreEmploi> listOffre = new ArrayList<>();
        String sql = "SELECT * FROM offre";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // Création de l'objet OffreEmploi
                OffreEmploi offre = new OffreEmploi(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getString("datePublication"),
                        rs.getString("location"),
                        rs.getInt("expérience")
                );

                //Ajout de l'offre à la liste
                listOffre.add(offre);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des offres", e);
        }

        return listOffre;
    }













    // Test de la classe
    public static void main(String[] args) {
        OffreEmploiDao offreEmploiDao = new OffreEmploiDao();
        System.out.println("Connexion et création de la table testées avec succès.");
    }
}
