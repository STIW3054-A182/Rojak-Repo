package com.Stiw3054.groupProject;

public class PlayerCount {
    private ObjectTable[] playerlist;
    PlayerCount(ObjectTable[] playerlist) { //<-------------------- bring in player list
        this.playerlist = playerlist;
    }

    public void playerCounter(){
        int [] playerNum = new int [10];

        int total =0;
        System.out.println("");
        System.out.println("|                      Category                      | Total |");
        System.out.println("|----------------------------------------------------|-------|");


        for(int y = 0; y < 10;y++ ) {
            for (int x = 0; x < playerlist[1].getArrayRK().length; x++) {
                if(playerlist[y].getArrayRK()[x] != null){
                    playerNum[y]++;
                }
            }
            System.out.printf("| %-50s | %5s |\n",playerlist[y].getArrayCat()[1],(playerNum[y]-1));
        }

        for(int x=0;x<playerNum.length;x++){
            total += playerNum[x];
        }
        System.out.println("|----------------------------------------------------|-------|");
        System.out.printf("| %-50s | %5s |\n", "TOTAL",total);
    }
}

