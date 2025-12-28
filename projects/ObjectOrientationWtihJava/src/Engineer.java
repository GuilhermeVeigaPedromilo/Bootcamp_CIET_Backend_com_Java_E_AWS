public class Engineer extends Employee{
    private String level;
    private String crea;
    public void setEngineer(String level, String crea) {
        this.level = level;
        this.crea = crea;
    }
    public void getEngineerData() {
        System.out.println("Engineer Data:");
        System.out.println("Name: " + this.getName());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Code: " + this.getCode());
        System.out.println("Salary: " + this.getSalary());
        System.out.println("Department: " + this.getDepartment());
        System.out.println("Level: " + this.level);
        System.out.println("CREA: " + this.crea);
    }
}
