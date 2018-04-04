import java.util.Random;
import java.util.Scanner;

public class diceRoll {
	public static void main(String[] args) {
		//We welcome our user
		System.out.println("Welcome to diceRoll! With our program rolling dices is super easy!\n"
				+ "You can choose from D3, D4, D6, D8, D10, D12, D20 and D100 dices.\n"
				+ "Just write your input in form of xDy+/-z where x-number of dices you want me to roll,\n"
				+ "y-how many sides should our dice have, z-number we could add or subtract from the result\n");
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextLine()) {
			try {
				String subTract = "";
				String diceChoice = scan.nextLine();
				if(diceChoice.contains("-")) {
					subTract += "-";
				}else {
					subTract += "+";
				}
				String[] arrayDice = diceChoice.split("D|\\+|\\-");
				//we declare 3 ints - first is number of dicer we want to roll, second tells us what dices
				//will we roll. Third int tells us what number will we add/subtract
				int numOfDices = Integer.parseInt(arrayDice[0]);
				int numOfSides = Integer.parseInt(arrayDice[1]);
				int addSubtr = Integer.parseInt(arrayDice[2]);
				//we make sure that the user can only use specific dices
				while(numOfSides != 3 && numOfSides !=4 && numOfSides !=6 && numOfSides !=8 && numOfSides !=10
						&& numOfSides !=12 && numOfSides !=20 && numOfSides !=100){
					System.out.println("Dices can be only D3, D4, D6, D8, D10, D12, D20 and D100");
					diceChoice = scan.nextLine();
					arrayDice = diceChoice.split("D|\\+|\\-");
					numOfDices = Integer.parseInt(arrayDice[0]);
					numOfSides = Integer.parseInt(arrayDice[1]);
					addSubtr = Integer.parseInt(arrayDice[2]);
					//we use subTract to know if user wants to add or subtract certain number
					if(diceChoice.contains("-")) {
						subTract += "-";
					}else {
						subTract += "+";
					}
				}
				System.out.println(numOfDices);
				System.out.println(numOfSides);
				System.out.println(addSubtr);
				System.out.println(subTract);
				int sum=0;
				int singleRoll =0;
				Random r = new Random();
				for(int i=0;i<numOfDices;i++) {
					singleRoll= r.nextInt(numOfSides-1) + 1;
					System.out.println("Roll = " + singleRoll);
					sum += singleRoll;
				}
				if(subTract.contains("+")) {
					sum+= addSubtr;
				}else {
					sum-= addSubtr;
				}
			
				System.out.println("Sum of your rolls = " + sum);
				
			} catch (Exception e) {
				System.out.println("Wrong input format! Write your input in form of "
									+ "xDy+/-z(for example 1D10+3, 2D10+0)");
			}
		}
		
		

		
	}
	

	
}
