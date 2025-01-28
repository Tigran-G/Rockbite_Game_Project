# Item Upgrade Application

This Java application allows players to manage their inventory, open item packs, and upgrade items based on a tiered rarity system. The application simulates a simple inventory system where players can collect and improve various weapons by combining items of the same type and rarity.

## Features
- **Open Item Packs**: Spend in-game gold to open packs and receive random items.
- **View Inventory**: Display all items in the inventory, grouped by rarity.
- **Upgrade Items**: Combine multiple items of the same type and rarity to upgrade one of them to the next tier.
- **Interactive Console**: Use the console interface to navigate the application.

## Upgrade Mechanics
The upgrade system follows these rules:
1. To upgrade an item, combine it with two additional items of the same type and rarity.
2. Items advance through the following rarity tiers:
   - **COMMON → GREAT → RARE → EPIC → LEGENDARY**
3. For EPIC items:
   - EPIC items can be upgraded incrementally:
     - **EPIC → EPIC 1 → EPIC 2**
   - To upgrade to **EPIC 1**, combine it with any other EPIC item.
   - To upgrade to **EPIC 2**, combine an EPIC 1 item with any other EPIC item.
   - To create a LEGENDARY item, combine one EPIC 2 item with two additional EPIC 2 items of the same type.

## How to Use
1. **Start the application**:
   Run the `Main` class to start the application.

2. **Main Menu Options**:
   - `1. Open Pack`: Spend 100 gold to open a random item pack. Items from the pack are added to your inventory.
   - `2. Show Inventory`: Display all items currently in your inventory, grouped by rarity.
   - `3. Upgrade Item`: Attempt to upgrade an item. You will need to specify the item's name and rarity.
   - `4. Exit`: Exit the application.

3. **Upgrade Process**:
   - Ensure you have enough items of the same type and rarity to perform the upgrade.
   - Enter the name and rarity of the item you wish to upgrade.
   - If successful, the upgraded item replaces the original, and the required materials are consumed.

## Example
### Inventory Example
```
Your Inventory:
COMMON:
  - Iron_Sword [COMMON]
  - Holy_Saber [COMMON]
  - Dragon_Slayer [COMMON]
GREAT:
  - Dragon_Slayer [GREAT]
RARE:
  - Shadow_Fang [RARE]
  - Dragon_Slayer [RARE]
EPIC:
  - Shadow_Fang [EPIC 0]
  - Dragon_Slayer [EPIC 0]
```

### Upgrade Example
1. Attempt to upgrade `Holy_Saber` from `COMMON` to `GREAT`:
   - Required: 3 `Holy_Saber [COMMON]`.
   - Result: 1 `Holy_Saber [GREAT]` in inventory.

2. Attempt to upgrade `Dragon_Slayer` from `GREAT` to `RARE`:
   - Required: 3 `Dragon_Slayer [GREAT]`.
   - Result: 1 `Dragon_Slayer [RARE]` in inventory.

## Requirements
- **Java Version**: 8 or higher

## Classes Overview
### Main
- Manages the game loop and user interactions.
- Options to open packs, display inventory, and upgrade items.

### Inventory_control
- Handles item storage and management.
- Methods for adding, removing, and displaying items.

### Sword
- Represents individual items with attributes:
  - `name` (e.g., Iron_Sword, Dragon_Slayer).
  - `rarity` (e.g., COMMON, GREAT, RARE).
  - `upgradeCount` (specific to EPIC items).
- Contains logic for upgrading items.

### Material_upgrade_system
- Provides helper methods for upgrading items and handling multiple upgrades.

### Pack
- Simulates the generation of random items when opening packs.

## Notes
- The application uses a simplified inventory system.
- Future improvements could include:
  - Enhanced user interface (e.g., GUI or web-based interface).
  - Saving and loading inventory data between sessions.
  - Additional item types and upgrade paths.

## Running the Application
1. Clone the repository.
2. Compile all `.java` files.
3. Run the `Main` class.

Enjoy managing and upgrading your inventory!

