package com.valorantstats.main.servlets;

import com.valorantstats.main.DatabaseSetup;
import com.valorantstats.main.InsertMatch;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("registro.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String agent = request.getParameter("agent");
            int kills = Integer.parseInt(request.getParameter("kills"));
            int deaths = Integer.parseInt(request.getParameter("deaths"));
            int assists = Integer.parseInt(request.getParameter("assists"));
            String map = request.getParameter("map");
            String matchDate = request.getParameter("matchDate");
            String result = request.getParameter("result");

            DatabaseSetup.createTable();
            InsertMatch.addMatch(agent, kills, deaths, assists, map, matchDate, result);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h1>Partida guardada correctamente</h1>");

        } catch (Exception e) {
            response.getWriter().println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}