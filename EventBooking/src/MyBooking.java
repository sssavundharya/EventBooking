import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class MyBooking {
	public static void MyBookingMethod(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter event name");
		String eventname=scan.next();
		System.out.println("Enter the tickets do u want:");
		int num=scan.nextInt();
		int booked = 0;
		int TotalTicket=0;
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/eventbooking", "root", "");
					Statement stmt = (Statement) con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from admin");
					while(rs.next()) {
						if(rs.getString(2).equals(eventname)){
							 TotalTicket = rs.getInt(7);
							 booked = rs.getInt(8);
							break;
							
						}
					}
					
					if((TotalTicket-booked)-num <0){
						System.out.println("not available");
					}
					else{
						
						booked+=num;
						System.out.println("price:"+ num*Integer.parseInt(rs.getString(5)));
						System.out.println("Available tickets:"+(TotalTicket-booked));
						String SQL_UPDATE = "update admin set Booked=? where EventName=?";
			            PreparedStatement st=(PreparedStatement) con.prepareStatement(SQL_UPDATE); 
			            st.setInt(1,booked);
			            st.setString(2,eventname);
			            st.executeUpdate();
			            System.out.println(num+"(s) are booked");
					}
					con.close();
				}
				catch(Exception e) {
					System.out.println(e);
				}


		
	}

}
