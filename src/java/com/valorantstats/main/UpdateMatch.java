package com.valorantstats.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMatch {

    /**
     * Actualiza los datos de una partida según su ID.
     *
     * @param id        ID de la partida a actualizar
     * @param agent     Nuevo agente
     * @param kills     Nuevos kills
     * @param deaths    Nuevos deaths
     * @param assists   Nuevos assists
     * @param map       Nuevo mapa
     * @param matchDate Nueva fecha
     * @param result    Nuevo resultado
     */
    public static void updateMatch(int id, String agent, int kills, int deaths, int assists,
                                   String map, String matchDate, String result) {

        String sql = "UPDATE match_stats SET agent=?, kills=?, deaths=?, assists=?, map=?, match_date=?, result=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, agent);
            pstmt.setInt(2, kills);
            pstmt.setInt(3, deaths);
            pstmt.setInt(4, assists);
            pstmt.setString(5, map);
            pstmt.setString(6, matchDate);
            pstmt.setString(7, result);
            pstmt.setInt(8, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Partida actualizada correctamente (ID: " + id + ")");
            } else {
                System.out.println("No se encontró la partida con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error actualizando partida: " + e.getMessage());
        }
    }
}

