
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Login { 
	public static void LoginMethod() {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter username:");
		String name=scan.next();
		System.out.println("enter password");
		String password=scan.next();
		String type = "";
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select username,password,type from event");
			while(rs.next()) {
				if(rs.getString(1).equals(name) && rs.getString(2).equals(password)){
					type = rs.getString(3);
					count=1;
					break;
				}
			}
			if(count==1){
				if(type.equals("admin")){
					 Admin.AdminMethod();
				}
				else{
					User.UserMethod();
				}
			}
			else{
				System.out.println("details not found");
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}