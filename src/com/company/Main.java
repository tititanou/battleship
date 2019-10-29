package com.company;
import com.sun.security.jgss.GSSUtil;
public class Main {
    // table

    static void initBoard(char tab[][]) {
            //createTable
            for (int line = 0; line < tab.length; line = line + 1) {
                for (int column = 0; column < tab[0].length; column = column + 1) {
                    tab[line][column]='~';
                }
            }

            // createShips


    }

    static void displayBoard(char tab[][]) {
        //Display Board
        System.out.println("    A B C D E F G H I J");
        System.out.println("   ---------------------");
        for (int line = 0; line < tab.length; line = line + 1) {
            String display = " ";
            for (int column = 0; column < tab[0].length; column = column + 1) {
                display = display + tab[line][column] + " ";
            }
            display = (line+1) +"|"+ display +"|";
            if (line<tab.length-1){
                display=" "+display;
            }
            System.out.println( display );
        }

        System.out.println("   ---------------------");
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to BattleShip");
        //welcome message

        char playerBoard[][]= new char[10][10];

        initBoard(playerBoard);

        displayBoard(playerBoard);
        
        /*test=(int) (Math.random()*6);
        System.out.println(test);
         */

    }
}