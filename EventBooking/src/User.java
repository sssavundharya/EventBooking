import java.util.Scanner;

public class User {
	public static void UserMethod(){
		Scanner scan=new Scanner(System.in);
		System.out.println("1.Book Event\n2.My Bookings");
		System.out.println("enter the choice 1 or 2:");
		int n=scan.nextInt();
		switch(n){
		case 1:
			TicketBooked.TicketBookedkMethod();
			break;
		case 2:
			MyBooking.MyBookingMethod();
			break;
			
		}
		
		
	}

}
