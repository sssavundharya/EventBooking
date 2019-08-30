import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class CurrentStatus {
	public static void CurrentStatusMethod(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter event name");
		String eventname=scan.next();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin");
			System.out.println("Event Id \tEvent Name \tEvent Place \tEvent Date \tEvent Price \tAvailabe Ticket");
			while(rs.next()) {
				if(rs.getString(2).equals(eventname)){
					int TotalTicket = Integer.parseInt(rs.getString(7));
					int booked = Integer.parseInt(rs.getString(8));
					int availTicket = TotalTicket - booked;
					System.out.println(rs.getString(1)+"\t\t"+rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t"+ rs.getString(5) + "\t\t"+availTicket );
					
				}
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	    }
	}


