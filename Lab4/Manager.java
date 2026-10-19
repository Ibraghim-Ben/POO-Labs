class Manager extends Employee {
    private int numEmployees;

    public Manager(String name, double salary, int age, int numEmployees) {
        super(name, salary, age);
        this.numEmployees = numEmployees;
    }

    public int getNumEmployees() { return numEmployees; }
    public void setNumEmployees(int numEmployees) { this.numEmployees = numEmployees; }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.2;
    }

    public double calculateBonus(int bonusPerEmployee) {
        return getSalary() * 0.2 + bonusPerEmployee * numEmployees;
    }

    @Override
    public void showDetails() {
        System.out.println("Detalii: Manager " + getName() + " are " + getAge() +  " de ani si are " + numEmployees + " angajați.");
    }
}
