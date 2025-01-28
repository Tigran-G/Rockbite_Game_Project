import java.util.*;

public class Main {
    private final Inventory_control inventory;
    private int gold;

    public Main() {
        this.inventory = new Inventory_control();
        this.gold = 500;
    }

    // Opens a pack and adds random items to the inventory
    public void openPack() {
        if (gold < 100) {
            System.out.println("Not enough gold to open the pack.");
            return;
        }

        gold -= 100;
        List<Sword> newItems = Pack.openPack();
        newItems.forEach(inventory::addItem);
        System.out.println("You opened the pack and received:");
        newItems.forEach(System.out::println);
    }

    // Upgrades an item if enough materials are available
    public void upgradeItem(String name, Rarity_Items rarity) {
        List<Sword> items = inventory.findItems(name, rarity);

        if (items.size() < 3 && rarity.ordinal() < Rarity_Items.EPIC2.ordinal()) {
            System.out.println("Not enough materials to upgrade.");
            return;
        }

        Sword target = items.get(0);
        if (!target.canUpgrade(items)) {
            System.out.println("The item cannot be improved.");
            return;
        }

        target.upgrade(items);
        inventory.removeItems(items.subList(1, Math.min(3, items.size())));
        System.out.println("Improvement successful! " + target);
    }

    public static void main(String[] args) {
        Main game = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Open pack");
            System.out.println("2. Show inventory");
            System.out.println("3. Improve item");
            System.out.println("4. Log out");
            System.out.print("Select an action: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> game.openPack();
                case 2 -> game.inventory.display();
                case 3 -> {
                    System.out.print("Enter the name of the item: ");
                    String name = scanner.next();
                    System.out.print("Enter rarity (COMMON, GREAT, RARE, EPIC, EPIC, EPIC 2): ");
                    try {
                        Rarity_Items rarity = Rarity_Items.valueOf(scanner.next().toUpperCase());
                        game.upgradeItem(name, rarity);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong rarity.");
                    }
                }
                case 4 -> {
                    System.out.println("Thanks for playing!");
                    return;
                }
                default -> System.out.println("Wrong choice.");
            }
        }
    }
}