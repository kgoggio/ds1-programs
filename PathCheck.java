package hw8;

import algs4.WeightedQuickUnionUF;

/**
 * A class used to determine if a path exists from the top of a grid to the
 * bottom
 */
public class PathCheck {

	// IMPORTANT:
	// Use the uf field below to help you solve the problem.
	// Note, however, that this one field is not enough.
	// You will need to have additional fields, but you must use
	// the uf field in solving the probem.
	private WeightedQuickUnionUF uf;
	private int[][] grid;
	private int insertNum = 0;
	private int mySize;
	
	

	

	/**
	 * Models an initial <code>size</code> by <code>size</code> grid with no cells
	 * selected.
	 * 
	 * @param size the length and width of the grid.
	 */
	public PathCheck(int size) {
		//throw new RuntimeException("Not implemented");
		uf = new WeightedQuickUnionUF(size*size);
		grid= new int[size] [size];
		for(int i= 0; i<size;i++ ) {
			for(int j =0; j<size;j++) {
				grid[i][j] = insertNum;
				insertNum++;
			}
		}
		mySize = size;
	
	}

	/**
	 * Selects the cell in given <code>row</code> and <code>col</code> and returns
	 * <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * 
	 * @param row the row of the cell to be selected.
	 * @param col the column of the cell to be selected.
	 * @return <code>true<code> if there is a path of selected cells from the top of the grid
	 * to the bottom, and <code>false</code> otherwise.
	 * @throws IllegalArgumentException if either <code>row</code> or
	 *                                  <code>col</code> is out of bounds (greater
	 *                                  than or equal to size or negative).
	 */
	public boolean select(int row, int col) throws IllegalArgumentException {
		boolean connected = false;
		int myMax = mySize-1;
		
		//int truthCount = 0;

		
		
		if(row >=mySize || col >=mySize) {
			throw new IllegalArgumentException("Out of bounds");
		}//correct
		if(row <0 || col <0) {
			throw new IllegalArgumentException("Out of bounds");
		}//correct
		
		//Connect the top if exists
		uf.union(row, col);
		//if(uf.connected(row, myMax)==true) {
			//return true;
		//}
		for(int topCol = 0; topCol <mySize;topCol++ ) {
			for(int botRow = 0; botRow<mySize;botRow++ ) {
				//this checks to the right
				if(uf.connected(row, topCol)==true) { //this condition is trigger, but it's not working quickly or working perfectly
					uf.union(row, topCol);
				} //checks below
				if(uf.connected(botRow, col)==true) {
					uf.union(botRow, col); 
				}
					
		}
		}
		if(uf.connected(0, col)==true && uf.connected(myMax,col)==true) {
			return true;
		}
		return connected;
	}
}
		/*
		try {
		uf.find((row-1)*col);
		uf.union((row-1)*col, row*col);
		} catch (Exception e) {
			//this is the top if there is an exception
		}
		
		//Connect the right if exists
		try {
			//v1
			if (mySize > (col + 1)) {throw new IllegalArgumentException("Out of bounds");}
			uf.find(row*(col+1));
			uf.union(row, col+1);
			if(uf.connected(row,(col+1)) ==true) {
				truthCount+=1;
			}
			
//			//v2
//			if(mySize > (col+1)) 
//				uf.find(grid[row][col+1]);
//				uf.union(grid[row][col+1],grid[0][col]);
//				if(uf.validate(row,col+1) ==true) {
//					truthCount+=1;
//				}
					
		} catch(Exception e) {
			//error if gone out of the screen to the right
		}
		
		//Connect the left if exists
		try {
			if ((col - 1) < 0) {throw new IllegalArgumentException("Out of bounds");}
			uf.find(row*(col-1));
			uf.union(row, col -1);
		} catch(Exception e) {
			//error if gone out to the left of the screen
		}
		//Connect the bottom if exists
		try {
			uf.find((row +1)*col);
			uf.union(row+1,col);
		} catch(Exception e) {
					//error if gone out to the left of the screen
		}
		
		if(uf.connected(row,col) == true) {
			return true;
		} 
		return end;
		*/
		//Then connect
//		if (row > 0 && row < myMax) {
//			try {
//				uf.(grid[row][col],grid[row-1][col])
//			}
//		}
			/*if(row > 0) {
				if(grid[row-1][col] !=0) {

					uf.find(grid[row][col],grid[row-1][col]);
				}
			}
			if(col > 0) {
				if(grid[row][col-1] !=0) {
					uf.union(grid[row][col],grid[row][col-1]);
				}
			}
			if(col+1 <mySize) {
				if(grid[row][col+1]!=0) {
					uf.union(grid[row][col],grid[row][col+1]);
				}
			}
			if(row+1<mySize) {
				if(grid[row+1][col]!=0) {
					uf.union(grid[row][col],grid[row+1][col]);
			}
			}
		*/
		//v1
		//gets the first two tests to pass
		/*
		for(int topCol = 0; topCol <mySize; topCol++) {
			for(int bottomCol = 0; bottomCol <mySize;bottomCol++) {
				if(uf.connected(grid[0][topCol],grid[mySize-1][bottomCol])!=true) {
					//return uf.connected(grid[0][topCol],grid[mySize-1][bottomCol]);
					//that means that the uf.union find is true
					return uf.connected(grid[0][topCol],grid[mySize-1][bottomCol])==true;
				} else {
					return true;
				}
				
			}
	}
		return false;
	}
}
*/
		//v2 also gets thru size large
	
		/*
		for(int topCol = 0; topCol <mySize; topCol++) {
			for(int bottomCol = 0; bottomCol <mySize;bottomCol++) {
				if(uf.connected(grid[0][topCol],grid[mySize-1][bottomCol])!=true) {
					end = false;
					return end;
			} else {
				end = true;
			}
		}
		}
		return true;
	}
}
*/
//		//v4
//		for(int topCol=0; topCol<mySize;topCol++) {
//			for(int bottomCol = 0; bottomCol<mySize;bottomCol++) {
//				if(uf.connected(grid[row][col],grid[0][topCol])==true && uf.connected(grid[row][col],grid[myMax][bottomCol])==true) {
//					return true; //this conditional/loop is not triggering
//				}
//			}
//		//}
//	}
//		return false; //this part is triggering
//}
//}		


