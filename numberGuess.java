import java.util.Random;
import java.util.Scanner;

public class numberGuess {
	
	public static void main(String[] args) {
		//We create a random (1-100) number which the user will try to guess
		Random rand = new Random();
		int number = rand.nextInt(99) + 1;
		
		//We ask our user for input - that is his guess
		System.out.println("Welcome to NumberGUESS!!! What intiger(1-100) do I have in mind?");
		int userChoice = getProperInput();
		//we use while loop so our player can go on as long as guesses
		while(userChoice != number) {
			if(userChoice > number) {
				System.out.println("Your number is too high!");
			}else {
				System.out.println("Your number is too low!");
			}
			//user guesses once again
			userChoice = getProperInput();
		}
		
		System.out.println("Splendid! Your guess was right! I was thinking of intiger " +number);
	}
	
	//METHODS BELOW
	//this method output is user quess(in form of int) - it also makes sure that user will...
	//...be notified if he makes a mistake
	public static int getProperInput() {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			try {
				int value = Integer.parseInt( scan.nextLine() );
				while(value<1 || value>100) {
					System.out.println("The number you're trying to guess is an integer BETWEEN 1 and 100. "
							+ "So...Maybe try that number range?");
					value = Integer.parseInt( scan.nextLine() );
				}
				return value;
			}catch (Exception e) {
				System.out.println("Your input is not a number! Try again.");
			}
		}
		return 0;
	}
}
