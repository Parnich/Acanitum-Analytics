package org.aconitum.analytics.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    // The database file will be created in the project root
    private static final String URL = "jdbc:sqlite:analytics.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            // 1. Respondents table
            stmt.execute("CREATE TABLE IF NOT EXISTS respondents (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nickname TEXT NOT NULL," +
                    "gender TEXT," +
                    "age INTEGER," +
                    "contact TEXT," +
                    "additional_info TEXT" +
                    ")");

            // 2. Surveys table (Your templates/projects)
            stmt.execute("CREATE TABLE IF NOT EXISTS surveys (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "description TEXT," +
                    "status TEXT DEFAULT 'ACTIVE'," + // e.g., ACTIVE, ARCHIVED
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")");

            System.out.println("Database initialized successfully: " + URL);
        } catch (SQLException e) {
            System.err.println("Database initialization failed!");
            e.printStackTrace();
        }
    }
}