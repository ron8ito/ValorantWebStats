package com.valorantstats.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMatch {

    public static void addMatch(String agent, int kills, int deaths, int assists,
                                String map, String matchDate, String result) {

        String sql = "INSERT INTO match_stats(agent, kills, deaths, assists, map, match_date, result) "
                   + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            
            if (conn != null) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, agent);
                pstmt.setInt(2, kills);
                pstmt.setInt(3, deaths);
                pstmt.setInt(4, assists);
                pstmt.setString(5, map);
                pstmt.setString(6, matchDate);
                pstmt.setString(7, result);

                pstmt.executeUpdate();
                System.out.println(">>> ÉXITO: Partida insertada correctamente en la base de datos.");
            } else {
                System.out.println(">>> ERROR: No se pudo insertar porque la conexión es NULL.");
            }

        } catch (SQLException e) {
            System.out.println(">>> ERROR SQL al insertar partida: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerramos recursos
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}