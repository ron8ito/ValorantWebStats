package com.valorantstats.main; 

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ConsultarServlet", urlPatterns = {"/ConsultarServlet"})
public class ConsultarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Map<String, String>> partidas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                String sql = "SELECT * FROM match_stats";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Map<String, String> fila = new HashMap<>();
                    // Usamos nombres que coincidan exactamente con la base de datos
                    fila.put("agent", rs.getString("agent"));
                    fila.put("kills", String.valueOf(rs.getInt("kills")));
                    fila.put("deaths", String.valueOf(rs.getInt("deaths")));
                    fila.put("assists", String.valueOf(rs.getInt("assists")));
                    fila.put("map", rs.getString("map"));
                    fila.put("result", rs.getString("result"));
                    partidas.add(fila);
                }
                
                request.setAttribute("misPartidas", partidas);
                request.getRequestDispatcher("ver_partidas.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL CONSULTAR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}