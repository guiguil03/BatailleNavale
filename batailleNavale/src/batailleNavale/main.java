package batailleNavale;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
  public static void main(String[] args) {
	  System.out.println("Hello World");
	  System.out.println("Moi c'est Myrah"); 
	  System.out.println(generateGrid(5, 5));
  }
  public static int[][] generateGrid(int i, int j) {
	  int [][] grid;
	  grid = new int[i][j]; 
	  return grid;
	  
  }
}
