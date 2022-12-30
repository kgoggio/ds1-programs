package hw2;

/**
 * 
 * A class that mimics how Java's String class behaves.
 * Look at Java's String API for information on how each of these should behave.
 *
 */
public class String {
	private static final boolean String = false;
	private char[] data;

	public String(char[] value) {
		//throw new RuntimeException("Not implemented.");

		this.data = new char[value.length];
		for(int i = 0; i <value.length; i++) {
			data[i] = value[i];
		}
		
		
		
	}

	
	public char charAt(int index) {
		//throw new RuntimeException("Not implemented.");
		//works
		char charAtIndex = data[index];

		return charAtIndex;
		
		
	}


	public int indexOf(char ch) {
		//throw new RuntimeException("Not implemented.");
		//how do i return -1 if the char doesn't appear in it/how do 
		//i get the first char to have index of both 0 and -1?
		//do i this to work so the last index works and gives 9 instead of -1?
		//problem lines in test code: 202-4; 219
		//works
		int n = data.length;
		for(int i=0; i < n;i++) {
			if(data[i] == ch) {
				targetIndex = i;
				break;
			}
		}
		//so i got upt o line 219; how do i get the code to run if the last 
			
		return -1
		
		
	}

	public boolean equals(String other) {
		//throw new RuntimeException("Not implemented.");
		//completely works!
		if(this.data.length == other.data.length) {
			for(int i = 0; i <this.data.length; i++) {
				if(this.data[i] != other.data[i]) {
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}

	public int compareTo(String anotherString) {
		//throw new RuntimeException("Not implemented.");
		//this works 100%
		// int pos = -1
		//if(data.length < anotherString.data.length;
		// size = data.length
		//else
		//size = anotherstring.data.length
		//for (int i =0; i <size; i ++
		//  if (data[i] !- anotherstring.data.i
		//pos = i
		//break
		//if (pos !- -1
		//return data[pos - anotherstring.data[i]
		// else
		
		int n = data.length;
		int m = anotherString.data.length;
		int loopLimit= 0;
		int i = 0;
		if (n >m) {
			loopLimit = m;
		}else if (m >n) {
			loopLimit = n;
		}else {
			loopLimit = n;
		}
		while(i<loopLimit) {
			if(data[i] !=anotherString.data[i]) {
				return data[i] - anotherString.data[i];
			}
			i++;
		}
		return n - m;
	}
			


	public String replace(char oldChar, char newChar) {
		//throw new RuntimeException("Not implemented.");
		//works!
		//prof anser:
		//string answer = new string(data);
		//for(int i = 0; i < data.length; i++)
		//boolean change = false
		int n = data.length;
		int oldCharCounter = 0;
		char[] newData = new char[n];
		for(int j =0;j<n;j++) {
			if(data[j] == oldChar) {
				newData[j] = newChar;
				//counter thing isn't neccessary
				oldCharCounter += 1;
			} else {
				newData[j] = data[j];
			}
		}
		if(oldCharCounter<1) {
			return this;
		} else {
		return new String(newData);
		}
	}
}
	

	
	// If you want to add a main method in this file to help test/debug
	// your code, make sure to see the note in the write-up!

