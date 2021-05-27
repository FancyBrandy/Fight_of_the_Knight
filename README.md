# Knight_Tournament
This two-player game is played on a board consists of n x n fields. Initially, two white and two black
knights are placed at the corners of the board (knights of the same color are placed at the opposite
corners).
Players step alternately, and knights can move only in an L shape, like in chess. The board is initially
grey, but after each step, the visited places are colored with the color of the visitor knight (the
previous color of the field doesn’t matter). A player wins, if there are 4 adjacent fields (horizontally,
vertically, or diagonally) which colored to player’s color. The game ends, when there are no more
grey fields.
Implement this game, and let the board size be selectable (4x4, 6x6, 8x8). The game should recognize
if it is ended, and it has to show in a message box which player won. After this, a new game should
be started automatically.
