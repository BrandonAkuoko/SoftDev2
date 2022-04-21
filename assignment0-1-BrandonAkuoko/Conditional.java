public class Conditional {
    public static void evenlyDivisible(int x){
        if (x%2 == 0){
            System.out.println("Even");

        }
        else if (x%3 == 0){
            System.out.println("divisible by 3");
        }
        else if(x%5 == 0){
            System.out.println("divisible by 5");
        }
        else{
            System.out.println("odd but not divisble by 3 or 5")
        }
    }
    public static void main(String[] args) {
        
    }
    
}
