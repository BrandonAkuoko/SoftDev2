import java.util.Scanner;
public class Hello {
    public static void helloYou(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        scanner.close();

    }
    public static void main(String[] args) {
        helloYou();
    }
    /*
    Standard input and output
    word = input("Enter..")
    print(word)
    // */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in); // read data from input source

    //     System.out.print("Enter ...:");
    //     int number = scanner.nextInt();
    //     System.out.println(number + 1 );

    //     // String word = scanner.next(); // prompt the user to enter data. next only does one word

    //     // System.out.println(word);
    //     // word = scanner.next(); // prompt the user to enter data. next only does one word

    //     // System.out.println(word);

    //     scanner.close();

    
        
    // }
    
}
