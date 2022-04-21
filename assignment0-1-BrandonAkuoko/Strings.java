public class Strings {
    public static void main(String[] args) {
        double result = Math.pow(2,3); // public static double pow

        String aString = "Hello World";
        char first = aString.charAt(0); //  the first character in the world
        char second = aString.charAt(1);
        int len = aString.length(); // non static  (public int length)
        char last = aString.charAt(len-1);

        System.out.println(""+first+second+last);
        
    }
    
}
