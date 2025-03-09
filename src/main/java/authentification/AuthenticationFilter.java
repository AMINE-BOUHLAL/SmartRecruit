package authentification;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(true); // Récupérer la session sans la perdre

        String action = req.getServletPath();
        String roles = (session != null) ? (String) session.getAttribute("roles") : null;
        Boolean isLoggedIn = (session != null && Boolean.TRUE.equals(session.getAttribute("isLoggedIn")));

        // Debug : Vérification de la session
        System.out.println("=== FILTRE AUTHENTIFICATION ===");
        System.out.println("Action demandée : " + action);
        System.out.println("Session existante ? " + (session != null));
        if (session != null) {
            System.out.println("isLoggedIn: " + session.getAttribute("isLoggedIn"));
            System.out.println("roles: " + session.getAttribute("roles"));
        }

        // Ne pas filtrer la page de connexion
        if ("/login".equals(action) || "/login.jsp".equals(action)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (Boolean.TRUE.equals(isLoggedIn)) {
            if ("recruteur".equals(roles) && (action.equals("/Acceuil.jsp") || action.equals("/AddOffer.jsp"))) {
                filterChain.doFilter(servletRequest, servletResponse);
                return  ;
            }
            if ("candidat".equals(roles) && (action.equals("/Acceuil.jsp") || action.equals("/AboutOffer.jsp") || action.equals("/addCandidat.jsp"))) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            System.out.println("Accès refusé : rôle incorrect");
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=access_denied");
            return;
        }

        System.out.println("Utilisateur non connecté, redirection vers login.jsp");
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
