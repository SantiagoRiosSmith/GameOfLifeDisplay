// Santiago Rios Smith
// 2025-06-18
// This project displays conway's game of life on a connected projector designed for the art display: Manufactured Ecosystems
package gameOfLife;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameOfLife {
	
    // grid is the current grid displayed on the display each number representing a dead or alive cell 0 or 1
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
    
    // nextGrid is the next grid that will be displayed
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
    
    // addGrid is a 4x4 marix of cells that will be added the the grid in specific scenerios
    private static int[][] addGrid = {
    		{0,0,0,0},
    		{0,0,0,0},
    		{0,0,0,0},
    		{0,0,0,0}
    };
    
    // All of these grids hold the previous grids which get compared to the current one to check for any recurring patterns
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
    // imageGrid holds the JLabels in a 16x16 matrix which hold the image of each cell
    private static JLabel[][] imageGrid = new JLabel[16][16];
    // frame is the virtual frame that the 16x16 image matrix will be displayed onto
    private static JFrame frame = new JFrame();
    // imageSize is the size of each image in pixels it will be calculated and can be changed in the resize.txt file
    private static int imageSize = 320;
    
    // This changes addGrid to hold a random 4x4 matrix of dead and alive cells
    static void insertAddGrid() {
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			int value = new java.util.Random().nextInt(2);
    			addGrid[i][j] = value;
    		}
    	}
    	// This part determines where on the 16x16 matrix the 4x4 matrix will be placed 
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
    
    // Checks to see if the grid changed or stayed the same over 2 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 3 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 4 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 5 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 6 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 7 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 8 fazes of the matrix
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
    
    // Checks to see if the grid changed or stayed the same over 14 fazes of the matrix
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
    
    // Creates and intitializes the properties of the digital frame used to project the 16x16 matrix of cells
    static void createFrame() {
    	frame.setSize(12800, 12800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1]; // projector
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();
        frame.setBounds(bounds);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    
    // Sets positions for JLabels
    static void createImageGrid() {
    	frame.setLayout(null);
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0; j < 16; j++) {
    			JLabel imageLabel = new JLabel();
    			imageLabel.setBounds(j * imageSize, i * imageSize, imageSize, imageSize);
    			frame.add(imageLabel);
    		    imageLabel.setVisible(true);
    			imageGrid[i][j] = imageLabel;
    			
    		}
    	}
    }
    
    // If the size of the images are changed by the user this properly proportions the frames of each image to fit that specified size
    static void editImageGrid() {
    	for(int i = 0; i < 16; i++) {
    		for(int j = 0; j < 16; j++) {
    			imageGrid[i][j].setBounds(j * imageSize, i * imageSize, imageSize, imageSize);
    		}
    	}
    }
    
    // This gives the 16 x 16 matrix a random starting position where each cell can either start as dead or alive
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
    static boolean checkOn(int row, int column){
      return bool(grid[row][column]);
    }
    
    // This counts the number of alive neighbours a specified cell has and returns that number
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
    
    // When the next grid is ready to be displayed each 16 x 16 matris is moved in order by 1 for the next iteration
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
    
    // This places the appropriate dead or alive image in each of the image frames in the 16x16 matrix
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
    
    // Given a specified time in milliseconds it will conduct a pause
    public static void delay(int time) {
    	try {
		    Thread.sleep(time);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
    }
    
    // Checks to see if every cell in the 16x16 matrix is dead
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
    
    // Checks to see if every cell in the 16x16 matrix is alive
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
    
    // This determines the size of each image needed given a height and width of a theoretical projector/screen
    public static int newImageDimentions(int width, int height) {
    	int usedDimention;
    	if(width < height) {
    		usedDimention = width;
    	}
    	else {
    		usedDimention = height;
    	}
    	if((usedDimention / 16) >= 320) {
    		return -1;
    		
    	}
    	imageSize = usedDimention / 16;
    	return usedDimention / 16;
    }
    
    // This changes and resizes each image in the 16x16 image matrix
    public static void resizeImage(int newSize) {
    	if(newSize == -1) {
    		return;
    	}
    	blueImage = new ImageIcon(gameOfLife.class.getResource("/BlueCellNew.png"));
    	whiteImage = new ImageIcon(gameOfLife.class.getResource("/WhiteCellNew.png"));
    	blueImage = new ImageIcon(blueImage.getImage().getScaledInstance(newSize, newSize, Image.SCALE_SMOOTH));
    	whiteImage = new ImageIcon(whiteImage.getImage().getScaledInstance(newSize, newSize, Image.SCALE_SMOOTH));
    }
    
    // This reads the first line of the resize.txt file, where a person will put in a number to resize the image matrix 
    public static String readFile() {
    	try (BufferedReader reader = new BufferedReader(new InputStreamReader(gameOfLife.class.getResourceAsStream("/resize.txt")))) {
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return "";
    }
    
    // This converts the inputed line by the user into an int used for resizing the image matrix
    public static void convertLineToInt(String sizeInFile) {
    	try {
    	    int number = Integer.parseInt(sizeInFile);
    	    if(number == imageSize) {
    	    	return;
    	    }
    	    else {
    	    	imageSize = number;
    	    	resizeImage(number);
    	    	editImageGrid();
    	    }
    	} catch (NumberFormatException e) {
    	}
    }
    
    // This puts everything together to show conway's game of life
	public static void main(String[] args) {
		createFrame();
		GraphicsConfiguration gc = frame.getGraphicsConfiguration();
        Rectangle bounds = gc.getBounds();
        resizeImage(newImageDimentions(bounds.width, bounds.height));
        createImageGrid();
        convertLineToInt(readFile());
		createRandomStartGrid();
		printGrid();
		delay(400);
		// In theory the display goes on forever and is self sustaining
		while(true) {
			// Checks to see if someone edited the resize.txt file
			convertLineToInt(readFile());
			// These loops determine if a cell is dead or alive given it's current state and how many alive neighbours it has
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
			// Checks to see if there will be any infinitly recurring patterns, if so add a random 4x4 matrix to stimulate new patterns
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
	// The images of dead and alive cells used
	static ImageIcon blueImage = new ImageIcon(gameOfLife.class.getResource("/BlueCellNew.png"));
	static ImageIcon whiteImage = new ImageIcon(gameOfLife.class.getResource("/WhiteCellNew.png"));
}
