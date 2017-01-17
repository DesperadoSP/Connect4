# Connect4
 This is a 2 player Connect 4 game, in which two players take turn clicking columns to fill in spaces in a board. The first player to fill in a certain number of spaces in a row (horizontally, vertically, or diagonally) wins the game.  
**Working Features:**  
       - Customizable rows, columns, and spaces needed in a row to win. Putting in a non-integer argument will spawn a popup message.    
       - You can have multiple boards open at the same time  
       - The players are represented by the colors blue and red.  
       - Popup message upon winning or draw. Allows you to clear the board to start a new game.  
       - A turn counter at the bottom indicating whose turn it is (color)  
**Unresolved Bugs**  
       - There are times where the rows, columns, and spaces needed aren't compatible with each other, resulting in unwinnable games. As of now, there is no correct and true algorithm to test for unwinnable games, but I implemented a warning message if the arguments are wacky.  
       - I forgot to account for negative arguments. As of now, putting in a 0 for any of the arguments will spawn an empty board. Putting a negative argument will result in an exception displayed in the terminal, but it doesn't spawn a board.  
       - You can edit the turn counter, but it doesn't do anything as it'll revert to normal after filling a space.    
       - Blue always go first, but this shouldn't be an issue since you can just change which player uses which color.  
**Running the code**  
       - Compile and run Customization.java  
**Using the program**  
       - Upon running, a bar will pop up. Enter the amount of rows, columns, and pieces needed in a row. Press Initialize to spawn the board with the entered arguments.  
       - The players will take turns clicking buttons which represent the column they want to drop their piece in. The turn counter will update to say which player's turn it is (color)  
       - If a column is full, a popup message will appear saying so.  
       - When a player wins or there is a draw, a popup message will appear giving you the option to clear the board and start a new game with the same rows/columns/spaces needed.  
       - You can initialize multiple boards without having to close your current one.  
       
       
       
       
       
       
