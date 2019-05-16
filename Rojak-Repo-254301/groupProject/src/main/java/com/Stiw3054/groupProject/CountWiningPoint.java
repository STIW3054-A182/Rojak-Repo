package com.Stiw3054.groupProject;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CountWiningPoint {
    List<String> ValidURLList;
    Document doc;
    List<List> Alldata = new ArrayList();

    HashMap<String, HashMap<String,Double>> MainMap = new HashMap<>();

    public CountWiningPoint(List <String> ValidURLList){
        this.ValidURLList =ValidURLList;
    }

    public void checkWiningPointTable () throws IOException {

        for (String uri : ValidURLList) {
            String Category = "";
            try{
                doc = Jsoup.connect(uri).get();
                Elements header=doc.select("div:nth-child(2) h2");
                String cat=header.text();
                Category= StringUtils.substringAfter(cat,"9");
                Elements table = doc.select("table.CRs1 tr");
                if(table.hasText()){
                    table.remove(0);
                    for (Element tr : table) {
                        List<String> Rowdata = new ArrayList();
                        Elements tds = tr.select("td");
                        for(Element td:tds){
                            Rowdata.add(td.text().trim().replace(",", "."));
                        }
                        Rowdata.add(Category);
                        Alldata.add(Rowdata);
                    }
                }
            } catch(IllegalStateException | NullPointerException e){}
        }
    }

    public List getPlayerList() {
        return Alldata;
    }

  public void count(List<List> data){
        for(List Row:data){
            String State = Row.get(6).toString().trim();
            String Cat = Row.get(11).toString().trim();
            Double Pts = Double.parseDouble(Row.get(7).toString().trim());
            HashMap<String,Double> SubMap = new HashMap<>();
            if(MainMap.get(State) == null){
                SubMap.put(Cat, Pts);
                MainMap.put(State, SubMap);
            }else if(MainMap.get(State).get(Cat) == null){
                SubMap = MainMap.get(State);
                SubMap.put(Cat, Pts);
                MainMap.put(State, SubMap);
            }else{
                SubMap = MainMap.get(State);
                Double Count = SubMap.get(Cat) + Pts;
                SubMap.put(Cat, Count);
                MainMap.put(State, SubMap);
            }
        }
        display(MainMap);
    }

    public void display(HashMap<String,HashMap<String,Double>> Map){
        double Total = 0;
        System.out.println("\n|-------------------------------------|");
        System.out.println("| State         | Category |  Total   |");
        System.out.println("|-------------------------------------|");
        for (HashMap.Entry<String,HashMap<String,Double>> entry1 : MainMap.entrySet()) {
            double total = 0;
            for(HashMap.Entry<String,Double> entry2 : entry1.getValue().entrySet()){
                System.out.printf("| %-14s| %-8s | %-8s |\n", entry1.getKey(),entry2.getKey(),entry2.getValue());
                total += entry2.getValue();
            }
            System.out.printf("| %-14s| %-8s | %-8s |\n", "","TOTAL",total);
            System.out.println("|-------------------------------------|");
            Total += total;
        }
        System.out.printf("| %-14s| %-8s | %-8s |\n", "GRAND TOTAL","",Total);
        System.out.println("|-------------------------------------|\n\n");
    }
}
