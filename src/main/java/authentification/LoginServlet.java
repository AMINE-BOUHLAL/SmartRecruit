package authentification;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Vérification si l'utilisateur est déjà connecté
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("isLoggedIn") != null && (Boolean) session.getAttribute("isLoggedIn")) {
            resp.sendRedirect("Acceuil.jsp");
            return;
        }

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Récupération de l'utilisateur depuis la base de données
        User user = userDao.getUser(email);

        // Vérification des informations d'identification
        if (user != null && user.getPassword().equals(password)) {
            session = req.getSession();  // Crée une nouvelle session si l'utilisateur est authentifié
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("userId", user.getId());
            session.setAttribute("email", email);
            session.setAttribute("roles", user.getRoles());  // Utilisation de "roles" comme clé
            System.out.println("Utilisateur connecté : " + email + ", rôle : " + user.getRoles());

            // Redirection en fonction du rôle
            if ("recruteur".equals(user.getRoles())) {
                resp.sendRedirect("Acceuil.jsp");  // Page spécifique pour recruteur
            } else if ("candidat".equals(user.getRoles())) {
                resp.sendRedirect("Acceuil.jsp");  // Page spécifique pour candidat
            }
            else {
                resp.sendRedirect("login.jsp?error=role_unknown");
            }
        }
        else {
            resp.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }
}
