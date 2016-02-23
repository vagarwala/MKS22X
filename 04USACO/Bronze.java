import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Bronze{
	int[][] lake;

	public Bronze(r, c){
		lake = new int[r][c];
	}

	public String stomp(row, col, deep){
		int i, j, d, highest;
		for (d = 0; d < deep; d++){
			highest = lake[row][col];
			for (i = 0; i < 3; i++)
	            for (j = 0; j < 3; j++)
	                if (lake[row+i][col+j] > highest) highest=lake[row+i][col+j];
	        /* -1 for each of highest */
	        for (i = 0; i < 3; i++)
	            for (j = 0; j < 3; j++)
	                if (lake[row+i][col+j] == highest) --lake[row+i][col+j];
		}
	}

	public int calculateVolume(){
		int sum = 0;
		for(int i = 0;i<array.length;i++){
		    for(int j =0;j<array[i].length;j++){
			if(array[i][j] < depth){
			    sum += (depth - array[i][j]);
			}
		    }
		}
		return sum * 72 * 72;
    }
    
	public static void main(String[] args){
		BufferedReader s = new BufferedReader(new FileReader(new File(args[0])));
		String line;
		int e, n, i, j, rs, cs, ds;

	}
}