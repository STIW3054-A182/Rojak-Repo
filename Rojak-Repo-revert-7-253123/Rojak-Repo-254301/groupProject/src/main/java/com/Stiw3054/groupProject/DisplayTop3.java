package com.Stiw3054.groupProject;

public class DisplayTop3 {

    void displaytop3 (ObjectTable [] playerlist,String top3){
        for(int y = 0; y < 10;y++ ) {
            System.out.printf("\n| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |", playerlist[y].getArrayRK()[0], playerlist[y].getArraySno()[0], playerlist[y].getArrayName()[0], playerlist[y].getArrayRtg()[0], playerlist[y].getArrayState()[0], playerlist[y].getArrayPts()[0], playerlist[y].getArrayCat()[0]);
            System.out.println("\n"+"| ---- | ----- | ------------------------------------------- | ---- | ---------------- | ---- | -------------------------------------------------- |");
            for (int x = 1; x <= Integer.parseInt(top3); x++) {

                if (playerlist[y].getArrayRK()[x] != null){                                              //     |               |
                    System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |\n", playerlist[y].getArrayRK()[x], playerlist[y].getArraySno()[x], playerlist[y].getArrayName()[x], playerlist[y].getArrayRtg()[x], playerlist[y].getArrayState()[x], playerlist[y].getArrayPts()[x], playerlist[y].getArrayCat()[x]);
                }
            }System.out.println();
        }
    }
}
