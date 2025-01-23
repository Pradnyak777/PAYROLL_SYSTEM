import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract methode to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + "id=" + id + " salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    // ArrayList<Employee> employeeList = new

    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class main {
    public static void main(String args[]) {
        
        
        PayrollSystem payrollSystem = new PayrollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("jon", 1, 40000.0);

        FullTimeEmployee emp2 = new FullTimeEmployee("Motu", 2, 50000.0);

        FullTimeEmployee emp3 = new FullTimeEmployee("patlu", 3, 440000.0);

        FullTimeEmployee emp4 = new FullTimeEmployee("zataka", 4, 540000.0);

        FullTimeEmployee emp5 = new FullTimeEmployee("don", 5, 480000.0);

        FullTimeEmployee emp6 = new FullTimeEmployee("Lkhha", 6, 400300.0);

        PartTimeEmployee Ptemp1 = new PartTimeEmployee("sham", 101, 30, 12.0);

        PartTimeEmployee Ptemp2 = new PartTimeEmployee("shama", 102, 31, 13.0);

        PartTimeEmployee Ptemp3 = new PartTimeEmployee("shamb", 103, 32, 14.0);

        PartTimeEmployee Ptemp4 = new PartTimeEmployee("shamc", 104, 34, 15.0);

        PartTimeEmployee Ptemp5 = new PartTimeEmployee("shamd", 105, 35, 16.0);

        PartTimeEmployee Ptemp6 = new PartTimeEmployee("shame", 106, 36, 17.0);

        // Add Full time Employee

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);

        // Add Part Time Employee
        payrollSystem.addEmployee(Ptemp1);
        payrollSystem.addEmployee(Ptemp2);
        payrollSystem.addEmployee(Ptemp3);
        payrollSystem.addEmployee(Ptemp4);
        payrollSystem.addEmployee(Ptemp5);
        payrollSystem.addEmployee(Ptemp6);

       
       
       
        // Print employee
        System.out.println("\n********Initial Employee Details*******");
        payrollSystem.displayEmployee();

       
       
       
        // remove employee
        System.out.println("\n .........Removing Employee......");

        payrollSystem.removeEmployee(106);

       
       
       
        // Last List for Remaining Employee details

        System.out.println("\n*********Remaining Employee Details*************");
        payrollSystem.displayEmployee();

    }

}
