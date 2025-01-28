import java.util.List;

class Sword {
    private final String name;
    private Rarity_Items rarity;
    private int upgradeCount;

    public Sword(String name, Rarity_Items rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public Rarity_Items getRarity() {
        return rarity;
    }

    public boolean canUpgrade(List<Sword> materials) {
        if (rarity == Rarity_Items.LEGENDARY) return false;

        long count = materials.stream()
                .filter(item -> item.getRarity() == rarity && item.getName().equals(name))
                .count();

        switch (rarity) {
            case COMMON:
            case GREAT:
            case RARE:
                return count >= 2;
            case EPIC:
                return upgradeCount < 2 && count >= 1;
            case EPIC1:
                return count >= 1;
            case EPIC2:
                return count >= 2;
            default:
                return false;
        }
    }

    public void upgrade(List<Sword> materials) {
        switch (rarity) {
            case COMMON:
            case GREAT:
            case RARE:
                materials.subList(0, 2).clear();
                rarity = Rarity_Items.values()[rarity.ordinal() + 1];
                break;
            case EPIC:
                incrementUpgradeCount();
                materials.remove(0);
                if (upgradeCount == 2) {
                    resetUpgradeCount();
                    rarity = Rarity_Items.EPIC2;
                }
                break;
            case EPIC1:
                materials.remove(0);
                rarity = Rarity_Items.EPIC2;
                break;
            case EPIC2:
                materials.subList(0, 2).clear();
                rarity = Rarity_Items.LEGENDARY;
                break;
        }
    }

    private void incrementUpgradeCount() {
        upgradeCount++;
    }

    private void resetUpgradeCount() {
        upgradeCount = 0;
    }

    @Override
    public String toString() {
        return rarity == Rarity_Items.EPIC
                ? String.format("%s [%s %d]", name, rarity, upgradeCount)
                : String.format("%s [%s]", name, rarity);
    }
}