import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        var scanner = new Scanner(System.in);
        // Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your name: ");
        var name = scanner.nextLine();
        System.out.println("Welcome, " + name + "!");
        //  Repeat Structure do - while
        do {
            System.out.printf("When is you born (YYYY): ");
            var year = scanner.nextInt();
            // Logic Operation Arithmetic
            var age = 2025 - year;
            // Conditional Structure
            if (age < 0 || age > 120) {
                System.out.println("Invalid year, please try again.");
            } else {
                System.out.println("You are " + age + " years old.");
                break;
            }
        } while (true);
    }
}
