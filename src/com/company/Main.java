package com.company;

import com.sun.security.jgss.GSSUtil;

public class Main {
 // table
 static void createTable(){
     char tab [][] = new char[10][10];
     System.out.println("   A B C D E F G H I J");
     for (int row = 0;row<10;row=row +1){
         String affichage = " ";
         for (int col= 0;col<10;col=col+1){
             tab [col] [row]= '~';
                    affichage= affichage+tab [col][row] + ' ';
         }
         System.out.println(row+" "+ affichage);
     }
 }
    public static void main(String[] args) {

        // write your code here
        System.out.println("Welcome to BattleShip");
        //welcome message

      /*  char tableauCaractere[] = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};


        for (int i = 1; i < tableauCaractere.length; i = i + 1) {
            System.out.println("Pour l'emplacement " + i + " du tableau nous avons = " + tableauCaractere[i]);
        }*/

createTable();


    }
}


