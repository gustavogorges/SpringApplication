package net.weg.api.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    private static final String URL_BANCO = "jdbc:mysql://localhost:3306/db_integracao";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    static public Connection conectar() {
        try {
            return DriverManager.getConnection(URL_BANCO,USERNAME,PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
