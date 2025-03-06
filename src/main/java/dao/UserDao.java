package dao;

import model.User;

import java.sql.*;

public class UserDao {
    private String url = "jdbc:mysql://localhost:3306/emploi";
    private String username = "root";
    private String password = "";

    // Méthode pour obtenir une connexion à la base de données
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Erreur SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trouvé: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour créer la table 'user' si elle n'existe pas
    public void createUserTable() {
        String createUserTableSQL = "CREATE TABLE IF NOT EXISTS user (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nom VARCHAR(100) NOT NULL, " +
                "prenom VARCHAR(100) NOT NULL, " +
                "email VARCHAR(255), " +
                "tel VARCHAR(20), " +
                "`password` VARCHAR(255), " +  // Ajout des backticks pour éviter les conflits avec MySQL
                "roles VARCHAR(20)" +
                ");";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createUserTableSQL);
            System.out.println("Table 'user' créée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la table : " + e.getMessage());
            e.printStackTrace();
        }
    }
    public  void createUser(User user){
        String sql = "INSERT INTO user (nom ,prenom,email,tel,password,roles) VALUES (?, ?,?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            System.out.println("sxxxx");
            preparedStatement.setString(1, user.getNom());
            preparedStatement.setString(2, user.getPrenom());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4, user.getTel());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setString(6,user.getRoles());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser( String email) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("roles")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    // Test de la classe
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
       userDao.createUserTable();
    }
}
