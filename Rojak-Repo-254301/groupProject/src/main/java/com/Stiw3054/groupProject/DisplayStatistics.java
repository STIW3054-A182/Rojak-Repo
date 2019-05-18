package com.Stiw3054.groupProject;

import java.util.List;

public class DisplayStatistics {

    String[] AllState = {"KUALA LUMPUR", "PUTRAJAYA", "JOHOR",
            "KEDAH", "PERAK", "PULAU PINANG", "SELANGOR",
            "SABAH", "SARAWAK", "N.SEMBILAN", "PERLIS",
            "KELANTAN", "TERENGANU", "PAHANG", "MELAKA"};

    private List<ObjectTable> playerlist;

    DisplayStatistics(List<ObjectTable> playerlist) {this.playerlist=playerlist;}

    void displayStatistics() {

        int GrandTotal = 0;
        for (int z = 0; z < AllState.length; z++) {
            int total = 0;
            System.out.printf("| %-15s  |  %-50s  |%-5s |\n", "State", "Category", "Total");
            System.out.printf("| %-15s  |  %-50s  |%-5s |\n", "---------------", "--------------------------------------------------", "-----");
            for (ObjectTable plist : playerlist) {
                int totalbyCAt = 0;
                for (int x = 0; x < plist.getArrayRK().size(); x++) {
                    if ((AllState[z]).equals(plist.getArrayState().get(x))) {
                        totalbyCAt++;
                    }
                }
                total += totalbyCAt;

                System.out.printf("| %-15s  |  %-50s  | %d\t |\n", AllState[z], plist.getArrayCat().get(1), totalbyCAt);
            }
            GrandTotal += total;
            System.out.printf("| %-15s  |  %-50s  | %d\t |\n", "...", "Total", total);
        }
        System.out.println("|------------------|------------------------------------------------------|------|");
        System.out.printf("| %-15s  |  %-50s  | %d  |\n\n", "Grand Total", "", GrandTotal);
    }
}
