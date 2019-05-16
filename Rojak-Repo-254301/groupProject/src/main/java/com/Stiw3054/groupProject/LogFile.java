package com.Stiw3054.groupProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class LogFile extends Thread {

    private Date logDate = new Date();

    void createLogFile(String url) throws IOException {

        FileWriter writefile = new FileWriter("resource\\ErrorLink.log",true);
        writefile.write(String.valueOf(logDate) + "\n");
        writefile.write(url+": Not Exists\n");
        writefile.close();
    }
}
