# Final Project Monster Hunter TCG

## I. Purpose of the application

<details>
<summary>More informations below</summary>
<br>
This application is a simple turn-based Trading Card Game based on the Capcom's Monster Hunter franchise. It is a game for two players where you will play one after another.
You will have cards to put on your board and active spot to attack the opponent's Monster. The first player to reach four points win.
</details>


## II. How to run the project

<details>
<summary>More informations below</summary>
<br>

Once you clone the repository, go to the Main file. Click on the green arrow and the game will launch itself in the terminal. Follow the instructions given to play.

</details>

## III. The main features

<details>
<summary>More informations below</summary>

**Coded and implemented:**<br>
*- Custom players names<br>
-A random card is drawn from the player deck each turn until there is no more cards<br>
-A random element of the types of elements that are in you deck is given each turn<br>
-You can put Monsters on the active spot and bench<br>
-You can attack with your active Monster<br>
-You can heal your Monsters with potions<br>
-You can skip your turn<br>
-Elemental Attacks: attacks using Elements deals damage of that element type<br>
-Weakness System: Monster take more damage from attack with specific element (but it's not specified on the terminal)<br>
-Blight Token: half-baked, some specifics attack add tokens to the enemy Monster but not all of them have an effect<br>*


**Coded but not implemented in game loop:**<br>
*-Active Monster retreat: all functions are done and working, just not implemented. When a Monster has a WaterBlight Token, it's retreat cost one more Element<br>
-Choose deck function: not implemented because not enough time to make several different deck<br>
-Win and Points System: implemented but not usable because monster can't die<br>*

**What is needed for it to be finished:**<br>
*-Monster dies when HP <= 0<br>*

**What I wish I could have done:**<br>
*-Custom Decks<br>
-Way more monsters (I have 80 created in the CSV but only four implemented)<br>*
</details>

## IV. The main classes

<details>
<summary>More informations below</summary>
<br>
| Classes     | Description                         |
|-------------|-------------------------------------|
| Main        | Game loop                           |
| Board       | Interaction with players            |
| MonsterCard | Have all of the main card functions |
| CSVModel    | Allows CSV reading                  |
| CSVService  | Allows CSV to be used               |


</details>

## V. Technical decisions

<details>
<summary>More informations below</summary>
<br>
First, I chose to implement the abstract class MonsterCard where I store every method for the future cards. That way, when I want to create a new Monster card class, I only need to create its attacks with methods. Therefore, creating a new MOnster card is really simple.
<br>
Second, I stored the Monsters's data in a csv file. Thanks to this, if I want to change a Monster's statistic or add an attack, I only need to change it in the csv file. It is also simpler to get the data to use in the functions needing them.
Finally, even if I first wanted to launch the application on a website with a visual interface, I then prefered delivering an application using the terminal only due to a lack of time to set up everything.
</details>

## VI. Inheritance

<details>
<summary>More informations below</summary>
<br>
All cards herits from MonsterCard or ItemCard, themselves inheriting Card.
</details>

## VII. Polymorphism

<details>
<summary>More informations below</summary>
<br>
A deck is composed of both MonsterCard and ItemCard because it is a List of Cards.

</details>

## VIII. Abstract classes

<details>
<summary>More informations below</summary>
<br>
MonsterCard, ItemCard, Card are an Abstract class
I chose abstract classes because I needed to have multiple specific cards but no general card. They allow all my cards to have the inherited methods to easily write code that can be used on any card, even without knowing what specific card is targeted.

</details>

## IX. Custom exceptions

<details>
<summary>More informations below</summary>
<br>
CSVReadException: thrown when an error occur while reading the CSV file.
For more general exceptions, there is:
- IllegalArgumentException: check that the input is the right one

</details>

## X. Data

<details>
<summary>More informations below</summary>
<br>
The data here is stored inside a csv file: cards_output.csv.
<br>
Each line represents a Monster and inside a line, data are separated with "," and "/" for som attributes.
<br>
The attributes are the following, in this order:
| Attributes  | Types                        |
|-------------|------------------------------|
| subname     | String                       |
| name        | String                       |
| healthpoint | int                          |
| weakness    | ArrayList&lt;Element>          |
| retreatCost | int                          |
| rarity      | int                          |
| moves       | ArrayList&lt;ArrayList&lt;String>> |

</details>

## XI. SOLID principles

<details>
<summary>More informations below</summary>

### 1. Single Responsibility:<br>
Each Class has its use: the CSVService is only made to work with the CSV file. It does not handle Monsters of the board. Same thing for the Monster classes, they just handle the constructor of the Monster and its attacks.
### 2. Open/Closed:<br>
If I want to add a new Monster, I can add it to the CSV file and create its class without needing to change the MonsterCard Class.
### 3. Liskov Substitution:<br>
Children of Card, MonsterCard and ItemCard respect the Liskov Substitution. They never do less or more than what their parent are able to do and do not Override methods to change them completely.
### 4. Interface Segregation:<br>
MonsterCard and ItemCard both inherit from Card and are separated because ItemCard does not need to handle the attributes of a Monster nor its methods.
### 5. Dependency Inversion:<br>
The Monster classes don't read the CSV file themselves to know their attributes, they ask to CSVModel to do it. This way, if I need to change the way I store the data, I would only need to change the CSVService for it to still return a model based on the CSVModel.
</details>

## XII. How to run the tests

<details>
<summary>More informations below</summary>
<br>
Not implemented - Work in progress -
</details>