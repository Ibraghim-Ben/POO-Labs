public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager("Irina", 5000, 40, 8);
        Developer developer1 = new Developer("Pavel", 4000, 30, 5);

        System.out.println("Bonus pentru manager: " + manager1.calculateBonus());
        System.out.println("Bonus pentru developer: " + developer1.calculateBonus());

        System.out.println("Bonus pentru manager cu extra: " + manager1.calculateBonus(150));
        System.out.println("Bonus pentru developer cu extra: " + developer1.calculateBonus(300));

        manager1.showDetails();
        developer1.showDetails();
    }
}
