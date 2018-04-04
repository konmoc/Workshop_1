import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;


public class lottoGame {
	
	public static void main(String[] args) {
		//Beggining message
		System.out.println("Welcome to Lotto. What you need to do is to write 6 numbers between 1-49");
		//we use arrayMaker - you can look below for comments about its role
		int[] userGuesses  = arrayMaker();
		System.out.println("Your choices are = " + Arrays.toString(userGuesses));
		int[] artificial  = computerArray();
		System.out.println("Computer choices are = " + Arrays.toString(artificial));
		lottoMatches(userGuesses, artificial);
	}
	//this method creates integers between 1 and 49
	public static int playerChoice(){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Add a number:");
		while(scan.hasNextLine()) {
			try {
				//we check if the input is an integer
				int value = Integer.parseInt(scan.nextLine());
				//we check if our integer is between 1-49
				if(value<49 && value>0) {
					return value;
				}else {
					System.out.println("Your value is not between 1-49.Do better this time.");
				}
				
			}catch (Exception e) {
				System.out.println("Your input is not an integer!");	 
			}
		}
		scan.close();
		return 0;
	}
	//This method uses playerChoice method and creates an array of integers
	//it makes sure that each element is different -also sorts the array(lowest to highest).
	public static int[] arrayMaker() {
		//our array which which will hold user guessed numbers
		int[] userGuesses = new int[6];
		//guessing 6 numbers an puting them inside an array
		for(int i=0;i<6;i++) {
			int a = playerChoice();
			//we make sure that the user doesn't choose two same numbers
			while(ArrayUtils.contains(userGuesses,a) )
			{	
				System.out.println("You already have chosen " + a + "! Try other numbers.");
				a = playerChoice();
			}
			System.out.println("Your number = " +a);
			userGuesses[i] = a;
		}
		//we sort our array from lowest to highest numbers
		Arrays.sort(userGuesses);
		//returning array which holds 6 user choices
		return userGuesses;
	}
	//This method is a modified arrayMaker. 
	//It creates array of 6 unique integers between 1-49. Elements are sorted.
	public static int[] computerArray() {
		//our array which which will hold computer generated numbers
		int[] computerGuesses = new int[6];
		//computer makes his own array containing six(1-49) unique, random numbers
		for(int i=0;i<6;i++) {
			Random random = new Random();
			int a = random.nextInt(49) + 1;
			//we make sure that the the numbers are unique
			while(ArrayUtils.contains(computerGuesses,a) )
			{	
				a = random.nextInt(49) + 1;
			}
			computerGuesses[i] = a;
		}
		//we sort our array from lowest to highest numbers
		Arrays.sort(computerGuesses);
		//returning array which holds 6 computer "choices"
		return computerGuesses;
	}
	//This method will check how many matches computerArray and arrayMaker have
	public static void lottoMatches(int[] user,int[] computer) {
		int counter = 0;
		int[] arrayComputer = computer;
		int[] arrayHuman = user;
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(arrayComputer[i]==arrayHuman[j])
				{
					counter++;
				}
			}
		}
		if(counter==3) {
			System.out.println("You have 3 matches!");
		}else if (counter==4) {
			System.out.println("WIN! You have 4 matches!");
		}else if (counter==5) {
			System.out.println("WIN!! You have 5 matches!");
		}else if (counter==6) {
			System.out.println("WIN!!! You have 6 matches!");
		}else {
			System.out.println("Your number of matches = " + counter +". Better luck next time!");
		}
		//System.out.println("Ilość dopasowań = " + counter);
	}
	
}

