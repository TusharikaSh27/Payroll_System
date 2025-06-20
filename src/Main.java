import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
public String getName(){
        return name;
}
public int getId(){
        return id;
}

public abstract double calculateSalary();//abstract method

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{ //abstract class
    private double monthlySalary;

    public FullTimeEmployee(String name, int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id,int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override

    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}
class PayrollSystem{
    private final ArrayList<Employee> employeeList;
    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }

}
public class Main{
    public static void main(String[] args){
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1= new FullTimeEmployee("Vikas",1,500);
        FullTimeEmployee emp2= new FullTimeEmployee("Ajay",2,4500);
        FullTimeEmployee emp3= new FullTimeEmployee("Aman",3,5500);
        PartTimeEmployee emp4=new PartTimeEmployee("Alex",4,5,10);
        PartTimeEmployee emp5=new PartTimeEmployee("Alice",5,6,10);
        PartTimeEmployee emp6=new PartTimeEmployee("Sia",6,5,9);
        PartTimeEmployee emp7=new PartTimeEmployee("Mia",7,6,8);
        PartTimeEmployee emp8=new PartTimeEmployee("Pia",8,5,10);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        System.out.println("Initial Employee Details:");

        payrollSystem.displayEmployees();
        System.out.println("Removing Employees ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details");
        payrollSystem.displayEmployees();
    }
}