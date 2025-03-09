package Controller;

import dao.OffreEmploiDao;
import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OffreEmploi;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/offre")
public class OffreEmploiServlet extends HttpServlet {
    private OffreEmploiDao offreEmploiDao ;
    public void init() {
        offreEmploiDao = new OffreEmploiDao();
    }
    public OffreEmploiServlet(){
        offreEmploiDao=new OffreEmploiDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // permet de récupérer la partie de l'URL spécifique au Servlet
        String action = request.getServletPath();
        switch (action) {
            case "/offre":
                createOffre(request, response);
                break;
            case "/listoffre":
                try {
                    listOffres(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/new":
                showNewForm(request, response);
                break;
            default:

        }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AboutOffer.jsp");
        dispatcher.forward(request, response);
    }

    // Création d'un utilisateur
    private void createOffre(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        String datePublication = request.getParameter("datePublication");
        String location = request.getParameter("location");
        String experience = request.getParameter("experience");
        OffreEmploi offreEmploi = new OffreEmploi(titre, description, datePublication, location, experience);
        offreEmploiDao.createOffre(offreEmploi);
        response.sendRedirect(request.getContextPath() + "/Acceuil.jsp");//une foit cliquer sur enregiter retourne vers la page login

    }
    private void listOffres(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<OffreEmploi> listOffre = offreEmploiDao.getAllOffre();
        System.out.println("listOffre = " + listOffre);
        request.setAttribute("listOffre", listOffre);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Acceuil.jsp");
        dispatcher.forward(request, response);}

    }


