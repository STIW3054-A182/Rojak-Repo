package com.Stiw3054.groupProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class NetworkConnection implements Callable<String> {
    private String url;
    private long startTime,endTime,executeTime;
    NetworkConnection(String url) {
        this.url = url;
    }

    private boolean checkURL(String url) {

        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            connection.setRequestMethod("HEAD");
            return (connection.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public String call() throws Exception {
        try {
            startTime = System.currentTimeMillis();
            if (checkURL(url)) {
                System.out.println(Thread.currentThread().getName() + " --> " + url);
                endTime = System.currentTimeMillis();
                executeTime = endTime - startTime;
                System.out.println("Execution time in milliseconds: " + executeTime);
                if (executeTime > 60000) {
                    LogFile logFile = new LogFile();
                    logFile.createLogFile(url);
                    logFile.createLogFile("Execution time in milliseconds: " + executeTime);
                    System.exit(0);
                }
            } else {
                try {
                    endTime = System.currentTimeMillis();
                    executeTime = endTime - startTime;
                    LogFile logFile = new LogFile();
                    logFile.createLogFile(url);
                    logFile.createLogFile("Execution time in milliseconds: " + executeTime);
                    url = "0";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;

    }
}

