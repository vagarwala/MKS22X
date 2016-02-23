public class KnightBoard{
    private int[][] board;
    private boolean solved;


    public KnightBoard(){
        this(8);
    }

    public KnightBoard(int n){
        this(n,n);
    }

    public KnightBoard(int row, int col){
        board = new int[row][col];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = -1;
            }
        }
    }

    public boolean solve(){
        solved = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(solveHelper(i,j,0)){
                    solved = true;
                }
            }
        }
        return solved;
    }
    
    public boolean solveHelper(int row, int col, int movei){
        if(movei == ((board.length * board[0].length) -1 )){
            if(placeKnight(row,col,movei)){
                return true;
            }
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }else{
            
            if(placeKnight(row,col,movei)){
                if (solveHelper(row + 2,col+1,movei+1) ||
                    solveHelper(row + 2,col-1,movei+1) ||
                    solveHelper(row - 2,col+1,movei+1) ||
                    solveHelper(row - 2,col-1,movei+1) ||
                    solveHelper(row + 1,col+2,movei+1) ||
                    solveHelper(row + 1,col-2,movei+1) ||
                    solveHelper(row - 1,col+2,movei+1) ||
                    solveHelper(row - 1,col-2,movei+1)){
                    return true;
                } else{
                    board[row][col] = -1; 
                }
            }
        }
        return false;
    }

    public void printSolution(){
        if(!solved){
            System.out.println("No Solution");
        } else{
            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[0].length;j++){
                    System.out.print(String.format("%02d", board[i][j]) +" ");
                }
                System.out.println();
            }
        }
    }

    public boolean placeKnight(int row, int col, int movei){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        if(board[row][col]!= -1){
            return false;
        }else{
            board[row][col] = movei;
            return true;
        }
    }
    
    public static void main(String[] args){
        KnightBoard i;
        if (args.length == 1){
            i = new KnightBoard(Integer.parseInt(args[0]));
        } else{
            i = new KnightBoard(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        }
        i.solve();
        i.printSolution();
    }
}