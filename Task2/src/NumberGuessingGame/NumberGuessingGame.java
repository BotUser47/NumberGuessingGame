package NumberGuessingGame;
import java.util.Scanner;
import java.util.Random;


class GuessingGame {
	int SI, UI,noOfGuesses = 0;
	
GuessingGame() {
		Random random = new Random();
		this.SI = random.nextInt(100) + 1;
	}

	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Guess the number : ");
			this.UI = NumberGuessingGame.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Oops!!!!Number of attempts finished...Better luck next time\n");
			return true;
		}
	}

	public boolean isCorrectGuess() {
		
		if ( SI == UI ) {
			System.out.println("Congratulations, you guess the number " + SI +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40");
				break;
				case 8:
				System.out.println("Your score is 30");
				break;
				case 9:
				System.out.println("Your score is 20");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && UI > SI ) {
			if ( UI - SI > 20 ) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( noOfGuesses < 10 && UI < SI ) {
			if ( SI - UI > 10 ) {
				System.out.println("Too low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}

public class NumberGuessingGame {
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.print("Choose the number between 1 to " + limit);
					System.out.print(" ");
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Please enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	public static void main(String[] args) {
		
		System.out.println("1. Start the Game \n2. Exit");
        System.out.print("Enter your choice : ");
		System.out.print(" ");
		int choice = takeIntegerInput(2);
		
		int noOfRound = 0;
		int nextRound = 1;
		
		if ( choice == 1 ) {
			while ( nextRound == 1 ) {
				
				GuessingGame game = new GuessingGame();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.print("\nRound " + ++noOfRound + " starts...");
				System.out.print(" ");
	
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
	
				System.out.println("1. Next Round \n2. Exit");
		        System.out.print(" Please Enter your choice : ");
				System.out.print(" ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}
