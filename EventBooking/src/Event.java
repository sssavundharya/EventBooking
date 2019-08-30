import java.util.Scanner;

public class Event {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter:\n1.New Register\n2.login");
		int choice=scan.nextInt();
		switch(choice) {
		 case 1:
			 NewRegister.NewRegisterMethod();
			 break;
		 case 2:
			 Login.LoginMethod();
			 break;
		default:
			System.out.println("please enter valid details");
		}
		
		
	}

}