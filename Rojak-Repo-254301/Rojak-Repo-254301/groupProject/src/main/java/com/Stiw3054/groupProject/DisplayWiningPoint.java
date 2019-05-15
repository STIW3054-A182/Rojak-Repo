package com.Stiw3054.groupProject;


public class DisplayWiningPoint {
    String [] AllState =    {"KUALA LUMPUR","PUTRAJAYA","JOHOR",
                            "KEDAH","PERAK","pULAU PINANG","SELANGOR",
                            "SABAH","SARAWAK","N.SEMBILAN","PERLIS",
                            "KELANTAN","TERENGANU","PAHANG"};


    void DisplayWiningPoint(ObjectTable [] playerlist) {
        for (int z = 0; z < AllState.length; z++) {
            double total = 0;
            System.out.printf("| %-15s  |  %-50s  |  %-5s\t |\n","State","Category","Total");
            System.out.printf("| %-15s  |  %-50s  |  %-5s\t |\n","---------------","--------------------------------------------------","-----");
            for (int y = 0; y < 10; y++) {

                double totalbyCAt = 0;

                for (int x = 1; x < playerlist[0].getArrayRK().length; x++) {

                    if ((AllState[z]).equals(playerlist[y].getArrayState()[x])){
                        total += Double.parseDouble((playerlist[y].getArrayPts()[x]).replace(',','.'));
                        totalbyCAt += Double.parseDouble((playerlist[y].getArrayPts()[x]).replace(',','.'));

                    }


                }
                System.out.printf("| %-15s  |  %-50s  | %.2f\t |\n", AllState[z], playerlist[y].getArrayCat()[1], totalbyCAt);
            }
            System.out.printf("| %-15s  |  %-50s  |  %-5s\t |\n", "...", "...", "...");
            System.out.printf("| %-15s  |  %-50s  |  %.2f\t |\n\n", "...", "Total", total);

        }
    }
}
