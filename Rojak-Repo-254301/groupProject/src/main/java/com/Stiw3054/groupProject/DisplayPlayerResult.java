package com.Stiw3054.groupProject;

import java.util.List;

public class DisplayPlayerResult {
    void DisplayerPlayerResult(List<ObjectTable>playerlist, String Name){

        System.out.println("| Rk.  |  SNo  |  Name                                       | Rtg  | Club/City        | Pts. | Category                                           |");
        System.out.println("-------|-------|---------------------------------------------|------|------------------|------|----------------------------------------------------|");
        for(ObjectTable plist:playerlist) {

            for (int x = 1; x < plist.getArrayRK().size(); x++) {

                if (plist.getArrayName().get(x).equals(Name)){

                    System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |", plist.getArrayRK().get(x), plist.getArraySno().get(x), plist.getArrayName().get(x), plist.getArrayRtg().get(x), plist.getArrayState().get(x), plist.getArrayPts().get(x), plist.getArrayCat().get(x));    }
            }
        }
    }

}
