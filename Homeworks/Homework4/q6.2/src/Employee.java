/**
 * This is the base class
 */
public class Employee {
    private String name;
    private Double salary;

    Employee(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Double getSalary() {
        return salary;
    }

    /**
     * This is the template method in which any class that extends this class will inherit this toString method
     * @return
     */
    public String toString() {
        return "Employee{" +
                "name='" + this.getName() + '\'' +
                ", salary=" + this.getSalary() +
                '}';
    }
}
