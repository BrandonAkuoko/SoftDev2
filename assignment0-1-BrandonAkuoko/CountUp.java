public class CountUp {
    public static int countWhile(int n){
        int count = 0;
        int sum = 0;
        while(count <= n){
            System.out.println(count);
            sum += count;
            count += 1;
        }
        return sum;
    }
    public static int countFor(int n){
        int sum = 0;
        for( int count = 0; count <= n; count += 1){
            System.out.println(count);
            sum += count;
        }
        return sum;
    }
    public static void main(String[] args) {
        int z = countWhile(10);
        int y = countFor(10);
        System.out.println("Sum = " + z);
        System.out.println("Sum = " + y);
    }
}
