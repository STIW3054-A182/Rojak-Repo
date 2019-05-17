package com.Stiw3054.groupProject;

public class DisplayStatistics {

    String[] AllState = {"KUALA LUMPUR", "PUTRAJAYA", "JOHOR",
            "KEDAH", "PERAK", "PULAU PINANG", "SELANGOR",
            "SABAH", "SARAWAK", "N.SEMBILAN", "PERLIS",
            "KELANTAN", "TERENGANU", "PAHANG", "MELAKA"};

    private ObjectTable[] playerlist;

    DisplayStatistics(ObjectTable[]playerlist) {this.playerlist=playerlist;}

    void displayStatistics() {

        int GrandTotal = 0;
        for (int z = 0; z < AllState.length; z++) {
            int total = 0;
            System.out.printf("| %-15s  |  %-50s  |%-5s |\n", "State", "Category", "Total");
            System.out.printf("| %-15s  |  %-50s  |%-5s |\n", "---------------", "--------------------------------------------------", "-----");
            for (int y = 0; y < 10; y++) {
                int totalbyCAt = 0;
                for (int x = 1; x < playerlist[0].getArrayRK().length; x++) {
                    if ((AllState[z]).equals(playerlist[y].getArrayState()[x])) {
                        totalbyCAt++;
                    }
                }
                total += totalbyCAt;

                System.out.printf("| %-15s  |  %-50s  | %d\t |\n", AllState[z], playerlist[y].getArrayCat()[1], totalbyCAt);
            }
            GrandTotal += total;
            System.out.printf("| %-15s  |  %-50s  | %d\t |\n", "...", "Total", total);
        }
        System.out.println("|-----------------|-------------------------------------------------------|------|");
        System.out.printf("| %-15s  |  %-50s  | %d  |\n\n", "Grand Total", "", GrandTotal);
    }
}
