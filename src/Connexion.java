import java.sql.*;
import java.util.*;

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
	
	public ArrayList<Integer> searchFirstLetter(String s) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		try {
			Class.forName(driverName);
		}
		catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException:");
			System.err.println(e.getMessage());
		}
		try {
			Connection co = DriverManager.getConnection(url, user, pass);
			String query;
			if (s.equals("unknown")) {
				String q1 = "SELECT nom FROM ville WHERE nom LIKE 'i%'";
				String q2 = "SELECT nom FROM ville WHERE nom LIKE 'j%'";
				String q3 = "SELECT nom FROM ville WHERE nom LIKE 'w%'";
				String q4 = "SELECT nom FROM ville WHERE nom LIKE 'x%'";
				String q5 = "SELECT nom FROM ville WHERE nom LIKE 'z%'";
				query = "("+q1+")"+" UNION "+"("+q2+")"+" UNION "+"("+q3+")"+" UNION "+"("+q4+")"+" UNION "+"("+q5+")";
			} else {
				query = "SELECT nom FROM ville WHERE (nom LIKE '"+s+"%')";
			}
			Statement stmt = co.createStatement();
			ResultSet res = stmt.executeQuery(query);
			
			int rowCount = 1;
			while (res.next()) { 
				System.out.println(res.getString(1)); 
				rowCount++;
			}
			
			stmt.close();
			co.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
