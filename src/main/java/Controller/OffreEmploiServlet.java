package Controller;

import dao.OffreEmploiDao;
import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OffreEmploi;
import model.User;

import java.io.IOException;

public class OffreEmploiServlet extends HttpServlet {
    private OffreEmploiDao offreEmploiDao ;
    public void init() {
        offreEmploiDao = new OffreEmploiDao();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // permet de récupérer la partie de l'URL spécifique au Servlet
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                createOffre(request, response);
                break;
            case "/list":
                listOffres(request, response);
                break;
            case "delete":

                break;
            default:

        }
    }

    // Création d'un utilisateur
    private void createOffre(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String datePublication = request.getParameter("datePublication");
        String location = request.getParameter("location");
        int experience = Integer.parseInt(request.getParameter("expérience"));
        OffreEmploi offreEmploi = new OffreEmploi(titre, description, datePublication, location, experience);
        offreEmploiDao.createOffre(offreEmploi);
        response.sendRedirect(request.getContextPath() + "Acceuil.jsp");//une foit cliquer sur enregiter retourne vers la page login

    }
    private void listOffres(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("offres", offreEmploiDao.getAllOffre());
        request.getRequestDispatcher("Acceuil.jsp").forward(request, response);
    }

}
