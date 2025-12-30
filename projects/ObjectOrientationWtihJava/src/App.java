import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Welcome to the Employee Management System.");
        var scanner = new Scanner(System.in);

        // Create a list to salve multiple employees
        List<Employee> employees = new ArrayList<>();

        do {
            System.out.println("Choose an option:");
            System.out.println("1- Register an Employee");
            System.out.println("2- View Employees");
            System.out.println("3- Calculate Deductions");
            System.out.println("4- Search an employee");
            System.out.println("5- Exit");
            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    System.out.println("Which employee would you like to register?");
                    System.out.println("1- Engineer");
                    System.out.println("2- Manager");
                    System.out.println("3- To give up");
                    System.out.print("Option: ");
                    int empType = scanner.nextInt();
                    
                    if (empType == 3) {
                        System.out.println("Operation cancelled.");
                        break;
                    }
                    
                    scanner.nextLine();
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

                    switch (empType) {
                        case 1:
                            System.out.println("Enter level of the Engineer: ");
                            String level = scanner.nextLine();
                            System.out.println("Enter CREA of the Engineer: ");
                            String crea = scanner.nextLine();
                            
                            // Create instance inside the switch to persist data
                            Engineer eng = new Engineer();
                            eng.setData(name, cpf, code, salary, department);
                            eng.setEngineer(level, crea);
                            employees.add(eng);
                            
                            System.out.println("Engineer registered successfully!");
                            break;
                        case 2:
                            System.out.println("Enter car's name destined to the manager: ");
                            String companyCar = scanner.nextLine();
                            
                            // Create instance inside the switch to persist data
                            Manager man = new Manager();
                            man.setData(name, cpf, code, salary, department);
                            man.setManager(companyCar);
                            employees.add(man);
                            
                            System.out.println("Manager registered successfully!"); // Added confirmation
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Employee List:");
                    System.out.println("========================================================================");
                    System.out.printf("| %-15s | %-35s | %-20s | %-30s | %-15s |\n", "Code", "Name", "CPF", "Department", "Salary");
                    
                    for (Employee e : employees) {
                        System.out.printf("| %-15s | %-35s | %-20s | %-30s | %-15.2f |\n", 
                            e.getCode(), e.getName(), e.getCPF(), e.getDepartment(), e.getSalary());
                    }
                    System.out.println("========================================================================");
                    break;

                case 3:
                    System.out.println("Employee List:");
                    System.out.println("========================================================================");
                    System.out.printf("%-20s | %-20s | %-20s | %-20s\n", "Name", "Salary", "Total Deductions", "Liquid Salary");
                    
                    // Using the Interface "Payable" to handle different types in one loop
                    for (Employee e : employees) {
                        double disc = e.calculateDiscounts(e.getSalary());
                        double liquid = e.getSalary() - disc;
                        
                        // Or use the foreach loop, this a example of Lambda expression
                        // (Note: Lambda logic usually happens on the collection itself)
                        System.out.printf("%-20s | %-20.2f | %-20.2f | %-20.2f\n", 
                            e.getName(), e.getSalary(), disc, liquid);
                    }
                    System.out.println("========================================================================");
                    break;

                case 4:
                    System.out.print("Enter the name of employee: ");
                    String searchName = scanner.nextLine();
                    
                    Employee foundEmployee = null;
                    
                    // Search for the employee in the list
                    for (Employee e : employees) {
                        if (e.getName().equalsIgnoreCase(searchName)) {
                            foundEmployee = e;
                            break; 
                        }
                    }

                    if (foundEmployee != null) {
                        // Check type and display specific data
                        if (foundEmployee instanceof Engineer eng) {
                            // Using Pattern Matching for instanceof (Java 16+)
                            eng.getEngineerData(); 
                        } else if (foundEmployee instanceof Manager man) {
                            man.getManagerData();
                        }
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
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