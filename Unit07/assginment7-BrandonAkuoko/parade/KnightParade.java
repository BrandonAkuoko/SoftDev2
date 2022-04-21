/**
 * @author Brandon Akuoko
 * 
 */
package parade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import backtracker.Backtracker;
import backtracker.Configuration;

public class KnightParade implements Configuration{
    private final Chessboard board;
    private int row;
    private int col;

    private static final int[] rowd = {-2, -2,  2,  2, -1, -1,  1,  1};
    private static final int[] cold = {-1,  1, -1,  1, -2,  2, -2,  2};
    // private int[][] randc = {-2}



    public KnightParade(Chessboard board, int row, int col){
        this.board = board;
        this.row = row;
        this.col = col;
        // board.makeMove(row, col);
    }



    @Override
    /**
     * creates the 8 possible combinations a Knight can make and moves  to see if it is possible. If so then it is added to the list of successors 
     */
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>(8);
        for(int i = 0; i < 8; i++){
            int nextr = row + rowd[i];
            int nextc = col + cold[i];
            Chessboard deepCopy = new Chessboard(board);
                if(deepCopy.makeMove(nextr, nextc) == true){
                    KnightParade successor = new KnightParade(deepCopy,nextr, nextc);
                    successors.add(successor);
                }
            }
            return successors;
        }        

    @Override
    public boolean isValid() {return true;}

    @Override
    public boolean isGoal() {return board.isFull();}

    @Override
    public String toString() {return board.toString();}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = scanner.nextInt();
        Chessboard board = new Chessboard(N);
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Starting position: ");
        String line = s.nextLine();
        String[] tokens = line.split(" ");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);
        KnightParade knight = new KnightParade(board, r, c);
        // System.out.print(knight);
        board.makeMove(r, c);
        Backtracker bt = new Backtracker(false);
        Configuration solution = bt.solve(knight);
        if(solution == null){
            System.out.println("no solution");
        }
        else{
            System.out.println(solution);
        }
    }
    
}
