package Controller;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
@WebServlet("/")
public class UserServlet extends HttpServlet {
    private UserDao userDao ; // Instance du DAO
    public void init() {
        userDao = new UserDao();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        this.doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // permet de récupérer la partie de l'URL spécifique au Servlet
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                createUser(request, response);
                break;
            case "update":

                break;
            case "delete":

                break;
            default:

        }
    }

    // Création d'un utilisateur
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");
        String roles = request.getParameter("roles");

        User user = new User(nom, prenom, email, tel, password, roles);
        userDao.createUser(user);
        response.sendRedirect(request.getContextPath() + "/login");//une foit cliquer sur enregiter retourne vers la page login

    }
}
