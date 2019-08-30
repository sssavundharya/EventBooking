import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TicketBooked {
	public static void TicketBookedkMethod(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admin");
			System.out.println("Event Id \tEvent Name \tEvent Place \tEvent Date \tEvent Price \tAvailabe Ticket");
			while(rs.next()) {
				int TotalTicket = Integer.parseInt(rs.getString(7));
				int booked = Integer.parseInt(rs.getString(8));
				int availTicket = TotalTicket - booked;
				System.out.println(rs.getString(1)+"\t\t"+rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(4) + "\t\t"+ rs.getString(5) + "\t\t"+availTicket );
				MyBooking.MyBookingMethod();
					
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
