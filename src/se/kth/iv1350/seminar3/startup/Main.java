package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.controller.*;
import se.kth.iv1350.seminar3.integration.*;
import se.kth.iv1350.seminar3.view.*;

public class Main {
    public static void main(String[] args){
        ExternalSystemCreator creator = new ExternalSystemCreator();
        Printer printer = new Printer();
        Controller contr = new Controller(printer,creator);
        new View(contr).test(); 
    }
}
