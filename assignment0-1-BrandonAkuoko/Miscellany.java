import java.util.Arrays;
public class Miscellany {
    public static boolean palidrone(String aString){
        for(int i = 0; i < aString.length()/2; i++){
            int j = aString.length() - i -1;
            if(aString.charAt(i) != aString.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static int[] squares(int n){
        int[] integer = new int[n];
        for (int i = 0; i < integer.length; i++){
            integer[i] = i * i;
        }
        return integer;
    }
    public static int[][] multiplicationtable(int rows, int columns){
        int [][] table = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                table[i][j] = (i + 1) * (j + 1); 
            }
        }
        return table;
    }
    public static void main(String[] args) {
        int[][] table = multiplicationtable(6, 5);
        for(int k = 0; k < table.length; k++){
            System.out.println(Arrays.toString(table[k]));
        }

    }
}
