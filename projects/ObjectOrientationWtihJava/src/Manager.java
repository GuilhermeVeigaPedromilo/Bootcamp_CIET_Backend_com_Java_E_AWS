public non-sealed class Manager extends Employee {
    private String companyCar;
    public void setManager(String companyCar) {
        this.companyCar = companyCar;
    }
    public void getManagerData() {
        System.out.println("Manager Data:");
        System.out.println("Name: " + this.getName());
        System.out.println("CPF: " + this.getCPF());
        System.out.println("Code: " + this.getCode());
        System.out.println("Salary: " + this.getSalary());
        System.out.println("Department: " + this.getDepartment());
        System.out.println("Company Car: " + this.companyCar);
    }
}
