package se.kth.iv1350.seminar3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger {
    private PrintWriter logWriter;

    public FileLogger(){
       try {
        logWriter = new PrintWriter(new FileWriter("log.txt"), true);
       } catch (IOException e) {
        System.out.println("Can't log");
        e.printStackTrace();
       } 
    }
    public void log(String message){
        logWriter.println(message);
    }
}
