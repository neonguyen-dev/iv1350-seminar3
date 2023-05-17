package se.kth.iv1350.seminar3.integration;

public class DatabaseCouldNotBeFoundException extends Exception {
    /**
     * Creates a new instance.
     */
    public DatabaseCouldNotBeFoundException(){
        super("InventorySystem could not be reached");
    }
}
