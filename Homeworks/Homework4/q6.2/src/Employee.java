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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
