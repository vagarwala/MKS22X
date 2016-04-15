import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
        private int xcor;
        private int ycor;
        private Node previous;
        public Node(int x, int y, Node p){
            setXcor(x);
            setYcor(y);
            setPrevious(p);
        }
        public Node(){
            this(0,0, null);
        }
        public int getXcor(){
            return xcor;
        }
        public int getYcor(){
            return ycor;
        }
        public Node getPrevious(){
            return previous;
        }
        public void setXcor(int x){
            xcor=x;
        }
        public void setYcor(int y){
            ycor=y;
        }
        public void setPrevious(Node p){
            previous = p;
        }
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        return solution;
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo=new FrontierQueue<Node>();
        return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo=new FrontierStack<Node>();
        return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/

    public void markSolution(){
        for(int i = 0;i+1<solution.length;i+=2){ // since the solution is a bunch of coords
            maze[solution[i+1]][solution[i]]='X';
        }
    }

    private int[] path(Node n){
        Stack<Integer> solution =new Stack<Integer>();
        while(n.getPrevious()!=null){
            solution.push(n.getXcor());
            solution.push(n.getYcor());
            n=n.getPrevious();
        }
        
        int[] result = new int[solution.size()];
        int i = 0;
        while(solution.size()>0){
            result[i] = solution.pop();
            i++;
        }
        return result;

    } 

    public boolean solve(){  
        placesToGo.add(new Node(startRow,startCol,null));
        Node current;
        while(placesToGo.hasNext()){
            current=placesToGo.next();
            maze[current.getXcor()][current.getYcor()]='.';

            if(maze[current.getXcor()-1][current.getYcor()]=='E'){
                solution=path(new Node(current.getXcor()-1,current.getYcor(),current));
                markSolution();
                return true;
            }
            if(maze[current.getXcor()+1][current.getYcor()]=='E'){
                solution=path(new Node(current.getXcor()+1,current.getYcor(),current));
                markSolution();
                return true;
            }
            if(maze[current.getXcor()][current.getYcor()-1]=='E'){
                solution=path(new Node(current.getXcor(),current.getYcor()-1,current));
                markSolution();
                return true;
            }
            if(maze[current.getXcor()][current.getYcor()+1]=='E'){
                solution=path(new Node(current.getXcor(),current.getYcor()+1,current));
                markSolution();
                return true;
            }


            if(maze[current.getXcor()-1][current.getYcor()]==' '){
                placesToGo.add(new Node(current.getXcor()-1,current.getYcor(),current));
            }
            if(maze[current.getXcor()+1][current.getYcor()]==' '){
                placesToGo.add(new Node(current.getXcor()+1,current.getYcor(),current));
            }
            if(maze[current.getXcor()][current.getYcor()-1]==' '){
                placesToGo.add(new Node(current.getXcor(),current.getYcor()-1,current));
            }
            if(maze[current.getXcor()][current.getYcor()+1]==' '){
                placesToGo.add(new Node(current.getXcor(),current.getYcor()+1,current));
            }
            wait(100);
            if(animate){
                System.out.println(this);
            }
        }
        return false;
    }
   
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){
        animate = b;
    }    


    public BetterMaze(String filename){
    	animate = false;
    	int maxc = 0;
    	int maxr = 0;
    	startRow = -1;
    	startCol = -1;
    	//read the whole maze into a single string first
    	String ans = "";
    	try{
    	    Scanner in = new Scanner(new File(filename));
    	    //keep reading next line
    	    while(in.hasNext()){
        		String line = in.nextLine();
        		if(maxr == 0){
        		    //calculate width of the maze
        		    maxc = line.length();
        		}
        		//every new line add 1 to the height of the maze
        		maxr++;
        		ans += line;
    	    }
    	}
    	catch(Exception e){
    	    System.out.println("File: " + filename + " could not be opened.");
    	    e.printStackTrace();
    	    System.exit(0);
    	}
    	System.out.println(maxr+" "+maxc);
    	maze = new char[maxr][maxc];
    	for(int i = 0; i < ans.length(); i++){
    	    char c = ans.charAt(i);
    	    maze[i / maxc][i % maxc] = c;
    	    if(c == 'S'){
        		startCol = i % maxc;
        		startRow = i / maxc;
    	    }
    	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}
