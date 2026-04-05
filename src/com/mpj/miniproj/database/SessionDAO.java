package com.mpj.miniproj.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SessionDAO {

    public static void saveSession(String speech, int fumbles, String sentiment) {

        String query = "INSERT INTO sessions (speech, fumbles, sentiment) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, speech);
            stmt.setInt(2, fumbles);
            stmt.setString(3, sentiment);

            stmt.executeUpdate();

            System.out.println("Session saved to database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}