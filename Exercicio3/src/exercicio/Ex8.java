package exercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex8 {
	static final String URL = "jdbc:derby://localhost:1527/Outro";
	static final String USUARIO = "ead";
	static final String SENHA = "ead";
	static final String SQL_INSERT = "INSERT INTO pessoa (id, nome) VALUES(?, ?)";
	static final String SQL_SELECT = "SELECT * FROM pessoa";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		PreparedStatement preparada = conexao.prepareStatement(SQL_INSERT);
		preparada.setInt(1, 1);
		preparada.setString(2, "Lucas");
		preparada.executeUpdate();
		preparada.setInt(1, 2);
		preparada.setString(2, "Ronaldo");
		preparada.executeUpdate();
		Statement consulta = conexao.createStatement();
		ResultSet resultados = consulta.executeQuery(SQL_INSERT);
		while (resultados.next()) {
			System.out.println(resultados.getString("nome"));
		}
		
	}

}
