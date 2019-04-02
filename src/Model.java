import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Model {
	Model() {}
	
	int[][] getValsFromFile(String path) {
		Scanner sc;
		int j = 0;
		int[][] res = new int[10][10];
		try {
			sc = new Scanner(new File(path));
			while (sc.hasNext()) {
				String[] tmp = sc.nextLine().split(" ");
				int[] t = new int[10];
				
				for (int i = 0; i < tmp.length; i++) 
					t[i] = Integer.parseInt(tmp[i]);
				
				res[j++] = t; 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	int[][] getNextGen(int[][] vals) {
		int[][] res = new int[10][10];
		for (int i = 0; i < vals.length; i++) {
			for (int j = 0; j < vals.length; j++) {
				int val = vals[i][j];
				int count = countNeighbor(vals,i,j);
				if (val == 1)
					if (count == 2 || count == 3)
						res[i][j] = 1;
					else 
						res[i][j] = 0;
				else {
					if (count == 3)
						res[i][j] = 1;
					else
						res[i][j] = 0;
				}
			}
		}
		
		return res;
	}
	
	int countNeighbor(int[][] vals, int i, int j) {
		int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
		int count = 0;
		
		for (int k = 0; k < y.length; k++) {
			try {
				int newX = i + x[k];
				int newY = j + y[k];
				if (vals[newX][newY] == 1)
					count++;
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
			}
		}
		return count;
	
	}
}
