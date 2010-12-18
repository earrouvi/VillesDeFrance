import java.sql.*;

public class Connexion {

	protected String driverName = new String("com.mysql.jdbc.Driver");
	protected String dbName = "villes";
	protected String url="jdbc:mysql://localhost:8889/villes";
	protected String user = "root";
	private String pass = "root";
	
	public Connexion() {
	}

	public boolean insert(String nom, int x, int y) {
		try {
			Class.forName(driverName);
		}
		catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException:");
			System.err.println(e.getMessage());
			return false;
		}
		try {
			Connection co = DriverManager.getConnection(url, user, pass);
			
			String query = "INSERT INTO ville (nom, x, y) VALUES ('"+nom+"', '"+x+"', '"+y+"')";
			Statement stmt = co.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			co.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
