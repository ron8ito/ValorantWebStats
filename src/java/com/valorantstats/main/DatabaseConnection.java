package com.valorantstats.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");

            // Ruta relativa: se creará en la carpeta raíz del proyecto
            String url = "jdbc:sqlite:valorant.db";

            conn = DriverManager.getConnection(url);
            
            // Verificamos dónde se está creando realmente
            File archivo = new File("valorant.db");
            System.out.println("------------------------------------------");
            System.out.println(">>> LA BASE DE DATOS ESTÁ EN:");
            System.out.println(">>> " + archivo.getAbsolutePath());
            
            if (archivo.exists()) {
                System.out.println(">>> ESTADO: ¡EL ARCHIVO EXISTE! ✅");
            }
            System.out.println("------------------------------------------");

        } catch (Exception e) {
            System.out.println(">>> ERROR EN CONEXIÓN: " + e.getMessage());
            e.printStackTrace();
        }

        return conn;
    }
}