package com.valorantstats.main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseSetup {

    public static void createTable() {
        // La sentencia SQL para crear la tabla si no existe
        String sql = "CREATE TABLE IF NOT EXISTS match_stats ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "agent TEXT NOT NULL, "
                + "kills INTEGER, "
                + "deaths INTEGER, "
                + "assists INTEGER, "
                + "map TEXT, "
                + "match_date TEXT, "
                + "result TEXT"
                + ");";

        // Intentamos obtener la conexión desde nuestra clase DatabaseConnection
        try (Connection conn = DatabaseConnection.getConnection(); 
             Statement stmt = conn.createStatement()) {

            if (conn != null) {
                stmt.execute(sql);
                System.out.println(">>> TABLA VERIFICADA: Lista para recibir datos.");
            }

        } catch (SQLException e) {
            System.out.println(">>> ERROR AL CREAR TABLA: " + e.getMessage());
            e.printStackTrace();
        }
    }
}