package hw2;

import static org.junit.Assert.*;
import org.junit.Test;
import api.Direction;
import api.Move;
import api.TilePosition;

/**
 * @author BORIS NDOUTOUME
 * @author Gabe Stackhouse
 * @author Steve Kautz
 */
public class Hw2Tests {

	@Test
	// findNextNonemptyCell
	public void findNextNonemptyCell() {
		int[] arr = { 0, 2, 1, 34, 6 };
		// Should return 1 as that's the index of the first nonempty cell
		assertEquals(1, GameUtil.findNextNonemptyCell(arr, 0));
	}

	@Test
	 // findNextNonemptyCell
	 public void findNextNonemptyCell1() {
		 int[] arr2 = { 0, 0, 0, 0 };
		 // Should return -1 because all cells are empty
		 assertEquals(-1, GameUtil.findNextNonemptyCell(arr2, 0));
	}

	@Test
	 // findNextNonemptyCell
	 public void findNextNonemptyCell2() {
		 int[] arr3 = { 1, 0, 0, 0 };
		 // Should return 0 as that's the index of the first nonempty cell
		 assertEquals(0, GameUtil.findNextNonemptyCell(arr3, 0));
	}

	@Test
	 // findNextMove when non null elements are separated by a zero
	 public void findNextMove() {
		int[] arr = {2, 0, 2, 4, 0, 4};
		 //When move at index 0 is applied, oldIndex = 0; oldIndex2 = 2; newIndex = 0; value = 2;
		 assertEquals(new Move(0, 2, 0, 2), GameUtil.findNextMove(arr, 0));
	}

	@Test
	 // findNextMove when non null elements are separated by a zero
	public void findNextMove1() {
		int[] arr = { 0, 1, 1, 0 };
		//When move at index 0 is applied, oldIndex = 1; oldIndex2 = 2; newIndex = 0; value = 1;
		 assertEquals(new Move(1, 2, 0, 1), GameUtil.findNextMove(arr, 0));
	}

	@Test
	// Tests findNextMove when a merge doesn't take place
	public void findNextMove2() {
		int[] arr = { 0, 1, 2, 0 };
		// When move at index 0 is applied, oldIndex = 1; newIndex = 0; value = 1;
		assertEquals(new Move(1, 0, 1), GameUtil.findNextMove(arr, 0));
	}
	
	@Test
	//Tests findNextMove at a different index
	public void findNextMove3() {
		int[] arr = {2, 2, 0, 4};
		// When move at index 2 is applied, oldIndex = 3; newIndex = 2; value = 4;
		assertEquals(new Move(3, 2, 4), GameUtil.findNextMove(arr, 2));
	}

	@Test
	 // ex'
	 public void ApplyOneMove() {
		int[] arr = {2, 0, 2, 4, 0, 4};
		int[] expected = {4, 0, 0, 4, 0, 4};
		Move move = new Move(0, 2, 0, 2);
		GameUtil.applyOneMove(arr, move);
		assertArrayEquals(expected, arr);// (expected, arr);
	}
	
	@Test
	// Test for collapseArray as provided in the documentation
	 public void collapseArray() {
		 int[] arr = {2, 2, 4 };
		 int[] expected = {4, 4, 0 };
		 GameUtil.collapseArray(arr);
		 assertArrayEquals(expected, arr);
	 }
	
	@Test
	// Tests if collapseArray can handle null move values
	public void collapseArray1() {
		int[] arr = {2, 0, 2, 4, 0, 4};
		int[] expected = {4, 8, 0, 0, 0, 0};
		GameUtil.collapseArray(arr);
		assertArrayEquals(expected, arr);
	}
	
	
	@Test
	// Tests collapseArray when all cells are empty
	public void collapseArray2() {
		int[] arr = {0, 0, 0};
		int[] expected = {0, 0, 0};
		GameUtil.collapseArray(arr);
		assertArrayEquals(expected, arr);
	}
	
	@Test
	//Tests collapseArray when no moves are available
	public void collapseArray3() {
		int[] arr = {2, 4, 6, 8};
		int[] expected = {2, 4, 6, 8};
		GameUtil.collapseArray(arr);
		assertArrayEquals(expected, arr);
	}
	
	@Test
	//Tests the getSize method
	public void getSizeTest() {
		Game g = new Game(5);
		assertEquals(5, g.getSize());
	}
	
	@Test
	//Tests the setCell and getCell methods
	public void getAndSetCellTest() {
		Game g = new Game(3);
		g.setCell(2, 2, 4);
		assertEquals(4, g.getCell(2, 2));
	}
	
	@Test
	//Generate should not be called if no moves are made
	public void noMovesAvailable() {
		Game g = new Game(3);
		int[][] expected = 
			{
				{4, 2, 0},
				{4, 2, 0},
			    {2, 4, 0}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, expected[r][c]);
			}
		}
		
		g.collapse(Direction.LEFT);
		
		int[][] actual = new int[3][3];
		
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				actual[r][c] = g.getCell(r, c);
			}
		}
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	//Tests if collapsing to the left is working correctly
	public void collapseLeft() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 2, 4},
			    {2, 0, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[][] expected = 
			{
				{4, 4, 0},
				{4, 2, 4},
				{2, 4, 0}
			};
		g.collapse(Direction.LEFT);
		
		checkGrid(expected, g);	
	}
	
	@Test
	//Tests if collapsing to the right is working correctly
	public void collapseRight() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 2, 4},
			    {2, 0, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[][] expected = 
			{
				{0, 4, 4},
				{4, 2, 4},
				{0, 2, 4}
			};
		g.collapse(Direction.RIGHT);
		
		checkGrid(expected, g);
		
	}
	
	@Test
	//Tests if collapsing to the right is working correctly
	public void collapseUp() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 4},
			    {2, 4, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[][] expected = 
			{
				{2, 2, 8},
				{4, 4, 4},
				{2, 0, 0}
			};
		g.collapse(Direction.UP);
		
		checkGrid(expected, g);	
	}
	
	@Test
	//Tests if collapsing to the right is working correctly
	public void collapseDown() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 4},
			    {2, 4, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[][] expected = 
			{
				{2, 0, 0},
				{4, 2, 4},
				{2, 4, 8}
			};
		g.collapse(Direction.DOWN);
		
		checkGrid(expected, g);
		
	}
	
	@Test
	//Tests copyRowOrColumn to Direction LEFT
	public void copyLeft() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] expected = {4, 0, 2};
		assertArrayEquals(expected, g.copyRowOrColumn(1, Direction.LEFT));
	}
	
	@Test
	//Tests copyRowOrColumn to Direction RIGHT
	public void copyRight() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 4}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] expected = {2, 0, 4};
		assertArrayEquals(expected, g.copyRowOrColumn(1, Direction.RIGHT));
	}
	
	@Test
	//Tests copyRowOrColumn to Direction UP
	public void copyUp() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] expected = {4, 2, 8};
		assertArrayEquals(expected, g.copyRowOrColumn(2, Direction.UP));
	}
	
	@Test
	//Tests copyRowOrColumn to Direction DOWN
	public void copyDown() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] expected = {8, 2, 4};
		assertArrayEquals(expected, g.copyRowOrColumn(2, Direction.DOWN));
	}
	
	@Test
	//Tests updateRowOrColumn to Direction LEFT
	public void updateLeft() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] copyArray = {4, 16, 2};
		g.updateRowOrColumn(copyArray, 2, Direction.LEFT);
		
		//Check grid
		int[] actual = new int[3];
		for (int c = 0; c < 3; c += 1) {
			actual[c] = g.getCell(2, c);
		}
		assertArrayEquals(copyArray, actual);
	}
	
	@Test
	//Tests updateRowOrColumn to Direction RIGHT
	public void updateRight() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] copyArray = {4, 16, 2};
		int[] expected = {2, 16, 4};
		g.updateRowOrColumn(copyArray, 2, Direction.RIGHT);
		
		//Check grid
		int[] actual = new int[3];
		for (int c = 0; c < 3; c += 1) {
			actual[c] = g.getCell(2, c);
		}
		assertArrayEquals(expected, actual);
	}
	
	@Test
	//Tests updateRowOrColumn to Direction UP
	public void updateUp() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] copyArray = {4, 16, 2};
		g.updateRowOrColumn(copyArray, 1, Direction.UP);
		
		//Check grid
		int[] actual = new int[3];
		for (int r = 0; r < 3; r += 1) {
			actual[r] = g.getCell(r, 1);
		}
		assertArrayEquals(copyArray, actual);
	}
	
	@Test
	//Tests updateRowOrColumn to Direction DOWN
	public void updateDown() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[] copyArray = {4, 16, 2};
		int[] expected = {2, 16, 4};
		g.updateRowOrColumn(copyArray, 0, Direction.DOWN);
		
		//Check grid
		int[] actual = new int[3];
		for (int r = 0; r < 3; r += 1) {
			actual[r] = g.getCell(r, 0);
		}
		assertArrayEquals(expected, actual);
	}
	
	@Test
	//Tests if generate() returns a TilePosition at an empty cell on the grid
	public void generateTest() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 8, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		TilePosition actual = g.generate();
		
		if (actual.getRow() != 1) {
			fail("TilePosition is not in an empty cell location");
		}
		else if (actual.getCol() != 1) {
			fail("TilePosition is not in an empty cell location");
		}
		else if (actual.getValue() != 2 && actual.getValue() != 4) {
			fail("TilePosition does not have a value of 2 or 4");
		}
	}
	
	@Test
	// Tests if generate() modifies the grid (it should not)
	public void generateGridTest() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 8, 4},
				{4, 0, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		int[][] actual = new int[3][3];
		
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				actual[r][c] = g.getCell(r, c);
			}
		}
		String msg = "The generate() method should not modify the grid";
		assertArrayEquals(msg, sampleGrid, actual);
	}
	
	@Test
	//Tests if generate() returns null if the grid has no empty cells
	public void generateNoEmptyCells() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 8, 4},
				{4, 8, 2},
			    {2, 4, 8}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		TilePosition actual = g.generate();
		assertEquals(null, actual);
	}
	
	@Test
	//Tests if the score is being kept correctly and the getScore() method is functional
	public void scoreTest() {
		Game g = new Game(3);
		int[][] sampleGrid = 
			{
				{2, 2, 4},
				{4, 0, 2},
			    {2, 0, 2}
			};				  
		for (int c = 0; c < 3; c += 1) {
			for (int r = 0; r < 3; r += 1) {
				g.setCell(r, c, sampleGrid[r][c]);
			}
		}
		
		g.collapse(Direction.LEFT);
		assertEquals(8, g.getScore());
	}
	
	 /**
	  * Helper method to check that the game's grid matches the given "after" grid
	  * with exactly one additional tile in one of the "after" grid's empty cells.
	  * @param originalMsg
	  * @param after
	  * @param g
	  */
	  private void checkGrid(int[][] after, Game g)
	  {
	    // count the number of additional tiles
	    int added = 0;
	    
	    for (int row = 0; row < after.length; ++row)
	    {
	      for (int col = 0; col < after[0].length; ++col)
	      {
	        int actual = g.getCell(row, col);
	        if (after[row][col] != 0)
	        {
	          // we're expecting a nonzero value, make sure it's correct
	          if (actual != after[row][col])
	          {
	            String msg = "Incorrect value in (" + row + ", " + col + "): ";
	            assertEquals(msg, after[row][col], actual);
	          }
	        }
	        else
	        {
	          // there's a zero in our "after" grid, but they could have
	          // added a tile there - if so, count it and make sure it's a 2 or 4
	          if (actual != 0)
	          {
	            added += 1;
	            if (actual != 2 && actual != 4)
	            {
	              String msg = "Added tile at (" + row + ", " + col + ") has value " + actual;
	              fail(msg);
	            }
	          }
	        }
	      }
	    }
	    
	    // make sure there is exactly one new tile
	    if (added != 1)
	    {
	      String msg = "Incorrect number of new tiles added to grid. ";
	      assertEquals(msg, 1, added);
	    }
	  }
	
}
