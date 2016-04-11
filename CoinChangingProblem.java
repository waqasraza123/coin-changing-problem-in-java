import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoinChangingProblem {

	//class variables private
	private int result, num;
	
	
	//greedy approach solution ===========================================
	void greedycoinsToUseForChanges(int amount, int coinsToUseForChange[]){
		
		//reverse the given array of available coins
		//since we want to use biggest coin possible
		reverse(coinsToUseForChange);
		
		
		for(int i=0; i<coinsToUseForChange.length; i++){
			
			//if the no at ith index is less than amount print it and subtract it from amount
			if(coinsToUseForChange[i] < amount){
				num = amount/coinsToUseForChange[i];
				System.out.println(num + "coin/coins of $" + coinsToUseForChange[i]);
				amount = amount - num*coinsToUseForChange[i];
			}
			
		}
	}
	
	//reverses the given array for greedy approach ==============================
	private void reverse(int[] input) {
		
		if(input == null || input.length <= 1){ 
			return; 
		} 
		
		
		else{
			for (int i = 0; i < input.length / 2; i++) { 
				int temp = input[i]; // swap numbers 
				input[i] = input[input.length - 1 - i];
				input[input.length - 1 - i] = temp; 
			}
		}
	}
	
	//solution with dynamic approach ==================================
	//To avoid the re-computations, we could store the results when 
	//computed and re-use them if required again. This reduces the 
	//time complexity of this algorithm to O(nm) where n is total 
	//amount to make change for and m is total number of denominations.
	void coinsToChangeWithDynamic(int []coinsToUseForChange, int amount){
	    int dp[] = new int[amount+1];
	    dp[0]=0;
	    int []prevcoinsToUseForChange = new int[amount+1];  
	    for(int j=1; j <= amount; j++){
	        dp[j]=Integer.MAX_VALUE;
	        for(int i=0;i<coinsToUseForChange.length;i++){
	            if(coinsToUseForChange[i]<=j && (1+dp[j-coinsToUseForChange[i]] < dp[j]) ){               
	                dp[j]=1+dp[j-coinsToUseForChange[i]];
	                prevcoinsToUseForChange[j]=coinsToUseForChange[i];
	            }                   
	        }
	    }

	    //===================================================
	    //find the best number of coins to make a change from 
	    //all possible solutions
	    result = dp[amount];
	    List<Integer> coinsToUseForChangesAdded = new ArrayList<Integer>();
	    for(int i=amount;i>=1;){
	        coinsToUseForChangesAdded.add(prevcoinsToUseForChange[i]);
	        int j=i;
	        i=amount-prevcoinsToUseForChange[i];
	        amount = amount - prevcoinsToUseForChange[j];
	    }
	    Integer [] coinsToUseForChanges = coinsToUseForChangesAdded.toArray(new Integer[coinsToUseForChangesAdded.size()]);
	    System.out.println( Arrays.toString(coinsToUseForChanges)); 
    }

}
