package br.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/cadcampanha", "SA", "");
		System.out.println("Abrindo uma conexão com banco de dados");
		connection.close();
	}

}
