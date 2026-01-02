public final class Manager extends Employee implements Payable {
    private String companyCar;
    public void setManager(String companyCar) {
        this.companyCar = companyCar;
    }
    @Override
    public double getPaymentAmount() {
        double salary = getSalary();
        // Managers might get a 10% bonus before deductions
        double bonus = salary * 0.10;
        return (salary + bonus) - calculateDiscounts(salary + bonus);
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
