package com.valorantstats.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectMatches {

    public static void showAllMatches() {

        String sql = "SELECT * FROM match_stats";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("---- Todas las partidas ----");

            while (rs.next()) {
                int id = rs.getInt("id");
                String agent = rs.getString("agent");
                int kills = rs.getInt("kills");
                int deaths = rs.getInt("deaths");
                int assists = rs.getInt("assists");
                String map = rs.getString("map");
                String matchDate = rs.getString("match_date");
                String result = rs.getString("result");

                System.out.println("ID: " + id +
                                   ", Agente: " + agent +
                                   ", K/D/A: " + kills + "/" + deaths + "/" + assists +
                                   ", Mapa: " + map +
                                   ", Fecha: " + matchDate +
                                   ", Resultado: " + result);
            }

        } catch (SQLException e) {
            System.out.println("Error consultando partidas: " + e.getMessage());
        }
    }
}
