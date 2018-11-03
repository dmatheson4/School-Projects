/* Dan Matheson
 * 4/13/17
 * This program will interact with the game gui to allow the user to 'play' the game of life. It also contains methods that will 
 * manipulate the map in different ways. For example, the copyMap method will copy a map or 2d boolean array to the current map.
 * This 2d boolean array represents cells that are either dead or alive. They have different conditions associated with keeping a cell alive,
 * reviving a cell, or killing a cell. These are all determined by the number of neighboring cells they have. The different grid types are torus
 * and flat. A torus grid looks like a donut in the sense that it is never ending, and the flat grid has walls that cannot provide neighbors to
 * any cells touching the wall.
 */
/**
 * CIS 181 Array Based Implementation of Conway's Game Of Life
 * The game of life class: GameOfLife.java
 *
 * @author Haiping Xu
 * Created on October 25, 2008
 **/

public class GameOfLife implements GameInterface {
	private boolean[][] originalMap,    // The initial cell configuration
	map,    // The current cell configuration
	newMap;    // The next generation configuration
	private GameGUI gui;
	private int generation = 0;
	private FileIO fileIO;

	// GameOfLife constructor
	public GameOfLife() {
		originalMap = new boolean[MAX_ROWS][MAX_COLS];
		map = new boolean[MAX_ROWS][MAX_COLS];
		newMap = new boolean[MAX_ROWS][MAX_COLS];
		gui = new GameGUI(this, map);
		gui.setTitle("CIS 181 Array Based Game Of Life");
		fileIO = new FileIO("life", "Game of Life Text Files");
		readExample(2);
	}

	//  ====>>>>> Complete the methods below this line! <<<<<====

	// copyMap:
	// Precondtions: None.
	// Postcondtion: 'map' is a deep copy of 'sourceMap'.
	//
	private void copyMap(boolean sourceMap[][]) {
		for (int row = 0; row < sourceMap.length; row++){
			for (int col = 0; col < sourceMap[0].length; col++){
				map[row][col] = sourceMap[row][col];
			}
		}

		// ==> 1. Add your code here!

	}

	// clearMap:
	// Precondtions: None.
	// Postcondtion: Sets all cells of the 'targetMap' to DEAD.
	//
	private void clearMap(boolean targetMap[][]) {
		for (int row = 0; row < targetMap.length; row++){
			for (int col = 0; col < targetMap[0].length; col++){
				targetMap[row][col] = DEAD;
			}
		}
		// ==> 2. Add your code here!

	}

	//  getFlatNeighborCount:
	//  Precondtions:  0 <= row < MAX_ROWS and 0 <= col < MAX_COLS.
	//  Postcondtion:  A count of all LIVE neighbors of the cell at [row, col] is
	//                 returned where its neighbors are all the ADJACENT cells
	//                 including those
	//                 a) In the rows BELOW and ABOVE the cell (if any exist).
	//                 b) In the columns LEFT and RIGHT of the cell (if any exist).
	//                 Thus, a cell adjacent to a board edge (or corner) has
	//                 fewer neighbors than other cells.
	//
	private int getFlatNeighborCount(int row, int col){
		int count = 0;

		//This will check if the row and column are both valid
		if(row >= 0 && row < MAX_ROWS && col >= 0 && col < MAX_COLS){

			//This will check if the top middle row is not equal to zero and if the spot is true
			if(row !=0 && map[row-1][col] == ALIVE)
				count++;
			//This will check if the bottom middle row is not at max and if the spot is true
			if(row != (MAX_ROWS - 1) && map[row+1][col] == ALIVE)
				count++;
			//This will check if the left middle column is not equal to zero and if the spot is true
			if(col != 0 && map[row][col-1] == ALIVE)
				count++;
			//This will check if the right middle column is not at max and if the spot is true
			if(col != (MAX_COLS - 1) && map[row][col+1] == ALIVE)
				count++;
			//This will check if the upper left spot is true
			if(row !=0  && col != 0 && map[row-1][col-1] == ALIVE)
				count++;
			//This will check if the upper right spot is true
			if(row !=0  && col != (MAX_COLS - 1) && map[row-1][col+1] == ALIVE)
				count++;
			//This will check if the lower left spot is true
			if(row != (MAX_ROWS - 1)  && col != 0 && map[row+1][col-1] == ALIVE)
				count++;
			//This will check if the lower right spot is true
			if(row != (MAX_ROWS - 1)  && col != (MAX_COLS - 1) && map[row+1][col+1] == ALIVE)
				count++;
		}
		// ==> 3. Add your code here!


		return count;
	}

	//  getTorusNeighborCount:
	//  Precondtions:  0 <= row < MAX_ROWS and 0 <= col < MAX_COLS.
	//  Postcondtion:  A count of all LIVE neighbors of the cell at [row, col] is
	//                 returned where its neighbors are all the ADJACENT cells
	//                 including those
	//                 a) In the rows BELOW and ABOVE the cell (if any exist).
	//                 b) In the columns LEFT and RIGHT of the cell (if any exist).
	//                 A cell adjacent to the edge of the board will have a possibility of having neighbors
	//                 that are on the other edge of the board (top to bottom, left to right, and in the corners).
	//				   
	//				   The board is basically a donut.

	private int getTorusNeighborCount(int row, int col){
		int count = 0;
		
		
		// ==> 3. Add your code here!
		//These four if statements will check the four corners to see if they have any neighbors in the other corners
		if(row == 0 && col == 0 && map[(MAX_ROWS - 1)][(MAX_COLS - 1)] == ALIVE)
			count++;
		if(row == 0 && col == (MAX_COLS - 1) && map[(MAX_ROWS - 1)][0] == ALIVE)
			count++;
		if(row == (MAX_ROWS - 1) && col == 0 && map[0][(MAX_COLS - 1)] == ALIVE)
			count++;
		if(row == (MAX_ROWS - 1) && col == (MAX_COLS - 1) && map[0][0] == ALIVE)
			count++;
		
		//These three if statements will check if a cell on the bottom row has any of three possible neighbors on the top of the map
		if(row == (MAX_ROWS - 1) && map[0][col] == ALIVE)
			count++;
		if(row == (MAX_ROWS - 1) && col > 0 && map[0][col-1] == ALIVE)
			count++;
		if(row == (MAX_ROWS - 1) && col < (MAX_COLS - 1) && map[0][col+1] == ALIVE)
			count++;
		
		//These three if statements will check if a cell on the top row has any of three possible neighbors on the bottom of the map
		if(row == 0 && map[(MAX_ROWS  -1)][col] == ALIVE)
			count++;
		if(row == 0 && col > 0 && map[(MAX_ROWS - 1)][col-1] == ALIVE)
			count++;
		if(row == 0 && col < (MAX_ROWS - 1) && map[(MAX_ROWS - 1)][col+1] == ALIVE)
			count++;
		
		//These three if statements will check if a cell on the right column have any of three possible neighbors on the left of the map
		if(col == (MAX_COLS - 1) && map[row][0] == ALIVE)
			count++;
		if(col == (MAX_COLS - 1) && row > 0 && map[row-1][0] == ALIVE)
			count++;
		if(col == (MAX_COLS - 1) && row < (MAX_ROWS - 1) && map[row+1][0] == ALIVE)
			count++;
		
		//These three if statements will check if a cell on the left column have any of three possible neighbors on the right of the map
		if(col == 0 && map[row][(MAX_COLS - 1)] == ALIVE)
			count++;
		if(col == 0 && row > 0 && map[row-1][(MAX_COLS - 1)] == ALIVE)
			count++;
		if(col == 0 && row < (MAX_ROWS - 1) && map[row+1][(MAX_COLS - 1)])
			count++;
		
		return count;
	}

	// nextGenerationForFlatGrid:
	// Precondtions: None
	// Postcondtion: The next generation of live and dead cells is calculated using
	//               a) the FLAT neighbor counts.
	//               b) the current birth, survival and death count rules.
	//               c) the rules are applied to the counts obtained from the current
	//                  generation's configuration of live and dead cells.
	//               The current 'map' is updated to the next generation's configuration
	//               of live and dead cells.
	//		     d) the global variable 'generation' is increased by 1
	//	
	public  void nextGenerationForFlatGrid() {

		//This for loop will go through all of the rows
		for(int row = 0; row<MAX_ROWS; row++){
			//This for loop will go through all of the columns
			for(int col = 0; col<MAX_COLS; col++){
				//This will check if the cell is dead and has exactly 3 neighbors and rebirths it
				if(map[row][col] == DEAD && getFlatNeighborCount(row,col) == BIRTH_NBR_COUNTS)
					newMap[row][col] = ALIVE;
				//This will check if the cell is alive and if it has less than two neighbors it will die
				else if(map[row][col] == ALIVE && getFlatNeighborCount(row,col) < 2)
					newMap[row][col] = DEAD;
				//This will check if the cell is alive and has at least two neighbors and it will stay alive
				else if(map[row][col] == ALIVE && (getFlatNeighborCount(row,col) == SURV_NBR_COUNTS_2 || getFlatNeighborCount(row,col) == SURV_NBR_COUNTS_3))
					newMap[row][col] = ALIVE;
				//If the cell is dead, has no/not enough neighbors, or too many neighbors it is dead
				else
					newMap[row][col] = DEAD;
			}
		}
		copyMap(newMap);//Copy the new map to the current map
		clearMap(newMap);//Clear the new map
		generation++;//Increment generation
		// ==> 4. Add your code here!

	}

	// nextGenerationForTorusGrid:
		// Precondtions: None
		// Postcondtion: The next generation of live and dead cells is calculated using
		//               a) the FLAT neighbor counts, as well as the TORUS neighbor counts.
		//               b) the current birth, survival and death count rules.
		//               c) the rules are applied to the counts obtained from the current
		//                  generation's configuration of live and dead cells.
		//               The current 'map' is updated to the next generation's configuration
		//               of live and dead cells.
		//		         d) the global variable 'generation' is increased by 1
		//	
	// ==> 5. Implement the game of life for torus grid.

	public void nextGenerationForTorusGrid() {

		int totalNeighbors;

		//This for loop will go through all of the rows
		for(int row = 0; row<MAX_ROWS; row++){
			//This for loop will go through all of the columns
			for(int col = 0; col<MAX_COLS; col++){
				//This will get the total number of neighbors from both the flat and torus grid methods and add them together
				totalNeighbors = getFlatNeighborCount(row,col) + getTorusNeighborCount(row,col);
				//This will check if the cell is dead and has exactly 3 neighbors and rebirths it
				if(map[row][col] == DEAD && totalNeighbors == BIRTH_NBR_COUNTS)
					newMap[row][col] = ALIVE;
				//This will check if the cell is alive and if it has less than two neighbors it will die
				else if(map[row][col] == ALIVE && totalNeighbors < 2)
					newMap[row][col] = DEAD;
				//This will check if the cell is alive and has at least two neighbors and it will stay alive
				else if(map[row][col] == ALIVE && (totalNeighbors == SURV_NBR_COUNTS_2 || totalNeighbors == SURV_NBR_COUNTS_3))
					newMap[row][col] = ALIVE;
				//If the cell is dead, has no/not enough neighbors, or too many neighbors it is dead
				else
					newMap[row][col] = DEAD;
			}
		}
		copyMap(newMap);//Copy the new map to the current map
		clearMap(newMap);//Clear the new map
		generation++;//Increment generation
	}




	//  ====>>>>> Don't touch the code below this line! <<<<<====

	// Return the next generation
	public int getGeneration() {
		return generation;
	}

	// Reset the map to the original map
	public void reset() {
		copyMap(originalMap);
		generation = 0;
		gui.repaint();
	}

	// Game of life examples 1-4: Fish, Plus, Glider, FlyingMachine
	public void readExample(int n) {
		System.out.println("Initializing with example " + n + " ...");
		clearMap(originalMap);

		switch (n) {
		case 1: // Example 1: Fish
			for (int col = 23; col <= 26; col++)
				originalMap[13][col] = ALIVE;
			originalMap[14][22] = ALIVE;
			originalMap[14][26] = ALIVE;
			originalMap[15][26] = ALIVE;
			originalMap[16][22] = ALIVE;
			originalMap[16][25] = ALIVE;
			break;
		case 2: // Example 2: Plus
			for (int col = 6; col < 43; col++)
				originalMap[24][col] = ALIVE;
			for (int row = 6; row < 43; row++)
				originalMap[row][24] = ALIVE;
			break;
		case 3: // Example 3: Glider
			originalMap[14][23] = ALIVE;
			originalMap[15][24] = ALIVE;
			for (int row = 13; row <= 15; row++)
				originalMap[row][25] = ALIVE;
			break;
		case 4: // Example 4: FlyingMachine
			for (int col = 22; col <= 25; col++) {
				originalMap[11][col] = ALIVE;
				originalMap[19][col] = ALIVE;
			}
			for (int row = 14; row <= 16; row++)
				for (int col = 17; col <= 18; col++)
					originalMap[row][col] = ALIVE;
			originalMap[15][19] = ALIVE;
			for (int row = 12; row <= 18; row = row+2)
				originalMap[row][21] = ALIVE;
			originalMap[14][24] = ALIVE;
			originalMap[16][24] = ALIVE;
			originalMap[12][25] = ALIVE;
			originalMap[13][25] = ALIVE;
			originalMap[17][25] = ALIVE;
			originalMap[18][25] = ALIVE;
			break;
		default: // Default Example: ClearSpace
			break;
		}

		copyMap(originalMap);
		generation = 0;
		gui.repaint();
	}

	//  Read map from file
	public void readInMap() {
		clearMap(originalMap);
		if (fileIO.read(originalMap)) {
			copyMap(originalMap);
			generation = 0;
		} else
			readExample(2);
		gui.repaint();
	}

	// Write map to file
	public void writeMap() {
		fileIO.write(map);
	}

	// Change the state of a cell
	public void updateMap(int row, int col) {
		map[row][col] = !map[row][col];

	}

	// Destroy the GUI window
	public void destroy() {
		gui.dispose();
	}

	// The main method of GameOfLife
	public static void  main(String[] args) {
		GameOfLife game = new GameOfLife();
	}
}
