package com.csit228.capstone.dao;


import com.csit228.capstone.database.DBConnector;
import java.sql.*;

public class UserJobDAO {

    private static UserJobDAO instance;


    public static UserJobDAO getUserJobDao() {
        if (instance == null) {
            instance = new UserJobDAO();
        }
        return instance;
    }


    public String getJobByUser(String username) {
        String job = "";
        String query = "SELECT j.name FROM job j " +
                "JOIN user_job uj ON j.id = uj.job_id " +
                "JOIN user u ON u.id = uj.user_id " +
                "WHERE u.username = ?";

        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                job = (rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return job;
    }

    public static void main(String[] args) {
        System.out.println(getUserJobDao().getJobByUser("asmith_ed"));
    }
}