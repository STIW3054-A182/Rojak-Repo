package com.Stiw3054.groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class CheckTable {
    List <String> ValidURLList;
    Document doc;
    String xxx= "";
    List <ObjectTable> playerlist = new ArrayList<ObjectTable>();
    int countvtable = 0;
    String cat;


    public CheckTable(List <String> ValidURLList){

        this.ValidURLList =ValidURLList;

    }

    public void Checktable () throws IOException {

        for (int x = 0; x < ValidURLList.size(); x++) {
            int count = 0;
            boolean ifvalid = false;

            ObjectTable objectTable = new ObjectTable();
            doc = Jsoup.connect(ValidURLList.get(x)).get();
            Elements table = doc.select("table.CRs1 tr");
            ifvalid =table.hasText();
            Elements table2 = doc.select("div.defaultDialog h2");
            for (Element row1 : table2) {
                Elements tds1 = row1.getElementsMatchingText("\\d{4}?");
                if (tds1.hasText()){
                    cat =tds1.text();

                }
            }
            if (ifvalid) {
                table.remove(0);

                for (Element row : table) {
                        objectTable.setArrayRK(row.select("td:nth-child(1)").text());//
                        objectTable.setArraySno(row.select("td:nth-child(2)").text());
                        objectTable.setArrayName(row.select(" td:nth-child(4)").text());
                        objectTable.setArrayRtg( row.select("td.CRr").text());
                        objectTable.setArrayState(row.select("td:nth-child(7)").text());
                        objectTable.setArrayPts(row.select("td:nth-child(8)").text().replace(",","."));
                        objectTable.setArrayCat(cat);
                        count ++;

                    }



                }

            if (ifvalid) {
                playerlist.add(objectTable);

            }
            else{
                LogFile logFile = new LogFile();
                logFile.createLogFile(ValidURLList.get(x));

            }
        }


    }

    public List <ObjectTable> getPlayerList() {
        return playerlist;
    }


}

