import java.util.Scanner;

/**
* <dl>
* <dt> Purpose:
* <dd> Simple example program
*
* <dt> Description:
* <dd> This program represents a simple calculator.
* </dl>
* @author Kai klasen
* @version Date: 29/09/2017
*/

public class Exercise2_methods {

	public static void main(String[] args) {
	
		//main method: the calculator "interface" where user is prompted for input and receives output
		
		//offering arithmetic calculations and prompting user for choice 
		System.out.println("Hello user, what would you like to do? \n\n" + "	1: add\n" + "	2: subtract\n" + "	3: multiply\n" + "	4: divide\n" + "	5: factorial\n" + "\n"+"	6: exit\n" + "\nPlease enter your choice: "); 
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
			
		//check for incorrect user input
		if(choice == 6) {
			System.out.println("Goodbye!");
			System.exit(0);
		}
		else if(choice > 6 || choice <= 0) {
			System.out.println("Error: your choice is incorrect");
			System.exit(1);
		}
		
		//prompting user for integers to perform arithmetics on
		System.out.print("You chose "+ choice +".\n" + "Please enter an integer to perform the arithmetics on: " );
		scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = 0;
		
		//if not operation "5: factorial" prompt for num2
		if (choice != 5){
			System.out.print("Please enter the second integer: ");
			scan = new Scanner(System.in);
			b = scan.nextInt();	
		}
		
		//selecting method according to user's choice
		if(choice == 1){
			int result = add(a,b);
			System.out.println(a + " + " + b +" = " + result);
		}
		else if(choice == 2){
			int result = subtract(a,b);
			System.out.println(a + " - " + b +" = " + result);
		}
		else if(choice == 3){
			int result = multiply(a,b);
			System.out.println(a + " * " + b +" = " + result);
		}
		else if(choice == 4){
			double result = divide(a,b);
			System.out.println(a + " / " + b +" = " + result);
		}
		else if(choice == 5){
			int result = factorial(a);
			System.out.println(a + "! = " + result);
		}
		
		//close scanner and exit program 
		scan.close();
		exit(0);
	}

	//implementation of "add" method
	public static int add(int a , int b){
		int result = a + b;
		return result;
	}
	
	//implementation of "subtract" method
	public static int subtract(int a, int b){
		int result = a - b;
		return result;
	}
	
	//implementation of "multiply" method
	public static int multiply(int a, int b){
		int result = a * b;
		return result;
	}
	
	//implementation of "divide" method
	public static double divide(double a, double b){
		double result = a / b;
		return result;
	}
	//implementation of "factorial" method
	public static int factorial(int a){
		if (a==0){
			return 1;
		}
		else{
			int result = a * factorial(a-1);
			return result;	
		}
	}
	public static void exit(int status){
		if(status != 0){
			System.out.println("Error");
		}
		System.exit(status);
	}
}
