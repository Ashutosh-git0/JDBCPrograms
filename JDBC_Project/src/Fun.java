import java.sql.*;
import java.io.*;
public class Fun {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create connection
			String url = "jdbc:mysql://localhost:3306/youtube";
			String userName = "root";
			String password = "PASSword_0";
			
			Connection con = DriverManager.getConnection(url,userName,password);
			//create query
			String q = "insert into table1(tName, tCity) values (?,?)";
			//get the PreparedStatement object
			PreparedStatement pstmt = con.prepareStatement(q);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your name : ");
			String name = br.readLine();
			
			System.out.println("Enter city : ");
			String city = br.readLine();
			
			//set values to query
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			pstmt.executeUpdate();
			System.out.println("inserted ....");
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
