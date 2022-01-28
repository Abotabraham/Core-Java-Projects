package tictactoe;
// this program models the tic tac toe game
import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {

        char [][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        while (true) {

            Scanner userInput = new Scanner(System.in);
            System.out.println("Let's play Tic Tac Toe!");
            //System.out.println();
            System.out.println("Enter your placement in the game board(1-9): ");

            //gameBoardDisplay(gameBoard);
            int playerPosition = userInput.nextInt();
            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
                System.out.println("Position taken! Try another position: ");
                playerPosition = userInput.nextInt();
            }
            placePiece(gameBoard, playerPosition, "player");


            Random randomNum = new Random();
            int computerPosition = randomNum.nextInt(9)+1;

            while (playerPositions.contains(computerPosition) || cpuPositions.contains(computerPosition)) {
                randomNum = new Random();
                computerPosition = randomNum.nextInt(9)+1;
            }

            placePiece(gameBoard, computerPosition, "computer");
            gameBoardDisplay(gameBoard);
            String resultWinner = winnerChecker();

            System.out.println(resultWinner);
        }


    }

    /**
     * Displays the state of the current board
     * @param gameBoard
     */
    public static void gameBoardDisplay(char [][] gameBoard) {

        for (char [] row : gameBoard ) {
            for (char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }

    }
     /**
      * checks and places the character of each player
      * @param gameBoard array where players put their choices
      * @param pos  where place the symbol
      * @param user  player against the computer
      */
    public static void placePiece (char [][] gameBoard, int pos, String user){
        char choiceSymbol = ' ';

        if (user.equals("player")){
            choiceSymbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("computer")){
            choiceSymbol = 'O';
            cpuPositions.add(pos);
        }


        switch (pos){
            case 1:
                gameBoard[0][0] = choiceSymbol;
                break;
            case 2:
                gameBoard[0][2] = choiceSymbol;
                break;
            case 3:
                gameBoard[0][4] = choiceSymbol;
                break;
            case 4:
                gameBoard[2][0] = choiceSymbol;
                break;
            case 5:
                gameBoard[2][2] = choiceSymbol;
                break;
            case 6:
                gameBoard[2][4] = choiceSymbol;
                break;
            case 7:
                gameBoard[4][0] = choiceSymbol;
                break;
            case 8:
                gameBoard[4][2] = choiceSymbol;
                break;
            case 9:
                gameBoard[4][4] = choiceSymbol;
                break;
            default:
                break;
        }
    }
  /**
   * checks the winner
   * @return
   */
    public static String winnerChecker () {

        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,8);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(3,5,7);

        List <List>winnings = new ArrayList<List>();
        winnings.add(topRow);
        winnings.add(midRow);
        winnings.add(botRow);
        winnings.add(leftCol);
        winnings.add(midCol);
        winnings.add(rightCol);
        winnings.add(cross1);
        winnings.add(cross2);


        for (List l : winnings) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "Computer wins :(";
            } else if (cpuPositions.size() + playerPositions.size() == 9) {
                return "TIE. Wanna try again?";

            }


        }
        return "";
    }
}
