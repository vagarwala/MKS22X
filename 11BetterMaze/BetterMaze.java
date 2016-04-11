import java.util.*;
public class BetterMaze{

    private class Node{
        private int xcor;
        private int ycor;
        private MyQueue<Node> path;
        public Node(int x, int y){
            setXcor(x);
            setYcor(y);
            path = new MyQueue<Node>();
        }
        public Node(){
            this(0,0);
        }
        public int getXcor(){
            return xcor;
        }
        public int getYcor(){
            return ycor;
        }
        public void setXcor(int x){
            xcor=x;
        }
        public void setYcor(int y){
            ycor=y;
        }
    }


    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    //private Frontier<???> placesToGo;
    private boolean  animate;

   /**return a copy of solution.
      This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been 
     * called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
      
    //public int[] solutionCoordinates(){ }    

    
}