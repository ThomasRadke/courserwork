Q1. accepts commands to go to different rooms
Q2. It accepts the commands go and then a direction help and quit
Q3. 5

  N
W * E
  S
                    campus pub ---- Start Point --- Lecture Theater
                                         |
                                         |
                                    Computing Lab ---- Computing admin office


Q4. The game itself knows information from all of the classes, the parser takes in information from commands
and command words.
Q5. All of the rooms are public. Lots of repetitive code
Q6. ZullWorld is responsible for executing the game the game is responsible for
taking commands and setting the rooms and exits the room class is responsible
for being rooms the command class is responsible for sending commands to the parser
the parser parses commands.