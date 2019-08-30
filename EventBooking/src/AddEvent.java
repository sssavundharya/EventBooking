import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AddEvent {
	public static void AddEventMethod(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Eventname:");
		String name=scan.next();
		System.out.println("Enter the Eventplace:");
		String place=scan.next();
		System.out.println("Enter the Event date(dd/mm/yy):");
		String date=scan.next();
		System.out.println("Enter the Eventprice:");
		int price=scan.nextInt();
		System.out.println("Enter the Event dicount:");
		int discount=scan.nextInt();
		System.out.println("Enter total no of tickets");
		int tickets=scan.nextInt();
		int avail=0;
		String EventId=name.substring(0,2)+date.substring(1,2)+date.substring(3,4)+place.substring(0,2);
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
            PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into admin values(?,?,?,?,?,?,?,?)"); 
            stmt.setString(1,EventId);
            stmt.setString(2,name);
            stmt.setString(3,place);
            stmt.setString(4,date);
            stmt.setInt(5,price);
            stmt.setInt(6,discount);
            stmt.setInt(7,tickets);
            stmt.setInt(8,avail);
            int i=stmt.executeUpdate();  
            System.out.println("successfully  created");  
            con.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}

		
	}
}
