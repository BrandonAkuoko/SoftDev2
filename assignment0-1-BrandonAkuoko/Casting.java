public class Casting{
    public static void main(String[] args) {
        long x = 15; // 15 --> 15.0F
        int y = (int)3000000000L; // 1 - negative 0 - postive 
        int w = 'A';
        char p = 67; // 'A' = 65, 'B' = 66 and 'C' = 67

        System.out.println(w);
        System.out.println(y);
        System.out.println(x);
        System.out.println(p);
        System.out.println(y);
    }
}