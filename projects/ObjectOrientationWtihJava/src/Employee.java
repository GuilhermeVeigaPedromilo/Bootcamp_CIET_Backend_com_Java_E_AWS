public class Employee {
    private String name;
    private String cpf;
    private int code;
    private double salary;
    private String department;
    public void setData(String name, String cpf, int code, double salary, String department) {
        this.name = name;
        this.cpf = cpf;
        this.code = code;
        this.salary = salary;
        this.department = department;
    }
    public String getName() {
        return name;
    }
    public String getCPF() {
        return cpf;
    }
    public int getCode() {
        return code;
    }
    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }
}