import java.util.*;

public class Inventory_control {
    private final List<Sword> swords;

    public Inventory_control() {
        this.swords = new ArrayList<>();
    }

    public void addItem(Sword item) {
        swords.add(item);
    }

    public List<Sword> getItems() {
        return swords;
    }

    public List<Sword> findItems(String name, Rarity_Items rarity) {
        List<Sword> result = new ArrayList<>();
        for (Sword item : swords) {
            if (item.getName().equals(name) && item.getRarity() == rarity) {
                result.add(item);
            }
        }
        return result;
    }

    public void removeItems(List<Sword> itemsToRemove) {
        swords.removeAll(itemsToRemove);
    }

    public void display() {
        if (swords.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Your inventory:");
        Map<Rarity_Items, List<Sword>> groupedItems = new TreeMap<>(Comparator.comparingInt(Enum::ordinal));
        for (Sword item : swords) {
            groupedItems.computeIfAbsent(item.getRarity(), k -> new ArrayList<>()).add(item);
        }

        groupedItems.forEach((rarity, items) -> {
            System.out.println(rarity + ":");
            items.forEach(item -> System.out.println("  - " + item));
        });
    }
}
