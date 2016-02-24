import java.util.*;
import java.io.*;

public class Bronze {

    public static int solve() {
		int[][]lake;
		try {
		    Scanner s = new Scanner(new File("makelake.in.txt"));
		    int rows = s.nextInt();
		    int cols = s.nextInt();
		    lake = new int[rows][cols];
		    int waterElevation = s.nextInt();
		    int numberStomps = s.nextInt();
		    s.nextLine();
		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
				    lake[i][j] = s.nextInt();
				}
		    }

		    for (int i = 0; i < numberStomps; i++) {
		        int r = s.nextInt()-1;
				int c = s.nextInt()-1;
				int d = s.nextInt();
			    lake[r][c] -= d;
				for (int j = r; j <  r+3; j++) {
				    for (int k = c; k < c+3; k++) {
						if (lake[j][k] > lake[r][c]) {
						    lake[j][k] = lake[r][c];
						}
				    }
				}
		    }

		    for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
				    if (lake[i][j] < waterElevation) {
						lake[i][j] = waterElevation - lake[i][j];
				    }
				    else {
						lake[i][j] = 0;
				    }
				}
		    }

		    int sum = arraySum(lake);
		    return sum*72*72;
		}
		catch (FileNotFoundException e) {
		    System.out.println(e);
		}
		
		return 0;
    }


    public static int arraySum(int[][]a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
		    for (int j = 0; j < a[i].length; j++) {
			sum += a[i][j];
		    }
		}
		return sum;
    }

    public static void main(String[]args) {
		System.out.println(solve());
    }
    
}