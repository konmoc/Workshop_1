import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class numberGuesss_2 {
	
	public static void main(String[] args) {
		//this program will guess a number between 0 and 1000 which will be choosen by the user
		//let's start by a warm welcome message
		System.out.println("Welcome to YourNumberGuess - think of an integer between 0 and 1000 "
			+ "which I will to guess.");
		//now we should wait for the user to make his mind
		for(int i=0;i<5;i++) {
			try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("waiting...");
			}catch (InterruptedException e) {
				System.out.println(e.getMessage());			}
		}
		//now we should ask the user if he's ready to guess
		Scanner scan = new Scanner(System.in);
		System.out.println("Ready?(yes/no)");
		String ready = scan.next();
		while(!ready.equals("yes")) {
			System.out.println("Ok...just type yes when you'll be ready.");
			ready = scan.next();
		}
		System.out.println("Great! Let's start our game!");
		int min = 0;
		int max = 1000;
		int counter = 0;
		
		int compGuess = (max-min)/2;
		System.out.println("Are You thinking about " + compGuess + "?(yes/no)");
		counter++;
		//user answers
		String answer = scan.next();
		while(!answer.contains("yes") && !answer.contains("no")) {
			System.out.println("yes or no?");
			answer = scan.next();
		}
		
		while(!answer.equals("yes")) {
			System.out.println("Too bad. Is your number greater or lower than " + answer + "?(g/l)");
			String greaterLower = scan.next();
			while(!greaterLower.equals("g") && !greaterLower.equals("l")) {
				System.out.println("Is it greater(g) or lower(l)?");
				greaterLower = scan.next();
			}
			if(greaterLower.equals("g")) {
				min=compGuess;
			}else {
				max=compGuess;
			}
			compGuess = ((max-min)/2)+min;
			System.out.println("Are You thinking about " + compGuess + "?(yes/no)");
			counter++;
			answer = scan.next();
		}
		System.out.println("That was easy! Number of computer guesses = " + counter);
		
	}

	
}
