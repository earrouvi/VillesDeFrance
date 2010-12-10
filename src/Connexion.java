import java.sql.*;

public class Connexion {

	protected String driverName = new String("com.mysql.jdbc.Driver");
	protected String dbName = "villes";
	protected String url="jdbc:mysql://localhost:8080/villes";
	protected String user = "elsa";
	private String pass = "byrnison";

	public Connexion() {

		try {
			Class.forName(driverName);
		}
		catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException:");
			System.err.println(e.getMessage());
		}

		try {
			Connection conn=DriverManager.getConnection(url, user, pass);

			String query="SELECT nom FROM villes";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();


			conn.close();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
