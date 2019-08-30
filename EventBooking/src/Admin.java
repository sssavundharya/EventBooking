import java.util.Scanner;

public class Admin {
	public static void AdminMethod(){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the num 1 or 2:\n1.AddEvent\n 2.currentStatus");
		int choice=scan.nextInt();
		switch(choice){
		case 1:
			AddEvent.AddEventMethod();
			break;
		case 2:
			CurrentStatus.CurrentStatusMethod();
			break;
		default:
			System.out.println("please enter the option 1 or 2");
		}
		
	}

}
