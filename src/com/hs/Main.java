package com.hs.cards;

import java.util.Random;

public class Main {

    //Attack count
    public static long count = 0;

    public static Random rand = new Random();

    public static void main(String[] args) {
        //Starting HP for each knife thrower and player, per player
        int[] hpP1 = {1073741780, 1073741780, 30};
        int[] hpP2 = {1073741780, 1073741780, 30};

        //Processing once per player
        try {
            processP1(hpP1, hpP2);
            processP2(hpP1, hpP2);
        } catch (StackOverflowError e) {
            System.out.println("crashed");
        }

        long elapsedTime;
        System.out.println("Finished after " + count + " attacks");
        elapsedTime = ((long)(count * 4.4));
        System.out.println("Program ran for " + ((long)(count * 4.4)) + " seconds ( = " + elapsedTime / 60 + " minutes, or " + elapsedTime / 3600 + " hours) before terminating");

        System.out.println("Knife thrower P1@1 " + hpP1[0] + ", lost " + (1073741780 - hpP1[0]));
        System.out.println("Knife thrower P1@2 " + hpP1[1] + ", lost " + (1073741780 - hpP1[1]));
        System.out.println("Player 1 " + hpP1[2]);

        System.out.println("Knife thrower P2@1 " + hpP2[0] + ", lost " + (1073741780 - hpP2[0]));
        System.out.println("Knife thrower P2@2 " + hpP1[1] + ", lost " + (1073741780 - hpP2[1]));
        System.out.println("Player 2 " + hpP2[2]);
    }

    private static void processP1(int[] hpP1, int[] hpP2) {
        int random;
        if (hpP1[0] > 0) {
            //Picking a random enemy that still has HP left
            do {
                random = rand.nextInt(8);
            } while (random < 3 && hpP2[random] == 0);

            count++;

            //If we're targeting another knife thrower or the player, decrease their hp
            if (random < 3) {
                hpP2[random]--;
            } else {
                //Otherwise rethrow for the enemy player because we killed a horse
                processP2(hpP1, hpP2);
            }
        }

        if (hpP1[1] > 0) {
            do {
                random = rand.nextInt(8);
            } while (random < 3 && hpP2[random] == 0);

            count++;
            if (random < 3) {
                hpP2[random]--;
            } else {
                processP2(hpP1, hpP2);
            }
        }
    }

    private static void processP2(int[] hpP1, int[] hpP2) {
        int random;
        if (hpP2[0] > 0) {
            do {
                random = rand.nextInt(8);
            } while (random < 3 && hpP1[random] == 0);

            count++;
            if (random < 3) {
                hpP1[random]--;
            } else {
                processP1(hpP1, hpP2);
            }
        }

        if (hpP2[1] > 0) {
            do {
                random = rand.nextInt(8);
            } while (random < 3 && hpP1[random] == 0);

            count++;
            if (random < 3) {
                hpP1[random]--;
            } else {
                processP1(hpP1, hpP2);
            }
        }
    }
}
