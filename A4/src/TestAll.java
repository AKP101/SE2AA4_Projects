/**
 * Author: From A3 Specification
 * Revised: date
 * 
 * Description: 
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

public class TestAll{
	BoardT b1;
	BoardT b2;
	BoardT b3;
	BoardT b4;
	int[][] testBoard = new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	int[][] testBoard2 = new int[][]{{0,0,5,0},{6,6,0,0},{0,2,0,6},{1,0,0,2}};
	int[][] testBoard3 = new int[][]{{5,0,0,0},{12,0,0,0},{2,6,0,0},{1,2,0,0}};
	int[][] testBoard4 = new int[][]{{5,0,0,0},{12,3,3,3},{2,6,0,6},{1,2,3,4}};
	int[][] testBoard5 = new int[][]{{0,0,0,5},{0,12,3,6},{0,0,2,12},{1,2,3,4}};
	int[][] testBoard6 = new int[][]{{5,0,0,0},{12,0,3,0},{0,6,3,6},{1,2,3,4}};
	int[][] testBoard7 = new int[][]{{5,6,6,6},{12,2,3,4},{1,0,0,0},{0,0,0,0}};
	int[][] testBoard8 = new int[][]{{5,0,0,1},{12,3,3,0},{2,2,3,0},{1,2,3,0}};
	int[][] testBoard9 = new int[][]{{5,0,0,0},{12,0,0,0},{2,3,3,0},{1,4,6,1}};
	int[][] testBoard10 = new int[][]{{5809,0,0,0},{12,0,0,0},{2,3,3,0},{1,4,6,1}};
	int[][] testBoard11 = new int[][]{{0,0,0,0},{12,0,0,0},{2,3,2048,0},{1,4,6,1}};
	int[][] testBoard12 = new int[][]{{1,2,3,4},{12,5,6,7},{8,9,20,10},{11,14,16,21}};
	@Before
	public void setUp() {
		b1 = new BoardT();
		b2 = new BoardT();
		b3 = new BoardT();
		b4 = new BoardT();
	}

	@After
	public void tearDown() {
		b1 = null;
		b2 = null;
		b3 = null;
		b4 = null;
	}

	@Test
	public void test_getScore1() {
		assertEquals(b1.getScore(), 0);
	}

	@Test
	public void test_getAndUpdateScore() {
		b1.updateScore(10);
		assertEquals(b1.getScore(), 10);
	}

	@Test
	public void test_randTile() {
		//2 randtiles are added to the matrix
		int result = 0;
		int[][] compare = b1.getBoard();
		for (int i = 0; i< testBoard.length; i++){
			for (int j = 0; j <testBoard.length; j++){
				if (compare[i][j] != testBoard[i][j]){
					result++;
				}
			}
		}
		assertEquals(result, 2);
	}

	@Test
	public void test_randTileVal() {
		//2 randtiles are added to the matrix
		// check the values are either 2 or 4
		int result = 0;
		int[][] compare = b1.getBoard();
		for (int i = 0; i < testBoard.length; i++){
			for (int j = 0; j <testBoard.length; j++){
				if (compare[i][j] != testBoard[i][j]){
					if (compare[i][j] == 2 || compare[i][j] ==4){
						result++;
					}
				}
			}
		}
		assertEquals(result, 2);
	}

	@Test
	public void test_SlideLeft(){
		boolean compare = true;
		b2.changeBoard(testBoard2);
		b2.slide(DirectionT.left);
		int[][] tester = b2.getBoard();
		for (int i = 0; i < testBoard2.length; i++){
			for (int j = 0; j <testBoard2.length; j++){
				if (tester[i][j] != testBoard3[i][j]){
					compare = false;
				}
			}
		}
		assertTrue(compare);
	}

	@Test
	public void test_SlideRight(){
		boolean compare = true;
		b3.changeBoard(testBoard4);
		b3.slide(DirectionT.right);
		int[][] tester = b3.getBoard();
		for (int i = 0; i < testBoard4.length; i++){
			for (int j = 0; j <testBoard4.length; j++){
				if (tester[i][j] != testBoard5[i][j]){
					compare = false;
				}
			}
		}
		assertTrue(compare);
	}


	@Test
	public void test_SlideUp(){
		boolean compare = true;
		b4.changeBoard(testBoard6);
		b4.slide(DirectionT.up);
		int[][] tester = b4.getBoard();
		for (int i = 0; i < testBoard6.length; i++){
			for (int j = 0; j <testBoard6.length; j++){
				if (tester[i][j] != testBoard7[i][j]){
					compare = false;
				}
			}
		}
		assertTrue(compare);
	}

	@Test
	public void test_SlideDown(){
		boolean compare = true;
		b2.changeBoard(testBoard8);
		b2.slide(DirectionT.down);
		int[][] tester = b2.getBoard();
		for (int i = 0; i < testBoard8.length; i++){
			for (int j = 0; j <testBoard8.length; j++){
				if (tester[i][j] != testBoard9[i][j]){
					compare = false;
				}
			}
		}
		assertTrue(compare);
	}

	@Test
	public void test_gameWon(){
		b1.changeBoard(testBoard10);
		assertTrue(b1.gameWon());
	}

	@Test
	public void test_gameWon2(){
		b1.changeBoard(testBoard11);
		assertTrue(b1.gameWon());
	}
	
	@Test
	public void test_gameLost(){
		b1.changeBoard(testBoard12);
		assertTrue(b1.gameLost());
	}
}
