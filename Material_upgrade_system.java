import java.util.List;

public class Material_upgrade_system {

    // Method for improving an item
    public static void upgradeItem(Sword sword, List<Sword> ingredients) {
        // Check if we can improve the item

        if (sword.canUpgrade(ingredients)) {
            sword.upgrade(ingredients); // Improving the item
        } else {
            throw new IllegalArgumentException("Not enough materials to upgrade or item cannot be upgraded.");
        }
    }


    // Method to check if we can upgrade all items in the list
    public static void upgradeMultipleItems(List<Sword> swords, List<Sword> ingredients) {
        for (Sword sword : swords) {
            try {
                upgradeItem(sword, ingredients);
                System.out.println(sword.getName() + " successfully upgraded to " + sword.getRarity());
            } catch (IllegalArgumentException e) {
                System.out.println("Failed to improve " + sword.getName() + ": " + e.getMessage());
            }
        }
    }
}
