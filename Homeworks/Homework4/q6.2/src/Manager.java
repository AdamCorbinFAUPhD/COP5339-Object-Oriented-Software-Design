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


}
