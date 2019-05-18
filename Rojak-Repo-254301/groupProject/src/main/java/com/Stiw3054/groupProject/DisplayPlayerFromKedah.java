package com.Stiw3054.groupProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

class DisplayPlayerFromKedah {
    private List<ObjectTable>playerlist;
    private PropertiesFile prop = new PropertiesFile();

    DisplayPlayerFromKedah(List<ObjectTable>playerlist) { //<-------------------- bring in player list
        this.playerlist = playerlist;
    }

    void RetrievePlayer() {
            // load a properties file
        System.out.println("| Rk.  |  SNo  |  Name                                       | Rtg  | Club/City        | Pts. | Category                                           |");
        System.out.println("-------|-------|---------------------------------------------|------|------------------|------|----------------------------------------------------|");

            for (ObjectTable plist:playerlist) {
                for (int x = plist.getArrayRK().size()-1; x>0; x--) { //Sorting winning points in ascending order.
                        if ((plist.getArrayState().get(x).equals(prop.ReadPropertiesState()))) {
                            System.out.printf("| %-3s  |  %-3s  |  %-42s | %-4s | %-15s  | %-4s | %-50s |\n",plist.getArrayRK().get(x), plist.getArraySno().get(x), plist.getArrayName().get(x), plist.getArrayRtg().get(x), plist.getArrayState().get(x), plist.getArrayPts().get(x), plist.getArrayCat().get(x));
                        }

                }
            }
        }
    }


