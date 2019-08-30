import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class NewRegister {
	public static void NewRegisterMethod() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter username:");
		String name=scan.next();
		System.out.println("Enter password:");
		String pass=scan.next();
		String type="";
		System.out.print("enter type:\n1.Admin\n2.User\n");
		int choice=scan.nextInt();
		switch(choice) {
			case 1:
				type="admin";
				break;
			case 2:
				type="user";
				break;
			
		}
		String id=name.substring(0,2)+pass.substring(1,2);
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
            PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into event values(?,?,?,?)"); 
            stmt.setString(1,id);
            stmt.setString(2,name);
            stmt.setString(3,pass);
            stmt.setString(4,type);
            int i=stmt.executeUpdate();  
            System.out.println("Account created successfully");  
            con.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}