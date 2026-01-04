import br.com.dio.dao.UserDAO;
import br.com.dio.exception.EmpltyStorageException;
import br.com.dio.exception.UserNotFoudException;
import br.com.dio.exception.ValidatorException;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.dio.validator.UserValidator.verifyModel;

public class App {
    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("");
            System.out.println("Welcome to the user's management");
            System.out.println("Selection an option:");
            System.out.println("1- Register");
            System.out.println("2- Update");
            System.out.println("3- Remove");
            System.out.println("4- Search a user by id");
            System.out.println("5- List users");
            System.out.println("6- Exit");
            System.out.print("-> ");
            var usersInput = scanner.nextInt();
            var selectedOption = MenuOption.values()[usersInput -1];
            switch (selectedOption) {
                case SAVE -> {
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("User saved %s", user);
                    } catch (ValidatorException ex) {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdate());
                        System.out.printf("User updated %s", user);
                    } catch (EmpltyStorageException | UserNotFoudException ex) {
                        System.out.println(ex.getMessage());
                    } catch (ValidatorException ex) {
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.printf("User deleted");
                    } catch (EmpltyStorageException | UserNotFoudException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("User with id - %s", id);
                        System.out.println(user);
                    } catch (EmpltyStorageException | UserNotFoudException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
                case FIND_ALL -> {
                   var users = dao.findAll();
                   System.out.println("Users registered");
                   System.out.println("================");
                   users.forEach(System.out::println);
                   System.out.println("================");
                }
                case EXIT -> System.exit(0);
            }
        }
    }

    private static UserModel validateInputs(final long id, final String name, final String email, final LocalDate birthday)
    throws ValidatorException {
        var user = new UserModel(0, name, email, birthday);
        try {
            verifyModel(user);
            return user;
        } catch (ValidatorException ex) {

        }
        return user;
    }

    private static UserModel requestToSave() throws ValidatorException {
        System.out.print("Enter username: ");
        var name = scanner.next();
        System.out.print("Enter user address (e-mail): ");
        var email = scanner.next();
        System.out.print("Enter birthday: ");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static UserModel requestToUpdate() throws ValidatorException {
        System.out.print("Enter user id: ");
        var id = scanner.nextLong();
        System.out.print("Enter username: ");
        var name = scanner.next();
        System.out.print("Enter user e-mail address: ");
        var email = scanner.next();
        System.out.print("Enter birthday: ");
        var birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0, name, email, birthday);
    }

    private static long requestId() {
        System.out.print("Enter user id: ");
        return scanner.nextLong();
    }
}
