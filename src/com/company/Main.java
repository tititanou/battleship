package com.company;
import com.sun.security.jgss.GSSUtil;
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
        public static void main (String[]args){
            // write your code here
            System.out.println("Welcome to BattleShip");
            //welcome message
            char playerBoard[][] = new char[10][10];
            initBoard(playerBoard);
            creatBoat(3, playerBoard);
            creatBoat(4, playerBoard);
            creatBoat(2, playerBoard);
            creatBoat(3, playerBoard);
            creatBoat(5, playerBoard);
            displayBoard(playerBoard);


        }

}