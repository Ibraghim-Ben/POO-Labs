class Developer extends Employee {
    private int numProjects;

    public Developer(String name, double salary, int age, int numProjects) {
        super(name, salary, age);
        this.numProjects = numProjects;
    }

    public int getNumProjects() {
        return numProjects;
    }

    public void setNumProjects(int numProjects) {
        this.numProjects = numProjects;
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.15;
    }

    public double calculateBonus(int bonusPerProject) {
        return getSalary() * 0.15 + bonusPerProject * numProjects;
    }

    @Override
    public void showDetails() {
        System.out.println("Detalii: Developer " + getName() + " are " + getAge() + " de ani si lucreaza cu " + numProjects + " proiecte.");
    }
}
