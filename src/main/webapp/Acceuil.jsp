<%@ page import="model.OffreEmploi" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SmartRecruit - Job Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            position: sticky;
            top: 0;
            z-index: 100;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
            padding-left: 20px;
            font-size: 24px;
        }
        .nav-links {
            display: flex;
            margin-right: 20px;
        }
        .nav-links a {
            color: white;
            text-decoration: none;
            padding: 0 15px;
            font-size: 16px;
        }
        .nav-links a:hover {
            text-decoration: underline;
        }
        .job-list {
            max-height: calc(100vh - 80px);
            overflow-y: scroll;
            padding: 20px;
        }
        .job-item {
            max-width: 800px;
            margin: 15px auto;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 12px;
            background-color: white;
        }
        .job-title {
            text-decoration: none;
            color: #2196F3;
            transition: color 0.3s ease;
        }
        .job-title:hover {
            color: #4CAF50;
            text-decoration: underline;
        }
        .job-item p {
            margin: 5px 0;
            color: #666;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>SmartRecruit - Job Portal</h1>
    <div class="nav-links">
        <a href="index.jsp">Home</a>
        <a href="AddOffer.jsp">Add Offer</a>
        <a href="logout.html">Log Out</a>
    </div>
</div>

<div class="job-list">
    <%
        // Vérifier si la liste des offres a été correctement passée à la page
        List<OffreEmploi> offres = (List<OffreEmploi>) request.getAttribute("listOffre");

        if (offres != null && !offres.isEmpty()) {
            // Parcourir et afficher chaque offre
            for (OffreEmploi offre : offres) {
    %>
    <div class="job-item">
        <a href="AboutOffer?id=<%= offre.getIdOffre() %>" class="job-title">
            <h3><%= offre.getTitre() %></h3>
        </a>
        <p>Location: <%= offre.getLocation() %></p>
        <p>Experience: <%= offre.getExperience() %> ans</p>
        <p><%= offre.getDescription() %></p>
    </div>
    <%
        }
    } else {
    %>
    <p>Aucune offre d'emploi disponible pour le moment.</p>
    <%
        }
    %>
</div>

</body>
</html>
