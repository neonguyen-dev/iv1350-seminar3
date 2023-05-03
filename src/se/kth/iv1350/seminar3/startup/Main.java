package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.controller.*;
import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.view.*;

/**
 * Contains the <code>main</code> method. Startup of the program.
 */
public class Main {
    /**
     * The startup operation.
     * @param args User arguments, if necessary.
     */
    public static void main(String[] args){
        ExternalSystemCreator creator = new ExternalSystemCreator(100000);
        Printer printer = new Printer();
        Controller contr = new Controller(printer,creator,100);
        new View(contr).test(); 
    }
}
