# Duel-Game


Warning: This repository is a work in progress. It contains both examples of possible 2D game solutions as well as unfinished classes.
The purpose of this game is to enhance understanding of the design patterns taught in class and to practice video game design principles.

Most of the work done so far has provided the infrastructure required for a game loop and interfacing with a client. As such the repo contains the following utilities:

- Asynchronous dispatcher for sending update commands to game objects
- Key Debouncer to avoid redundant execution of key-binded logic
- Strategy design pattern implementation allowing programmer to implement dynamic game object behaviour. An implementation of the resulting state design behaviour can be seen in the Player and Boss classes.   

Note: The asynchronous dispatcher was made with the intention to gain familiarity with the Observer-Observable design pattern. It is currently programmed to dispatch to all game objects in the game world. This is not scalable and not the suggested method for game update dispatching in a single player game. A well defined area-of-interest coupled with a spatial tree structure and search algorithm would provide a more robust solution. The intention is augment the Dispatcher accordingly, implementing an appropriate data structure such as an AABB tree.

Upcoming Goals:
- Finalize Boss (phase 3), creating add-spawning behavior (additional enemies)
- Implement spatial tree structure and incorporate in game loop for update dispatching
- Create health and damage components, reflect such work in 

Copyright © 2020 mja9 - Miguel Josemaria Arana, aviole - Andressa Lemgruber Viol, vvn1 - Vikram Nayar
