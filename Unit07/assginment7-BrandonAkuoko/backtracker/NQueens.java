package backtracker;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import backtracker.Backtracker;
import backtracker.Configuration;
public class NQueens implements Configuration {
    private final int n;
    private final Queen[] queens;

    public NQueens(int n){
        this.n = n;
        this.queens = new Queen[0];
    }

    public NQueens(int n, Queen[] queens){
        this.n = n;
        this.queens = queens;
    }


    @Override
    public Collection<Configuration> getSuccessors() {
        List<Configuration> successors = new ArrayList<>(n);
        int row = queens.length;
        if(row<n){
            for(int i = 0; i<n;i++){
                Queen next = new Queen(row,i);
                Queen[] deepCopy = Arrays.copyOf(queens,queens.length+1);
                deepCopy[queens.length] = next;
                NQueens successor = new NQueens(n, deepCopy);
                successors.add(successor);    
            }
        }
    
        return successors;
    }

    @Override
    public boolean isValid() {

        for(int i = 0; i<queens.length-1; i++){
            if(queens[i].canAttack(queens[queens.length-1])){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        return isValid() && queens.length==n;
    }

    @Override
    public String toString(){
        String[][] board = new String[n][n];
        for(int row = 0; row<n; row++){
            for(int col = 0; col<n;col++){
                board[row][col] = "[]";

            }
        }
        for(Queen queen : queens){
            board[queen.getRow()][queen.getCol()]="[Q]";

        }
        StringBuilder builder = new StringBuilder();
        for(String[] row : board){
            for(String square : row){
                builder.append(square);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // NQueens nqueens = new NQueens(4);
        // System.out.println(nqueens);
        // System.out.println(nqueens.isValid());
        // System.out.println(nqueens.isGoal());
        // System.out.println(nqueens.getSuccessors());
        Backtracker backtracker = new Backtracker(false);
        NQueens nQueens = new NQueens(5);
        Configuration solution = backtracker.solve(nQueens);
        if(solution == null){
            System.out.println("no solution");
        }else{
            System.out.println(solution);
        }
    }
    
}