///Main Module of XO Game
///Created By Thanawat Chuensriwirot 60160078
///Burapha University


import java.util.Scanner;

public class Main {
    private static int total_turn = 9;
    private static String showWinner = "";
    public static void main(String[] args) {
        do {
            XO game = createXOBoard();
            while (true) {
                try {
                    printWelcome();
                    printBar();
                    printTurn(game);
                    printBoard(game);
                    String input = inputPosition();
                    //Check input template (x,y)
                    if (checkSyntax(input)) {
                        printError();
                        continue;
                    } else {
                        int x = extractPositionX(input);
                        int y = extractPositionY(input);
                        showInput(input);

                        if (checkSelectedPosition(game, x, y)) continue;
                        redureTotal_Turn();

                        switchPlayer(game);
                    }

                    checkWin(game);
                } catch (Exception e) {
                    printError();
                }
                if (checkDraw(game)) break;
            }
            printBoard(game);

            // Function Showing Winner
            printBar();
            printWinner();
            printBar();

            //Function Playing again
            checkReplay();
            break;
        } while (true);
        //Out of Loop
        printBar();
        //End of Process
    }

    private static void printWelcome() {
        System.out.println("Welcome to XO Game :)");
    }

    private static void redureTotal_Turn() {
        total_turn--;
    }

    private static void checkReplay() {
        System.out.print("Play again? (y/n) :");
        Scanner scan = new Scanner(System.in);
        char replay = scan.next().charAt(0);
        if(replay=='y'){
            System.out.println("\n\n\n\n\n\n\n\n\n");
        }else if(replay=='n'){
            System.out.println("\nThank you for playing!!\n");
            return;
        }else{
            try {
                System.err.println("Input invalid!!");
                Thread.sleep(500);
                System.err.println(".");
                Thread.sleep(1000);
                System.err.println("..");
                Thread.sleep(1000);
                System.err.println("...Stopping process");
                Thread.sleep(1000);
                System.out.println("\nThank you for playing!!");
                return;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private static void printWinner() {
        System.out.println("Winner is " + showWinner);
        if (showWinner.equals("None")) { //If no one is showWinner.
            System.out.println("!!Draw!!");
        }
    }

    private static boolean checkDraw(XO game) {
        if (game.isWin() == true) { //If someone is showWinner set showWinner text to player.
            showWinner = String.valueOf(game.isWho_win());
            return true;
        } else if (game.isWin() == false && total_turn <= 0) { //If ended game and no one is showWinner.
            showWinner = "None";
            return true;
        }
        return false;
    }

    private static void printError() {
        System.err.println("Input invalid.");
    }

    private static void checkWin(XO game) {
        game.check_win(); //Method check player
    }

    private static void switchPlayer(XO game) {
        if (game.getStatus() == 'x') { //Function switch player
            game.setStatus('o');
        } else {
            game.setStatus('x');
        }
    }

    private static boolean checkSelectedPosition(XO game, int x, int y) {
        if (game.getMipmap()[x][y] == '*') { //If selected box wasn't selected
            game.getMipmap()[x][y] = game.getStatus();
        } else { //If selected box was selected, Then try again!!
            System.err.println("This box is selected!! Try Again.");
            return true;
        }
        return false;
    }

    private static void showInput(String input) {
        System.out.println("You Choose position " + input);
    }

    private static int extractPositionY(String input) {
        return Integer.valueOf(input.substring(3, 4)) - 1;
    }

    private static int extractPositionX(String input) {
        return Integer.valueOf(input.substring(1, 2)) - 1;
    }

    private static boolean checkSyntax(String input){
        if (input.charAt(0) != ('(') || input.charAt(2) != (',') || input.charAt(input.length() - 1) != (')')) {
            return true;
        } else {
            return false;
        }
    }

    private static String inputPosition() {
        System.out.print("Input your position of area (x,y) [1-3/1-3]:");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    private static void printBoard(XO game) {
        game.showMipmap(); //Method show current map
    }

    private static void printTurn(XO game) {
        System.out.println("Turn of " + game.getStatus() + " Player.");
    }

    private static XO createXOBoard() {
        return new XO();
    }

    private static void printBar() {
        System.out.println("------------------------------------------");
    }
}