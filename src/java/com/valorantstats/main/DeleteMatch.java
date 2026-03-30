package com.valorantstats.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMatch {

    /**
     * Elimina una partida según su ID.
     *
     * @param id ID de la partida a eliminar
     */
    public static void deleteMatch(int id) {

        String sql = "DELETE FROM match_stats WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Partida eliminada correctamente (ID: " + id + ")");
            } else {
                System.out.println("No se encontró la partida con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("Error eliminando partida: " + e.getMessage());
        }
    }
}
