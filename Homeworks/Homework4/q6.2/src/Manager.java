public class Manager extends Employee {
    private Double bonus;
    Manager(String name) {
        super(name);
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + this.getName() + '\'' +
                ", salary=" + this.getSalary() +
                ", bonus=" + bonus +
                '}';
    }
}
