import java.util.Scanner;

/**
* <dl>
* <dt> Purpose:
* <dd> Simple example program
*
* <dt> Description:
* <dd> This program converts bytes into bytes, kilobytes, megabytes and gigabytes
* </dl>
* @author Kai klasen
* @version Date: 30/09/2017
*/

public class Exercise4_byteConversion {

	public static void main(String[] args) {

		//units for conversion 
		final String [] units = {"B", "KB", "MB", "GB"};
		
		//array to store converted input in all "units[]" units
		double [] numconvert = new double [units.length];
		
		//prompt user for integer input in bytes
		System.out.println("Please enter an integer byte amount that you want converted");
		Scanner scan = new Scanner(System.in);
		
		//loop until input is integer
		while (!scan.hasNextInt()){
			System.out.println("Error: please enter an integer number");
			scan.next();
		}
		int input = scan.nextInt();
		numconvert[0] = input;
		
		//loop through the conversion
		for (int i = 1; i< units.length; i++){
			numconvert[i] = convert(numconvert[i-1]);
			if(String.format("%.1f", numconvert[i]).compareTo("0.0") == 0){
				break;
			}
			System.out.println(input + " = " + String.format("%.1f", numconvert[i]) + units [i]);
		}
		scan.close();
	}
	public static double convert(double input) {
		double result = (double)input/Math.pow(2,10);
		return result;
	}
}
