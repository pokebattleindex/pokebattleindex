# PokebattleIndex

OOAD Mini Project made by

Srinivasa Raghavan S - PES2UG19CS407 \
Swati Maste - PES2UG19CS419 \
Vihar Devalla - PES2UG19CS453

# Dependencies
* `MongoDB`
* `Maven` 
* `Spring Boot`
* `Spring Web`
* `Spring Data Mongodb`
* `Thymeleaf`
* `TailwindCSS`

# Details of the Project
Our project consists of three major functionalities,
1. Register/Login to maintain the player data
2. Pokedex -> Tool to display Pokémon information, like name ,type, weight etc.
3. Custom Poke-Battle between Pikachu and Charmander.

Minor functionalities include:
1. Leader Board -> keeps track of the battles
2. Settings page ->  allows user to the change username/password
 
We used 3 Repos to connect to 3 different collections in the database, namely `UserRepo`,`MoveRepo`,`PokeRepo`.
Similarly 3 different `Model` files have been made to store the database data in `Object` form, namely `Pokemon.java`,`User.java` and `PokeMove.java`.

Thymeleaf has been used for HTML templating (th:) and TailwindCSS for Styling  
