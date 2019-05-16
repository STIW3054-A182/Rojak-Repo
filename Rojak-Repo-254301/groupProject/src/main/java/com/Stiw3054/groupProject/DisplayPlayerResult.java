package com.Stiw3054.groupProject;

public class DisplayPlayerResult {
    void DisplayerPlayerResult(ObjectTable [] playerlist,String Name){
        for(int y = 0; y < 10;y++ ) {

            for (int x = 1; x < playerlist[1].getArrayRK().length; x++) {

                if ((playerlist[y].getArrayRK()[x] != null)&&playerlist[y].getArrayName()[x].equals(Name)){
                    System.out.printf("\n| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |", playerlist[y].getArrayRK()[0], playerlist[y].getArraySno()[0], playerlist[y].getArrayName()[0], playerlist[y].getArrayRtg()[0], playerlist[y].getArrayState()[0], playerlist[y].getArrayPts()[0], playerlist[y].getArrayCat()[0]);
                    System.out.println("\n"+"| ---- | ----- | ------------------------------------------- | ---- | ---------------- | ---- | -------------------------------------------------- |");
                    System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |\n", playerlist[y].getArrayRK()[x], playerlist[y].getArraySno()[x], playerlist[y].getArrayName()[x], playerlist[y].getArrayRtg()[x], playerlist[y].getArrayState()[x], playerlist[y].getArrayPts()[x], playerlist[y].getArrayCat()[x]);
                }
            }
        }
    }

}
