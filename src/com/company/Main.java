package com.company;

import com.sun.security.jgss.GSSUtil;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Welcome to BattleShip");
        //welcome message


        char battleFieldLine0[] = {' ', ' ', ' ', 'A', ' ', 'B', ' ', 'C', ' ', 'D', ' ', 'E', ' ', 'F', ' ', 'G', ' ', 'H', ' ', 'I', ' ', 'J'};
        char battleFieldLine1[] = {'1', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine2[] = {'2', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine3[] = {'3', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine4[] = {'4', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine5[] = {'5', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine6[] = {'6', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine7[] = {'7', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine8[] = {'8', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine9[] = {'9', ' ', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        char battleFieldLine10[] = {'1', '0', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~', ' ', '~'};
        System.out.println(battleFieldLine0);
        System.out.println(battleFieldLine1);
        System.out.println(battleFieldLine2);
        System.out.println(battleFieldLine3);
        System.out.println(battleFieldLine4);
        System.out.println(battleFieldLine5);
        System.out.println(battleFieldLine6);
        System.out.println(battleFieldLine7);
        System.out.println(battleFieldLine8);
        System.out.println(battleFieldLine9);
        System.out.println(battleFieldLine10);
        // Gameboard creation



      /*  int MyTable [] = new int[10];
        double tableauDouble[] = {0.0,1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
        char tableauCaractere[] = {'a','b','c','d','e','f','g'};
        System.out.println(tableauCaractere);*/
        char tableauCaractere[] = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};


        for (int i = 1; i < tableauCaractere.length; i = i + 1) {
            System.out.println("À l'emplacement " + i + " du tableau nous avons = " + tableauCaractere[i]);
        }
    }
}

