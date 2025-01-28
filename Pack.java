import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pack {
    private static final Random random = new Random();

    // Item drop probabilities (can be configured)
    private static final List<RarityChance> rarityChances = List.of(
            new RarityChance(Rarity_Items.COMMON, 50),   // 50% for COMMON
            new RarityChance(Rarity_Items.GREAT, 25),   // 25% for GREAT
            new RarityChance(Rarity_Items.RARE, 15),    // 15% for RARE
            new RarityChance(Rarity_Items.EPIC, 8),     // 8% for EPIC
            new RarityChance(Rarity_Items.LEGENDARY, 2) // 2% for LEGENDARY
    );

    /**
     * Generates swords when the pack is opened.
     * @return a list of swords dropped from the pack.
     */
    public static List<Sword> openPack() {
        List<Sword> swords = new ArrayList<>();
        int packSize = 3; // Number of items in one pack

        for (int i = 0; i < packSize; i++) {
            Rarity_Items rarity = rollRarity();
            Sword sword = new Sword(generateRandomName(), rarity);
            swords.add(sword);
        }

        return swords;
    }

    /**
     * Generates a random sword name.
     * @return random sword name.
     */
    private static String generateRandomName() {
        String[] swordNames = {
                "Iron_Sword", "Steel_Sword", "Dragon_Slayer",
                "Knight's_Blade", "Shadow_Fang", "Holy_Saber"
        };
        return swordNames[random.nextInt(swordNames.length)];
    }

    /**
     * Determines the rarity of an item based on probabilities.
     * @return the rarity of the item.
     */
    private static Rarity_Items rollRarity() {
        int roll = random.nextInt(100) + 1;
        int cumulativeChance = 0;

        for (RarityChance rarityChance : rarityChances) {
            cumulativeChance += rarityChance.getChance();
            if (roll <= cumulativeChance) {
                return rarityChance.getRarity();
            }
        }

        return Rarity_Items.COMMON; // If nothing happened, return COMMON
    }

    /**
     * Class for storing rarity drop rates.
     */
    private static class RarityChance {
        private final Rarity_Items rarity;
        private final int chance;

        public RarityChance(Rarity_Items rarity, int chance) {
            this.rarity = rarity;
            this.chance = chance;
        }

        public Rarity_Items getRarity() {
            return rarity;
        }

        public int getChance() {
            return chance;
        }
    }
}
