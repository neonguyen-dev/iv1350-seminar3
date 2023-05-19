package se.kth.iv1350.seminar3.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Logger to file
 */
public class FileLogger {
    private PrintWriter logWriter;

    /**
     * Creates a new instance.
     */
    public FileLogger(){
       try {
        logWriter = new PrintWriter(new FileWriter("log.txt"), true);
       } catch (IOException e) {
        System.out.println("Can't log");
        e.printStackTrace();
       } 
    }

    /**
     * Logs a message in log.txt file
     * @param message The message
     */
    public void log(String message){
        logWriter.println(message);
    }
}
