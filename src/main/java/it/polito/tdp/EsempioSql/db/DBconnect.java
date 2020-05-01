package it.polito.tdp.EsempioSql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBconnect { //visibilità package perché nessuna classe fuori dal package deve preoccuparsi della connessione (divisione lavoro)

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root"; //così ho l'url in un unico punto e non in ogni metodo di BabsDAO
		return DriverManager.getConnection(jdbcURL);
	}
	
}
