import java.util.*;
import java.io.*;

public class Silver{

    private final int MAXN = 101;
    private final int MAXT = 16;

    private int h, w, t, r1, c1, r2, c2;
    private char[][] field = new char[MAXN][MAXN];
    private int[][][] dp = new int[MAXN][MAXN][MAXT];

    public Silver(String filename){
        try{
            Scanner in = new Scanner(new File(filename));
            ArrayList<String> lines = new ArrayList<String>();
            h = in.nextInt();
            w = in.nextInt();
            t = in.nextInt();
            for(int i = 0; i < h; i++){
                String s = in.next();
                for(int j = 0; j < w; j++){
                    field[i][j] = s.charAt(j);
                }
            }
            r1 = in.nextInt();
            c1 = in.nextInt();
            r2 = in.nextInt();
            c2 = in.nextInt();
            --r1; --c1; --r2; --c2;
            dp[r1][c1][0] = 1;
        }catch(FileNotFoundException E){
                System.out.println("The file does not exist");
        }

    }
    public int solve(){
        for(int i = 1; i <= t; i++){
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    dp[y][x][i] = 0;
                    final int dy[] = {0,0,+1,-1};
                    final int dx[] = {+1,-1,0,0};
                    for(int d = 0; d < 4; d++){
                        int y2 = y + dy[d];
                        int x2 = x + dx[d];
                        if(0 <= x2 && x2 < w && 0 <= y2 && y2 < h){
                            if(field[y2][x2] != '*'){
                                dp[y][x][i] += dp[y2][x2][i-1];
                            }
                        }
                    }
                }
            }
        }
        return dp[r2][c2][t];
    }

    public static void main(String[] args){
        String file;
        if (args.length == 0){
            file = "ctravel.in";
        }else{
            file = args[0];
        }
        Silver pasture = new Silver(file);
        System.out.println(pasture.solve() + ",6,Agarwala,Vandana");
    }

}