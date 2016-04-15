import java.util.*;
public class Driver{
    public static void main(String[]args){
	BetterMaze m = new BetterMaze("data2.dat");
	m.setAnimate(true);
	if(args.length>0){
	    System.out.println(m1.solveBFS());
	}else{
	    System.out.println(m1.solveDFS());
	}
	System.out.println(Arrays.toString(m.solutionCoordinates()));
	System.out.println(m);
    }
}