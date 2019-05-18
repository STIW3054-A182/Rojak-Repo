package com.Stiw3054.groupProject;

import java.util.List;

public class DisplayTop3 {

    void displaytop3 (List <ObjectTable> playerlist,String top3){
        for(ObjectTable plist:playerlist) {
            System.out.println("| Rk.  |  SNo  |  Name                                       | Rtg  | Club/City        | Pts. | Category                                           |");
            System.out.println("-------|-------|---------------------------------------------|------|------------------|------|----------------------------------------------------|");
            for (int x = 0; x < Integer.parseInt(top3); x++) {
                    System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |\n", plist.getArrayRK().get(x), plist.getArraySno().get(x), plist.getArrayName().get(x), plist.getArrayRtg().get(x), plist.getArrayState().get(x), plist.getArrayPts().get(x), plist.getArrayCat().get(x));
            }System.out.println(" ");
        }
    }
}
