/**
 * @author Brandon Akuoko
 * Assignment 6.3
 */
package knights;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import graphs.AdjacencyGraph;
import graphs.Graph;

public class KnightMoves {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a size for board > ");
        String line = scanner.nextLine();
        String[] rc = line.split(" ");
        int rows = Integer.parseInt(rc[0]);
        int cols = Integer.parseInt(rc[1]);
        while(rows < 3 && cols < 3){
            System.out.println("Board cannot be less than 3. Please try again.");
            scanner.nextLine();
            System.out.print("Please enter a size for board > ");
            try{
                rows = scanner.nextInt();
                cols = scanner.nextInt();
            }
            catch(NumberFormatException n){
                System.out.println("You cannot enter a letter");
            }
            
        }
        Graph<Square> chess = makeBoard(rows, cols);
        Square[] squares = makeSquares(rows, cols);
        boolean Quit = false;
        Scanner move = new Scanner(System.in);
        while(Quit == false){
            System.out.print("Enter the start and end coordinates: ");
            String coords = move.nextLine();
            if(coords.equals("quit")){
                System.out.print("Goodbye");
                Quit = true;
            }
            else{
                try{
                    String[] tokens = coords.split(" ");
                    // System.out.println(tokens[0]);
                    // System.out.println(tokens[1]);
                    // System.out.println(tokens[2]);
                    // System.out.println(tokens[3]);
                    // System.out.println(tokens[4]);
                    // System.out.println(tokens[5]);
                    Square start = new Square(tokens[0], tokens[1]);
                    Square end =  new Square(tokens[2], tokens[3]);
                    makeConnections(start, chess, squares);
                    List<Square> dfPath = chess.dfPath(start, end);
                    //makeConnections(start, end, chess);
                    List<Square> bfPath = chess.bfPath(start, end);
                    // makeConnections(start, chess, squares);
                    System.out.println("DFS: "  + dfPath);
                    System.out.println("BFS: " + bfPath);
                }
                catch(NumberFormatException n){
                    System.out.println("You cannot enter a letter");
                    Quit = false;
                }
            }
        }
    }
    /**
     * This function creates the chessboard and adds empty squares to it
     * @param rows
     * @param cols
     * @return
     */
    public static Graph<Square> makeBoard(int rows, int cols){
        Graph<Square> chessboard = new AdjacencyGraph<>();
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                Square square = new Square(r, c);
                chessboard.add(square);
            }
        }
        return chessboard;
    }
    /**
     * This function creates squares and replaces the old empty ones with new filled ones
     * @param r
     * @param c
     * @return
     */
    public static Square[] makeSquares(int r, int c){
        Square[] squares = new Square[r * c];
        int temp = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < r; j++){
                Square newSquares = new Square(i, j);
                squares[temp] = newSquares;
                temp++;
            }
        }
        return squares;
    }
    /**
     * This function checks the scenarios for each way the piece can move and creates new connections if the chess board contains them
     * @param start
     * @param chess
     * @param squares
     */
    public static void makeConnections(Square start, Graph<Square> chess, Square[] squares){
        // System.out.println(start);
        Square[] temp = new Square[8];
        for(Square square : squares){
            start = square;
            // System.out.println(start);
            // all scenarios of outputs
            temp[0] = new Square(start.getR() - 1, start.getC() - 2);
            temp[1] = new Square(start.getR() + 1, start.getC() - 2);
            temp[2] = new Square(start.getR() - 1, start.getC() + 2);
            temp[3] = new Square(start.getR() + 1, start.getC() + 2);
            temp[4] = new Square(start.getR() - 2, start.getC() - 1);
            temp[5] = new Square(start.getR() - 2, start.getC() + 1);
            temp[6] = new Square(start.getR() + 2, start.getC() - 1);
            temp[7] = new Square(start.getR() + 2, start.getC() + 1);

            for(Square t : temp){
                if(chess.contains(t)){
                    chess.connectUndirected(start, t);
                }
            }
        }
    }
}