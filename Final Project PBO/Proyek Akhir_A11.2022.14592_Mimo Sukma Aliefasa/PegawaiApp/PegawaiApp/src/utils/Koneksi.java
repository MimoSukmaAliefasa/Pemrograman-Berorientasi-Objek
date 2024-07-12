package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private String url = "jdbc:mysql://localhost/db_absensi?serverTimezone=UTC"; // Menambahkan parameter timezone
    private String username = "root";
    private String password = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}