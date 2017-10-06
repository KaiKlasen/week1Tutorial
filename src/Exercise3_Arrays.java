/**
* <dl>
* <dt> Purpose:
* <dd> Simple example program
*
* <dt> Description:
* <dd> This program fills an array
* </dl>
* @author Kai klasen
* @version Date: 30/09/2017
*/

public class Exercise3_Arrays {

	public static void main(String[] args) {

		int numbers[] = new int[20];
		numbers[0] = 1;
		
		//loop to assign values into array: numbers[]
		for (int i = 1; i< numbers.length; i++){
			numbers[i] = 2*numbers[i-1]; 
		}
		
		//creating meanval array and initializing first and last element
		double meanval[] = new double[20];
		meanval[0] = numbers[0];
		meanval[19] = Math.pow(2,20);

		//array storing mean value of neighbouring elements in numbers[]
		for (int j = 1; j< meanval.length-1; j++){
			meanval[j] = ( (double) numbers[j-1] + numbers[j+1] )/2;
		}
		//end of program
		System.out.println("Done, your values have been stored in the arrays");
		System.exit(0);
	} 
}
