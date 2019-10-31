package com.company;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {
    // table

    static int getRandom(int MAX){
        return (int)(Math.random()*(MAX+1));
    }
    static void creatBoat(int N,char tab[][]) {

        boolean shipNotOk;


        do {
            // ALEA
            int hv = getRandom(1);
            int row;
            int col;
            // random pos orient
            if (hv == 0) {
                row = getRandom(tab[0].length - 1);
                col = getRandom(tab.length - N);
            } else {
                row = getRandom(tab[0].length - N);
                col = getRandom(tab.length - 1);
            }

             shipNotOk=false;
            // CHECK

            for (int position = 0; position < N; position++) {
                if (hv == 0) {
                    if (tab[row][col + position] == '#'){
                        shipNotOk = true;
                    }
                } else {
                    if (tab[row + position][col] == '#'){
                        shipNotOk = true;
                    }
                }
            }

            // WRITE
            if (shipNotOk == false) {
                for (int position = 0; position < N; position++) {
                    if (hv == 0) {
                        tab[row][col + position] = '#';
                    } else {
                        tab[row + position][col] = '#';
                    }
                }
            }
        }while (shipNotOk);
    }


    //init
    static void initBoard ( char tab[][]){
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
    static void displayBoard ( char tab[][]){
            //Display Board
            System.out.println("    A B C D E F G H I J");
            System.out.println("   ---------------------");
            for (int line = 0; line < tab.length; line = line + 1) {
                String display = " ";
                for (int column = 0; column < tab[0].length; column = column + 1) {
                    display = display + tab[line][column] + " ";
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
    static int getInputColIndex(String s){
        if(s.length() > 0){
            char first = s.toLowerCase().charAt(0);
            if(first >= 'a' && first <= 'j') {
                return (first-'a');
            }
        }
        return -1;
    }
    // function that takes a string as a parameter and checks if second and third characters are between '1' and '10'
    // if it is not the case, it returns -1
    static int getInputRowIndex(String s){
        if(s.length() > 1){
            char second = s.toLowerCase().charAt(1);
            if(second >= '1' && second <= '9') {
                if(s.length() > 2) {
                    char third = s.toLowerCase().charAt(2);
                    if (third == '0') {
                        return Integer.parseInt(s.substring(1, 3))-1;
                    }
                }
                else{
                    return (second-'0'-1);
                }
            }
        }
        return -1;
    }
    static boolean hitTheBoat (int Row, int Col, char tab [][]){
        if(tab [Row][Col]=='#'){
            tab [Row][Col]= 'X';
            System.out.println( "hit");
            System.out.println("play again");
            return true;
        }else if (tab [Row] [Col]== '~'){
            tab [Row][Col] = 'O';
            System.out.println("missed");
            return false;
        }else{
            System.out.println("already hit");
            return false;
        }

    }


    static boolean play(char tab [][]) {
        Scanner sc = new Scanner(System.in);
        int colIdx;
        int rowIdx;
        boolean canPlayAgain = false;


        do {
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


    static boolean cpuPlay(char tab [][]){
            int row;
            int col;
            row = getRandom(tab[0].length - 1);
            col = getRandom(tab.length - 1);
            System.out.print("CPU : ");
            return hitTheBoat(row, col, tab);
    }

    static boolean allShipsDestroyed(char tab[][]){
        boolean is0ship=true;
        int row;
        int col;
        for (col=0;col<tab.length;col++){
            for (row=0;row<tab[0].length;row++){
                if(tab[row][col]=='#'){
                    is0ship=false;
                }
           }
        }
        return is0ship;
    }




    public static void main (String[]args){
        //welcome message
        System.out.println("Welcome to BattleShip");


            //create boards
            char playerBoard[][] = new char[10][10];
            char cpuBoard[][] = new char[10][10];

            // Init boards
            initBoard(playerBoard);
            initBoard(cpuBoard);
            boolean isPlayerTurn = true;


            // game loop
            while (true) {
                // Display the board of the enemy
                displayBoard(cpuBoard);
                // display our own board
                displayBoard(playerBoard);

                // Is is the player's rturn ??
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
                boolean hasPlayerWon= allShipsDestroyed(cpuBoard);

                boolean hasCPUWon= allShipsDestroyed(playerBoard);

                if (hasPlayerWon==true) {
                    System.out.println("YOU WIN");
                }
                else if (hasCPUWon==true) {
                    System.out.println("CPU WINS");
                }

                if  (hasCPUWon||hasPlayerWon) {
                    do {
                        System.out.println("Do you want to play again? Yes/No");
                        String input = sc.next();
                        String response = input.toLowerCase();
                        if (response == "yes") {

                        } else if (response == "no") {
                            System.out.println(Game is finished !);
                            break;
                        }
                    } while (response != "yes" && response != "no") ;

                }

            }


        }
    }


}
/*if (allShipsDestroyed(cpuBoard) == true) {
                        System.out.println(Player has won);

                    }

 */