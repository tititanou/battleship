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
                row = getRandom(tab.length - N);
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
                        return Integer.parseInt(s.substring(1, 2))-1;
                    }
                }
                else{
                    return (second-'0'-1);
                }
            }
        }
        return -1;
    }
    static void hitTheBoat (int col, int row, char tab [][]){
        if(tab [row][col]=='#'){
            tab [row][col]= 'x';
            System.out.println( " hit");
        }else if (tab [row] [col]== '~'){
            tab [row][col] = '°';
            System.out.println("missed");
        }else{
            System.out.println("already hit");
        }

    }


    static void play(char tab [][]) {
        Scanner sc = new Scanner(System.in);
        int colIdx;
        int rowIdx;
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
                hitTheBoat(colIdx, rowIdx, tab);
            }
        }while( colIdx==-1 || rowIdx==-1);
    }

    static void cpuPlay(char tab [][]){
        int row;
        int col;

        row = getRandom(9);
        col=getRandom(9);
        hitTheBoat(col,row,tab);



    }



    public static void main (String[]args){
        //welcome message
        System.out.println("Welcome to BattleShip");

        //create boards
        char playerBoard[][] = new char[10][10];
        char cpuBoard [][]= new char[10][10];

        // Init boards
        initBoard(playerBoard);
        initBoard(cpuBoard);

        // game loop
        while(true){
            // Display the board of the enemy
            displayBoard(cpuBoard);
            // display our own board
            displayBoard(playerBoard);

            // the player plays
            play(cpuBoard);

            // the computer plays
            cpuPlay(playerBoard);
        }


    }


}