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

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorservice = Executors.newFixedThreadPool(coreCount);
        PropertiesFile propertiesFile = new PropertiesFile();
        //Path filePath = Paths.get("C:\\Users\\USER\\Desktop\\Rojak-Repo-245210\\Rojak-Repo-254301\\groupProject\\url.txt"); // Change to your own path
        //propertiesFile.WritePropertiesFile();
        File relativePath = new File (propertiesFile.ReadPropertiesPath());
        String path = relativePath.getAbsolutePath();
        System.out.println(path);
        System.out.print("C:\\Users\\User\\IdeaProjects\\Rojak-Repo-master\\Rojak-Repo-254301\\groupProject\\resource\\url.txt");
        //String fileName = String.valueOf(filePath.getFileName());



        List<String> myURLArrayList = Files.readAllLines(Paths.get(path));
        List<String> ValidURLlist = new ArrayList<>();
        System.out.println("\nVerifying the URLs ......");

        for (String url : myURLArrayList) {
            Future<String> ValidURL = executorservice.submit(new NetworkConnection(url));
            if (!ValidURL.get().equals("0"))
                ValidURLlist.add(ValidURL.get());
        }
        ValidURLlist.forEach(System.out::println);
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

        CheckTable CheckT = new CheckTable(ValidURLlist);
        CheckT.Checktable();


        ObjectTable [] playerlist = CheckT.getPlayerList();


        //displayAll display = new displayAll(playerlist);
        //display.displayall();

        //DisplayTop3 displayTop3 = new DisplayTop3();
        //displayTop3.displaytop3(playerlist,propertiesFile.ReadPropertiesTop());

        //DisplayPlayerResult displayPlayerResult = new DisplayPlayerResult();
        //displayPlayerResult.DisplayerPlayerResult(playerlist,propertiesFile.ReadPropertiesPlayer());

        //DisplayWiningPoint displayWiningPoint = new DisplayWiningPoint();
        //displayWiningPoint.DisplayWiningPoint(playerlist);

        System.out.println("\nExecution time in milliseconds: " + executeTime);
    }
}
