import java.sql.*;
public class FirstJDBC
{
  public static void main(String[] args){
    try {
    	
    	//creating connection
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/youtube";
      String userName = "root";
      String password = "PASSword_0";
      Connection con = DriverManager.getConnection(url,userName,password);
      //Create Query
      String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(20) not null, tCity varchar(400))";
      // create a statement
      Statement stmt = con.createStatement();
      stmt.executeUpdate(q);
      System.out.println("table created in db...");
      con.close();
      
      if(con.isClosed()){
        System.out.println("Connection closed");
      } else{
        System.out.println("Connection created");
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}