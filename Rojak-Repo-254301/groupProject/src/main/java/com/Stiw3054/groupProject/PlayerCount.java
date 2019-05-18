package com.Stiw3054.groupProject;

import java.util.List;

public class PlayerCount {
    private List <ObjectTable> playerlist;
    PlayerCount(List <ObjectTable> playerlist) { //<-------------------- bring in player list
        this.playerlist = playerlist;
    }

    public void playerCounter(){
        int [] playerNum = new int [10];

        int total =0;
        System.out.println("");
        System.out.println("|                      Category                      | Total |");
        System.out.println("|----------------------------------------------------|-------|");


        for(ObjectTable plist: playerlist) {

            System.out.printf("| %-50s | %5s |\n",plist.getArrayCat().get(1),plist.getArrayName().size());
            total += plist.getArrayName().size();
        }

        System.out.println("|----------------------------------------------------|-------|");
        System.out.printf("| %-50s | %5s |\n", "TOTAL",total);
    }
}

