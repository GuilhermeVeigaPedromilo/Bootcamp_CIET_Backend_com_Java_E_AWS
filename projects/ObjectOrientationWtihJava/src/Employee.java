public sealed abstract class Employee permits Manager, Engineer {
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
    public double calculateDiscounts(double salary) {
        double inss_tax_value = 0;
        if (salary < 1751.82) {
            inss_tax_value = (salary / 100) * 8;
        } else if (salary >= 1751.82 || salary < 2919.72) {
            inss_tax_value = (salary / 100) * 9;
        } else if (salary >= 2919.72 || salary < 5839.45) {
            inss_tax_value = (salary / 100) * 11;
        } else {
            inss_tax_value = 642.34;
        }
        double fgts_tax_value = (salary / 100) * 8.3;
        double total_deductions = inss_tax_value + fgts_tax_value;
        System.out.println("Total Deductions: " + total_deductions);
        return total_deductions;
    }
}