import java.util.Scanner;

public class Main {

	//class variables private =============================
	private static Scanner scanner;
	private static int numberForChange;
	
	public static void main(String[] args){
			
		CoinChangingProblem coinChangingProblem = new CoinChangingProblem();
		
		scanner = new Scanner(System.in);
		//take input until user wants to quit(enter 420 to exit)
		while (numberForChange != 420) {
			
			System.out.println("Enter a number: ===============================");
			
			try {
				numberForChange = scanner.nextInt(); //take input as number, user can enter string
			} catch (Exception e) {
				System.out.println("Please input a string");
				break;
			}
			
			//available coins for change ==========================================
			int coinsToUseForChange[] = {1, 5, 10, 25};
			
				
			System.out.println("Greedy Solution:");
			coinChangingProblem.greedycoinsToUseForChanges(numberForChange, coinsToUseForChange);
			
			
			System.out.println("\nDynamic Solution:");
			coinChangingProblem.coinsToChangeWithDynamic(coinsToUseForChange, numberForChange);	
			
		}
	}
}
