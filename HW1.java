package ds1;


public class HW1 {
	/**
	 * Computes the sum of the ints in an array.
	 * 
	 * @param a the array of ints to be summed
	 * @return the sum of the ints in <code>a</code>
	 */
	public int sum(int[] a) {
		//throw new RuntimeException("Not implemented yet");
		//implemented; no failures
		int sum  = 0;
		for (int i: a){
			sum += i;
			
		}

		return sum;
	}
			
	
	/**
	 * Finds the maximum int in a non-empty array.
	 * 
	 * @param a a non-empty array of ints
	 * @return the maximum int in the array
	 */
	public int largest(int[] a) {
		//throw new RuntimeException("Not implemented yet");
        int n = a.length;
        int max = a[0];
        for (int i = 0; i < n; i++) {
        	if (a[i]>max) {
        		max = a[i];
        	}
        }
        return max;
	}
	/**
	 * Finds the second largest int in an array of unique ints
	 * 
	 * @param a an int array of unique ints with size > 1
	 * @return the second largest int in the array
	 */
	public int secondLargest(int[] a) {
		//throw new RuntimeException("Not implemented yet");
		int n = a.length;
        int max = largest(a);
        int secondLargest = a[0];
        for (int i = 0; i < n; i++) {
        	if(max == secondLargest) {
        		secondLargest = a[1];
        	}
        	if (max >a[i]&& a[i] > secondLargest) {
        		secondLargest = a[i];
	        	}
	        }
        return secondLargest;
		
        }
	
	/**
	 * Returns the number of even ints in an array.
	 * 
	 * @param a an array of ints
	 * @return the number of even ints in the array
	 */
	public int countEvens(int[] a) {
		//throw new RuntimeException("Not implemented yet");

		int evenNumCount = 0;
		for (int i: a) {
			if (i%2==0) {
				evenNumCount +=1;
			}else {
				evenNumCount+=0;
			}
		}
		return evenNumCount;
	}
	
	/**
	 * Returns a new array containing the even ints from an input array in
	 * the same order they appear in the array.
	 * 
	 * @param a an array of ints
	 * @return a new array containing the even ints from an input array in
	 * the same order they appear in the array
	 */
	public int[] getEvens(int[] a) {
		//throw new RuntimeException("Not implemented yet");
		int j = 0; 
		int[] Evens = new int[countEvens(a)];
		for (int i: a) {
			if (i%2==0) {
				Evens[j++] = i;
			} else {
				continue; 
			}
		}
		return Evens;
	}
}
			
		
