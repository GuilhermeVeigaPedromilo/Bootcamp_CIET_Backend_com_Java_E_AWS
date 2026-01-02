public class Person {
    // Attributes
    private String name;
    private int age;

    // Constructor
    public Person setPerson(String name, int age) {
        this.name = name;
        this.age = age;
        return this;
    }

    // Methods
    public String getData() {
        return "- Name: " + name + "\n- Age: " + age;
    }
}
