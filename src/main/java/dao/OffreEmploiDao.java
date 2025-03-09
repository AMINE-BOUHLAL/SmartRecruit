package dao;

import model.OffreEmploi;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ObjIntConsumer;

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
                    "experience  VARCHAR(100) " +
                    ");";


            statement.executeUpdate(OFFRE);
            System.out.println("Table 'offre' created successfully (if it did not exist already).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createOffre(OffreEmploi offreEmploi){
        String sql = "INSERT INTO offre (titre ,description,datePublication,location,experience ) VALUES (?, ?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1,offreEmploi.getTitre());
            preparedStatement.setString(2,offreEmploi.getDescription());
            preparedStatement.setString(3,offreEmploi.getDatePublication());
            preparedStatement.setString(4,offreEmploi.getLocation());
            preparedStatement.setString(5,offreEmploi.getExperience());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OffreEmploi> getAllOffre() {
        List<OffreEmploi> offreEmplois = new ArrayList<>();
        String sql = "SELECT * FROM offre";
        System.out.println("Exécution de la requête SQL : " + sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOffre = rs.getInt("idOffre");
                String titre = rs.getString("titre");
                String description = rs.getString("description");
                String datePublication = rs.getString("datePublication");
                String location = rs.getString("location");
                String experience = rs.getString("experience");
                System.out.println("Offre récupérée: " + titre);

                offreEmplois.add(new OffreEmploi(idOffre,titre,description,datePublication,location,experience));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return offreEmplois;
    }


    // Test de la classe
    public static void main(String[] args) {
        OffreEmploiDao offreEmploiDao = new OffreEmploiDao();
        System.out.println("Connexion et création de la table testées avec succès.");
    }
}
