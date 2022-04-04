import java.sql.*;
import java.io.*;
public class ImageSave {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","PASSword_0");
			
			String q = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			FileInputStream fis = new FileInputStream("/home/anonymous/Desktop/Py-tut-05-atom-editor-for-Python.png");
			pstmt.setBinaryStream(1, fis,fis.available());
			pstmt.executeUpdate();
			
			System.out.println("Inserted....");
			pstmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
