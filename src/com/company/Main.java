package com.company;

import com.sun.security.jgss.GSSUtil;

public class Main {
 // table
 static void createTable(){
     char tab [][] = new char[10][10];
     System.out.println("   A B C D E F G H I J");
     for (int line = 0;line<10;line=line +1){
         String affichage = " ";
         for (int column= 0;column<10;column=column+1){
             tab [column] [line]= '~';
                    affichage= affichage+tab [column][line] + ' ';
         }
         System.out.println(line+" "+ affichage);
     }
 }
    public static void main(String[] args) {

        // write your code here
        System.out.println("Welcome to BattleShip");
        //welcome message


        







        // Gameboard creation




        createTable();


    }
}


