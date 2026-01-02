import java.util.Scanner;

import enumaration.OperationEnum;

public class App {
    public static void main(String[] args) throws Exception {
        var option = -1;
        var scanner = new Scanner(System.in);
        do {
            System.out.println("Select an operation:");
            System.out.println("1. SUM");
            System.out.println("2. SUBTRACT");
            System.out.println("3. MULTIPLY");
            System.out.println("4. DIVIDE");
            System.out.println("5. EXIT");
            System.out.print("Option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1,2,3,4 -> {
                    System.out.print("Insert the first value:");
                    var value1 = scanner.nextInt();
                    System.out.print("Insert the second value:");
                    var value2 = scanner.nextInt();
                    var selectedOperation = OperationEnum.values()[option - 1];
                    var result = selectedOperation.getCalculate().apply(value1, value2);
                    System.out.println("%s %s %s = %s".formatted(value1, selectedOperation.getSymbol(), value2, result));
                    break;
                }

                case 5 -> System.out.println("Exiting the program. Goodbye!");
            
                default -> System.out.println("Invalid option. Please try again.");
            }

        } while (option != 5);
        scanner.close();
    }
}
