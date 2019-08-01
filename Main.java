///Main Module of XO Game
///Created By Thanawat Chuensriwirot 60160078
///Burapha University


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) { //Loop of game -> use for replay if player wanted
            char[][] arr; //Create Empty of character array
            XO game = new XO(); //Create Object From XO Class
            int counter = 9; //Amount of turn for playing in game (3*3)
            Scanner scan = new Scanner(System.in); //Input Class
            String winner = ""; //Winner label for ended game
            while (true) { //Loop until someone is winner
                try {
                    System.out.println("------------------------------------------");
                    System.out.println("Turn of " + game.getStatus() + " Player.");
                    Thread.sleep(500);
                    game.showMipmap(); //Method show current map
                    System.out.print("Input your position of area (x,y) [1-3/1-3]:");
                    String input = scan.next();
                    //Check input template (x,y)
                    if (input.charAt(0) != ('(') || input.charAt(2) != (',') || input.charAt(input.length() - 1) != (')')) {
                        System.err.println("Input invalid.");
                        continue;
                    } else { //If it was followed template,Process will continue.
                        int x = Integer.valueOf(input.substring(1, 2)) - 1;
                        int y = Integer.valueOf(input.substring(3, 4)) - 1;
                        System.out.println("You Choose position " + input);
                        Thread.sleep(500);
                        arr = game.getMipmap();
                        if (arr[x][y] == '*') { //If selected box wasn't selected
                            arr[x][y] = game.getStatus();
                        } else { //If selected box was selected, Then try again!!
                            System.err.println("This box is selected!! Try Again.");
                            continue;
                        }
                        counter--; //Reduce amount turn of playing

                        if (game.getStatus() == 'x') { //Function switch player
                            game.setStatus('o');
                        } else {
                            game.setStatus('x');
                        }
                    }
                    game.check_win(); //Method check player
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.err.println("Input invalid.");
                }
                if (game.isWin() == true) { //If someone is winner set winner text to player.
                    winner = String.valueOf(game.isWho_win());
                    break;
                } else if (game.isWin() == false && counter <= 0) { //If ended game and no one is winner.
                    winner = "None";
                    break;
                }
            }
            game.showMipmap(); //Show current map

            // Function Showing Winner
            System.out.println("\n##############################");
            System.out.println("Winner is " + winner);
            if (winner.equals("None")) { //If no one is winner.
                System.out.println("!!Draw!!");
            }
            System.out.println("##############################\n");

            //Function Playing again
            System.out.print("Play again? (y/n) :");
            char replay = scan.next().charAt(0);
            if(replay=='y'){
                System.out.println("\n\n\n\n\n\n\n\n\n");
            }else if(replay=='n'){
                System.out.println("\nThank you for playing!!\n");
                break;
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
                    break;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        //Out of Loop
        System.out.print("---------------------------------");
        //End of Process
    }
}