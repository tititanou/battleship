package com.company;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {

    static int getRandom(int MAX) {
        return (int) (Math.random() * (MAX + 1));      //fonction to generate a random integer between 0 et max
    }

    static void creatBoat(int N, char tab[][]) {         //fonction to create a boat

        boolean shipNotOk;                               //variable to know if we can create a boat


        do {
            // ALEA
            int hv = getRandom(1);                  // variable to draw by lot if vertical or horizontal
            int row;
            int col;
            if (hv == 0) {
                row = getRandom(tab[0].length - 1);     //variable to generate a random position on raw for the boat's 1st case
                col = getRandom(tab.length - N);        //variable to generate a random position on column for the boat's 1st case
            } else {
                row = getRandom(tab[0].length - N);
                col = getRandom(tab.length - 1);
            }

            shipNotOk = false;                                  //checking if there is already another boat
            // CHECK

            for (int position = 0; position < N; position++) {
                if (hv == 0) {
                    if (tab[row][col + position] == '#') {
                        shipNotOk = true;
                    }
                } else {
                    if (tab[row + position][col] == '#') {
                        shipNotOk = true;
                    }
                }
            }

            // WRITE
            if (shipNotOk == false) {                                   //there is no boat so I can create a boat
                for (int position = 0; position < N; position++) {
                    if (hv == 0) {
                        tab[row][col + position] = '#';
                    } else {
                        tab[row + position][col] = '#';
                    }
                }
            }
        } while (shipNotOk);
    }


    //init
    static void initBoard(char tab[][]) {                                           //generate a new game board
                                                                                    //createTable
        for (int line = 0; line < tab.length; line = line + 1) {
            for (int column = 0; column < tab[0].length; column = column + 1) {
                tab[line][column] = '~';
            }
        }

        // createShips
        creatBoat(3, tab);
        creatBoat(4, tab);
        creatBoat(2, tab);
        creatBoat(3, tab);
        creatBoat(5, tab);
    }

    static void displayBoard(char tab[][],boolean hiddenMode) {
        //Display Board
        System.out.println("    A B C D E F G H I J");
        System.out.println("   ---------------------");
        for (int line = 0; line < tab.length; line = line + 1) {
            String display = " ";
            for (int column = 0; column < tab[0].length; column = column + 1) {
                if (hiddenMode==true && tab[line][column] == '#') {                         //hidden mode to hide the boats on the CPU's board
                    display = display + '~' + " ";
                }
                else {
                    display = display + tab[line][column] + " ";
                }
            }
            display = (line + 1) + "|" + display + "|";
            if (line < tab.length - 1) {
                display = " " + display;
            }
            System.out.println(display);
        }
        System.out.println("   ---------------------");
    }

    // function that takes a string as a parameter and checks if the first character is between A and J
    // if it is not the case, it returns -1
    static int getInputColIndex(String s) {
        if (s.length() > 0) {
            char first = s.toLowerCase().charAt(0);
            if (first >= 'a' && first <= 'j') {
                return (first - 'a');
            }
        }
        return -1;
    }

    // function that takes a string as a parameter and checks if second and third characters are between '1' and '10'
    // if it is not the case, it returns -1
    static int getInputRowIndex(String s) {
        if (s.length() > 1) {
            char second = s.toLowerCase().charAt(1);
            if (second >= '1' && second <= '9') {
                if (s.length() > 2) {
                    char third = s.toLowerCase().charAt(2);
                    if (third == '0') {
                        return Integer.parseInt(s.substring(1, 3)) - 1;
                    }
                } else {
                    return (second - '0' - 1);
                }
            }
        }
        return -1;
    }

    static boolean hitTheBoat(int Row, int Col, char tab[][]) {                 //function to shoot
        if (tab[Row][Col] == '#') {
            tab[Row][Col] = 'X';
            System.out.println("hit");
            System.out.println("play again");
            return true;                                                       // if player hits a boat, he can plays again
        } else if (tab[Row][Col] == '~') {
            tab[Row][Col] = 'O';
            System.out.println("missed");
            return false;                                                       // if player miss his shoot, it's CPU's turn
        } else {
            System.out.println("already hit");
            return false;                                                       // if the position of shoot is already hit, Player or CPU can replays
        }

    }


    static boolean play(char tab[][]) {
        Scanner sc = new Scanner(System.in);
        int colIdx;
        int rowIdx;
        boolean canPlayAgain = false;


        do {                                                                    // Ask a position to shoot
            // Get input from user
            System.out.println("Entrez des coordonnées : ");
            String input = sc.next();
            // get column index
            colIdx = getInputColIndex(input);
            // get row index
            rowIdx = getInputRowIndex(input);
            if (colIdx != -1 && rowIdx != -1) {
                // Here I got valid position for ROW and COLUMN indexes
                System.out.print("PLAYER : ");
                canPlayAgain = hitTheBoat(rowIdx, colIdx, tab);

            }
        } while (colIdx == -1 || rowIdx == -1);
        return canPlayAgain;
    }


    static boolean cpuPlay(char tab[][]) {                                      //Get a random shooting position from CPU
        int row;
        int col;
        row = getRandom(tab[0].length - 1);
        col = getRandom(tab.length - 1);
        System.out.print("CPU : ");
        return hitTheBoat(row, col, tab);
    }

    static boolean allShipsDestroyed(char tab[][]) {                            //Check if every parts of boats are destroyed
        boolean is0ship = true;
        int row;
        int col;
        for (col = 0; col < tab.length; col++) {
            for (row = 0; row < tab[0].length; row++) {
                if (tab[row][col] == '#') {
                    is0ship = false;
                }
            }
        }
        return is0ship;
    }

    public static void main(String[] args) {
                                                                                    //welcome message
        System.out.println("Welcome to BattleShip");


                                                                                    //create boards of player, and CPU
        char playerBoard[][] = new char[10][10];
        char cpuBoard[][] = new char[10][10];

                                                                                    // Init boards of player and CPU
        initBoard(playerBoard);
        initBoard(cpuBoard);
        boolean isPlayerTurn = true;
        boolean isPlaying=true;
        boolean validResponse=true;



                                                                                    // game loop
        while (isPlaying) {
                                                                                    // Display the board of the enemy
            displayBoard(cpuBoard,true);
                                                                                    // display our own board
            displayBoard(playerBoard,false);


                                                                                    // Is is the player's return ??
            if (isPlayerTurn == true) {
                                                                        // Yes, the player shoots and if he has missed, this is the CPU's turn now
                if (play(cpuBoard) == false) {
                    isPlayerTurn = false;
                }
            } else {
                                                                        // No it is not player 's turn , it is CPU's one (isPlayerTurn is false)
                if (cpuPlay(playerBoard) == false) {
                    isPlayerTurn = true;
                }
            }
            boolean hasPlayerWon = allShipsDestroyed(cpuBoard);

            boolean hasCPUWon = allShipsDestroyed(playerBoard);

            if (hasPlayerWon == true) {
                System.out.println("YOU WIN");
            } else if (hasCPUWon == true) {
                System.out.println("CPU WINS");
            }

            if (hasCPUWon || hasPlayerWon) {                            // Ask if the player wants to play again
                do {
                    System.out.println("Do you want to play again? Yes/No");
                    Scanner sc = new Scanner(System.in);
                    String input = sc.next();
                    String response = input.toLowerCase();

                    if (response.equals("yes")) {                       // write "yes" make game restart
                        validResponse=true;
                        isPlayerTurn=true;
                        initBoard(playerBoard);
                        initBoard(cpuBoard);



                    } else if (response.equals("no")) {                 // write "no" make game finish
                        validResponse=true;
                        isPlaying =false;
                        System.out.println("Game is finished !");

                    }

                    else{
                        validResponse=false;                            // if player writes a wrong word, ask again if play wants to play again
                    }



                } while (!validResponse);

            }

        }


    }
}



/*if (allShipsDestroyed(cpuBoard) == true) {
                        System.out.println(Player has won);

                    }

 */