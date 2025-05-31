package gameOfLife;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameOfLife {
	
    private static int[][] grid = {
    	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    	    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    	};
    
    private static int[][] nextGrid = {
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    	    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    	};
    
    private static int[][] addGrid = {
    		{0,0,0,0},
    		{0,0,0,0},
    		{0,0,0,0},
    		{0,0,0,0}
    };
    
    private static int[][] checkDoublesGrid = new int[16][16];
    private static int[][] checkTriplesGrid = new int[16][16];
    private static int[][] checkQuadruplesGrid = new int[16][16];
    private static int[][] checkQuintuplesGrid = new int[16][16];
    private static int[][] checkSextuplesGrid = new int[16][16];
    private static int[][] checkSeptuplesGrid = new int[16][16];
    private static int[][] checkOctuplesGrid = new int[16][16];
    private static int[][] nine = new int[16][16];
    private static int[][] ten = new int[16][16];
    private static int[][] eleven = new int[16][16];
    private static int[][] twelve = new int[16][16];
    private static int[][] thirteen = new int[16][16];
    private static int[][] fourteen = new int[16][16];
    private static JLabel[][] imageGrid = new JLabel[16][16];
    private static JFrame frame = new JFrame();

    static void insertAddGrid() {
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			int value = new java.util.Random().nextInt(2);
    			addGrid[i][j] = value;
    		}
    	}
    	int insertXValue = new java.util.Random().nextInt(13);
    	int insertYValue = new java.util.Random().nextInt(13);
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
	    		if(grid[i + insertXValue][j + insertYValue] == 0) {
	    			grid[i + insertXValue][j + insertYValue] = addGrid[i][j];
	    		}
    		}
    	}
    }
    
    // Checks to see if the grid changed or stayed the same
    static boolean copyGridCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(grid[i][j] != nextGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridDoubleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkDoublesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridTripleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkTriplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridQuadrupleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkQuadruplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridQuintupleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkQuintuplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridSextupleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkSextuplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridSeptupleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkSeptuplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static boolean copyGridOctupleCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != checkOctuplesGrid[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    static boolean copyGridFourteenCheck() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(nextGrid[i][j] != fourteen[i][j]) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    static void createFrame() {
    	frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1]; // projector
        gd.setFullScreenWindow(frame);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    
    // Sets positions for JLabels
    static void createImageGrid() {
    	frame.setLayout(null);
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0; j < 16; j++) {
    			JLabel imageLabel = new JLabel();
    			imageLabel.setBounds(j * 50, i * 50, 50, 50);
    			frame.add(imageLabel);
    		    imageLabel.setVisible(true);
    			imageGrid[i][j] = imageLabel;
    			
    		}
    	}
    }
    
    static void createRandomStartGrid() {
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0; j < 16; j++) {
    			int value = new java.util.Random().nextInt(2);
    			grid[i][j] = value;
    		}
    	}
    }
    
    // converts each 1 and 0 in the grid provided a true or false 
    static boolean bool(int num) {
    	if(num == 0) {
    		return false;
    	}
    	return true;
    }
    
    // Checks to see if a specific light is on
    // index is row      bit is column
    static boolean checkOn(int row, int column){
      return bool(grid[row][column]);
    }
    
    static int checkNeighbours(int row, int column){
    	int neighbours = 0;
    	// Top row of cells
    	if(row == 0) {
    		if(column == 0) {
    			if(checkOn(0 ,1)) {
    				neighbours++;
    			}
    			if(checkOn(1 ,0)) {
    				neighbours++;
    			}
    			if(checkOn(1 ,1)) {
    				neighbours++;
    			}
    		}
    		else if(column == 15) {
    			if(checkOn(0 ,14)) {
    				neighbours++;
    			}
    			if(checkOn(1 ,15)) {
    				neighbours++;
    			}
    			if(checkOn(1 ,14)) {
    				neighbours++;
    			}
    		}
    		else {
    			if(checkOn(row ,column - 1)) {
    				neighbours++;
    			}
    			if(checkOn(row ,column + 1)) {
    				neighbours++;
    			}
    			if(checkOn(row + 1 ,column - 1)) {
    				neighbours++;
    			}
    			if(checkOn(row + 1 ,column)) {
    				neighbours++;
    			}
    			if(checkOn(row + 1 ,column + 1)) {
    				neighbours++;
    			}
    		}
    	}
    	// Bottom row of cells
    	else if(row == 15) {
    		if(column == 0) {
    			if(checkOn(14 ,0)) {
    				neighbours++;
    			}
    			if(checkOn(14 ,1)) {
    				neighbours++;
    			}
    			if(checkOn(15 ,1)) {
    				neighbours++;
    			}
    		}
    		else if(column == 15) {
    			if(checkOn(14 ,14)) {
    				neighbours++;
    			}
    			if(checkOn(14 ,15)) {
    				neighbours++;
    			}
    			if(checkOn(15 ,14)) {
    				neighbours++;
    			}
    		}
    		else {
    			if(checkOn(row - 1 ,column - 1)) {
    				neighbours++;
    			}
    			if(checkOn(row - 1 ,column)) {
    				neighbours++;
    			}
    			if(checkOn(row - 1 ,column + 1)) {
    				neighbours++;
    			}
    			if(checkOn(row ,column - 1)) {
    				neighbours++;
    			}
    			if(checkOn(row ,column + 1)) {
    				neighbours++;
    			}
    		}
    	}
    	// Left column of cells
    	else if(column == 0) {
    		if(checkOn(row - 1, column)) {
    			neighbours++;
    		}
    		if(checkOn(row - 1, column + 1)) {
    			neighbours++;
    		}
    		if(checkOn(row, column + 1)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column + 1)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column)) {
    			neighbours++;
    		}
    	}
    	// Right column of cells
    	else if(column == 15) {
    		if(checkOn(row - 1, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row - 1, column)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column)) {
    			neighbours++;
    		}
    	}
    	// All other cells
    	else {
    		if(checkOn(row - 1, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row - 1, column)) {
    			neighbours++;
    		}
    		if(checkOn(row - 1, column + 1)) {
    			neighbours++;
    		}
    		if(checkOn(row, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row, column + 1)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column - 1)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column)) {
    			neighbours++;
    		}
    		if(checkOn(row + 1, column + 1)) {
    			neighbours++;
    		}
    	}
    	return neighbours;
    }
    
    public static void copyGrid() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	fourteen[i][j] = thirteen[i][j];
    	    	thirteen[i][j] = twelve[i][j];
    	    	twelve[i][j] = eleven[i][j];
    	    	eleven[i][j] = ten[i][j];
    	    	ten[i][j] = nine[i][j];
    	    	nine[i][j] = checkOctuplesGrid[i][j];
    	    	checkOctuplesGrid[i][j] = checkSeptuplesGrid[i][j];
    	    	checkSeptuplesGrid[i][j] = checkSextuplesGrid[i][j];
    	    	checkSextuplesGrid[i][j] = checkQuintuplesGrid[i][j];
    	    	checkQuintuplesGrid[i][j] = checkQuadruplesGrid[i][j];
    	    	checkQuadruplesGrid[i][j] = checkTriplesGrid[i][j];
    	    	checkTriplesGrid[i][j] = checkDoublesGrid[i][j];
    	    	checkDoublesGrid[i][j] = grid[i][j];
    	    	grid[i][j] = nextGrid[i][j];
    	    }
    	}
    }
    
    public static void printGrid() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	        if(grid[i][j] == 1) {
    	    		imageGrid[i][j].setIcon(whiteImage);
    	    	}
    	    	else {
    	    		imageGrid[i][j].setIcon(blueImage);
    	    	}
    	    }
    	}
    }
    
    public static void delay(int time) {
    	try {
		    Thread.sleep(time);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
    }
    
    public static boolean gridEmpty() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(grid[i][j] != 0) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
    public static boolean gridFull() {
    	for (int i = 0; i < 16; i++) {
    	    for (int j = 0; j < 16; j++) {
    	    	if(grid[i][j] != 1) {
    	    		return false;
    	    	}
    	    }
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		createFrame();
		createImageGrid();
		createRandomStartGrid();
		printGrid();
		delay(400);
		while(true) {
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					int onNeighbours = checkNeighbours(i, j);
			        if(onNeighbours < 2){
			          nextGrid[i][j] = 0;
			        }
			        else if(onNeighbours > 3){
			        	nextGrid[i][j] = 0;
			        }
			        else if(onNeighbours == 2 || onNeighbours == 3){
			          if(checkOn(i, j)){
			        	  nextGrid[i][j] = 1;
			          }
			          // current bit off and 3 neighbours
			          else if(onNeighbours == 3){
			        	  nextGrid[i][j] = 1;
			          }
			        }
				}
			}
			delay(400);
			if(copyGridCheck() || copyGridDoubleCheck() || copyGridTripleCheck() || copyGridQuadrupleCheck() || copyGridQuintupleCheck() || copyGridSextupleCheck() || copyGridSeptupleCheck() || copyGridOctupleCheck() || copyGridFourteenCheck()) {
				if(gridEmpty() || gridFull()) {
					createRandomStartGrid();
					printGrid();
					delay(400);
					continue;
				}
				else {
					while(true) {
						int value = new java.util.Random().nextInt(3);
						if(value != 2) {
							insertAddGrid();
						}
						else {
							break;
						}
					}
					printGrid();
					delay(400);
					continue;
				}
			}
			copyGrid();
			printGrid();
		}
	}
	static ImageIcon blueImage = new ImageIcon(gameOfLife.class.getResource("/BlueCell.png"));
	static ImageIcon whiteImage = new ImageIcon(gameOfLife.class.getResource("/WhiteCell.png"));
}
