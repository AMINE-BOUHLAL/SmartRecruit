package dao;

import model.User;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/emploi", "root", "");

            Statement statement = connection.createStatement();

            String createuser = "CREATE TABLE IF NOT EXISTS user (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nom VARCHAR(100) NOT NULL, " +
                    "prenom VARCHAR(100) NOT NULL, " +
                    "email VARCHAR(255), " +
                    "tel VARCHAR(20), " +
                    "password VARCHAR(20), " +
                    "roles VARCHAR(20)" +
                    ");";


            statement.executeUpdate(createuser);
            System.out.println("Table 'user' created successfully (if it did not exist already).");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void createUser(User user){
        String sql = "INSERT INTO user (nom, prenom, email, tel,password,roles) VALUES (?, ?, ?, ?,?,?)";
        try(PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
            preparedStatement.setString(1,user.getNom());
            preparedStatement.setString(2,user.getPrenom());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4,user.getTel());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }

