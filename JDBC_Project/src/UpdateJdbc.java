import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJdbc {
public static void main(String[] args) {
	try {
		Connection con = ConnectionProvider.getConnection();
		String q = "update table1 set tName=?, tCity=? where tId=?";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter new name : ");
		String name = br.readLine();
		
		System.out.println("Enter new city name : ");
		String city = br.readLine();
		
		System.out.println("Enter student id : ");
		int id = Integer.parseInt(br.readLine());
		
		PreparedStatement pstmt = con.prepareStatement(q);
		pstmt.setString(1, name);
		pstmt.setString(2, city);
		
		pstmt.setInt(3, id);
		
		pstmt.executeUpdate();
		System.out.println("Updated....");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
