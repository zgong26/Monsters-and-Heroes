# CS611-Assignment 3
## Monsters and Heroes
---------------------------------------------------------------------------
Ziqi Gong
zgong@bu.edu
U02767242

## Files
---------------------------------------------------------------------------
1. Armor.java
An armor interface which declares some unique properties for armor items

2. Battle.java
A concrete class where defines a battle between heroes and monsters

3. Board.java
Used directly from TTT game. The parent class of World class which is a square 
board consists of Cells.

4. Character.java
Interface of a game character which declares some necessary methods.

5. ErrorControl.java
A class that contains static methods that are used to prevent mistakes that might 
occur in a game such as invalid input, string-integer issue, etc. Directly used from
TTT game.

6.Dragon.java
A child class extends from Monster that defines a Dragon monster type.

7. Exoskeleton.java
A child class extends from Monster that defines a Exoskeleton monster type.

8. Spirit.java
A child class extends from Monster that defines a Spirit monster type.

8. FireSpell.java
FireSpell class extends from Item and implements Spell interface. It defines an 
object of FireSpell.

9. IceSpell.java
IceSpell class extends from Item and implements Spell interface. It defines an 
object of IceSpell.

10. LightningSpell.java
LightningSpellclass extends from Item and implements Spell interface. It defines an 
object of LightningSpell.

11. Game.java
A game class where the basic structure of the game runs inside.

12. Hand.java
A Hand class that can equip weapon(s). Used by Heroes

13. Hero.java
This abstract Hero class implements Character and defines some unique and necessary features of Hero.

14. HeroCollection.java
This class contains all heroes in the game

15. HeroTeam.java
This HeroTeam class unites all heroes in the team of this game.

16. Inventory.java
Inventory class is used by Hero and Market to store items. It also includes necessary functions such as sorting.

17. Item.java
This abstract class is encapsulate game items in the game.

18. ItemCollection.java
This class contains all items appear in the game.

19. Main.java
Program entry

20. Market.java
This class represents a unique market where inside could contain differen items.

21. Monster.java
This monster interface that declares some unique behaviors of monsters

22. MonsterCollection.java
This class contains all monsters in the game

23. MonsterTeam.java
This MonsterTeam class unites all monsters involved in a battle

24. Move.java
This class contains static methods that can be used to control player's movement in the world.

25. Paladin.java
A concret class of a type of Hero

26. Warrior.java
A concret class of a type of Hero

27. Sorcerer.java
A concret class of a type of Hero

28. Potion.java
This is a concrete potion class that extends from Item, which represents a potion object in the game

29. Spell.java
This is the spell interface which declares some unique properties for spell items

30. Weapon.java
The weapon class which declares some unique properties for weapon items

31. World.java
The world class extends from board. Where the main game/map occurs.

## Notes
---------------------------------------------------------------------------
All bonus parts are done!(All complex versions are implemented as mentioned
in the handout)

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "Game" after unzipping the files
2. Run the following instructions:
javac Main.java
java Main

## Input/Output Example
---------------------------------------------------------------------------
Output:
Welcome
Warriors: 
1. Gaerdal_Ironhand  mana: 100  strength: 700  agility: 500  dexterity: 600  initial gold: 1354  initial experience points: 7
2. Sehanine_Monnbow  mana: 600  strength: 700  agility: 800  dexterity: 500  initial gold: 2500  initial experience points: 8
3. Muamman_Duathall  mana: 300  strength: 900  agility: 500  dexterity: 750  initial gold: 2546  initial experience points: 6
4. Flandal_Steelskin  mana: 200  strength: 750  agility: 650  dexterity: 700  initial gold: 2500  initial experience points: 7
5. Undefeated_Yoj  mana: 400  strength: 800  agility: 400  dexterity: 700  initial gold: 2500  initial experience points: 7
6. Eunoia_Cyn  mana: 400  strength: 700  agility: 800  dexterity: 600  initial gold: 2500  initial experience points: 6

Sorcerers: 
7. Segojan_Earthcaller  mana: 900  strength: 800  agility: 500  dexterity: 650  initial gold: 2500  initial experience points: 5
8. Reign_Havoc  mana: 800  strength: 800  agility: 800  dexterity: 800  initial gold: 2500  initial experience points: 8
9. Reverie_Ashels  mana: 900  strength: 800  agility: 700  dexterity: 400  initial gold: 2500  initial experience points: 7
10. Kalabar  mana: 800  strength: 850  agility: 400  dexterity: 600  initial gold: 2500  initial experience points: 6
11. Skye_Soar  mana: 1000  strength: 700  agility: 400  dexterity: 500  initial gold: 2500  initial experience points: 5

Paladins: 
12. Parzival  mana: 300  strength: 750  agility: 650  dexterity: 700  initial gold: 2500  initial experience points: 7
13. Sehanine_Moonbow  mana: 300  strength: 750  agility: 700  dexterity: 700  initial gold: 2500  initial experience points: 7
14. Skoraeus_Stonebones  mana: 250  strength: 650  agility: 600  dexterity: 350  initial gold: 2500  initial experience points: 4
15. Garl_Glittergold  mana: 100  strength: 600  agility: 500  dexterity: 400  initial gold: 2500  initial experience points: 5
16. Amaryllis_Astra  mana: 500  strength: 500  agility: 500  dexterity: 500  initial gold: 2500  initial experience points: 5
17. Caliber_Heist  mana: 400  strength: 400  agility: 400  dexterity: 400  initial gold: 2500  initial experience points: 8
Please pick up to 3 heroes to join your adventure!
Enter '0' to end pick
Please pick('0' to end): 

Input: 1
Output: 
Gaerdal_Ironhand picked!
Please pick('0' to end): 

Input: 2
Output:
Sehanine_Monnbow picked!
Please pick('0' to end): 

Input: 0

Output:
Please enter the world size(between 5 to 10), default is 8

Input: 8

+---+---+---+---+---+---+---+---+
| P |   |   | m | m | X | X | X |
+---+---+---+---+---+---+---+---+
|   |   |   | X | X | m | m | m |
+---+---+---+---+---+---+---+---+
|   |   |   | X |   |   |   | X |
+---+---+---+---+---+---+---+---+
| X |   | X | m | m | X | m |   |
+---+---+---+---+---+---+---+---+
| m |   |   | X |   | m |   |   |
+---+---+---+---+---+---+---+---+
|   | m | m |   |   |   |   |   |
+---+---+---+---+---+---+---+---+
| m |   | m | X |   | m | m | m |
+---+---+---+---+---+---+---+---+
| m |   |   | m |   |   |   |   |
+---+---+---+---+---+---+---+---+

Enter 'w s a d' to move
'i' to display heroes' inventory
'exit' to exit the game
