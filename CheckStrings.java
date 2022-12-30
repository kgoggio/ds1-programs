package ds1;

import java.lang.String;
import java.util.Arrays;

public class CheckStrings {
	/**
	 * Returns true if the Strings in w appear in sorted order
	 * (alphabetical order) and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if the Strings in w appear in sorted order
	 * and false otherwise.
	 */
	//bool
	public boolean isSorted(String[] w) {
		//throw new RuntimeException("Not implemented.");
		//one test runs, but fails; the other two don't run at all
		//re-write this out
		//smarter way to do this; sorts are a dead end
		int n = w.length;
		//alt way: (int i = 0; i <n-1;i++)
		//cont (if w[i].compareTo[i+1] > 0) {
		//			return false
		//return true
		for(int i = 1; i<n;i++) {
			if(w[i].compareTo(w[i-1])<0) {
				return false;
			}
		}
		return true;
	}
				
				
	               

	
	/** 
	 * Returns true if at least one String in w appears more than once
	 * and false otherwise.
	 * 
	 * @param w the array of Strings to check
	 * @return true if at least one String in w appears more than once
	 * and false otherwise.
	 */
	public boolean hasDuplicate(String[] w) {
		//throw new RuntimeException("Not implemented.");
		//this fully works!
		int n = w.length;
		int dups = 0;
		for(int i = 0; i <n-1; i++) {
			for(int j = i+1; j <n;j++) {
				if(w[i].equals(w[j])) {
					dups +=1;
					//when comparing objects, 99% of time must use .equals()
					//can just have done return true;
				}
			}
			
			}
		//could have just returned false here
		if(dups >0) {
			return true;
		}else {
			return false;
		}
	}
}
	
