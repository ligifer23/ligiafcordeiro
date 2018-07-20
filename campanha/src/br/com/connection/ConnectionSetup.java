package br.com.connection;

public class ConnectionSetup {

	public static Connection getConnection(String type, String server, String dbname, 
			String userid, String pwd) {
		// TODO Auto-generated method stub
		if(type.equals("MySQL")) {
			return new MySqlConnection();
		} else 	
			if(type.equals("SQLServer")) {
				return new SqlServerConnection();
			} else 
				if(type.equals("Oracle")) {
					return new OracleConnection();
		}
				
		throw new IllegalArgumentException("Tipo de conexão de banco de dados não identificada");

}
}