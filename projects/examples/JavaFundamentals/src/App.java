import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Don't use the class date, because is deprecated currently
        int currentYear = OffsetDateTime.now().getYear();
        System.out.println("Hello, World!");
        var scanner = new Scanner(System.in);        
        // Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your name: ");
        var name = scanner.nextLine();
        System.out.printf("Welcome, " + name + "!");
        //  Repeat Structure do - while
        do {
            System.out.printf("When is you born (YYYY): ");
            var year = scanner.nextInt();
            // Logic Operation Arithmetic
            var age = currentYear - year;
            // Conditional Structure
            if (age < 0 || age > 120) {
                System.out.println("Invalid year, please try again.");
            } else {
                System.out.printf("You are " + age + " years old.");
                // Using Person class
                final var person = new Person();
                person.setPerson(name, age);
                System.out.printf("Person Data: \n" + person.getData());
                break;
            }
        } while (true);
        scanner.close();
    }
}
