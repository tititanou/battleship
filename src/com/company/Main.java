/*package com.company;

public class Main {
    // table

    static void initTable( char tab[][] ){

        for (int line = 0;line<tab.length;line=line +1){
            for (int column= 0;column<tab[0].length;column=column+1){
                tab [column] [line]= '~';
            }
        }
    }


    static void displayTable(char tab[][]){

        /*System.out.println("    A B C D E F G H I J");
        System.out.println("    --------------------");
        for (int line = 0;line<tab.length;line=line +1){
            String display = "|";
            for (int column= 0;column<tab[0].length;column=column+1){
                display= display+tab [column][line] + ' ';
            }
            if(line == 9){
                System.out.println( (line+1)  +" "+ display + "|");
            }
            else{
                System.out.println( " "  + (line+1)  +" "+ display + "|");
            }
        }
        System.out.println("    --------------------");
    }



        static char ship = '#';
        static char missed = 'o';
        static char hit = 'x';
        static char sea = '~';


    public static void main(String[] args) {
        /* write your code here
        System.out.println("Welcome to BattleShip");
        //welcome message

        char playerBoard[][] = new char[10][10];
        char cpuBoard[][] = new char[10][10];

        initTable( playerBoard );
        displayTable( playerBoard );

        initTable( cpuBoard );
        displayTable( cpuBoard );


        //play

    }
}
*/
package com.company;
import com.sun.security.jgss.GSSUtil;
public class Main {
    // table
    static int getRandom(int N){
        return (int)(Math.random()*(N+1));
    }
    static void creatBoat(int n,char tab[][]) {
        int hv = getRandom(1);
        int row;
        int col;
        // random pos orient
        if (hv == 0){
            row = getRandom(9);
            col = getRandom(10-n);
        }
        else   {
            col = getRandom( 9);
            row = getRandom(10-n);
        }
        for(int position = 0;position<n;position++){
            if (hv == 0){
                tab[row][col+position] = '#';
            }
            else {
                tab [row+position][col] = '#';
            }
        }
    }
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
        creatBoat(3,playerBoard);
        displayBoard(playerBoard);
      /*test=(int) (Math.random()*6);
      System.out.println(test);
       */
    }
}

