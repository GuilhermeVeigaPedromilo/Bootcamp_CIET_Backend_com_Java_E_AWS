import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Contact;
import domain.User;
import domain.ContactType;
import domain.Sex;

public class App {
    public static void main(String[] args) throws Exception {
        List<User> users = new ArrayList<>((generateUsers()));
        // Sort users by nome in two different ways and print the results
        System.out.println("Sorting users by name");
        users.sort((u1, u2) -> u2.name().compareTo(u1.name()));
        users.forEach(System.out::println);
        users.sort((u1, u2) -> u2.name().compareTo(u1.name()));
        users.forEach(System.out::println);

        // Filter users older than 30 and print the results
        System.out.println("\nUsers older than 30");
        List<User> usersOlderThan30 = users.stream()
        .filter(user -> user.age() > 30)
        .collect(Collectors.toList());
        usersOlderThan30.forEach(System.out::println);

        // Get all email contacts and print the results with streams
        System.out.println("\nEmail contacts:");
        var values = users.stream()
        .flatMap(user -> user.contacts().stream())
        .filter(contact -> contact.type() == ContactType.EMAIL)
        .map(contact -> contact.description())
        .collect(Collectors.toList());
        values.forEach(System.out::println);
    }

    private static List<User> generateUsers() {
        var contact1 = List.of(
                new Contact("alice.smith@gmail.com", ContactType.EMAIL),
                new Contact("+1-555-0101", ContactType.PHONE));
        var contact2 = List.of(
                new Contact("bob.jones@outlook.com", ContactType.EMAIL),
                new Contact("+1-555-0202", ContactType.PHONE));
        var contact3 = List.of(
                new Contact("charlie.davis@company.org", ContactType.EMAIL),
                new Contact("+1-555-0303", ContactType.PHONE));
        var contact4 = List.of(
                new Contact("diana.prince@webmail.com", ContactType.EMAIL),
                new Contact("+1-555-0404", ContactType.PHONE));
        var contact5 = List.of(
                new Contact("ethan.hunt@mission.com", ContactType.EMAIL),
                new Contact("+1-555-0505", ContactType.PHONE));

        var user1 = new User("Alice Smith", 25, Sex.FEMALE, new ArrayList<>(contact1));
        var user2 = new User("Bob Jones", 32, Sex.MALE, new ArrayList<>(contact2));
        var user3 = new User("Charlie Davis", 19, Sex.MALE, new ArrayList<>(contact3));
        var user4 = new User("Diana Prince", 28, Sex.FEMALE, new ArrayList<>(contact4));
        var user5 = new User("Ethan Hunt", 45, Sex.MALE, new ArrayList<>(contact5));

        return List.of(user1, user2, user3, user4, user5);
    }
}
