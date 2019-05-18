package com.Stiw3054.groupProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CheckURL {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

            int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorservice = Executors.newFixedThreadPool(coreCount);
        PropertiesFile propertiesFile = new PropertiesFile();
        File relativePath = new File(propertiesFile.ReadPropertiesPath());
        String path = relativePath.getAbsolutePath();
        System.out.println("Path : " + path);

        String fileName = relativePath.getName();
        System.out.println("File name : " + fileName);
    
        List<String> myURLArrayList = Files.readAllLines(Paths.get(path));
        List<String> ValidURLlist = new ArrayList<>();
        System.out.println("\n1. Verifying the URLs ......");

        for (String url : myURLArrayList) {
            Future<String> ValidURL = executorservice.submit(new NetworkConnection(url));
            if (!ValidURL.get().equals("0"))
                ValidURLlist.add(ValidURL.get());
        }
        executorservice.shutdown();

        while (!executorservice.isTerminated()) {
        }

        try {
            if (!executorservice.awaitTermination(60, TimeUnit.SECONDS)) { //wait for existing tasks to terminate
                executorservice.shutdownNow(); //cancel currently executing task
                if (!executorservice.awaitTermination(60, TimeUnit.SECONDS)) { //wait for tasks to respond to being cancelled
                    System.err.println("Service didn't terminate!");
                }
            }
        } catch (InterruptedException e) {
            executorservice.shutdownNow(); //re-cancel if current thread also interrupted
            Thread.currentThread().interrupt(); //preserve interrupt status
        }

        System.out.println();
        System.out.println(" *** Checking the table from the valid URL ***");
        CheckTable CheckT = new CheckTable(ValidURLlist);
        CheckT.Checktable();


        List<ObjectTable>playerlist = CheckT.getPlayerList();        //*
        displayAll display = new displayAll(playerlist);           //*  <---------- take playerlist  value to yr constructor to print something
        display.displayall();

        System.out.println();
        System.out.println("2. Count player......");

       PlayerCount pc1 = new PlayerCount(playerlist);
        pc1.playerCounter();

        System.out.println();
        System.out.println("3. Display Statistics......");
        DisplayStatistics ds1 = new DisplayStatistics(playerlist);
        ds1.displayStatistics();

        System.out.println();
        System.out.println("4. All Players From KEDAH......\n");
        DisplayPlayerFromKedah displayPlayerFromKedah = new DisplayPlayerFromKedah(playerlist);
        displayPlayerFromKedah.RetrievePlayer();

        System.out.println();
        System.out.println("5. Display Top 3 Players From Each Category......\n");
        DisplayTop3 displayTop3 = new DisplayTop3();
        displayTop3.displaytop3(playerlist, propertiesFile.ReadPropertiesTop());

        System.out.println("6. Display Wining Points......");
        CountWiningPoint countWiningPoint = new CountWiningPoint(playerlist);
        countWiningPoint.count();

        System.out.println();
        System.out.println("7. Display A Player Result......\n");
        DisplayPlayerResult displayPlayerResult = new DisplayPlayerResult();
        displayPlayerResult.DisplayerPlayerResult(playerlist, propertiesFile.ReadPropertiesPlayer());
    }
}
