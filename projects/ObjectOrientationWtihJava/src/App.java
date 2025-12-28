import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Welcome to the Employee Management System.");
        var scanner = new Scanner(System.in);
        Manager manager = new Manager();
        Engineer engineer = new Engineer();
        do {
            System.out.println("Choose an option:");
            System.out.println("1- Register an Employee");
            System.out.println("2- View Employees");
            System.out.println("3- Exit");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Enter name of the employee: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter CPF of the employee: ");
                    String cpf = scanner.nextLine();
                    System.out.println("Enter code of the employee: ");
                    int code = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter department's name of the employee: ");
                    String department = scanner.nextLine();
                    System.out.println("Enter salary of the employee: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Which employee would you like to register?");
                    System.out.println("1- Enginner");
                    System.out.println("2- Manager");
                    System.out.println("3- To give up");
                    System.out.print("Option: ");
                    int empType = scanner.nextInt();
                    switch (empType) {
                        case 1:
                            scanner.nextLine();
                            System.out.println("Enter level of the Engineer: ");
                            String level = scanner.nextLine();
                            System.out.println("Enter CREA of the Engineer: ");
                            String crea = scanner.nextLine();
                            engineer.setData(name, cpf, code, salary, department);
                            engineer.setEngineer(level, crea);
                            System.out.println("Engineer registered successfully!");
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("Enter car's name destined to the manager");
                            String companyCar = scanner.nextLine();
                            manager.setData(name, cpf, code, salary, department);
                            manager.setManager(companyCar);
                            break;
                        case 3:
                            System.out.println("Operation cancelled.");
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Employee Data:");
                    System.out.println("Manager: ");
                    manager.getManagerData();
                    System.out.println("====================");
                    System.out.println("Engineer: ");
                    engineer.getEngineerData();
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (true);
    }
}
